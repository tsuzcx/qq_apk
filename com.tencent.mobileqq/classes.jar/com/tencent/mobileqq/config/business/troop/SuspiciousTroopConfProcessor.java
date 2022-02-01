package com.tencent.mobileqq.config.business.troop;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class SuspiciousTroopConfProcessor
  extends IQConfigProcessor<SuspiciousTroopConfBean>
{
  public static SuspiciousTroopConfBean a()
  {
    SuspiciousTroopConfBean localSuspiciousTroopConfBean2 = (SuspiciousTroopConfBean)QConfigManager.a().a(573);
    SuspiciousTroopConfBean localSuspiciousTroopConfBean1 = localSuspiciousTroopConfBean2;
    if (localSuspiciousTroopConfBean2 == null) {
      localSuspiciousTroopConfBean1 = new SuspiciousTroopConfBean();
    }
    return localSuspiciousTroopConfBean1;
  }
  
  @NonNull
  public SuspiciousTroopConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new SuspiciousTroopConfBean();
  }
  
  @Nullable
  public SuspiciousTroopConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return SuspiciousTroopConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SuspiciousTroopConfBean paramSuspiciousTroopConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramSuspiciousTroopConfBean == null) {
        break label43;
      }
    }
    label43:
    for (paramSuspiciousTroopConfBean = paramSuspiciousTroopConfBean.toString();; paramSuspiciousTroopConfBean = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramSuspiciousTroopConfBean);
      return;
    }
  }
  
  public Class<SuspiciousTroopConfBean> clazz()
  {
    return SuspiciousTroopConfBean.class;
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
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfProcessor
 * JD-Core Version:    0.7.0.1
 */