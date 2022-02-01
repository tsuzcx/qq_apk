package com.tencent.mobileqq.config.business.newfriend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class SysSuspiciousConfProcessor
  extends IQConfigProcessor<SysSuspiciousConfBean>
{
  public static SysSuspiciousConfBean a()
  {
    SysSuspiciousConfBean localSysSuspiciousConfBean2 = (SysSuspiciousConfBean)QConfigManager.a().a(493);
    SysSuspiciousConfBean localSysSuspiciousConfBean1 = localSysSuspiciousConfBean2;
    if (localSysSuspiciousConfBean2 == null) {
      localSysSuspiciousConfBean1 = new SysSuspiciousConfBean();
    }
    return localSysSuspiciousConfBean1;
  }
  
  @NonNull
  public SysSuspiciousConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new SysSuspiciousConfBean();
  }
  
  @Nullable
  public SysSuspiciousConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
      }
      return SysSuspiciousConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SysSuspiciousConfBean paramSysSuspiciousConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramSysSuspiciousConfBean != null) {
        paramSysSuspiciousConfBean = paramSysSuspiciousConfBean.toString();
      } else {
        paramSysSuspiciousConfBean = " empty";
      }
      localStringBuilder.append(paramSysSuspiciousConfBean);
      QLog.d("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<SysSuspiciousConfBean> clazz()
  {
    return SysSuspiciousConfBean.class;
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
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor
 * JD-Core Version:    0.7.0.1
 */