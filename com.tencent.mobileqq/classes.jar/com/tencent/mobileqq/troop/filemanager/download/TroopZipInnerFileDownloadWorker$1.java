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
      paramInt2 = TroopFileTransferUtil.Log.a;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.a.jdField_a_of_type_JavaLangString);
      paramString1.append("] onReqDownloadResult isSuccess:false  errCode:");
      paramString1.append(paramInt1);
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", paramInt2, paramString1.toString());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 2;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.A, 103);
      return;
    }
    int i = TroopFileTransferUtil.Log.a;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.a.jdField_a_of_type_JavaLangString);
    paramString1.append("] onReqDownloadResult isSuccess:true  int32_ret_code:");
    paramString1.append(paramInt1);
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, paramString1.toString());
    if ((TextUtils.isEmpty(paramString3)) && (paramInt2 == 0))
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.a.jdField_a_of_type_JavaLangString);
      paramString1.append("] onReqDownloadResult. no host");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", paramInt1, paramString1.toString());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 101;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, TroopTechReportUtils.TroopFileReportResultCode.x, 1);
      return;
    }
    paramString1 = FileManagerUtil.a(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString1))
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.a.jdField_a_of_type_JavaLangString);
      paramString1.append("] onReqDownloadResult. no string_download_url");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", paramInt1, paramString1.toString());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 102;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    paramString2 = URLUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipInnerPath);
    paramByteStringMicro1 = (QQAppInterface)this.mApp.get();
    if ((paramByteStringMicro1 != null) && (TroopFileUtils.a(paramByteStringMicro1)) && (TroopFileUtils.b(paramByteStringMicro1)) && (paramBundle != null))
    {
      paramByteStringMicro1 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramString4 = this.a;
        paramString4.jdField_a_of_type_Boolean = true;
        paramString4.g = paramByteStringMicro1;
        i = (short)paramBundle.getInt("httpsPort", 0);
        paramInt1 = i;
        if (i != 0) {
          break label461;
        }
        paramInt1 = 443;
        break label461;
      }
    }
    paramInt1 = 0;
    label461:
    if (!this.a.jdField_a_of_type_Boolean) {
      paramInt1 = paramInt3;
    }
    paramByteStringMicro1 = this.a;
    paramString4 = new StringBuilder();
    paramString4.append("/ftn_compress_getfile/rkey=");
    paramString4.append(paramString1);
    paramString4.append("&filetype=");
    paramString4.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipType);
    paramString4.append("&path=");
    paramString4.append(paramString2);
    paramString4.append("&mType=Other");
    paramByteStringMicro1.f = paramString4.toString();
    paramString1 = new StringBuilder();
    paramString1.append(paramString3);
    paramString1.append(":");
    paramString1.append(paramInt1);
    paramString1 = paramString1.toString();
    this.a.jdField_a_of_type_JavaUtilList.add(paramString1);
    if (paramInt2 != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.a.a(paramInt2));
      paramString2.append(":");
      paramString2.append(paramInt1);
      paramString2 = paramString2.toString();
      this.a.jdField_a_of_type_JavaUtilList.add(paramString2);
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramString2 = new StringBuilder();
      paramString2.append("https://");
      paramString2.append(paramString1);
      paramString2.append(this.a.f);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("http://");
      paramString2.append(paramString1);
      paramString2.append(this.a.f);
      paramString1 = paramString2.toString();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.PreviewUrl = paramString1;
    try
    {
      paramString1 = new URL(paramString1);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramString1.getHost();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    i = TroopFileTransferUtil.Log.a;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.a.jdField_a_of_type_JavaLangString);
    paramString1.append("] onReqDownloadResult. str_download_dns:");
    paramString1.append(paramString3);
    paramString1.append(" int32_server_ip:");
    paramString1.append(paramInt2);
    paramString1.append(" int32_server_port:");
    paramString1.append(paramInt3);
    paramString1.append(" mUrlParm:");
    paramString1.append(this.a.f);
    paramString1.append(" port:");
    paramString1.append(paramInt1);
    paramString1.append(" isHttps:");
    paramString1.append(this.a.jdField_a_of_type_Boolean);
    paramString1.append(" httpsDomain:");
    paramString1.append(this.a.g);
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, paramString1.toString());
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */