package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class QVipQidProcessor
  extends BaseQVipConfigProcessor<QVipQidConfig>
{
  public static QVipQidConfig c()
  {
    QVipQidConfig localQVipQidConfig2 = (QVipQidConfig)QConfigManager.a().a(694);
    QVipQidConfig localQVipQidConfig1 = localQVipQidConfig2;
    if (localQVipQidConfig2 == null) {
      localQVipQidConfig1 = new QVipQidConfig();
    }
    return localQVipQidConfig1;
  }
  
  @NonNull
  public QVipQidConfig a()
  {
    return new QVipQidConfig();
  }
  
  @NonNull
  public QVipQidConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipQidConfig.a(paramArrayOfQConfItem[0].a);
  }
  
  @NonNull
  public QVipQidConfig b()
  {
    return new QVipQidConfig();
  }
  
  public Class<QVipQidConfig> clazz()
  {
    return QVipQidConfig.class;
  }
  
  public int type()
  {
    return 694;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipQidProcessor
 * JD-Core Version:    0.7.0.1
 */