package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$BroadcastSystemMsgReq
  extends MessageMicro<BroadcastSystemMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public BroadcastMsgCtr.Ex2tlvGroupInfo group_info_tlv = new BroadcastMsgCtr.Ex2tlvGroupInfo();
  public BroadcastMsgCtr.BroadcastMsgCtrInstInfo msg_from_inst_info = new BroadcastMsgCtr.BroadcastMsgCtrInstInfo();
  public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrInstInfo> msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrInstInfo.class);
  public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrMsgUnit.class);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_sys_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 72, 88, 98, 138 }, new String[] { "uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_msg_time", "uint32_msg_sys_seq", "group_info_tlv", "msg_roaming_dst_insts" }, new Object[] { localLong, null, localByteStringMicro, localInteger, localInteger, null, localLong, localLong, localInteger, localInteger, null, null }, BroadcastSystemMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.BroadcastSystemMsgReq
 * JD-Core Version:    0.7.0.1
 */