package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$StSignInStatusRsp
  extends MessageMicro<StSignInStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "ret", "base", "yesterday", "notInfo", "doneInfo", "groupScore", "mantleUrl", "backgroundUrl" }, new Object[] { null, null, null, null, null, null, "", "" }, StSignInStatusRsp.class);
  public final PBStringField backgroundUrl = PBField.initString("");
  public oidb_0xeb7.SignInStatusBase base = new oidb_0xeb7.SignInStatusBase();
  public oidb_0xeb7.SignInStatusDoneInfo doneInfo = new oidb_0xeb7.SignInStatusDoneInfo();
  public oidb_0xeb7.SignInStatusGroupScore groupScore = new oidb_0xeb7.SignInStatusGroupScore();
  public final PBStringField mantleUrl = PBField.initString("");
  public oidb_0xeb7.SignInStatusNotInfo notInfo = new oidb_0xeb7.SignInStatusNotInfo();
  public oidb_0xeb7.Ret ret = new oidb_0xeb7.Ret();
  public oidb_0xeb7.SignInStatusYesterdayFirst yesterday = new oidb_0xeb7.SignInStatusYesterdayFirst();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInStatusRsp
 * JD-Core Version:    0.7.0.1
 */