package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class HotPicMsg$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_imginfo_rsp", "msg_get_videoinfo_rsp" }, new Object[] { null, null }, RspBody.class);
  public HotPicMsg.GetImgInfoRsp msg_get_imginfo_rsp = new HotPicMsg.GetImgInfoRsp();
  public HotPicMsg.GetVideoInfoRsp msg_get_videoinfo_rsp = new HotPicMsg.GetVideoInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.RspBody
 * JD-Core Version:    0.7.0.1
 */