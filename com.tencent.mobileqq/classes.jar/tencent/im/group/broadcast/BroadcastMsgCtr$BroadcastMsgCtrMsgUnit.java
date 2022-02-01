package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$BroadcastMsgCtrMsgUnit
  extends MessageMicro<BroadcastMsgCtrMsgUnit>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bsavemsgdb = PBField.initBool(false);
  public final PBBytesField bytes_tlv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_member_flag_ex2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_intelligent_terminal_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_ctr_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_msg_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_bits = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "uint64_uin", "bytes_tlv", "uint32_msg_ctr_cmd", "uint32_msg_mask", "uint32_intelligent_terminal_flag", "uint32_online_bits", "uint32_mobile_flag", "uint32_new_msg_mask", "bsavemsgdb", "uint32_group_member_flag_ex2", "uint32_read_msg_seq" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrMsgUnit.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.BroadcastMsgCtrMsgUnit
 * JD-Core Version:    0.7.0.1
 */