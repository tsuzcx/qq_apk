package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x8fd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_grp_member_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<Oidb_0x8fd.GroupMemberInfo> rpt_msg_grp_member_info = PBField.initRepeatMessage(Oidb_0x8fd.GroupMemberInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fd.Oidb_0x8fd.RspBody
 * JD-Core Version:    0.7.0.1
 */