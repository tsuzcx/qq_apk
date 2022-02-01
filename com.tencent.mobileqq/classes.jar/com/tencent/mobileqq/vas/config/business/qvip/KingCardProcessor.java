package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class KingCardProcessor
  extends BaseQVipConfigProcessor<KingCardConfig>
{
  @NonNull
  public static KingCardConfig e()
  {
    KingCardConfig localKingCardConfig2 = (KingCardConfig)QConfigManager.b().b(541);
    KingCardConfig localKingCardConfig1 = localKingCardConfig2;
    if (localKingCardConfig2 == null) {
      localKingCardConfig1 = KingCardConfig.a();
    }
    return localKingCardConfig1;
  }
  
  @NonNull
  public KingCardConfig a()
  {
    return KingCardConfig.a();
  }
  
  @NonNull
  public KingCardConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    return KingCardConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public KingCardConfig b()
  {
    return KingCardConfig.a();
  }
  
  public Class<KingCardConfig> clazz()
  {
    return KingCardConfig.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor
 * JD-Core Version:    0.7.0.1
 */