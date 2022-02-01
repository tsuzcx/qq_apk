package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class QVipPrettyAccountProcessor
  extends BaseQVipConfigProcessor<QVipPrettyAccountConfig>
{
  @NonNull
  public static QVipPrettyAccountConfig e()
  {
    QVipPrettyAccountConfig localQVipPrettyAccountConfig2 = (QVipPrettyAccountConfig)QConfigManager.b().b(665);
    QVipPrettyAccountConfig localQVipPrettyAccountConfig1 = localQVipPrettyAccountConfig2;
    if (localQVipPrettyAccountConfig2 == null) {
      localQVipPrettyAccountConfig1 = new QVipPrettyAccountConfig();
    }
    return localQVipPrettyAccountConfig1;
  }
  
  @NonNull
  public QVipPrettyAccountConfig a()
  {
    return new QVipPrettyAccountConfig();
  }
  
  @NonNull
  public QVipPrettyAccountConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipPrettyAccountConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipPrettyAccountConfig b()
  {
    return new QVipPrettyAccountConfig();
  }
  
  public Class<QVipPrettyAccountConfig> clazz()
  {
    return QVipPrettyAccountConfig.class;
  }
  
  public int type()
  {
    return 665;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor
 * JD-Core Version:    0.7.0.1
 */