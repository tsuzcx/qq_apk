package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x8d$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_notify_infos", "red_spot_notify_body" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x8d.RedSpotNotifyBody red_spot_notify_body = new SubMsgType0x8d.RedSpotNotifyBody();
  public final PBRepeatMessageField<SubMsgType0x8d.NotifyBody> rpt_msg_notify_infos = PBField.initRepeatMessage(SubMsgType0x8d.NotifyBody.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.MsgBody
 * JD-Core Version:    0.7.0.1
 */