package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetMessageConfigurationRequest
  extends MessageMicro<GetMessageConfigurationRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "uin", "versionInfo" }, new Object[] { Long.valueOf(0L), "" }, GetMessageConfigurationRequest.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest
 * JD-Core Version:    0.7.0.1
 */