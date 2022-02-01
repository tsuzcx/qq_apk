package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$BroadcastMsgCtrMsgReq
  extends MessageMicro<BroadcastMsgCtrMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ex2_tlv_trans2_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_red_packet = PBField.initEnum(0);
  public BroadcastMsgCtr.Ex2tlvGroupInfo group_info_tlv = new BroadcastMsgCtr.Ex2tlvGroupInfo();
  public BroadcastMsgCtr.BroadcastMsgCtrInstInfo msg_from_inst_info = new BroadcastMsgCtr.BroadcastMsgCtrInstInfo();
  public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrInstInfo> msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrInstInfo.class);
  public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrMsgUnit.class);
  public final PBUInt32Field uint32_feeds_topic_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_ex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_ex2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_ex3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_ex4 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_id_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_total_pkg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mem_level_name_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_message_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_sys_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_spec_focus_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_spec_hated_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBBoolField whether_anonymous_message = PBField.initBool(false);
  public final PBBoolField whether_store_message = PBField.initBool(false);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 112, 122, 138, 144, 152, 160, 168, 176, 184, 192, 202, 208, 216, 224 }, new String[] { "uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_spec_focus_flag", "uint32_msg_time", "whether_store_message", "uint32_msg_sys_seq", "whether_anonymous_message", "uint32_id_info", "group_info_tlv", "msg_roaming_dst_insts", "uint32_spec_hated_flag", "enum_red_packet", "uint32_feeds_topic_flag", "uint32_flag_ex2", "uint32_mem_level_name_seq", "uint32_flag_ex", "uint32_message_type", "bytes_ex2_tlv_trans2_buf", "uint32_flag_ex3", "uint32_flag_ex4", "uint32_is_total_pkg" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.BroadcastMsgCtrMsgReq
 * JD-Core Version:    0.7.0.1
 */