package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$SignInStatusYesterdayFirst
  extends MessageMicro<SignInStatusYesterdayFirst>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "yesterdayFirstUid", "yesterdayWord", "yesterdayNick" }, new Object[] { "", "", "" }, SignInStatusYesterdayFirst.class);
  public final PBStringField yesterdayFirstUid = PBField.initString("");
  public final PBStringField yesterdayNick = PBField.initString("");
  public final PBStringField yesterdayWord = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusYesterdayFirst
 * JD-Core Version:    0.7.0.1
 */