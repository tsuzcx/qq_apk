package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

@Deprecated
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
    String str = paramArrayOfQConfItem[0].b;
    if (!TextUtils.isEmpty(str))
    {
      QVipFeatureSwitchConfig localQVipFeatureSwitchConfig = (QVipFeatureSwitchConfig)JSONConverter.a(str, QVipFeatureSwitchConfig.class);
      paramArrayOfQConfItem = localQVipFeatureSwitchConfig;
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("content:");
        paramArrayOfQConfItem.append(str);
        paramArrayOfQConfItem.append(" config:");
        paramArrayOfQConfItem.append(localQVipFeatureSwitchConfig.toString());
        QLog.d("QVipFeatureSwitchProcessor", 2, paramArrayOfQConfItem.toString());
        return localQVipFeatureSwitchConfig;
      }
    }
    else
    {
      paramArrayOfQConfItem = null;
    }
    return paramArrayOfQConfItem;
  }
  
  @NonNull
  public QVipFeatureSwitchConfig b()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  public Class<QVipFeatureSwitchConfig> clazz()
  {
    return QVipFeatureSwitchConfig.class;
  }
  
  @NonNull
  public QVipFeatureSwitchConfig e()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  public int type()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */