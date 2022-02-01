package com.tencent.mobileqq.troop.luckycharacter.api.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

class TroopLuckyCharacterServiceImpl$1
  implements Runnable
{
  TroopLuckyCharacterServiceImpl$1(TroopLuckyCharacterServiceImpl paramTroopLuckyCharacterServiceImpl) {}
  
  public void run()
  {
    TroopLuckyCharacterServiceImpl.access$002(this.this$0, (TroopLuckyCharacterConfig)QConfigManager.b().b(696));
    String str = TroopLuckyCharacterServiceImpl.access$100(this.this$0).getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(str, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("self_troop_lucky_character_switch");
    boolean bool = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    this.this$0.updateSelfSettingSwitch(bool);
    ((ITroopListHandler)((AppInterface)TroopLuckyCharacterServiceImpl.access$100(this.this$0)).getBusinessHandler(TroopListHandler.class.getName())).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.api.impl.TroopLuckyCharacterServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */