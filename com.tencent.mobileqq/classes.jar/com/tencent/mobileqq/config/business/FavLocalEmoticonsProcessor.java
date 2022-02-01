package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FavLocalEmoticonsProcessor
  extends IQConfigProcessor<FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  @NonNull
  public FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig a(int paramInt)
  {
    FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig localFavLocalEmoticonsConfig = new FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig();
    localFavLocalEmoticonsConfig.a = a;
    localFavLocalEmoticonsConfig.b = b;
    return localFavLocalEmoticonsConfig;
  }
  
  @Nullable
  public FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return new FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig();
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfQConfItem);
    }
    FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig localFavLocalEmoticonsConfig = new FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem);
      localFavLocalEmoticonsConfig.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localFavLocalEmoticonsConfig.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localFavLocalEmoticonsConfig;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfQConfItem);
      localFavLocalEmoticonsConfig.a = a;
      localFavLocalEmoticonsConfig.b = b;
    }
    return localFavLocalEmoticonsConfig;
  }
  
  public void a(FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig paramFavLocalEmoticonsConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig.class;
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
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 561;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FavLocalEmoticonsProcessor
 * JD-Core Version:    0.7.0.1
 */