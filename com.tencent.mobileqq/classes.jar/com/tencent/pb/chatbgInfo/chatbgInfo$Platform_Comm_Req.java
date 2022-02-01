package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class chatbgInfo$Platform_Comm_Req
  extends MessageMicro<Platform_Comm_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ImPlat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform_Comm_Req.class);
  public final PBInt64Field ImPlat = PBField.initInt64(0L);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Platform_Comm_Req
 * JD-Core Version:    0.7.0.1
 */