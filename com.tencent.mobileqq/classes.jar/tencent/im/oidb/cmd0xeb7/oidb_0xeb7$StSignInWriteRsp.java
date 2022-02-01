package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xeb7$StSignInWriteRsp
  extends MessageMicro<StSignInWriteRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret", "doneInfo", "groupScore" }, new Object[] { null, null, null }, StSignInWriteRsp.class);
  public oidb_0xeb7.SignInStatusDoneInfo doneInfo = new oidb_0xeb7.SignInStatusDoneInfo();
  public oidb_0xeb7.SignInStatusGroupScore groupScore = new oidb_0xeb7.SignInStatusGroupScore();
  public oidb_0xeb7.Ret ret = new oidb_0xeb7.Ret();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInWriteRsp
 * JD-Core Version:    0.7.0.1
 */