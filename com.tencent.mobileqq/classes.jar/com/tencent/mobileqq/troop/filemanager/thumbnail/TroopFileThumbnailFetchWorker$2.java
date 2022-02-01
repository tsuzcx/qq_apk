package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TroopFileThumbnailFetchWorker$2
  extends TroopFileReqDownloadFileObserver
{
  TroopFileThumbnailFetchWorker$2(TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {
      return;
    }
    String str = paramBundle.getString("itemKey");
    if (str == null) {
      return;
    }
    if (!UUID.fromString(str).equals(this.a.a())) {
      return;
    }
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    int j = paramBundle.getInt("thumbNail");
    int i = 0;
    boolean bool = paramBundle.getBoolean("isPreview", false);
    if ((j != 0) && (!bool))
    {
      if (j != this.a.jdField_a_of_type_Int) {
        return;
      }
      if ((paramDownloadFileRspBody != null) && (paramBoolean))
      {
        j = paramDownloadFileRspBody.int32_ret_code.get();
        int k = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.jdField_a_of_type_JavaLangString);
        paramBundle.append("] onReqFetchResult isSuccess:true  errCode:");
        paramBundle.append(paramInt);
        paramBundle.append(" retCode:");
        paramBundle.append(j);
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", k, paramBundle.toString());
        if (j < 0) {
          if ((j != -103) && (j != -302) && (j != -301))
          {
            this.a.c(j);
          }
          else
          {
            paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
            paramBundle = new StringBuilder();
            paramBundle.append("[");
            paramBundle.append(this.a.jdField_a_of_type_JavaLangString);
            paramBundle.append("] onReqFetchResult  file is not exsit. retCode:");
            paramBundle.append(j);
            TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramBundle.toString());
            paramBundle = this.a;
            paramBundle.jdField_a_of_type_Boolean = true;
            paramBundle.b(4);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
            TroopFileDataCenter.a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener.a(this.a.a(), false, j, this.a);
            }
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue.toLowerCase();
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp))
        {
          paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
          paramBundle = new StringBuilder();
          paramBundle.append("[");
          paramBundle.append(this.a.jdField_a_of_type_JavaLangString);
          paramBundle.append("] onReqFetchResult DownloadIp is null");
          TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramBundle.toString());
          TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
        }
        j = paramDownloadFileRspBody.uint32_preview_port.get();
        paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.jdField_a_of_type_JavaLangString);
        paramBundle.append("] onReqFetchResult DownloadIp:");
        paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        paramBundle.append(" DownloadDNS:");
        paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        paramBundle.append(" videoPort:");
        paramBundle.append(j);
        paramBundle.append(" DownloadUrl:");
        paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl);
        paramBundle.append(" cookieValue:");
        paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt, paramBundle.toString());
        paramInt = i;
        if (paramDownloadFileRspBody.uint32_preview_port_https.has()) {
          paramInt = paramDownloadFileRspBody.uint32_preview_port_https.get();
        }
        paramBundle = null;
        if (paramDownloadFileRspBody.str_download_dns_https.has()) {
          paramBundle = paramDownloadFileRspBody.str_download_dns_https.get();
        }
        this.a.a(j, paramBundle, paramInt);
        return;
      }
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
      paramDownloadFileRspBody.append("] onReqFetchResult isSuccess:false  errCode:");
      paramDownloadFileRspBody.append(paramInt);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramDownloadFileRspBody.toString());
      this.a.c(TroopTechReportUtils.TroopFileReportResultCode.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.2
 * JD-Core Version:    0.7.0.1
 */