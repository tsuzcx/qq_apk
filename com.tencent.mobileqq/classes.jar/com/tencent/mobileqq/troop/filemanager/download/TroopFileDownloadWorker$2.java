package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.HexUtil;
import java.io.File;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TroopFileDownloadWorker$2
  extends TroopFileReqDownloadFileObserver
{
  TroopFileDownloadWorker$2(TroopFileDownloadWorker paramTroopFileDownloadWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    this.a.h = MessageCache.a();
    if (paramBundle.getLong("troopUin") != this.a.jdField_c_of_type_Long) {
      return;
    }
    String str = paramBundle.getString("itemKey");
    if (str == null) {
      return;
    }
    if (!UUID.fromString(str).equals(this.a.a())) {
      return;
    }
    if (this.a.b) {
      return;
    }
    int i = paramBundle.getInt("thumbNail");
    boolean bool = paramBundle.getBoolean("isPreview", false);
    if (i == 0)
    {
      if (bool) {
        return;
      }
      if ((paramDownloadFileRspBody != null) && (paramBoolean))
      {
        i = paramDownloadFileRspBody.int32_ret_code.get();
        int j = TroopFileTransferUtil.Log.a;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.jdField_a_of_type_JavaLangString);
        paramBundle.append("] onReqDownloadResult isSuccess:true  errCode:");
        paramBundle.append(paramInt);
        paramBundle.append(" retCode:");
        paramBundle.append(i);
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", j, paramBundle.toString());
        if (i < 0)
        {
          if ((i != -302) && (i != -301))
          {
            if (i != -134) {
              if (i != -107)
              {
                if (i == -103) {
                  break label370;
                }
                if (i != -102) {}
              }
              else
              {
                this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
                this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
                paramDownloadFileRspBody = this.a;
                paramDownloadFileRspBody.jdField_c_of_type_Boolean = true;
                paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 101);
                return;
              }
            }
            if ((i == -134) || (i == -133) || (i == -132)) {
              break label508;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
            this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
            paramDownloadFileRspBody = this.a;
            paramDownloadFileRspBody.jdField_c_of_type_Boolean = true;
            paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 1);
            return;
          }
          label370:
          TroopFileDataCenter.b(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 301);
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
            new File(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.deleteThumbnailFile(this.a.jdField_c_of_type_Long, 128);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.deleteThumbnailFile(this.a.jdField_c_of_type_Long, 640);
          this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
          paramDownloadFileRspBody = this.a;
          paramDownloadFileRspBody.jdField_c_of_type_Boolean = true;
          paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i);
          return;
        }
        label508:
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
          paramInt = TroopFileTransferUtil.Log.a;
          paramDownloadFileRspBody = new StringBuilder();
          paramDownloadFileRspBody.append("[");
          paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
          paramDownloadFileRspBody.append("] onReqDownloadResult DownloadIp is null");
          TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramDownloadFileRspBody.toString());
          TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
        }
        if ((i != -133) && (i != -132))
        {
          if (i == -134)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
            this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
            paramDownloadFileRspBody = this.a;
            paramDownloadFileRspBody.jdField_c_of_type_Boolean = true;
            paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 302);
          }
        }
        else {
          TroopFileDataCenter.a(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status, 309);
        }
        paramInt = TroopFileTransferUtil.Log.a;
        paramDownloadFileRspBody = new StringBuilder();
        paramDownloadFileRspBody.append("[");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
        paramDownloadFileRspBody.append("] onReqDownloadResult DownloadIp:");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
        paramDownloadFileRspBody.append(" DownloadDNS:");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        paramDownloadFileRspBody.append(" NameForSave:");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave);
        paramDownloadFileRspBody.append(" DownloadUrl:");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl);
        paramDownloadFileRspBody.append(" cookieValue:");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt, paramDownloadFileRspBody.toString());
        this.a.g();
        return;
      }
      i = TroopFileTransferUtil.Log.a;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
      paramDownloadFileRspBody.append("] onReqDownloadResult isSuccess:false  errCode:");
      paramDownloadFileRspBody.append(paramInt);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramDownloadFileRspBody.toString());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = paramInt;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.A, 103);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.2
 * JD-Core Version:    0.7.0.1
 */