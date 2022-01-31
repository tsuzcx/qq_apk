package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_effect_commu$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 2402 }, new String[] { "ret", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null }, RspBody.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public group_effect_commu.TEntryNotifyRsp0x2000 st_entry_notify = new group_effect_commu.TEntryNotifyRsp0x2000();
  public group_effect_commu.TGetEffectDetailRsp0x1 st_get_detail = new group_effect_commu.TGetEffectDetailRsp0x1();
  public group_effect_commu.TGetMyEffectRsp0x2 st_get_effect = new group_effect_commu.TGetMyEffectRsp0x2();
  public group_effect_commu.TGetSwitchOthersRsp0x8 st_get_switch_others = new group_effect_commu.TGetSwitchOthersRsp0x8();
  public group_effect_commu.TSetMyEffectRsp0x4 st_set_effect = new group_effect_commu.TSetMyEffectRsp0x4();
  public group_effect_commu.TSetGlobalEffectRsp0x20 st_set_global_effect = new group_effect_commu.TSetGlobalEffectRsp0x20();
  public group_effect_commu.TSetSwitchRsp0x10 st_set_switch = new group_effect_commu.TSetSwitchRsp0x10();
  public group_effect_commu.TSetSwitchOthersRsp0x40 st_set_switch_others = new group_effect_commu.TSetSwitchOthersRsp0x40();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.RspBody
 * JD-Core Version:    0.7.0.1
 */