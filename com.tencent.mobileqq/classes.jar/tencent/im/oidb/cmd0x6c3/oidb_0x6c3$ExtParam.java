package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6c3$ExtParam
  extends MessageMicro<ExtParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 106 }, new String[] { "msg_login_sig", "msg_user_login_session" }, new Object[] { null, null }, ExtParam.class);
  public oidb_0x6c3.LoginSig msg_login_sig = new oidb_0x6c3.LoginSig();
  public oidb_0x6c3.UserLoginSession msg_user_login_session = new oidb_0x6c3.UserLoginSession();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExtParam
 * JD-Core Version:    0.7.0.1
 */