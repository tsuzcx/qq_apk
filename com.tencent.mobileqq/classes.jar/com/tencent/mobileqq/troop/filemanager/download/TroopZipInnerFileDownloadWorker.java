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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.a();
  }
  
  protected void f()
  {
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("] reqDownload app=null");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    int i = TroopFileTransferUtil.Log.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("] reqDownload");
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
    Object localObject3 = TroopFileTransferUtil.a(this.jdField_c_of_type_Long);
    if (localObject3 != null)
    {
      localObject2 = ((TroopFileManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localObject2 != null)
      {
        localObject3 = ((TroopFileManager)localObject3).a(((TroopFileInfo)localObject2).g);
        if (localObject3 != null)
        {
          ((TroopFileInfo)localObject2).e = 8;
          ((TroopFileInfo)localObject3).a((TroopFileInfo)localObject2);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = TroopFileProtocol.a((QQAppInterface)localObject1, this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver);
    b(1);
    TroopTechReportUtils.b();
  }
  
  protected void g()
  {
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("] startDownload app=null");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    Object localObject2 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append((String)localObject2);
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = null;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a = FileUtil.a(this.jdField_d_of_type_JavaLangString);
    long l = TroopFileTransferUtil.a();
    int i = TroopFileTransferUtil.Log.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("] startDownload. nSessionId:");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" firstIP=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    ((StringBuilder)localObject2).append(" urlParams:");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append(" mTmpFilePath:");
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = TroopFileDownloader.a((QQAppInterface)localObject1, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */