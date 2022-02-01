package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class TroopFileUploadSimpleWorker$1
  extends TroopFileReqUploadFileObserver
{
  TroopFileUploadSimpleWorker$1(TroopFileUploadSimpleWorker paramTroopFileUploadSimpleWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    TroopFileUploadSimpleWorker.a(this.a, null);
    if (TroopFileUploadSimpleWorker.a(this.a))
    {
      TroopFileTransferUtil.Log.b("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.a, "[" + TroopFileUploadSimpleWorker.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.a, "[" + TroopFileUploadSimpleWorker.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      TroopFileUploadSimpleWorker.a(this.a, TroopTechReportUtils.TroopFileReportResultCode.A);
      TroopFileUploadSimpleWorker.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.a, "[" + TroopFileUploadSimpleWorker.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      TroopFileUploadSimpleWorker.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        TroopFileUploadSimpleWorker.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (TroopFileUploadSimpleWorker.a(this.a) != 104)
        {
          TroopFileUploadSimpleWorker.a(this.a, 104);
          TroopFileUploadSimpleWorker.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          TroopFileUploadSimpleWorker.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    TroopFileUploadSimpleWorker.b(this.a, paramUploadFileRspBody.str_file_id.get());
    TroopFileUploadSimpleWorker.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    TroopFileUploadSimpleWorker.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    TroopFileUploadSimpleWorker.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    TroopFileUploadSimpleWorker.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.a, "[" + TroopFileUploadSimpleWorker.a(this.a) + "] onReqUploadFileResult fileid:" + TroopFileUploadSimpleWorker.b(this.a) + " UploadIp:" + TroopFileUploadSimpleWorker.c(this.a) + " ServerDns:" + TroopFileUploadSimpleWorker.d(this.a) + " busId:" + TroopFileUploadSimpleWorker.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadSimpleWorker.1
 * JD-Core Version:    0.7.0.1
 */