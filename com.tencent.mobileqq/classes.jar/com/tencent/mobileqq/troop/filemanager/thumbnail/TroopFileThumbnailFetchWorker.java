package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class TroopFileThumbnailFetchWorker
  implements TroopFileThumbnailDownloader.IFileThumbDownloaderSink
{
  protected int a;
  protected long a;
  TroopFileReqDownloadFileObserver a;
  protected ITroopFileProtoReq a;
  protected TroopFileThumbnailDownloader a;
  protected TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  protected Timer a;
  protected boolean a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  protected String d;
  protected String e;
  
  protected TroopFileThumbnailFetchWorker(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener paramITroopFileThumbFetchWorkerListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFileThumbnailFetchWorker.2(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener = paramITroopFileThumbFetchWorkerListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = TroopFileThumbnailFetchMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id, paramInt);
    if (FileManagerUtil.a(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName)) == 2) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static TroopFileThumbnailFetchWorker a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener paramITroopFileThumbFetchWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. nThumbSize=0");
      return null;
    }
    return new TroopFileThumbnailFetchWorker(paramLong, paramItem, paramInt, paramITroopFileThumbFetchWorkerListener);
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] stop. but had stoped. mStatus:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] stop fetch. mStatus:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader;
      if (localObject != null)
      {
        ((TroopFileThumbnailDownloader)localObject).c();
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = null;
      }
      else
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("] stop downloader=null");
        TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      }
    }
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq != null)
    {
      TroopFileProtocol.a(TroopFileTransferUtil.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    }
    e();
    if (!TextUtils.isEmpty(this.d)) {
      FileUtils.deleteFile(this.d);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    ((TroopFileTransferManager.Item)localObject).StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, (TroopFileTransferManager.Item)localObject);
    b(0);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration == 0) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      paramInt1 = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append("] startFetch app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt1, paramString.toString());
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    FileUtils.deleteFile(this.d);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/ftn_handler/");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl);
    ((StringBuilder)localObject1).append("/?fname=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ((StringBuilder)localObject1).append("&pictype=cut&size=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append("*");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    localObject1 = ((StringBuilder)localObject1).toString();
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_Boolean)
    {
      int i = 443;
      if (paramInt1 <= 0) {
        paramInt1 = 443;
      }
      if ((TroopFileUtils.c(localQQAppInterface)) && (!TextUtils.isEmpty(paramString)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        paramString = null;
      }
      if (bool) {
        if (paramInt2 <= 0) {
          paramInt1 = i;
        } else {
          paramInt1 = paramInt2;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/ftn_video_pic/rkey=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl);
      ((StringBuilder)localObject1).append("&filetype=17&size=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("*");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramInt1);
      localArrayList.add(((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)) {
        if (FileIPv6StrateyController.a().isConfigEnableIPV6(localQQAppInterface, 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, paramInt1);
          localObject2 = FileIPv6StrateyController.a().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
          if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
          {
            if (FileIPv6StrateyController.a())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
              localStringBuilder.append("] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
              QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
              localArrayList.clear();
            }
            FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject2).a, localArrayList, false, false);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. use IPv6. iplist:");
            ((StringBuilder)localObject2).append(localArrayList.toString());
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. use IPv4:");
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramInt1);
            localArrayList.add(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramInt1);
          localArrayList.add(((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      if ((TroopFileUtils.c(localQQAppInterface)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
        bool = true;
      }
      else
      {
        bool = false;
        paramString = null;
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)) {
        if (FileIPv6StrateyController.a().isConfigEnableIPV6(localQQAppInterface, 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
          localObject2 = FileIPv6StrateyController.a().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
          if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
          {
            if (FileIPv6StrateyController.a())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
              localStringBuilder.append("] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
              QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
              localArrayList.clear();
            }
            FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject2).a, localArrayList, true, false);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. use IPv6. iplist:");
            ((StringBuilder)localObject2).append(localArrayList.toString());
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. use IPv4");
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
            localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          }
        }
        else
        {
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        }
      }
    }
    long l = TroopFileTransferUtil.a();
    paramInt1 = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("] startFetch. nSessionId:");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" firstIP=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    ((StringBuilder)localObject2).append(" urlParams:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" mTmpFilePath:");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append(" bUseHttps:");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append(" httpsDomain:");
    ((StringBuilder)localObject2).append(paramString);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt1, ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader;
    if (localObject2 != null)
    {
      ((TroopFileThumbnailDownloader)localObject2).c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = TroopFileThumbnailDownloader.a(localQQAppInterface, l, this.d, 0L, localArrayList, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool, paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader;
    if (paramString == null)
    {
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    paramString.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.i();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b();
    b(2);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    g();
    if ((!paramBoolean) && (!FileManagerUtil.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] renameFile fail  mFilePath:");
      ((StringBuilder)localObject).append(this.e);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      if (FileUtils.fileExistsAndNotEmpty(this.e))
      {
        c(TroopTechReportUtils.TroopFileReportResultCode.o);
        return;
      }
    }
    b(3);
    f();
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onFetchSuc  mFilePath:");
    ((StringBuilder)localObject).append(this.e);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    }
    if ((this.jdField_a_of_type_Int == 640) && (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    FilePicURLDrawlableHelper.a(this.e, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth > 0) && (((BitmapFactory.Options)localObject).outHeight > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = ((BitmapFactory.Options)localObject).outWidth;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = ((BitmapFactory.Options)localObject).outHeight;
    }
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener;
    if (localObject != null) {
      ((TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener)localObject).a(a(), true, 0, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.jdField_a_of_type_JavaLangString);
    paramString1.append("] onHasErr. fetch fail. errCode:");
    paramString1.append(paramInt);
    paramString1.append(" transferedSize:");
    paramString1.append(paramLong);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramString1.toString());
    if (paramInt == -5000)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.h;
    }
    else if (paramInt == -5001)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.g;
    }
    else if (paramInt == 9039)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.n;
    }
    else if (paramInt == 9004)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.k;
    }
    else if (paramInt == 9301)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.i;
    }
    else if (paramInt == -5001)
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.q;
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b())
    {
      i = TroopTechReportUtils.TroopFileReportResultCode.p;
    }
    else
    {
      i = paramInt;
      if (paramInt == -5003) {
        i = TroopTechReportUtils.TroopFileReportResultCode.y;
      }
    }
    c(i);
  }
  
  public boolean a()
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] start fetch thumb. filename:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
    localStringBuilder.append(" filePath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  protected void b()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] reqFetch app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] reqFetch");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = TroopFileProtocol.a((QQAppInterface)localObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
    b(1);
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString) {}
  
  protected void c()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = TroopFileThumbnailMgr.a();
    this.c = this.jdField_b_of_type_JavaLangString;
  }
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      FileUtils.deleteFile(this.d);
    }
    b(4);
    e();
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onFetchErr  errCode:");
    ((StringBuilder)localObject).append(paramInt);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.y) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    } else if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.p) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
    } else {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
    }
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener;
    if (localObject != null) {
      ((TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener)localObject).a(a(), false, paramInt, this);
    }
  }
  
  public void d() {}
  
  protected void e()
  {
    TroopFileThumbnailMgr.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void f()
  {
    TroopFileThumbnailMgr.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int);
    boolean bool = TroopFileThumbnailMgr.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, this.e);
    if (this.jdField_a_of_type_Int == 383) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ThumbnailDownloading_Middle_Fail = (bool ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker
 * JD-Core Version:    0.7.0.1
 */