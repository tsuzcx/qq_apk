package com.tencent.mobileqq.weather.webpage;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherPreloadWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherPreloadWebPageConfigProcessor
  extends IQConfigProcessor<WeatherPreloadWebPageConfigProcessor.Config>
{
  public static final WeatherPreloadWebPageConfigProcessor.Companion a = new WeatherPreloadWebPageConfigProcessor.Companion(null);
  
  @NotNull
  public WeatherPreloadWebPageConfigProcessor.Config a(int paramInt)
  {
    return new WeatherPreloadWebPageConfigProcessor.Config();
  }
  
  @Nullable
  public WeatherPreloadWebPageConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherPreloadWebPageConfigProcessor", 2, "onParsed");
    }
    WeatherPreloadWebPageConfigProcessor.Config localConfig = new WeatherPreloadWebPageConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
    }
    return localConfig;
  }
  
  public void a(@Nullable WeatherPreloadWebPageConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<WeatherPreloadWebPageConfigProcessor.Config> clazz()
  {
    return WeatherPreloadWebPageConfigProcessor.Config.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherPreloadWebPageConfigProcessor
 * JD-Core Version:    0.7.0.1
 */