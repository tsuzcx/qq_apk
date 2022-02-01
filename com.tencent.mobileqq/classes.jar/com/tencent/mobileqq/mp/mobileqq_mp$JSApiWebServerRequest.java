package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$JSApiWebServerRequest
  extends MessageMicro<JSApiWebServerRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "cmd", "body" }, new Object[] { "", Integer.valueOf(0), "" }, JSApiWebServerRequest.class);
  public final PBStringField body = PBField.initString("");
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest
 * JD-Core Version:    0.7.0.1
 */