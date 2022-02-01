package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequest;
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
  protected TroopFileProtoReqMgr.ProtoRequest a;
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
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop fetch. mStatus:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader == null) {
        break label197;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = null;
    }
    for (;;)
    {
      g();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest != null)
      {
        TroopFileProtocol.a(TroopFileTransferUtil.a(), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
      }
      e();
      if (!TextUtils.isEmpty(this.d)) {
        FileUtils.e(this.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      b(0);
      return;
      label197:
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop downloader=null");
    }
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
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch app=null");
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    FileUtils.e(this.d);
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + "&pictype=cut&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramInt1;
      if (paramInt1 <= 0) {
        i = 443;
      }
      localObject1 = localObject2;
      bool1 = bool2;
      if (TroopFileUtils.d(localQQAppInterface))
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = true;
          localObject1 = paramString;
        }
      }
      if (!bool1) {
        break label1225;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    label779:
    label1171:
    label1225:
    for (paramInt1 = 443;; paramInt1 = i)
    {
      localObject2 = "/ftn_video_pic/rkey=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "&filetype=17&size=" + this.jdField_a_of_type_Int + "*" + this.jdField_a_of_type_Int + "&";
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + ":" + paramInt1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
      {
        if (!FileIPv6StrateyController.a().a(localQQAppInterface, 3)) {
          break label779;
        }
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        paramString = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, paramInt1);
        paramString = FileIPv6StrateyController.a().a(localQQAppInterface, paramString, 3);
        if ((paramString != null) && (!paramString.a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          FileIPv6StrateyController.a(paramString.a, localArrayList, false, false);
          QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. use IPv6. iplist:" + localArrayList.toString());
        }
      }
      else
      {
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        long l = TroopFileTransferUtil.a();
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startFetch. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + (String)localObject1 + " mTmpFilePath:" + this.d + " bUseHttps:" + bool1 + " httpsDomain:" + paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.c();
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader = TroopFileThumbnailDownloader.a(localQQAppInterface, l, this.d, 0L, localArrayList, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, this.jdField_b_of_type_Boolean, bool1, paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader != null) {
          break label1171;
        }
        c(TroopTechReportUtils.TroopFileReportResultCode.w);
        return;
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopVideo thumb. use IPv4:");
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + ":" + paramInt1);
        break;
        paramString = localObject3;
        bool1 = bool3;
        if (TroopFileUtils.d(localQQAppInterface))
        {
          paramString = localObject3;
          bool1 = bool3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
          {
            bool1 = true;
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
          }
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          if (FileIPv6StrateyController.a().a(localQQAppInterface, 3))
          {
            QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
            localObject2 = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
            localObject2 = FileIPv6StrateyController.a().a(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
            if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
            {
              if (FileIPv6StrateyController.a())
              {
                QLog.d("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
                localArrayList.clear();
              }
              FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject2).a, localArrayList, true, false);
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. use IPv6. iplist:" + localArrayList.toString());
            }
            for (;;)
            {
              break;
              QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopImage thumb. use IPv4");
              localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
            }
          }
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.a(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.i();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration != 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailDownloader.b();
      b(2);
      return;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    g();
    if ((!paramBoolean) && (!FileManagerUtil.a(new VFSFile(this.d), new VFSFile(this.e))))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.e);
      if (FileUtils.b(this.e)) {
        c(TroopTechReportUtils.TroopFileReportResultCode.o);
      }
    }
    do
    {
      return;
      b(3);
      f();
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchSuc  mFilePath:" + this.e);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      }
      if ((this.jdField_a_of_type_Int == 640) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      FilePicURLDrawlableHelper.a(this.e, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = localOptions.outWidth;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = localOptions.outHeight;
      }
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener.a(a(), true, 0, this);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. fetch fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i;
    if (paramInt == -5000) {
      i = TroopTechReportUtils.TroopFileReportResultCode.h;
    }
    for (;;)
    {
      c(i);
      return;
      if (paramInt == -5001)
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
    }
  }
  
  public boolean a()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start fetch thumb. filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch app=null");
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqFetch");
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, false, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    g();
    if (!TextUtils.isEmpty(this.d)) {
      FileUtils.e(this.d);
    }
    b(4);
    e();
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFetchErr  errCode:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.y) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 1;
    }
    for (;;)
    {
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener.a(a(), false, paramInt, this);
      }
      return;
      if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.p) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 2;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.thumbInvalidCode = 0;
      }
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
    TroopFileTransferManager.Item localItem;
    if (this.jdField_a_of_type_Int == 383)
    {
      localItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      if (bool) {
        break label58;
      }
    }
    label58:
    for (bool = true;; bool = false)
    {
      localItem.ThumbnailDownloading_Middle_Fail = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker
 * JD-Core Version:    0.7.0.1
 */