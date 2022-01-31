package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class HotPicMsg$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_imginfo_req", "msg_get_videoinfo_req" }, new Object[] { null, null }, ReqBody.class);
  public HotPicMsg.GetImgInfoReq msg_get_imginfo_req = new HotPicMsg.GetImgInfoReq();
  public HotPicMsg.GetVideoInfoReq msg_get_videoinfo_req = new HotPicMsg.GetVideoInfoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody
 * JD-Core Version:    0.7.0.1
 */