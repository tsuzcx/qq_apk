package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect_commu$TGetMyEffectRsp0x2
  extends MessageMicro<TGetMyEffectRsp0x2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "ret", "global_effect_id", "st_global_effectinfo", "rpt_userconfig", "query_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, TGetMyEffectRsp0x2.class);
  public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field query_interval = PBField.initUInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBRepeatMessageField<group_effect_commu.TEffectDetail> rpt_userconfig = PBField.initRepeatMessage(group_effect_commu.TEffectDetail.class);
  public group_effect.EffectInfo st_global_effectinfo = new group_effect.EffectInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2
 * JD-Core Version:    0.7.0.1
 */