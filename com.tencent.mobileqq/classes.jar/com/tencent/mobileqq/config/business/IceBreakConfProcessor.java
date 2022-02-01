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
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakConfProcessor", 2, "onUpdate newConf:" + paramIceBreakConfBean);
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
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 693;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.IceBreakConfProcessor
 * JD-Core Version:    0.7.0.1
 */