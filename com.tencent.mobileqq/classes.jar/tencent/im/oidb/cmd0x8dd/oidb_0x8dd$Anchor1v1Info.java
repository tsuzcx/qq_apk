package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x8dd$Anchor1v1Info
  extends MessageMicro<Anchor1v1Info>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42, 50 }, new String[] { "str_jump_url", "str_wording", "str_tags" }, new Object[] { "", "", "" }, Anchor1v1Info.class);
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBRepeatField<String> str_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Anchor1v1Info
 * JD-Core Version:    0.7.0.1
 */