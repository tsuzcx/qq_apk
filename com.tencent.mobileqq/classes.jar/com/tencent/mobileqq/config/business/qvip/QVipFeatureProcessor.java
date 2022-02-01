package com.tencent.mobileqq.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipFeatureProcessor
  extends BaseQVipConfigProcessor<QVipFeatureConfig>
{
  @NonNull
  public QVipFeatureConfig a()
  {
    return new QVipFeatureConfig();
  }
  
  @NonNull
  public QVipFeatureConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipFeatureProcessor", 1, paramArrayOfQConfItem[0].a);
    }
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = (QVipFeatureConfig)JSONConverter.a(paramArrayOfQConfItem, QVipFeatureConfig.class);
        a(paramArrayOfQConfItem.enableSplashAnim);
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return new QVipFeatureConfig();
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 4).edit().putBoolean("splashAnim", paramBoolean).commit();
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
  
  public int type()
  {
    return 690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipFeatureProcessor
 * JD-Core Version:    0.7.0.1
 */