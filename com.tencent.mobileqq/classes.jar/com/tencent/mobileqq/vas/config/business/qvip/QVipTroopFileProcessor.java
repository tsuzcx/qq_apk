package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QVipTroopFileProcessor
  extends BaseQVipConfigProcessor<QVipTroopFileConfig>
{
  @NonNull
  public static QVipTroopFileConfig e()
  {
    QVipTroopFileConfig localQVipTroopFileConfig2 = (QVipTroopFileConfig)QConfigManager.b().b(628);
    QVipTroopFileConfig localQVipTroopFileConfig1 = localQVipTroopFileConfig2;
    if (localQVipTroopFileConfig2 == null) {
      localQVipTroopFileConfig1 = QVipTroopFileConfig.c();
    }
    return localQVipTroopFileConfig1;
  }
  
  @NonNull
  public QVipTroopFileConfig a()
  {
    return QVipTroopFileConfig.c();
  }
  
  @NonNull
  public QVipTroopFileConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.TROOP_FILE.ConfigProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    return QVipTroopFileConfig.b(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipTroopFileConfig b()
  {
    return QVipTroopFileConfig.c();
  }
  
  public Class<QVipTroopFileConfig> clazz()
  {
    return QVipTroopFileConfig.class;
  }
  
  public int type()
  {
    return 628;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor
 * JD-Core Version:    0.7.0.1
 */