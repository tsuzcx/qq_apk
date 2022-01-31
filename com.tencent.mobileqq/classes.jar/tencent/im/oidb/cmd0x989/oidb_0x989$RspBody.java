package tencent.im.oidb.cmd0x989;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.qun.group_effect.group_effect.EffectInfo;

public final class oidb_0x989$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wording", "effect_info" }, new Object[] { "", null }, RspBody.class);
  public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x989.oidb_0x989.RspBody
 * JD-Core Version:    0.7.0.1
 */