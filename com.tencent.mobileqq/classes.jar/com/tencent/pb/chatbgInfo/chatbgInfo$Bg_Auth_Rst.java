package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class chatbgInfo$Bg_Auth_Rst
  extends MessageMicro<Bg_Auth_Rst>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bgId", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_Auth_Rst.class);
  public final PBInt32Field bgId = PBField.initInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Auth_Rst
 * JD-Core Version:    0.7.0.1
 */