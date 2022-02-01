package com.tencent.mobileqq.screendetect;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class ScreenShotConfigProcessor
  extends IQConfigProcessor<ScreenShotConfigProcessor.ScreenShotConfigData>
{
  @NonNull
  public ScreenShotConfigProcessor.ScreenShotConfigData a(int paramInt)
  {
    return new ScreenShotConfigProcessor.ScreenShotConfigData();
  }
  
  @Nullable
  public ScreenShotConfigProcessor.ScreenShotConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("ScreenShotConfigProcessor", 2, localStringBuilder.toString());
      }
      return ScreenShotConfigProcessor.ScreenShotConfigData.a(paramArrayOfQConfItem[0].b);
    }
    return new ScreenShotConfigProcessor.ScreenShotConfigData();
  }
  
  public void a(ScreenShotConfigProcessor.ScreenShotConfigData paramScreenShotConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramScreenShotConfigData);
      QLog.d("ScreenShotConfigProcessor", 2, localStringBuilder.toString());
    }
    ScreenShotHelper.a(paramScreenShotConfigData);
  }
  
  public Class<ScreenShotConfigProcessor.ScreenShotConfigData> clazz()
  {
    return ScreenShotConfigProcessor.ScreenShotConfigData.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramInt);
      QLog.d("ScreenShotConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor
 * JD-Core Version:    0.7.0.1
 */