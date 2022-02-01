package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x496$MsgSeqInfo
  extends MessageMicro<MsgSeqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_manager_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_manager_msg_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_first_unread_manager_msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "rpt_manager_uin_list", "uint64_update_time", "uint64_first_unread_manager_msg_seq", "rpt_uint64_manager_msg_seq" }, new Object[] { localLong, localLong, localLong, localLong, localLong }, MsgSeqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.MsgSeqInfo
 * JD-Core Version:    0.7.0.1
 */