package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class IceBreakConfProcessor
  extends IQConfigProcessor<IceBreakConfBean>
{
  @NonNull
  public IceBreakConfBean a(int paramInt)
  {
    return new IceBreakConfBean();
  }
  
  @Nullable
  public IceBreakConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return IceBreakConfBean.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(IceBreakConfBean paramIceBreakConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramIceBreakConfBean);
      QLog.d("IceBreakConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<IceBreakConfBean> clazz()
  {
    return IceBreakConfBean.class;
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
      localStringBuilder.append("onReqFailed failCode:");
      localStringBuilder.append(paramInt);
      QLog.d("IceBreakConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 693;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.IceBreakConfProcessor
 * JD-Core Version:    0.7.0.1
 */