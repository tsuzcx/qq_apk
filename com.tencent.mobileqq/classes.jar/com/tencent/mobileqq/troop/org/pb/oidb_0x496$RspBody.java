package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x496$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x496.AioKeyword aio_keyword_config = new oidb_0x496.AioKeyword();
  public oidb_0x496.GroupMsgConfig msg_group_msg_config = new oidb_0x496.GroupMsgConfig();
  public oidb_0x496.Robot robot_config = new oidb_0x496.Robot();
  public final PBRepeatMessageField<oidb_0x496.MsgSeqInfo> rpt_msg_seq_info = PBField.initRepeatMessage(oidb_0x496.MsgSeqInfo.class);
  public final PBUInt64Field uint64_max_aio_msg = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_max_position_msg = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "rpt_msg_seq_info", "uint64_max_aio_msg", "uint64_max_position_msg", "msg_group_msg_config", "robot_config", "aio_keyword_config" }, new Object[] { null, localLong, localLong, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody
 * JD-Core Version:    0.7.0.1
 */