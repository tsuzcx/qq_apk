package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class QVipPubAccountProocessor
  extends BaseQVipConfigProcessor<QVipPubAccountConfig>
{
  @NonNull
  public static QVipPubAccountConfig e()
  {
    QVipPubAccountConfig localQVipPubAccountConfig2 = (QVipPubAccountConfig)QConfigManager.b().b(651);
    QVipPubAccountConfig localQVipPubAccountConfig1 = localQVipPubAccountConfig2;
    if (localQVipPubAccountConfig2 == null) {
      localQVipPubAccountConfig1 = new QVipPubAccountConfig();
    }
    return localQVipPubAccountConfig1;
  }
  
  @NonNull
  public QVipPubAccountConfig a()
  {
    return new QVipPubAccountConfig();
  }
  
  @NonNull
  public QVipPubAccountConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipPubAccountConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipPubAccountConfig b()
  {
    return new QVipPubAccountConfig();
  }
  
  public Class<QVipPubAccountConfig> clazz()
  {
    return QVipPubAccountConfig.class;
  }
  
  public int type()
  {
    return 651;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountProocessor
 * JD-Core Version:    0.7.0.1
 */