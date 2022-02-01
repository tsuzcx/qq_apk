package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class DeviceManageConfProcessor
  extends IQConfigProcessor<DeviceManageConfBean>
{
  @NonNull
  public DeviceManageConfBean a(int paramInt)
  {
    return new DeviceManageConfBean();
  }
  
  @Nullable
  public DeviceManageConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      DeviceManageConfBean localDeviceManageConfBean = DeviceManageConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localDeviceManageConfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(DeviceManageConfBean paramDeviceManageConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramDeviceManageConfBean.toString());
    }
  }
  
  public Class<DeviceManageConfBean> clazz()
  {
    return DeviceManageConfBean.class;
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
      QLog.d("DeviceManageConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 528;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DeviceManageConfProcessor
 * JD-Core Version:    0.7.0.1
 */