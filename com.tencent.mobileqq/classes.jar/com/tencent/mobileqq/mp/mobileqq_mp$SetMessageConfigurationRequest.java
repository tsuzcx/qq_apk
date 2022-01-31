package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SetMessageConfigurationRequest
  extends MessageMicro<SetMessageConfigurationRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "type", "versionInfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, SetMessageConfigurationRequest.class);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest
 * JD-Core Version:    0.7.0.1
 */