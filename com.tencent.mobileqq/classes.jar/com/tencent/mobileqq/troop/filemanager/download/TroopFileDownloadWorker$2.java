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
    this.a.v = MessageCache.c();
    if (paramBundle.getLong("troopUin") != this.a.d) {
      return;
    }
    String str = paramBundle.getString("itemKey");
    if (str == null) {
      return;
    }
    if (!UUID.fromString(str).equals(this.a.h())) {
      return;
    }
    if (this.a.g) {
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
        int j = TroopFileTransferUtil.Log.b;
        paramBundle = new StringBuilder();
        paramBundle.append("[");
        paramBundle.append(this.a.f);
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
                this.a.q.k = 1;
                this.a.q.l = i;
                paramDownloadFileRspBody = this.a;
                paramDownloadFileRspBody.w = true;
                paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 101);
                return;
              }
            }
            if ((i == -134) || (i == -133) || (i == -132)) {
              break label508;
            }
            this.a.q.k = 1;
            this.a.q.l = i;
            paramDownloadFileRspBody = this.a;
            paramDownloadFileRspBody.w = true;
            paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 1);
            return;
          }
          label370:
          TroopFileDataCenter.b(this.a.d, this.a.e, 301);
          if (this.a.e.TmpFile != null) {
            new File(this.a.e.TmpFile).delete();
          }
          this.a.e.deleteThumbnailFile(this.a.d, 128);
          this.a.e.deleteThumbnailFile(this.a.d, 640);
          this.a.q.k = 1;
          this.a.q.l = i;
          paramDownloadFileRspBody = this.a;
          paramDownloadFileRspBody.w = true;
          paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i);
          return;
        }
        label508:
        this.a.e.cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
        if (this.a.e.cookieValue != null) {
          this.a.e.cookieValue = this.a.e.cookieValue.toLowerCase();
        }
        this.a.e.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
        this.a.e.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
        this.a.e.DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
        this.a.e.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
        this.a.e.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
        if (TextUtils.isEmpty(this.a.e.DownloadIp))
        {
          paramInt = TroopFileTransferUtil.Log.b;
          paramDownloadFileRspBody = new StringBuilder();
          paramDownloadFileRspBody.append("[");
          paramDownloadFileRspBody.append(this.a.f);
          paramDownloadFileRspBody.append("] onReqDownloadResult DownloadIp is null");
          TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt, paramDownloadFileRspBody.toString());
          TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
        }
        if ((i != -133) && (i != -132))
        {
          if (i == -134)
          {
            this.a.q.k = 1;
            this.a.q.l = i;
            paramDownloadFileRspBody = this.a;
            paramDownloadFileRspBody.w = true;
            paramDownloadFileRspBody.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, 302);
          }
        }
        else {
          TroopFileDataCenter.a(this.a.d, this.a.e, this.a.e.Status, 309);
        }
        paramInt = TroopFileTransferUtil.Log.b;
        paramDownloadFileRspBody = new StringBuilder();
        paramDownloadFileRspBody.append("[");
        paramDownloadFileRspBody.append(this.a.f);
        paramDownloadFileRspBody.append("] onReqDownloadResult DownloadIp:");
        paramDownloadFileRspBody.append(this.a.e.DownloadIp);
        paramDownloadFileRspBody.append(" DownloadDNS:");
        paramDownloadFileRspBody.append(this.a.e.DownloadDNS);
        paramDownloadFileRspBody.append(" NameForSave:");
        paramDownloadFileRspBody.append(this.a.e.NameForSave);
        paramDownloadFileRspBody.append(" DownloadUrl:");
        paramDownloadFileRspBody.append(this.a.e.DownloadUrl);
        paramDownloadFileRspBody.append(" cookieValue:");
        paramDownloadFileRspBody.append(this.a.e.cookieValue);
        TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt, paramDownloadFileRspBody.toString());
        this.a.l();
        return;
      }
      i = TroopFileTransferUtil.Log.b;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.f);
      paramDownloadFileRspBody.append("] onReqDownloadResult isSuccess:false  errCode:");
      paramDownloadFileRspBody.append(paramInt);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramDownloadFileRspBody.toString());
      this.a.q.k = 1;
      this.a.q.l = paramInt;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.A, 103);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.2
 * JD-Core Version:    0.7.0.1
 */