package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_activity$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_error_code", "act_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<group_activity.GroupAct> act_list = PBField.initRepeatMessage(group_activity.GroupAct.class);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.qun.group_activity.group_activity.RspBody
 * JD-Core Version:    0.7.0.1
 */