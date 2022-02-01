package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_effect$EffectConfig
  extends MessageMicro<EffectConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_banner", "rpt_category" }, new Object[] { null, null }, EffectConfig.class);
  public final PBRepeatMessageField<group_effect.Banner> rpt_banner = PBField.initRepeatMessage(group_effect.Banner.class);
  public final PBRepeatMessageField<group_effect.Category> rpt_category = PBField.initRepeatMessage(group_effect.Category.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect.EffectConfig
 * JD-Core Version:    0.7.0.1
 */