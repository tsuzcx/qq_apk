package com.tencent.mobileqq.troop.entereffect;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.group_effect.UserConfig;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;

public class TroopEnterEffectConfig$EffectInfoData
{
  public long a;
  public int b;
  public String c;
  public boolean d;
  
  public TroopEnterEffectConfig$EffectInfoData() {}
  
  public TroopEnterEffectConfig$EffectInfoData(long paramLong, int paramInt, String paramString)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public group_effect_commu.TEffectDetail a()
  {
    group_effect_commu.TEffectDetail localTEffectDetail = new group_effect_commu.TEffectDetail();
    Object localObject = new group_effect.UserConfig();
    ((group_effect.UserConfig)localObject).effect_id.set(this.b);
    ((group_effect.UserConfig)localObject).group_code.set(this.a);
    localObject = ((group_effect.UserConfig)localObject).status;
    long l;
    if (this.d) {
      l = 1L;
    } else {
      l = 0L;
    }
    ((PBUInt64Field)localObject).set(l);
    new group_effect.EffectInfo().name.set(this.c);
    return localTEffectDetail;
  }
  
  public void a(group_effect_commu.TEffectDetail paramTEffectDetail)
  {
    group_effect.UserConfig localUserConfig = (group_effect.UserConfig)paramTEffectDetail.st_userconfig.get();
    paramTEffectDetail = (group_effect.EffectInfo)paramTEffectDetail.st_effectinfo.get();
    this.b = localUserConfig.effect_id.get();
    this.c = paramTEffectDetail.name.get();
    this.a = localUserConfig.group_code.get();
    boolean bool;
    if (localUserConfig.status.get() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{groupCode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", effectId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isOn: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfoData
 * JD-Core Version:    0.7.0.1
 */