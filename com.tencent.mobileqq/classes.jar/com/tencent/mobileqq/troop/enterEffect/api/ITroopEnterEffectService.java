package com.tencent.mobileqq.troop.entereffect.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfoData;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

@Service(process={"all"})
public abstract interface ITroopEnterEffectService
  extends IRuntimeService
{
  public static final int JS_IPC_SUB_CMD_NOTIFY_CHANGE_STATUS = 2;
  public static final int JS_IPC_SUB_CMD_NOTIFY_SET_EFFECT = 1;
  public static final String SP_KEY_NO_LONGER_TIPS_ID = "gray_tips_no_longer_";
  public static final String SP_KEY_SHOW_GRAY_TIPS_TIME = "show_gray_tips_time";
  public static final String TAG = "TroopEnterEffect";
  
  public abstract void addTroopEnterEffectData(TroopEnterEffectData paramTroopEnterEffectData);
  
  public abstract TroopEnterEffectConfig.EffectInfo getAllEffectInfo();
  
  public abstract int getEffectId();
  
  public abstract int getEffectId(String paramString);
  
  public abstract TroopEnterEffectConfig.EffectInfoData getEffectInfo(String paramString);
  
  public abstract TroopEnterEffectData getFirstEffectData(String paramString);
  
  public abstract int getGroupLevel();
  
  public abstract int getMode();
  
  public abstract long getNotifyInterval();
  
  public abstract SharedPreferences getSharedPreferences();
  
  public abstract int getSvipLevel();
  
  public abstract int getSvipType();
  
  public abstract TroopEnterEffectConfig getTroopEnterEffectConfig();
  
  public abstract boolean hasSetEffect(String paramString);
  
  public abstract boolean hasShowGrayTipsToday();
  
  public abstract boolean isAllTroopShowEnterance();
  
  public abstract boolean isEffectOn(String paramString);
  
  public abstract void notifyEnterTroop(String paramString);
  
  public abstract void readEffectConfigData(boolean paramBoolean);
  
  public abstract void removeAllEffectDatas(String paramString);
  
  public abstract void removeEnterEffectData(TroopEnterEffectData paramTroopEnterEffectData);
  
  public abstract void report(String paramString1, String paramString2, String... paramVarArgs);
  
  public abstract void saveEffectConfigData(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2);
  
  public abstract void setGroupLevel(int paramInt);
  
  public abstract void setMode(int paramInt);
  
  public abstract void setNotifyInterval(long paramLong);
  
  public abstract void setSvipLevel(int paramInt);
  
  public abstract void setSvipType(int paramInt);
  
  public abstract void updateEffectInfo(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void updateEffectInfo(TroopEnterEffectConfig.EffectInfo paramEffectInfo);
  
  public abstract void updateEffectStatus(ArrayList<String> paramArrayList);
  
  public abstract void updateGlobalEffectInfo(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public abstract void updateNoLongerShowTips(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.api.ITroopEnterEffectService
 * JD-Core Version:    0.7.0.1
 */