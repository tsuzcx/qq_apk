package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
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
  TroopFileGetFilePreviewObserver a;
  protected List<String> a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected TroopZipInnerFileDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    super(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver = new TroopZipInnerFileDownloadWorker.1(this);
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
  
  String a(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.a();
  }
  
  protected void f()
  {
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
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
    Object localObject = TroopFileTransferUtil.a(this.jdField_c_of_type_Long);
    if (localObject != null)
    {
      TroopFileInfo localTroopFileInfo = ((TroopFileManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localTroopFileInfo != null)
      {
        localObject = ((TroopFileManager)localObject).a(localTroopFileInfo.g);
        if (localObject != null)
        {
          localTroopFileInfo.e = 8;
          ((TroopFileInfo)localObject).a(localTroopFileInfo);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver);
    b(1);
    TroopTechReportUtils.b();
  }
  
  protected void g()
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
    this.jdField_d_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = null;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a = FileUtil.a(this.jdField_d_of_type_JavaLangString);
    long l = TroopFileTransferUtil.a();
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = TroopFileDownloader.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 903;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */