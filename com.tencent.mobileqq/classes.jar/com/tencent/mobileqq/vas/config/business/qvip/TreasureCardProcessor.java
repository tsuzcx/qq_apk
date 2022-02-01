package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TreasureCardProcessor
  extends BaseQVipConfigProcessor<TreasureCardConfig>
{
  @NonNull
  public static TreasureCardConfig e()
  {
    TreasureCardConfig localTreasureCardConfig2 = (TreasureCardConfig)QConfigManager.b().b(751);
    TreasureCardConfig localTreasureCardConfig1 = localTreasureCardConfig2;
    if (localTreasureCardConfig2 == null) {
      localTreasureCardConfig1 = TreasureCardConfig.a();
    }
    return localTreasureCardConfig1;
  }
  
  @NonNull
  public TreasureCardConfig a()
  {
    return TreasureCardConfig.a();
  }
  
  @NonNull
  public TreasureCardConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TreasureCardProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    return TreasureCardConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public TreasureCardConfig b()
  {
    return TreasureCardConfig.a();
  }
  
  public Class<TreasureCardConfig> clazz()
  {
    return TreasureCardConfig.class;
  }
  
  public int type()
  {
    return 751;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.TreasureCardProcessor
 * JD-Core Version:    0.7.0.1
 */