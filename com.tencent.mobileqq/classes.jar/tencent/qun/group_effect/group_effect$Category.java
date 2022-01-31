package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect$Category
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 810 }, new String[] { "name", "wording", "rpt_effect_id", "rpt_effect_info" }, new Object[] { "", "", Integer.valueOf(0), null }, Category.class);
  public final PBStringField name = PBField.initString("");
  public final PBRepeatField rpt_effect_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_effect_info = PBField.initRepeatMessage(group_effect.EffectInfo.class);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect.Category
 * JD-Core Version:    0.7.0.1
 */