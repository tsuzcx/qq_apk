package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.qun.group_effect.group_effect.EffectInfo;

public final class oidb_0x98d$YListRsp
  extends MessageMicro<YListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_effect_info", "user_setting", "svip_level", "group_level" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, YListRsp.class);
  public final PBUInt32Field group_level = PBField.initUInt32(0);
  public final PBRepeatMessageField<group_effect.EffectInfo> rpt_effect_info = PBField.initRepeatMessage(group_effect.EffectInfo.class);
  public final PBUInt32Field svip_level = PBField.initUInt32(0);
  public group_effect.EffectInfo user_setting = new group_effect.EffectInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d.YListRsp
 * JD-Core Version:    0.7.0.1
 */