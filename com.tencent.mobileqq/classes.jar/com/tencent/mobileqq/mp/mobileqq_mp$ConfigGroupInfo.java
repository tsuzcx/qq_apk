package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobileqq_mp$ConfigGroupInfo
  extends MessageMicro<ConfigGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_info" }, new Object[] { null }, ConfigGroupInfo.class);
  public final PBRepeatMessageField<mobileqq_mp.ConfigInfo> config_info = PBField.initRepeatMessage(mobileqq_mp.ConfigInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo
 * JD-Core Version:    0.7.0.1
 */