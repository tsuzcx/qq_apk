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
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfQConfItem[0].a);
      }
      return ScreenShotConfigProcessor.ScreenShotConfigData.a(paramArrayOfQConfItem[0].a);
    }
    return new ScreenShotConfigProcessor.ScreenShotConfigData();
  }
  
  public void a(ScreenShotConfigProcessor.ScreenShotConfigData paramScreenShotConfigData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramScreenShotConfigData);
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
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor
 * JD-Core Version:    0.7.0.1
 */