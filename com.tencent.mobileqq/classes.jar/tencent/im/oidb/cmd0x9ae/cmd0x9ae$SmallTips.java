package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x9ae$SmallTips
  extends MessageMicro<SmallTips>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_tips_context", "string_tips_action_url" }, new Object[] { "", "" }, SmallTips.class);
  public final PBStringField string_tips_action_url = PBField.initString("");
  public final PBStringField string_tips_context = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ae.cmd0x9ae.SmallTips
 * JD-Core Version:    0.7.0.1
 */