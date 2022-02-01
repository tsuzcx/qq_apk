package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x2dc$GroupVisitorJoinMsg
  extends MessageMicro<GroupVisitorJoinMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0x2dc.VisitorJoinInfo> rpt_msg_visitor_join_info = PBField.initRepeatMessage(cmd0x2dc.VisitorJoinInfo.class);
  public final PBUInt32Field uint32_op_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_uin", "uint64_group_code", "rpt_msg_visitor_join_info", "uint32_op_flag" }, new Object[] { localLong, localLong, null, Integer.valueOf(0) }, GroupVisitorJoinMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg
 * JD-Core Version:    0.7.0.1
 */