package tencent.im.s2c.msgtype0x210.submsgtype0x7e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class submsgtype0x7e$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_notice", "msg_online_push" }, new Object[] { "", null }, MsgBody.class);
  public submsgtype0x7e.WalletMsgPush msg_online_push = new submsgtype0x7e.WalletMsgPush();
  public final PBStringField str_notice = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e.MsgBody
 * JD-Core Version:    0.7.0.1
 */