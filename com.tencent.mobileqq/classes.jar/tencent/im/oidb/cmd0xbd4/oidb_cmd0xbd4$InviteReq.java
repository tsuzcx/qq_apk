package tencent.im.oidb.cmd0xbd4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbd4$InviteReq
  extends MessageMicro<InviteReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_rowkey", "rpt_msg_invitee" }, new Object[] { "", null }, InviteReq.class);
  public final PBRepeatMessageField<oidb_cmd0xbd4.Invitee> rpt_msg_invitee = PBField.initRepeatMessage(oidb_cmd0xbd4.Invitee.class);
  public final PBStringField str_rowkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.InviteReq
 * JD-Core Version:    0.7.0.1
 */