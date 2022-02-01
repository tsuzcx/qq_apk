package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatbgInfo$Bg_Req
  extends MessageMicro<Bg_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, Bg_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public chatbgInfo.Platform_Comm_Req comm = new chatbgInfo.Platform_Comm_Req();
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public chatbgInfo.Bg_CheckAuth_Req reqcmd_0x01 = new chatbgInfo.Bg_CheckAuth_Req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Req
 * JD-Core Version:    0.7.0.1
 */