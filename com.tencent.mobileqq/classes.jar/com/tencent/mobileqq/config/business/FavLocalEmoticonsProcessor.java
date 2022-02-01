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
    Object localObject1;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onParsed, content:");
        ((StringBuilder)localObject1).append(paramArrayOfQConfItem);
        QLog.d("FavLocalEmoticonsProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig();
    }
    try
    {
      localObject2 = new JSONObject(paramArrayOfQConfItem);
      ((FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig)localObject1).a = Integer.valueOf(((JSONObject)localObject2).getString("maxPicSize")).intValue();
      ((FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig)localObject1).b = Integer.valueOf(((JSONObject)localObject2).getString("maxLongSideLen")).intValue();
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label107:
      break label107;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onParsed error, content:");
    ((StringBuilder)localObject2).append(paramArrayOfQConfItem);
    QLog.d("FavLocalEmoticonsProcessor", 1, ((StringBuilder)localObject2).toString());
    ((FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig)localObject1).a = a;
    ((FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig)localObject1).b = b;
    return localObject1;
    return new FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FavLocalEmoticonsProcessor
 * JD-Core Version:    0.7.0.1
 */