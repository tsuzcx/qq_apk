package tencent.im.s2c.msgtype0x210.submsgtype0xc6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xc6$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sec_cmd", "msg_s2c_account_exception_notify" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public SubMsgType0xc6.AccountExceptionAlertBody msg_s2c_account_exception_notify = new SubMsgType0xc6.AccountExceptionAlertBody();
  public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.MsgBody
 * JD-Core Version:    0.7.0.1
 */