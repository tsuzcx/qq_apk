package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class auth$ProxyAuthResponse
  extends MessageMicro<ProxyAuthResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "code", "expires_in" }, new Object[] { "", Long.valueOf(0L) }, ProxyAuthResponse.class);
  public final PBStringField code = PBField.initString("");
  public final PBInt64Field expires_in = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qconn.protofile.auth.ProxyAuthResponse
 * JD-Core Version:    0.7.0.1
 */