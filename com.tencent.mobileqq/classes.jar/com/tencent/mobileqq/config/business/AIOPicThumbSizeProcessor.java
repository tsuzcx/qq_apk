package com.tencent.mobileqq.config.business;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AIOPicThumbSizeProcessor
  extends IQConfigProcessor<AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig>
{
  private static volatile AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a;
  
  public static AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a()
  {
    try
    {
      if (a == null) {
        a = (AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)QConfigManager.a().a(672);
      }
      AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = a;
      return localAIOPicThumbSizeConfig;
    }
    finally {}
  }
  
  public DisplayMetrics a()
  {
    return BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
  }
  
  @NonNull
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a(int paramInt)
  {
    return b();
  }
  
  @Nullable
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0))
    {
      paramArrayOfQConfItem = b();
      return paramArrayOfQConfItem;
    }
    String str = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onParsed, content:" + str);
    }
    AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = new AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(str);
        localAIOPicThumbSizeConfig.jdField_a_of_type_Boolean = localJSONObject.optBoolean("useNewConfig", true);
        paramArrayOfQConfItem = localAIOPicThumbSizeConfig;
        if (!localAIOPicThumbSizeConfig.jdField_a_of_type_Boolean) {
          break;
        }
        localAIOPicThumbSizeConfig.jdField_b_of_type_Double = localJSONObject.optDouble("minRatio", 0.0D);
        localAIOPicThumbSizeConfig.jdField_a_of_type_Double = localJSONObject.optDouble("maxRatio", 0.0D);
        localAIOPicThumbSizeConfig.jdField_a_of_type_Int = localJSONObject.optInt("textOtherSpace", 128);
        localAIOPicThumbSizeConfig.jdField_b_of_type_Int = localJSONObject.optInt("picSizeLimit", 650);
        if ((localAIOPicThumbSizeConfig.jdField_a_of_type_Double > 0.0D) && (localAIOPicThumbSizeConfig.jdField_b_of_type_Double > 0.0D) && (localAIOPicThumbSizeConfig.jdField_a_of_type_Int > 0))
        {
          paramArrayOfQConfItem = a();
          int i = (int)(Math.min(paramArrayOfQConfItem.widthPixels, paramArrayOfQConfItem.heightPixels) / paramArrayOfQConfItem.density - localAIOPicThumbSizeConfig.jdField_a_of_type_Int);
          localAIOPicThumbSizeConfig.d = ((int)(i * localAIOPicThumbSizeConfig.jdField_b_of_type_Double));
          localAIOPicThumbSizeConfig.c = ((int)(i * localAIOPicThumbSizeConfig.jdField_a_of_type_Double));
          localAIOPicThumbSizeConfig.f = localJSONObject.optInt("aioImageMinSizeUnderLimit", 45);
          localAIOPicThumbSizeConfig.e = localJSONObject.optInt("aioImageMaxSizeUnderLimit", 135);
          localAIOPicThumbSizeConfig.h = localJSONObject.optInt("aioImageDynamicMinSize", 45);
          localAIOPicThumbSizeConfig.g = localJSONObject.optInt("aioImageDynamicMaxSize", 135);
          return localAIOPicThumbSizeConfig;
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.d("AIOPicThumbSizeProcessor", 1, "onParsed error, content:" + str);
        return b();
      }
      localAIOPicThumbSizeConfig.d = localJSONObject.optInt("aioImageMinSize", 45);
      localAIOPicThumbSizeConfig.c = localJSONObject.optInt("aioImageMaxSize", 135);
    }
  }
  
  public void a(AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig paramAIOPicThumbSizeConfig)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
      }
      a = (AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig)QConfigManager.a().a(672);
      return;
    }
    finally {}
  }
  
  public AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig b()
  {
    AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig localAIOPicThumbSizeConfig = new AIOPicThumbSizeProcessor.AIOPicThumbSizeConfig();
    localAIOPicThumbSizeConfig.jdField_b_of_type_Int = 650;
    localAIOPicThumbSizeConfig.d = 45;
    localAIOPicThumbSizeConfig.c = 135;
    localAIOPicThumbSizeConfig.f = 45;
    localAIOPicThumbSizeConfig.e = 135;
    localAIOPicThumbSizeConfig.h = 45;
    localAIOPicThumbSizeConfig.g = 135;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor
 * JD-Core Version:    0.7.0.1
 */