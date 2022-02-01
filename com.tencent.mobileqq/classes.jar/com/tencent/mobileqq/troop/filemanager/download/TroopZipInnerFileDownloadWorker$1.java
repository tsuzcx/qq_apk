package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

class TroopZipInnerFileDownloadWorker$1
  extends TroopFileGetFilePreviewObserver
{
  TroopZipInnerFileDownloadWorker$1(TroopZipInnerFileDownloadWorker paramTroopZipInnerFileDownloadWorker) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:false  errCode:" + paramInt1);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 2;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.A, 103);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:true  int32_ret_code:" + paramInt1);
    if ((paramInt1 == 0) || ((TextUtils.isEmpty(paramString3)) && (paramInt2 == 0)))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. no host");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 101;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, TroopTechReportUtils.TroopFileReportResultCode.x, 1);
      return;
    }
    paramString1 = FileManagerUtil.a(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString1))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. no string_download_url");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 102;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    paramString2 = URLUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipInnerPath);
    paramByteStringMicro1 = (QQAppInterface)this.b.get();
    if ((paramByteStringMicro1 != null) && (TroopFileUtils.b(paramByteStringMicro1)) && (TroopFileUtils.c(paramByteStringMicro1)) && (paramBundle != null))
    {
      paramByteStringMicro1 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.g = paramByteStringMicro1;
        int i = (short)paramBundle.getInt("httpsPort", 0);
        paramInt1 = i;
        if (i != 0) {}
      }
    }
    for (paramInt1 = 443;; paramInt1 = 0)
    {
      if (this.a.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        this.a.f = ("/ftn_compress_getfile/rkey=" + paramString1 + "&filetype=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipType + "&path=" + paramString2 + "&mType=Other");
        paramString1 = paramString3 + ":" + paramInt1;
        this.a.jdField_a_of_type_JavaUtilList.add(paramString1);
        if (paramInt2 != 0)
        {
          paramString2 = this.a.a(paramInt2) + ":" + paramInt1;
          this.a.jdField_a_of_type_JavaUtilList.add(paramString2);
        }
        if (this.a.jdField_a_of_type_Boolean) {
          paramString1 = "https://" + paramString1 + this.a.f;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.PreviewUrl = paramString1;
          try
          {
            paramString1 = new URL(paramString1);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramString1.getHost();
            TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. str_download_dns:" + paramString3 + " int32_server_ip:" + paramInt2 + " int32_server_port:" + paramInt3 + " mUrlParm:" + this.a.f + " port:" + paramInt1 + " isHttps:" + this.a.jdField_a_of_type_Boolean + " httpsDomain:" + this.a.g);
            this.a.g();
            return;
            paramString1 = "http://" + paramString1 + this.a.f;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
        paramInt1 = paramInt3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */