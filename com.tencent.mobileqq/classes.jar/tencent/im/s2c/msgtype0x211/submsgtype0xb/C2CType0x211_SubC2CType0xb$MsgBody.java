package tencent.im.s2c.msgtype0x211.submsgtype0xb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class C2CType0x211_SubC2CType0xb$MsgBody
  extends MessageMicro
{
  public static final int MSG_MSG_HEADER_FIELD_NUMBER = 1;
  public static final int MSG_REJECT_MOTIFY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_msg_header", "msg_reject_motify" }, new Object[] { null, null }, MsgBody.class);
  public C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader msg_msg_header = new C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader();
  public C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify msg_reject_motify = new C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody
 * JD-Core Version:    0.7.0.1
 */