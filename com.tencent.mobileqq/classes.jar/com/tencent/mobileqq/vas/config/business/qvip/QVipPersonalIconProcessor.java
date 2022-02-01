package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class QVipPersonalIconProcessor
  extends BaseQVipConfigProcessor<QVipPersonalIconConfig>
{
  @NonNull
  public static QVipPersonalIconConfig c()
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig2 = (QVipPersonalIconConfig)QConfigManager.a().a(618);
    QVipPersonalIconConfig localQVipPersonalIconConfig1 = localQVipPersonalIconConfig2;
    if (localQVipPersonalIconConfig2 == null) {
      localQVipPersonalIconConfig1 = new QVipPersonalIconConfig();
    }
    return localQVipPersonalIconConfig1;
  }
  
  @NonNull
  public QVipPersonalIconConfig a()
  {
    return new QVipPersonalIconConfig();
  }
  
  @NonNull
  public QVipPersonalIconConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipPersonalIconConfig.a(paramArrayOfQConfItem[0].a);
  }
  
  @NonNull
  public QVipPersonalIconConfig b()
  {
    return new QVipPersonalIconConfig();
  }
  
  public Class<QVipPersonalIconConfig> clazz()
  {
    return QVipPersonalIconConfig.class;
  }
  
  public int type()
  {
    return 618;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconProcessor
 * JD-Core Version:    0.7.0.1
 */