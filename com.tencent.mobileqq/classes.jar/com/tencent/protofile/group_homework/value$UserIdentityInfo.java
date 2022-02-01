package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$UserIdentityInfo
  extends MessageMicro<UserIdentityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66 }, new String[] { "group_id", "id", "course", "title", "name", "ts", "type", "tmp_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, UserIdentityInfo.class);
  public final PBStringField course = PBField.initString("");
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public UserIdentityInfo tmp_info = new UserIdentityInfo();
  public final PBUInt32Field ts = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.UserIdentityInfo
 * JD-Core Version:    0.7.0.1
 */