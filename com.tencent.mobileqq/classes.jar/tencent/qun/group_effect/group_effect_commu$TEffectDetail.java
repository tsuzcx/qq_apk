package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class group_effect_commu$TEffectDetail
  extends MessageMicro<TEffectDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "st_userconfig", "st_effectinfo" }, new Object[] { null, null }, TEffectDetail.class);
  public group_effect.EffectInfo st_effectinfo = new group_effect.EffectInfo();
  public group_effect.UserConfig st_userconfig = new group_effect.UserConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TEffectDetail
 * JD-Core Version:    0.7.0.1
 */