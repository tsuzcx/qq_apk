package com.tencent.mobileqq.config.business;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pic.api.IPicValue;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class AIOPicThumbSizeProcessor
  extends IQConfigProcessor<AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig>
{
  public static final int a = ((IPicValue)QRoute.api(IPicValue.class)).getAioOtherSpaceValue();
  private static volatile AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig b;
  
  public static AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a()
  {
    try
    {
      if (b == null) {
        b = (AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)QConfigManager.b().b(672);
      }
      AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = b;
      return localAIOPicThumbSizeConfig;
    }
    finally {}
  }
  
  @NonNull
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a(int paramInt)
  {
    return c();
  }
  
  @Nullable
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    String str;
    AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      str = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("onParsed, content:");
        paramArrayOfQConfItem.append(str);
        QLog.d("AIOPicThumbSizeProcessor", 2, paramArrayOfQConfItem.toString());
      }
      localAIOPicThumbSizeConfig = new AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      localAIOPicThumbSizeConfig.a = localJSONObject.optBoolean("useNewConfig", true);
      paramArrayOfQConfItem = localAIOPicThumbSizeConfig;
      if (!localAIOPicThumbSizeConfig.a) {
        break label400;
      }
      localAIOPicThumbSizeConfig.c = localJSONObject.optDouble("minRatio", 0.0D);
      localAIOPicThumbSizeConfig.b = localJSONObject.optDouble("maxRatio", 0.0D);
      localAIOPicThumbSizeConfig.d = localJSONObject.optInt("textOtherSpace", a);
      localAIOPicThumbSizeConfig.e = localJSONObject.optInt("picSizeLimit", 650);
      if ((localAIOPicThumbSizeConfig.b > 0.0D) && (localAIOPicThumbSizeConfig.c > 0.0D) && (localAIOPicThumbSizeConfig.d > 0))
      {
        paramArrayOfQConfItem = b();
        double d1 = (int)(Math.min(paramArrayOfQConfItem.widthPixels, paramArrayOfQConfItem.heightPixels) / paramArrayOfQConfItem.density - localAIOPicThumbSizeConfig.d);
        double d2 = localAIOPicThumbSizeConfig.c;
        Double.isNaN(d1);
        int i = (int)(d2 * d1);
        localAIOPicThumbSizeConfig.g = i;
        d2 = localAIOPicThumbSizeConfig.b;
        Double.isNaN(d1);
        i = (int)(d1 * d2);
        localAIOPicThumbSizeConfig.f = i;
      }
      else
      {
        localAIOPicThumbSizeConfig.g = localJSONObject.optInt("aioImageMinSize", 45);
        localAIOPicThumbSizeConfig.f = localJSONObject.optInt("aioImageMaxSize", 135);
      }
      localAIOPicThumbSizeConfig.i = localJSONObject.optInt("aioImageMinSizeUnderLimit", 45);
      localAIOPicThumbSizeConfig.h = localJSONObject.optInt("aioImageMaxSizeUnderLimit", 135);
      localAIOPicThumbSizeConfig.k = localJSONObject.optInt("aioImageDynamicMinSize", 45);
      localAIOPicThumbSizeConfig.j = localJSONObject.optInt("aioImageDynamicMaxSize", 135);
      return localAIOPicThumbSizeConfig;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      label363:
      break label363;
    }
    paramArrayOfQConfItem = new StringBuilder();
    paramArrayOfQConfItem.append("onParsed error, content:");
    paramArrayOfQConfItem.append(str);
    QLog.d("AIOPicThumbSizeProcessor", 1, paramArrayOfQConfItem.toString());
    paramArrayOfQConfItem = c();
    label400:
    return paramArrayOfQConfItem;
    return c();
  }
  
  public void a(AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig paramAIOPicThumbSizeConfig)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
      }
      b = (AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)QConfigManager.b().b(672);
      return;
    }
    finally {}
  }
  
  public DisplayMetrics b()
  {
    return MobileQQ.getContext().getResources().getDisplayMetrics();
  }
  
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig c()
  {
    AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = new AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig();
    localAIOPicThumbSizeConfig.e = 650;
    localAIOPicThumbSizeConfig.g = 45;
    localAIOPicThumbSizeConfig.f = 135;
    localAIOPicThumbSizeConfig.i = 45;
    localAIOPicThumbSizeConfig.h = 135;
    localAIOPicThumbSizeConfig.k = 45;
    localAIOPicThumbSizeConfig.j = 135;
    return localAIOPicThumbSizeConfig;
  }
  
  public Class<AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig> clazz()
  {
    return AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 672;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor
 * JD-Core Version:    0.7.0.1
 */