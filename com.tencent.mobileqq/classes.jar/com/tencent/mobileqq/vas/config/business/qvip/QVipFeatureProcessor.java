package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipFeatureProcessor
  extends BaseQVipConfigProcessor<QVipFeatureConfig>
{
  public static QVipFeatureConfig a()
  {
    Object localObject1;
    try
    {
      QVipFeatureConfig localQVipFeatureConfig = (QVipFeatureConfig)QConfigManager.b().b(690);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new QVipFeatureConfig();
    }
    return localObject2;
  }
  
  @NonNull
  public QVipFeatureConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipFeatureProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = (QVipFeatureConfig)JSONConverter.a(paramArrayOfQConfItem, QVipFeatureConfig.class);
        paramArrayOfQConfItem.onParsedConfigFinished();
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("QVIP.SDK.QVipFeatureProcessor", 1, paramArrayOfQConfItem, new Object[0]);
    }
    return new QVipFeatureConfig();
  }
  
  @NonNull
  public QVipFeatureConfig b()
  {
    return new QVipFeatureConfig();
  }
  
  public Class<QVipFeatureConfig> clazz()
  {
    return QVipFeatureConfig.class;
  }
  
  @NonNull
  public QVipFeatureConfig e()
  {
    return new QVipFeatureConfig();
  }
  
  public int type()
  {
    return 690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor
 * JD-Core Version:    0.7.0.1
 */