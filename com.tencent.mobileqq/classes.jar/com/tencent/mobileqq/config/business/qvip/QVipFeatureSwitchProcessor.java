package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipFeatureSwitchProcessor
  extends BaseQVipConfigProcessor<QVipFeatureSwitchConfig>
{
  public static QVipFeatureSwitchConfig a()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  @NonNull
  public QVipFeatureSwitchConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipFeatureSwitchConfig localQVipFeatureSwitchConfig = null;
    String str = paramArrayOfQConfItem[0].a;
    paramArrayOfQConfItem = localQVipFeatureSwitchConfig;
    if (!TextUtils.isEmpty(str))
    {
      localQVipFeatureSwitchConfig = (QVipFeatureSwitchConfig)JSONConverter.a(str, QVipFeatureSwitchConfig.class);
      paramArrayOfQConfItem = localQVipFeatureSwitchConfig;
      if (QLog.isColorLevel())
      {
        QLog.d("QVipFeatureSwitchProcessor", 2, "content:" + str + " config:" + localQVipFeatureSwitchConfig.toString());
        paramArrayOfQConfItem = localQVipFeatureSwitchConfig;
      }
    }
    return paramArrayOfQConfItem;
  }
  
  @NonNull
  public QVipFeatureSwitchConfig b()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  @NonNull
  public QVipFeatureSwitchConfig c()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  public Class<QVipFeatureSwitchConfig> clazz()
  {
    return QVipFeatureSwitchConfig.class;
  }
  
  public int type()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipFeatureSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */