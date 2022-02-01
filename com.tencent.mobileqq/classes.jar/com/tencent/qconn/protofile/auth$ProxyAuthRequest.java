package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class auth$ProxyAuthRequest
  extends MessageMicro<ProxyAuthRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "appid" }, new Object[] { Long.valueOf(0L) }, ProxyAuthRequest.class);
  public final PBInt64Field appid = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qconn.protofile.auth.ProxyAuthRequest
 * JD-Core Version:    0.7.0.1
 */