package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class TroopEnterEffectConfig$EffectInfo
{
  public int a;
  public String a;
  public ConcurrentHashMap a;
  public int b;
  
  public TroopEnterEffectConfig$EffectInfo()
  {
    this.jdField_a_of_type_Int = 600;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public group_effect_commu.TGetMyEffectRsp0x2 a()
  {
    group_effect_commu.TGetMyEffectRsp0x2 localTGetMyEffectRsp0x2 = new group_effect_commu.TGetMyEffectRsp0x2();
    localTGetMyEffectRsp0x2.query_interval.set(this.jdField_a_of_type_Int);
    localTGetMyEffectRsp0x2.global_effect_id.set(this.b);
    new group_effect.EffectInfo().name.set(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopEnterEffectConfig.EffectInfoData)((Map.Entry)localIterator.next()).getValue()).a());
      }
      localTGetMyEffectRsp0x2.rpt_userconfig.set(localArrayList);
    }
    return localTGetMyEffectRsp0x2;
  }
  
  public void a(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2)
  {
    this.jdField_a_of_type_Int = paramTGetMyEffectRsp0x2.query_interval.get();
    this.b = paramTGetMyEffectRsp0x2.global_effect_id.get();
    Object localObject = (group_effect.EffectInfo)paramTGetMyEffectRsp0x2.st_global_effectinfo.get();
    if (localObject != null) {
      this.jdField_a_of_type_JavaLangString = ((group_effect.EffectInfo)localObject).name.get();
    }
    if ((paramTGetMyEffectRsp0x2.rpt_userconfig.has()) && (paramTGetMyEffectRsp0x2.rpt_userconfig.size() > 0))
    {
      paramTGetMyEffectRsp0x2 = paramTGetMyEffectRsp0x2.rpt_userconfig.get();
      int i = 0;
      while (i < paramTGetMyEffectRsp0x2.size())
      {
        localObject = (group_effect_commu.TEffectDetail)paramTGetMyEffectRsp0x2.get(i);
        TroopEnterEffectConfig.EffectInfoData localEffectInfoData = new TroopEnterEffectConfig.EffectInfoData();
        localEffectInfoData.a((group_effect_commu.TEffectDetail)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect.EffectInfo", 2, "mergeFromPB rpt_userconfig index = " + i + " detail = " + localEffectInfoData.toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEffectInfoData.a + "", localEffectInfoData);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.EffectInfo", 2, "mergeFromPB nextReqTime = " + this.jdField_a_of_type_Int + " global_effectId = " + this.b + " global_effectName = " + this.jdField_a_of_type_JavaLangString + " individual effect size = " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfo
 * JD-Core Version:    0.7.0.1
 */