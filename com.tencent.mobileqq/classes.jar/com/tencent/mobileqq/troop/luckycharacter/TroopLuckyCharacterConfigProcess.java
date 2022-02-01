package com.tencent.mobileqq.troop.luckycharacter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TroopLuckyCharacterConfigProcess
  extends IQConfigProcessor<TroopLuckyCharacterConfig>
{
  @NonNull
  public TroopLuckyCharacterConfig a(int paramInt)
  {
    QLog.d("TroopLuckyCharacterConfigProcess", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new TroopLuckyCharacterConfig();
  }
  
  @Nullable
  public TroopLuckyCharacterConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterConfigProcess", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopLuckyCharacterConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(TroopLuckyCharacterConfig paramTroopLuckyCharacterConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterConfigProcess", 2, "onUpdate");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((TroopLuckyCharacterManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.TROOP_LUCKY_CHARACTER_MANAGER)).a(paramTroopLuckyCharacterConfig);
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
    QLog.d("TroopLuckyCharacterConfigProcess", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 696;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfigProcess
 * JD-Core Version:    0.7.0.1
 */