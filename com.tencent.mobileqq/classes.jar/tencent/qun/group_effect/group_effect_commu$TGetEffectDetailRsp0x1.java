package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_effect_commu$TGetEffectDetailRsp0x1
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "rpt_effectinfo" }, new Object[] { Integer.valueOf(0), null }, TGetEffectDetailRsp0x1.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_effectinfo = PBField.initRepeatMessage(group_effect.EffectInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TGetEffectDetailRsp0x1
 * JD-Core Version:    0.7.0.1
 */