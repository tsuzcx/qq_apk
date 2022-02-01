package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloadWorker;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.UUID;
import mqq.os.MqqHandler;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class TroopFileDownloadMgr
  extends Observable
  implements INetInfoHandler, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener
{
  private static TroopFileDownloadMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, TroopFileDownloadWorker> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected boolean a;
  private LinkedList<TroopFileDownloadWorker> b = new LinkedList();
  
  private TroopFileDownloadMgr()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static TroopFileDownloadMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr == null) {
        jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr = new TroopFileDownloadMgr();
      }
      TroopFileDownloadMgr localTroopFileDownloadMgr = jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr;
      return localTroopFileDownloadMgr;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " RS:" + this.b.size();
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    QLog.i("TroopFileDownloadMgr", 1, "[" + paramItem.Id.toString() + "] refreshOneFileResult:" + paramBoolean + " errorCode:" + paramInt);
    if (a(paramLong, paramItem, paramFileInfo)) {
      return;
    }
    paramFileInfo = TroopFileTransferUtil.a();
    if ((paramFileInfo != null) && (FileManagerUtil.a(paramItem.FileName) == 2) && (QFileUtils.a(paramFileInfo)))
    {
      FileVideoDownloadManager.a(new VideoForTroop(paramFileInfo, paramItem.getInfo(paramLong))).a();
      return;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
  }
  
  private boolean a(long paramLong, TroopFileTransferManager.Item paramItem, group_file_common.FileInfo paramFileInfo)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if ((localQQAppInterface == null) || (paramFileInfo == null))
    {
      QLog.e("TroopFileDownloadMgr", 1, "downloadSucIfLocalExsited para=null");
      return false;
    }
    paramItem.Md5 = paramFileInfo.bytes_md5.get().toByteArray();
    String str1 = FileHttpUtils.a(paramItem.Md5);
    paramItem.Sha = paramFileInfo.bytes_sha.get().toByteArray();
    String str2 = FileHttpUtils.a(paramItem.Sha);
    paramItem.Sha3 = FileHttpUtils.a(paramFileInfo.bytes_sha3.get().toByteArray());
    QLog.i("TroopFileDownloadMgr", 1, "troop findFile md5[" + str1 + "], sha3[" + paramItem.Sha3 + "], sha[" + str2 + "]");
    paramFileInfo = localQQAppInterface.getFileManagerDataCenter().a(paramItem.FileName, paramItem.ProgressTotal).iterator();
    while (paramFileInfo.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramFileInfo.next();
      if (((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.str10Md5 != null) && (localFileManagerEntity.str10Md5.equals(str1))) || ((localFileManagerEntity.strFileSha3 != null) && (localFileManagerEntity.strFileSha3.equals(paramItem.Sha3))) || ((localFileManagerEntity.strFileSHA != null) && (localFileManagerEntity.strFileSHA.equals(str2))) || ((localFileManagerEntity.strTroopFileSha1 != null) && (localFileManagerEntity.strTroopFileSha1.equals(str2))))
      {
        long l = new VFSFile(localFileManagerEntity.getFilePath()).lastModified();
        if (localFileManagerEntity.localModifyTime != l)
        {
          QLog.w("TroopFileDownloadMgr", 1, "find exsited file, bug file is modified,item.localModifyTime[" + localFileManagerEntity.localModifyTime + "], lastModified[" + l + "]");
        }
        else
        {
          QLog.i("TroopFileDownloadMgr", 1, "sessionid[" + localFileManagerEntity.nSessionId + "]find exsited file, set file download sucessed!");
          paramItem.LocalFile = localFileManagerEntity.getFilePath();
          if ((!FileUtils.b(paramItem.middleThumbnailFile)) && (FileUtils.b(localFileManagerEntity.strMiddleThumPath))) {
            paramItem.middleThumbnailFile = localFileManagerEntity.strMiddleThumPath;
          }
          if ((!FileUtils.b(paramItem.largeThumbnailFile)) && (FileUtils.b(localFileManagerEntity.strLargeThumPath))) {
            paramItem.largeThumbnailFile = localFileManagerEntity.strLargeThumPath;
          }
          TroopFileDataCenter.a(paramLong, paramItem, 11);
          a(paramItem.getInfo(paramLong), str1, str2, paramItem.Sha3);
          if (5 == FileManagerUtil.a(paramItem.FileName)) {
            localQQAppInterface.getFileManagerEngine().a().a(paramLong, paramItem);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.b.iterator();
    while (paramBundle.hasNext())
    {
      TroopFileDownloadWorker localTroopFileDownloadWorker = (TroopFileDownloadWorker)paramBundle.next();
      if (paramUUID.equals(localTroopFileDownloadWorker.a()))
      {
        localTroopFileDownloadWorker.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (TroopFileDownloadWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label154;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label154:
      for (;;)
      {
        bool2 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | bool1;
        if (bool2) {
          TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] stopDownload." + a());
        }
        c();
        return 0;
      }
    }
  }
  
  private int c(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (ExcitingTransferAdapter.a().d()) && (paramItem.ProgressTotal > ExcitingTransferAdapter.a().d())) {}
    for (paramBundle = ExtfGroupDownloadWorker.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = TroopFileDownloadWorker.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  private void c()
  {
    if (this.b.size() >= 2) {}
    label78:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label78;
        }
        Object localObject = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (TroopFileDownloadWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((TroopFileDownloadWorker)localObject).a()) {
            break;
          }
          this.b.remove(localObject);
        }
      }
    }
  }
  
  private int d(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = TroopZipInnerFileDownloadWorker.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    paramItem = TroopFilePreviewWorker.a(paramLong, paramItem);
    if (paramItem == null) {
      return -3;
    }
    if (!paramItem.a()) {
      return -5;
    }
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "stopUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    TroopFileTransferUtil.Log.b("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "failAll. reason:" + paramInt);
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.9(this, paramInt), false);
  }
  
  protected void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    TroopFileDownloadWorker localTroopFileDownloadWorker;
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface != null)
    {
      TroopFileProtocol.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new TroopFileDownloadMgr.4(this, paramLong, paramItem, paramBundle));
      return;
    }
    QLog.e("TroopFileDownloadMgr", 1, "CheckFileExsited app=null");
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramTroopFileStatusInfo.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.b);
    localFileManagerEntity.peerNick = ContactUtils.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.c(paramTroopFileStatusInfo.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramTroopFileStatusInfo.a));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.e(paramTroopFileStatusInfo.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramTroopFileStatusInfo.a).lastModified();
      label265:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.8(this, paramUUID, paramBoolean, paramInt, paramTroopFileDownloadWorker), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((TroopFileDownloadWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.6(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  protected void b(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    this.b.remove(paramTroopFileDownloadWorker);
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetNone2Mobile");
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.11(this), false);
  }
  
  public void onNetWifi2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr
 * JD-Core Version:    0.7.0.1
 */