package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TencentDocsPushProcessor
  extends IQConfigProcessor<TencentDocsPushBean>
{
  @NonNull
  public TencentDocsPushBean a(int paramInt)
  {
    return new TencentDocsPushBean();
  }
  
  @Nullable
  public TencentDocsPushBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new TencentDocsPushBean();
      return TencentDocsPushBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocsPushBean paramTencentDocsPushBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramTencentDocsPushBean.toString());
    }
  }
  
  public Class<TencentDocsPushBean> clazz()
  {
    return TencentDocsPushBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TencentDocsPushProcessor
 * JD-Core Version:    0.7.0.1
 */