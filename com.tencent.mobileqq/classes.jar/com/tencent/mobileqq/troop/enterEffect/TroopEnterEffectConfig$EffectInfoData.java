package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.group_effect.UserConfig;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;

public class TroopEnterEffectConfig$EffectInfoData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  
  public group_effect_commu.TEffectDetail a()
  {
    group_effect_commu.TEffectDetail localTEffectDetail = new group_effect_commu.TEffectDetail();
    Object localObject = new group_effect.UserConfig();
    ((group_effect.UserConfig)localObject).effect_id.set(this.jdField_a_of_type_Int);
    ((group_effect.UserConfig)localObject).group_code.set(this.jdField_a_of_type_Long);
    localObject = ((group_effect.UserConfig)localObject).status;
    if (this.jdField_a_of_type_Boolean) {}
    for (long l = 1L;; l = 0L)
    {
      ((PBUInt64Field)localObject).set(l);
      new group_effect.EffectInfo().name.set(this.jdField_a_of_type_JavaLangString);
      return localTEffectDetail;
    }
  }
  
  public void a(group_effect_commu.TEffectDetail paramTEffectDetail)
  {
    group_effect.UserConfig localUserConfig = (group_effect.UserConfig)paramTEffectDetail.st_userconfig.get();
    paramTEffectDetail = (group_effect.EffectInfo)paramTEffectDetail.st_effectinfo.get();
    this.jdField_a_of_type_Int = localUserConfig.effect_id.get();
    this.jdField_a_of_type_JavaLangString = paramTEffectDetail.name.get();
    this.jdField_a_of_type_Long = localUserConfig.group_code.get();
    if (localUserConfig.status.get() != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public String toString()
  {
    return "{groupCode: " + this.jdField_a_of_type_Long + ", effectId: " + this.jdField_a_of_type_Int + ", isOn: " + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfoData
 * JD-Core Version:    0.7.0.1
 */