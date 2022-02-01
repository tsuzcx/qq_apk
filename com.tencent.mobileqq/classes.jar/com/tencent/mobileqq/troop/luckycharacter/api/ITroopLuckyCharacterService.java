package com.tencent.mobileqq.troop.luckycharacter.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopLuckyCharacterService
  extends IRuntimeService
{
  public abstract boolean isSupportLuckyCharacter(TroopInfo paramTroopInfo);
  
  public abstract boolean selfSettingSwitchIsOpen();
  
  public abstract void updateConfig(TroopLuckyCharacterConfig paramTroopLuckyCharacterConfig);
  
  public abstract void updateSelfSettingSwitch(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService
 * JD-Core Version:    0.7.0.1
 */