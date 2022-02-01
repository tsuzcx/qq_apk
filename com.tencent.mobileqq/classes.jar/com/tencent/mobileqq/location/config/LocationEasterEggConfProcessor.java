package com.tencent.mobileqq.location.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class LocationEasterEggConfProcessor
  extends IQConfigProcessor<LocationEasterEggBean>
{
  @NonNull
  public LocationEasterEggBean a(int paramInt)
  {
    return new LocationEasterEggBean();
  }
  
  @Nullable
  public LocationEasterEggBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      LocationEasterEggBean localLocationEasterEggBean = LocationEasterEggBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocationEasterEggConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localLocationEasterEggBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(LocationEasterEggBean paramLocationEasterEggBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onUpdate " + paramLocationEasterEggBean.toString());
    }
  }
  
  public Class<LocationEasterEggBean> clazz()
  {
    return LocationEasterEggBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 575;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.config.LocationEasterEggConfProcessor
 * JD-Core Version:    0.7.0.1
 */