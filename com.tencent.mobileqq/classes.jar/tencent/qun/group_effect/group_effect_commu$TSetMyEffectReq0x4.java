package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_effect_commu$TSetMyEffectReq0x4
  extends MessageMicro<TSetMyEffectReq0x4>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_config" }, new Object[] { null }, TSetMyEffectReq0x4.class);
  public final PBRepeatMessageField<group_effect.UserConfig> user_config = PBField.initRepeatMessage(group_effect.UserConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TSetMyEffectReq0x4
 * JD-Core Version:    0.7.0.1
 */