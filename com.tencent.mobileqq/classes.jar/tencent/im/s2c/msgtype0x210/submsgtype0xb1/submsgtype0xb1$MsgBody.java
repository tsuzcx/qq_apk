package tencent.im.s2c.msgtype0x210.submsgtype0xb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xb1$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_notify_type", "invite_info", "univite_info", "deal_info" }, new Object[] { Integer.valueOf(0), null, null, null }, MsgBody.class);
  public submsgtype0xb1.DealInviteInfo deal_info = new submsgtype0xb1.DealInviteInfo();
  public submsgtype0xb1.InviteInfo invite_info = new submsgtype0xb1.InviteInfo();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public submsgtype0xb1.UninviteInfo univite_info = new submsgtype0xb1.UninviteInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody
 * JD-Core Version:    0.7.0.1
 */