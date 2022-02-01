package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GroupItem
  extends MessageMicro<GroupItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_group_name = PBField.initString("");
  public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_groupid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_groupid", "uint32_group_level", "str_group_name", "uint32_member_num" }, new Object[] { Long.valueOf(0L), localInteger, "", localInteger }, GroupItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GroupItem
 * JD-Core Version:    0.7.0.1
 */