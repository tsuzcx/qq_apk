package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x9ae$AuthTips
  extends MessageMicro<AuthTips>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "string_tips_title", "string_tips_context", "string_tips_action", "string_tips_action_url", "string_lbutton", "string_rbutton" }, new Object[] { "", "", "", "", "", "" }, AuthTips.class);
  public final PBStringField string_lbutton = PBField.initString("");
  public final PBStringField string_rbutton = PBField.initString("");
  public final PBStringField string_tips_action = PBField.initString("");
  public final PBStringField string_tips_action_url = PBField.initString("");
  public final PBStringField string_tips_context = PBField.initString("");
  public final PBStringField string_tips_title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips
 * JD-Core Version:    0.7.0.1
 */