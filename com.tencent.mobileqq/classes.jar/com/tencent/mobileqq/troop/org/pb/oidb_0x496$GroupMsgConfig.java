package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$GroupMsgConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "bool_uin_enable", "uint32_max_aio_msg", "uint32_enable_helper", "uint32_group_max_number", "uint32_next_update_time" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgConfig.class);
  public final PBBoolField bool_uin_enable = PBField.initBool(false);
  public final PBUInt32Field uint32_enable_helper = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_max_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_aio_msg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_update_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig
 * JD-Core Version:    0.7.0.1
 */