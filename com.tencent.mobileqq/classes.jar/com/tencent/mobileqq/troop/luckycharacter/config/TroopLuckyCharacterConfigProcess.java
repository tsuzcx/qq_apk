package com.tencent.mobileqq.troop.luckycharacter.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopLuckyCharacterConfigProcess
  extends IQConfigProcessor<TroopLuckyCharacterConfig>
{
  @NonNull
  public TroopLuckyCharacterConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopLuckyCharacterConfigProcess", 2, localStringBuilder.toString());
    return new TroopLuckyCharacterConfig();
  }
  
  @Nullable
  public TroopLuckyCharacterConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterConfigProcess", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopLuckyCharacterConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(TroopLuckyCharacterConfig paramTroopLuckyCharacterConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterConfigProcess", 2, "onUpdate");
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null) {
      ((ITroopLuckyCharacterService)localAppRuntime.getRuntimeService(ITroopLuckyCharacterService.class, "")).updateConfig(paramTroopLuckyCharacterConfig);
    }
  }
  
  public Class<TroopLuckyCharacterConfig> clazz()
  {
    return TroopLuckyCharacterConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopLuckyCharacterConfigProcess", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 696;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfigProcess
 * JD-Core Version:    0.7.0.1
 */