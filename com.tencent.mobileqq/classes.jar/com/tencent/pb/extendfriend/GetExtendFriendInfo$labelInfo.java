package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetExtendFriendInfo$labelInfo
  extends MessageMicro<labelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_label_id", "str_label_name" }, new Object[] { Long.valueOf(0L), "" }, labelInfo.class);
  public final PBStringField str_label_name = PBField.initString("");
  public final PBUInt64Field uint64_label_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.extendfriend.GetExtendFriendInfo.labelInfo
 * JD-Core Version:    0.7.0.1
 */