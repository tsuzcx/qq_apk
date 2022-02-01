package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$BroadcastMsgCtrMsgRsp
  extends MessageMicro<BroadcastMsgCtrMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_fail_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_succ_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_group_uin", "uint64_from_uin", "uint32_msg_seq", "uint32_msg_type", "uint32_succ_count", "uint32_fail_count" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger }, BroadcastMsgCtrMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.BroadcastMsgCtrMsgRsp
 * JD-Core Version:    0.7.0.1
 */