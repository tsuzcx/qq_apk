package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class QVIPPrettyTroopProcessor
  extends BaseQVipConfigProcessor<QVipPrettyTroopConfig>
{
  @NonNull
  public static QVipPrettyTroopConfig e()
  {
    QVipPrettyTroopConfig localQVipPrettyTroopConfig2 = (QVipPrettyTroopConfig)QConfigManager.b().b(527);
    QVipPrettyTroopConfig localQVipPrettyTroopConfig1 = localQVipPrettyTroopConfig2;
    if (localQVipPrettyTroopConfig2 == null) {
      localQVipPrettyTroopConfig1 = new QVipPrettyTroopConfig();
    }
    return localQVipPrettyTroopConfig1;
  }
  
  @NonNull
  public QVipPrettyTroopConfig a()
  {
    return new QVipPrettyTroopConfig();
  }
  
  @NonNull
  public QVipPrettyTroopConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipPrettyTroopConfig.b(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipPrettyTroopConfig b()
  {
    return new QVipPrettyTroopConfig();
  }
  
  public Class<QVipPrettyTroopConfig> clazz()
  {
    return QVipPrettyTroopConfig.class;
  }
  
  public int type()
  {
    return 527;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor
 * JD-Core Version:    0.7.0.1
 */