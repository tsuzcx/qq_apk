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
    if (paramBundle.getLong("troopUin") != this.a.a) {
      return;
    }
    String str = paramBundle.getString("itemKey");
    if (str == null) {
      return;
    }
    if (!UUID.fromString(str).equals(this.a.a())) {
      return;
    }
    if (this.a.d) {
      return;
    }
    int j = paramBundle.getInt("thumbNail");
    int i = 0;
    boolean bool = paramBundle.getBoolean("isPreview", false);
    if ((j != 0) && (!bool))
    {
      if (j != this.a.k) {
        return;
      }
      if ((paramDownloadFileRspBody != null) && (paramBoolean))
      {
        j = paramDownloadFileRspBody.int32_ret_code.get();
        int k = TroopFileTransferUtil.Log.b;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.c);
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
            paramInt = TroopFileTransferUtil.Log.b;
            paramBundle = new StringBuilder();
            paramBundle.append("[");
            paramBundle.append(this.a.c);
            paramBundle.append("] onReqFetchResult  file is not exsit. retCode:");
            paramBundle.append(j);
            TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramBundle.toString());
            paramBundle = this.a;
            paramBundle.d = true;
            paramBundle.b(4);
            this.a.b.ErrorCode = 0;
            TroopFileDataCenter.a(this.a.a, this.a.b, 12);
            if (this.a.f != null) {
              this.a.f.a(this.a.b(), false, j, this.a);
            }
          }
        }
        this.a.b.cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        if (this.a.b.cookieValue != null) {
          this.a.b.cookieValue = this.a.b.cookieValue.toLowerCase();
        }
        this.a.b.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
        this.a.b.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
        this.a.b.DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        this.a.b.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
        this.a.b.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
        if (TextUtils.isEmpty(this.a.b.DownloadIp))
        {
          paramInt = TroopFileTransferUtil.Log.b;
          paramBundle = new StringBuilder();
          paramBundle.append("[");
          paramBundle.append(this.a.c);
          paramBundle.append("] onReqFetchResult DownloadIp is null");
          TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramBundle.toString());
          TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
        }
        j = paramDownloadFileRspBody.uint32_preview_port.get();
        paramInt = TroopFileTransferUtil.Log.b;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.c);
        paramBundle.append("] onReqFetchResult DownloadIp:");
        paramBundle.append(this.a.b.DownloadIp);
        paramBundle.append(" DownloadDNS:");
        paramBundle.append(this.a.b.DownloadDNS);
        paramBundle.append(" videoPort:");
        paramBundle.append(j);
        paramBundle.append(" DownloadUrl:");
        paramBundle.append(this.a.b.DownloadUrl);
        paramBundle.append(" cookieValue:");
        paramBundle.append(this.a.b.cookieValue);
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
      i = TroopFileTransferUtil.Log.b;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.c);
      paramDownloadFileRspBody.append("] onReqFetchResult isSuccess:false  errCode:");
      paramDownloadFileRspBody.append(paramInt);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramDownloadFileRspBody.toString());
      this.a.c(TroopTechReportUtils.TroopFileReportResultCode.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.2
 * JD-Core Version:    0.7.0.1
 */