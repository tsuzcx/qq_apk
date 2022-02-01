package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xeb7$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "signInStatusRsp", "signInWriteRsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xeb7.StSignInStatusRsp signInStatusRsp = new oidb_0xeb7.StSignInStatusRsp();
  public oidb_0xeb7.StSignInWriteRsp signInWriteRsp = new oidb_0xeb7.StSignInWriteRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.RspBody
 * JD-Core Version:    0.7.0.1
 */