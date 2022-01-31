package com.tencent.mobileqq.troop.filemanager.download;

import ajlx;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class TroopZipInnerFileDownloadWorker
  extends TroopFileDownloadWorker
{
  TroopFileProtocol.GetFilePreviewObserver a;
  public List a;
  public String f;
  
  protected TroopZipInnerFileDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    super(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFilePreviewObserver = new ajlx(this);
  }
  
  public static TroopZipInnerFileDownloadWorker a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new TroopZipInnerFileDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  public String a(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.a();
  }
  
  protected void b()
  {
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = TroopFileTransferUtil.a(this.jdField_a_of_type_Long);
    if (localObject != null)
    {
      TroopFileInfo localTroopFileInfo = ((TroopFileManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localTroopFileInfo != null)
      {
        localObject = ((TroopFileManager)localObject).a(localTroopFileInfo.f);
        if (localObject != null)
        {
          localTroopFileInfo.e = 8;
          ((TroopFileInfo)localObject).a(localTroopFileInfo);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFilePreviewObserver);
    b(1);
    TroopTechReportUtils.b();
  }
  
  public void c()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.c + str);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader = null;
    }
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = FileUtil.a(this.d);
    long l = TroopFileTransferUtil.a();
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader = TroopFileDownloader.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 903;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */