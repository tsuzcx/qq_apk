package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class PicAioQzonePreSendMgr$1
  implements RichProtoProc.RichProtoCallback
{
  PicAioQzonePreSendMgr$1(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    int j = 0;
    while (j < paramRichProtoResp.resps.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(j);
      int i = -1;
      if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
        i = ((RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq).result;
      } else if ((paramRichProtoReq instanceof RichProto.RichProtoResp.C2CPicUpResp)) {
        i = ((RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoReq).result;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("picPreSendProcess request Result, resultCode:");
        localStringBuilder.append(i);
        localStringBuilder.append(", selfUin:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", friendUin:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", md5:");
        localStringBuilder.append(this.c.rawMd5);
        localStringBuilder.append(", commonInfo:");
        localStringBuilder.append(paramRichProtoReq.toString());
        QLog.i("PicAioQzonePreSendMgr", 2, localStringBuilder.toString());
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicAioQzonePreSendMgr.1
 * JD-Core Version:    0.7.0.1
 */