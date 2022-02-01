package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class SharePicToWXUpHandler
  extends C2CPicUpHandler
{
  protected void setBuType(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(96);
  }
  
  protected void setSsoCmd(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    paramProtoReq.ssoCmd = "LongConn.SharePic2Wechat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.SharePicToWXUpHandler
 * JD-Core Version:    0.7.0.1
 */