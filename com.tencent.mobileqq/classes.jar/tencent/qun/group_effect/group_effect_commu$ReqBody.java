package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public group_effect_commu.TEntryNotifyReq0x2000 st_entry_notify = new group_effect_commu.TEntryNotifyReq0x2000();
  public group_effect_commu.TGetEffectDetailReq0x1 st_get_detail = new group_effect_commu.TGetEffectDetailReq0x1();
  public group_effect_commu.TGetMyEffectReq0x2 st_get_effect = new group_effect_commu.TGetMyEffectReq0x2();
  public group_effect_commu.TGetSwitchOthersReq0x8 st_get_switch_others = new group_effect_commu.TGetSwitchOthersReq0x8();
  public group_effect_commu.TSetMyEffectReq0x4 st_set_effect = new group_effect_commu.TSetMyEffectReq0x4();
  public group_effect_commu.TSetGlobalEffectReq0x20 st_set_global_effect = new group_effect_commu.TSetGlobalEffectReq0x20();
  public group_effect_commu.TSetSwitchReq0x10 st_set_switch = new group_effect_commu.TSetSwitchReq0x10();
  public group_effect_commu.TSetSwitchOthersReq0x40 st_set_switch_others = new group_effect_commu.TSetSwitchOthersReq0x40();
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt64Field u64_cmd = PBField.initUInt64(0L);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 2402 }, new String[] { "u64_cmd", "u64_uin", "i32_implat", "str_version", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify" }, new Object[] { localLong, localLong, Integer.valueOf(0), "", null, null, null, null, null, null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.ReqBody
 * JD-Core Version:    0.7.0.1
 */