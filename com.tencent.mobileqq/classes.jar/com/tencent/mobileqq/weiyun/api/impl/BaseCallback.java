package com.tencent.mobileqq.weiyun.api.impl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.channel.WySender.ICallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.RspMsgBody;
import com.tencent.mobileqq.weiyun.utils.WyLog;

class BaseCallback<T>
  implements WySender.ICallback
{
  private static final String a = HardCodeUtil.a(2131899188);
  private final int b;
  private final IWeiyunCallback<T> c;
  
  BaseCallback(int paramInt, IWeiyunCallback<T> paramIWeiyunCallback)
  {
    this.b = paramInt;
    this.c = paramIWeiyunCallback;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return;
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
        paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
        if (paramString == null)
        {
          WyLog.a().w("BaseCallback", "rspMsgBody is null.");
          paramString = a;
          this.c.a(1828003, paramString, null);
          return;
        }
        switch (this.b)
        {
        default: 
          paramString = a;
          this.c.a(1828001, paramString, null);
          return;
        case 246001: 
          this.c.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
          return;
        case 246000: 
          this.c.a(paramString.QqSdkFileUploadMsgRsp_body);
          return;
        case 245706: 
          this.c.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
          return;
        case 245700: 
          this.c.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
          return;
        case 26113: 
          this.c.a(paramString.LibInfoListGetMsgRsp_body);
          return;
        case 12102: 
          this.c.a(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
          return;
        case 11005: 
          this.c.a(paramString.PwdVerifyMsgRsp_body);
          return;
        case 11001: 
          this.c.a(paramString.PwdQueryMsgRsp_body);
          return;
        case 2804: 
          this.c.a(paramString.DiskAlbumStatusReportRsp_body);
          return;
        case 2803: 
          this.c.a(paramString.DiskPicBackupRsp_body);
          return;
        case 2509: 
          this.c.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
          return;
        case 2414: 
          this.c.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
          return;
        }
        this.c.a(paramString.DiskFileBatchDownloadMsgRsp_body);
        return;
      }
      catch (Throwable paramString)
      {
        WyLog.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
        paramString = a;
        this.c.a(1828003, paramString, null);
        return;
      }
    }
    this.c.a(paramInt, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.BaseCallback
 * JD-Core Version:    0.7.0.1
 */