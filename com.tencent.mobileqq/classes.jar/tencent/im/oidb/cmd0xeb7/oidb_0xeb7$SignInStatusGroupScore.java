package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$SignInStatusGroupScore
  extends MessageMicro<SignInStatusGroupScore>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "groupScoreWord", "scoreUrl" }, new Object[] { "", "" }, SignInStatusGroupScore.class);
  public final PBStringField groupScoreWord = PBField.initString("");
  public final PBStringField scoreUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusGroupScore
 * JD-Core Version:    0.7.0.1
 */