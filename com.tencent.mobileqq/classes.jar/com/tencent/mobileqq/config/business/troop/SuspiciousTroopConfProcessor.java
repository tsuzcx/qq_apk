package com.tencent.mobileqq.config.business.troop;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SuspiciousTroopConfProcessor
  extends IQConfigProcessor<SuspiciousTroopConfBean>
{
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("SuspiciousTroopConfProcessor", 2, localStringBuilder.toString());
      }
      return SuspiciousTroopConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SuspiciousTroopConfBean paramSuspiciousTroopConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramSuspiciousTroopConfBean != null) {
        paramSuspiciousTroopConfBean = paramSuspiciousTroopConfBean.toString();
      } else {
        paramSuspiciousTroopConfBean = " empty";
      }
      localStringBuilder.append(paramSuspiciousTroopConfBean);
      QLog.d("SuspiciousTroopConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("SuspiciousTroopConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfProcessor
 * JD-Core Version:    0.7.0.1
 */