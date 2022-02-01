package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x751$RspCheckIsConfMember
  extends MessageMicro<RspCheckIsConfMember>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_check_is_conf_member_result" }, new Object[] { null }, RspCheckIsConfMember.class);
  public final PBRepeatMessageField<oidb_0x751.CheckIsConfMemberResult> msg_check_is_conf_member_result = PBField.initRepeatMessage(oidb_0x751.CheckIsConfMemberResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x751.oidb_0x751.RspCheckIsConfMember
 * JD-Core Version:    0.7.0.1
 */