package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
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
  private static TroopFileDownloadMgr b;
  protected boolean a = false;
  private Map<UUID, TroopFileDownloadWorker> c = new HashMap();
  private LinkedList<UUID> d = new LinkedList();
  private LinkedList<TroopFileDownloadWorker> e = new LinkedList();
  
  public static TroopFileDownloadMgr a()
  {
    try
    {
      if (b == null) {
        b = new TroopFileDownloadMgr();
      }
      TroopFileDownloadMgr localTroopFileDownloadMgr = b;
      return localTroopFileDownloadMgr;
    }
    finally {}
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramItem.Id.toString());
    localStringBuilder.append("] refreshOneFileResult:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" errorCode:");
    localStringBuilder.append(paramInt);
    QLog.i("TroopFileDownloadMgr", 1, localStringBuilder.toString());
    if (a(paramLong, paramItem, paramFileInfo)) {
      return;
    }
    paramFileInfo = TroopFileTransferUtil.a();
    if ((paramFileInfo != null) && (FileManagerUtil.c(paramItem.FileName) == 2) && (QFileUtils.a(paramFileInfo)))
    {
      FileVideoDownloadManager.b(new VideoForTroop(paramFileInfo, paramItem.getInfo(paramLong))).c();
      return;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
  }
  
  private boolean a(long paramLong, TroopFileTransferManager.Item paramItem, group_file_common.FileInfo paramFileInfo)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    Object localObject1 = "TroopFileDownloadMgr";
    if ((localQQAppInterface != null) && (paramFileInfo != null))
    {
      paramItem.Md5 = paramFileInfo.bytes_md5.get().toByteArray();
      String str1 = FileHttpUtils.a(paramItem.Md5);
      paramItem.Sha = paramFileInfo.bytes_sha.get().toByteArray();
      String str2 = FileHttpUtils.a(paramItem.Sha);
      paramItem.Sha3 = FileHttpUtils.a(paramFileInfo.bytes_sha3.get().toByteArray());
      paramFileInfo = new StringBuilder();
      paramFileInfo.append("troop findFile md5[");
      paramFileInfo.append(str1);
      paramFileInfo.append("], sha3[");
      paramFileInfo.append(paramItem.Sha3);
      paramFileInfo.append("], sha[");
      paramFileInfo.append(str2);
      paramFileInfo.append("]");
      QLog.i("TroopFileDownloadMgr", 1, paramFileInfo.toString());
      Object localObject2 = localQQAppInterface.getFileManagerDataCenter().c(paramItem.FileName, paramItem.ProgressTotal).iterator();
      paramFileInfo = (group_file_common.FileInfo)localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
        if (((((FileManagerEntity)localObject1).strFileMd5 != null) && (((FileManagerEntity)localObject1).strFileMd5.equals(str1))) || ((((FileManagerEntity)localObject1).strFileMd5 != null) && (((FileManagerEntity)localObject1).strFileMd5.equals(str1))) || ((((FileManagerEntity)localObject1).str10Md5 != null) && (((FileManagerEntity)localObject1).str10Md5.equals(str1))) || ((((FileManagerEntity)localObject1).strFileSha3 != null) && (((FileManagerEntity)localObject1).strFileSha3.equals(paramItem.Sha3))) || ((((FileManagerEntity)localObject1).strFileSHA != null) && (((FileManagerEntity)localObject1).strFileSHA.equals(str2))) || ((((FileManagerEntity)localObject1).strTroopFileSha1 != null) && (((FileManagerEntity)localObject1).strTroopFileSha1.equals(str2))))
        {
          long l = new VFSFile(((FileManagerEntity)localObject1).getFilePath()).lastModified();
          if (((FileManagerEntity)localObject1).localModifyTime != l)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("find exsited file, bug file is modified,item.localModifyTime[");
            localStringBuilder.append(((FileManagerEntity)localObject1).localModifyTime);
            localStringBuilder.append("], lastModified[");
            localStringBuilder.append(l);
            localStringBuilder.append("]");
            localObject1 = localStringBuilder.toString();
            QLog.w(paramFileInfo, 1, (String)localObject1);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sessionid[");
            ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).nSessionId);
            ((StringBuilder)localObject2).append("]find exsited file, set file download sucessed!");
            QLog.i(paramFileInfo, 1, ((StringBuilder)localObject2).toString());
            paramItem.LocalFile = ((FileManagerEntity)localObject1).getFilePath();
            if ((!FileUtils.fileExistsAndNotEmpty(paramItem.middleThumbnailFile)) && (FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).strMiddleThumPath))) {
              paramItem.middleThumbnailFile = ((FileManagerEntity)localObject1).strMiddleThumPath;
            }
            if ((!FileUtils.fileExistsAndNotEmpty(paramItem.largeThumbnailFile)) && (FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).strLargeThumPath))) {
              paramItem.largeThumbnailFile = ((FileManagerEntity)localObject1).strLargeThumPath;
            }
            TroopFileDataCenter.a(paramLong, paramItem, 11);
            a(paramItem.getInfo(paramLong), str1, str2, paramItem.Sha3);
            if (5 == FileManagerUtil.c(paramItem.FileName)) {
              localQQAppInterface.getFileManagerEngine().i().a(paramLong, paramItem);
            }
            return true;
          }
        }
      }
      return false;
    }
    QLog.e("TroopFileDownloadMgr", 1, "downloadSucIfLocalExsited para=null");
    return false;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.e.iterator();
    while (paramBundle.hasNext())
    {
      TroopFileDownloadWorker localTroopFileDownloadWorker = (TroopFileDownloadWorker)paramBundle.next();
      if (paramUUID.equals(localTroopFileDownloadWorker.h()))
      {
        localTroopFileDownloadWorker.a(0);
        paramBundle.remove();
        i = 1;
        break label59;
      }
    }
    int i = 0;
    label59:
    int j = i;
    boolean bool;
    if (i == 0)
    {
      paramBundle = (TroopFileDownloadWorker)this.c.remove(paramUUID);
      j = i;
      if (paramBundle != null)
      {
        paramBundle.a(0);
        j = i | 0x1;
      }
      j |= this.d.remove(paramUUID);
    }
    if (bool)
    {
      i = TroopFileTransferUtil.Log.b;
      paramBundle = new StringBuilder();
      paramBundle.append("[");
      paramBundle.append(paramUUID.toString());
      paramBundle.append("] stopDownload.");
      paramBundle.append(e());
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramBundle.toString());
    }
    d();
    return 0;
  }
  
  private int d(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      i = TroopFileTransferUtil.Log.b;
      paramBundle = new StringBuilder();
      paramBundle.append("[");
      paramBundle.append(paramItem.Id.toString());
      paramBundle.append("] startDownload worker exsited. ");
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramBundle.toString());
      return -4;
    }
    IExcitingTransferAdapter localIExcitingTransferAdapter = (IExcitingTransferAdapter)TroopFileTransferUtil.a().getRuntimeService(IExcitingTransferAdapter.class, "");
    if ((paramItem.ProgressTotal > 0L) && (localIExcitingTransferAdapter.isEnableGroupDownload()) && (paramItem.ProgressTotal > localIExcitingTransferAdapter.getGroupDownloadLimitedSize())) {
      paramBundle = ExtfGroupDownloadWorker.a(paramLong, paramItem, paramBundle, this);
    } else {
      paramBundle = TroopFileDownloadWorker.b(paramLong, paramItem, paramBundle, this);
    }
    if (paramBundle == null) {
      return -3;
    }
    this.c.put(paramItem.Id, paramBundle);
    this.d.add(paramItem.Id);
    paramBundle.j();
    int i = TroopFileTransferUtil.Log.b;
    paramBundle = new StringBuilder();
    paramBundle.append("[");
    paramBundle.append(paramItem.Id.toString());
    paramBundle.append("] startDownload filePath. ");
    paramBundle.append(paramItem.FilePath);
    paramBundle.append(e());
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramBundle.toString());
    d();
    return 0;
  }
  
  private void d()
  {
    if (this.e.size() >= 2) {
      return;
    }
    while (this.d.size() > 0)
    {
      Object localObject = (UUID)this.d.remove(0);
      localObject = (TroopFileDownloadWorker)this.c.remove(localObject);
      if (localObject != null)
      {
        this.e.add(localObject);
        if (((TroopFileDownloadWorker)localObject).a()) {
          break;
        }
        this.e.remove(localObject);
      }
    }
  }
  
  private int e(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      i = TroopFileTransferUtil.Log.b;
      paramBundle = new StringBuilder();
      paramBundle.append("[");
      paramBundle.append(paramItem.Id.toString());
      paramBundle.append("] startDownloadZipInnerFile worker exsited. ");
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramBundle.toString());
      return -4;
    }
    paramBundle = TroopZipInnerFileDownloadWorker.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.c.put(paramItem.Id, paramBundle);
    this.d.add(paramItem.Id);
    paramBundle.j();
    int i = TroopFileTransferUtil.Log.b;
    paramBundle = new StringBuilder();
    paramBundle.append("[");
    paramBundle.append(paramItem.Id.toString());
    paramBundle.append("] startDownloadZipInnerFile filePath. ");
    paramBundle.append(paramItem.FilePath);
    paramBundle.append(e());
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramBundle.toString());
    d();
    return 0;
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" WS:");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(" QS:");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append(" RS:");
    localStringBuilder.append(this.e.size());
    return localStringBuilder.toString();
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      if (paramItem.Id == null) {
        return -2;
      }
      paramItem = TroopFilePreviewWorker.a(paramLong, paramItem);
      if (paramItem == null) {
        return -3;
      }
      if (!paramItem.b()) {
        return -5;
      }
      return 0;
    }
    return -1;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "stopUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  protected void a(int paramInt)
  {
    int i = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failAll. reason:");
    localStringBuilder.append(paramInt);
    TroopFileTransferUtil.Log.b("TroopFileDownloadMgr", i, localStringBuilder.toString());
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.9(this, paramInt), false);
  }
  
  protected void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.e.iterator();
    TroopFileDownloadWorker localTroopFileDownloadWorker;
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.i()));
      }
    }
    this.e.clear();
    localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.i()));
      }
    }
    this.c.clear();
    this.d.clear();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "stopAllInter");
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
      int i = TroopFileTransferUtil.Log.b;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(paramTroopFileStatusInfo.d);
      paramString1.append("] addFMEntity fail app=null ");
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", i, paramString1.toString());
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    localFileManagerEntity.peerNick = ContactUtils.i(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.d;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.e(paramTroopFileStatusInfo.k));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.d(paramTroopFileStatusInfo.k));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.g(paramTroopFileStatusInfo.k));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramTroopFileStatusInfo.k).lastModified();
      label277:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label277;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.8(this, paramUUID, paramBoolean, paramInt, paramTroopFileDownloadWorker), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((TroopFileDownloadWorker)localIterator.next()).h())) {
        return true;
      }
    }
    return this.c.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      if (paramItem.Id == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "startDownload item.id null.");
        return -2;
      }
      a(paramLong, paramItem, paramBundle);
      return 0;
    }
    TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "startDownload key param invaild.");
    return -1;
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void b(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    this.e.remove(paramTroopFileDownloadWorker);
    int i = TroopFileTransferUtil.Log.b;
    paramTroopFileDownloadWorker = new StringBuilder();
    paramTroopFileDownloadWorker.append("[");
    paramTroopFileDownloadWorker.append(paramUUID.toString());
    paramTroopFileDownloadWorker.append("] onWorkDoneInter. bSuc:");
    paramTroopFileDownloadWorker.append(paramBoolean);
    paramTroopFileDownloadWorker.append(" errCode:");
    paramTroopFileDownloadWorker.append(paramInt);
    paramTroopFileDownloadWorker.append(e());
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", i, paramTroopFileDownloadWorker.toString());
    d();
  }
  
  public int c(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      if (paramItem.Id == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "startDownloadZipInnerFile item.id null.");
        return -2;
      }
      TroopFileTransferMgr.a(new TroopFileDownloadMgr.6(this, paramLong, paramItem, paramBundle), false);
      return 0;
    }
    TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "startDownloadZipInnerFile key param invaild.");
    return -1;
  }
  
  public void c()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void onNetMobile2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "onNetNone2Mobile");
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    TroopFileTransferMgr.a(new TroopFileDownloadMgr.11(this), false);
  }
  
  public void onNetWifi2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.b, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr
 * JD-Core Version:    0.7.0.1
 */