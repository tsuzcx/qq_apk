package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class value$GroupUserIdentity
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, GroupUserIdentity.class);
  public final PBRepeatMessageField infos = PBField.initRepeatMessage(value.UserIdentityInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.GroupUserIdentity
 * JD-Core Version:    0.7.0.1
 */