package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect$Banner
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 810 }, new String[] { "effect_id", "bottom_url", "top_url", "goto_url", "time_begin", "time_end", "effect_info" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, Banner.class);
  public final PBStringField bottom_url = PBField.initString("");
  public final PBUInt32Field effect_id = PBField.initUInt32(0);
  public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
  public final PBStringField goto_url = PBField.initString("");
  public final PBUInt32Field time_begin = PBField.initUInt32(0);
  public final PBUInt32Field time_end = PBField.initUInt32(0);
  public final PBStringField top_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect.Banner
 * JD-Core Version:    0.7.0.1
 */