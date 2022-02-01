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
    if (paramBundle.getLong("troopUin") != this.a.jdField_c_of_type_Long) {}
    boolean bool;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("itemKey");
      } while ((str == null) || (!UUID.fromString(str).equals(this.a.a())) || (this.a.b));
      i = paramBundle.getInt("thumbNail");
      bool = paramBundle.getBoolean("isPreview", false);
    } while ((i != 0) || (bool));
    if ((paramDownloadFileRspBody == null) || (!paramBoolean))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:false  errCode:" + paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = paramInt;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.A, 103);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0) {
      switch (i)
      {
      case -134: 
      default: 
        if ((i != -134) && (i != -133) && (i != -132))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
          this.a.jdField_c_of_type_Boolean = true;
          this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 1);
          return;
        }
        break;
      case -107: 
      case -102: 
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
        this.a.jdField_c_of_type_Boolean = true;
        this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 101);
        return;
      case -302: 
      case -301: 
      case -103: 
        TroopFileDataCenter.b(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 301);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
          new File(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.deleteThumbnailFile(this.a.jdField_c_of_type_Long, 128);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.deleteThumbnailFile(this.a.jdField_c_of_type_Long, 640);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
        this.a.jdField_c_of_type_Boolean = true;
        this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i);
        return;
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
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult DownloadIp is null");
      TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
    }
    if ((i == -133) || (i == -132)) {
      TroopFileDataCenter.a(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status, 309);
    }
    while (i != -134)
    {
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult DownloadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " DownloadDNS:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + " NameForSave:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave + " DownloadUrl:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + " cookieValue:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
      this.a.g();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
    this.a.jdField_c_of_type_Boolean = true;
    this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.2
 * JD-Core Version:    0.7.0.1
 */