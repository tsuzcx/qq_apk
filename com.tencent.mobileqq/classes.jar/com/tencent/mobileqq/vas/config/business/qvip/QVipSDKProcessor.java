package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QVipSDKProcessor
  extends BaseQVipConfigProcessor<QVipSDKConfig>
{
  @NonNull
  public static QVipSDKConfig e()
  {
    QVipSDKConfig localQVipSDKConfig2 = (QVipSDKConfig)QConfigManager.b().b(562);
    QVipSDKConfig localQVipSDKConfig1 = localQVipSDKConfig2;
    if (localQVipSDKConfig2 == null) {
      localQVipSDKConfig1 = QVipSDKConfig.n();
    }
    return localQVipSDKConfig1;
  }
  
  @NonNull
  public QVipSDKConfig a()
  {
    return QVipSDKConfig.n();
  }
  
  @NonNull
  public QVipSDKConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.ConfigProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    return QVipSDKConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipSDKConfig b()
  {
    return QVipSDKConfig.n();
  }
  
  public Class<QVipSDKConfig> clazz()
  {
    return QVipSDKConfig.class;
  }
  
  public int type()
  {
    return 562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor
 * JD-Core Version:    0.7.0.1
 */