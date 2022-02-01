package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xeb7$SignInStatusDoneInfo
  extends MessageMicro<SignInStatusDoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "leftTitleWrod", "rightDescWord", "belowPortraitWords", "recordUrl" }, new Object[] { "", "", "", "" }, SignInStatusDoneInfo.class);
  public final PBRepeatField<String> belowPortraitWords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField leftTitleWrod = PBField.initString("");
  public final PBStringField recordUrl = PBField.initString("");
  public final PBStringField rightDescWord = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.SignInStatusDoneInfo
 * JD-Core Version:    0.7.0.1
 */