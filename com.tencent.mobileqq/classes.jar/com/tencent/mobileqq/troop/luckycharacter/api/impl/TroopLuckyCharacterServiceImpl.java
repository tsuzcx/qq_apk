package com.tencent.mobileqq.troop.luckycharacter.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TroopLuckyCharacterServiceImpl
  implements ITroopLuckyCharacterService
{
  private static final String TAG = "TroopLuckyCharacterServiceImpl";
  private AppRuntime mApp;
  private TroopLuckyCharacterConfig mConfig = new TroopLuckyCharacterConfig();
  private boolean mSelfSettingSwitch = false;
  
  public boolean isSupportLuckyCharacter(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      if (TextUtils.isEmpty(paramTroopInfo.troopuin)) {
        return false;
      }
      if (QQTheme.isNowSimpleUI())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopLuckyCharacterServiceImpl", 2, "isSupportLuckyCharacter isNowSimpleUI");
        }
        return false;
      }
      TroopLuckyCharacterConfig localTroopLuckyCharacterConfig = this.mConfig;
      boolean bool;
      if (localTroopLuckyCharacterConfig != null) {
        bool = localTroopLuckyCharacterConfig.b(paramTroopInfo.troopuin);
      } else {
        bool = false;
      }
      if (!bool) {
        return false;
      }
      return selfSettingSwitchIsOpen();
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    ThreadManager.getSubThreadHandler().post(new TroopLuckyCharacterServiceImpl.1(this));
  }
  
  public void onDestroy() {}
  
  public boolean selfSettingSwitchIsOpen()
  {
    return this.mSelfSettingSwitch;
  }
  
  public void updateConfig(TroopLuckyCharacterConfig paramTroopLuckyCharacterConfig)
  {
    ThreadManager.getSubThreadHandler().post(new TroopLuckyCharacterServiceImpl.2(this));
  }
  
  public void updateSelfSettingSwitch(boolean paramBoolean)
  {
    this.mSelfSettingSwitch = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.api.impl.TroopLuckyCharacterServiceImpl
 * JD-Core Version:    0.7.0.1
 */