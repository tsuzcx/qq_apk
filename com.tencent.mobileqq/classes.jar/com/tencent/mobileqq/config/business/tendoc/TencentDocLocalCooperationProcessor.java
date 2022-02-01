package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocLocalCooperationProcessor
  extends IQConfigProcessor<TencentDocLocalCooperationBean>
{
  public static TencentDocLocalCooperationBean a()
  {
    return (TencentDocLocalCooperationBean)QConfigManager.a().a(525);
  }
  
  @NonNull
  public TencentDocLocalCooperationBean a(int paramInt)
  {
    return new TencentDocLocalCooperationBean();
  }
  
  @Nullable
  public TencentDocLocalCooperationBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocLocalCooperationBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocLocalCooperationBean paramTencentDocLocalCooperationBean) {}
  
  public Class<TencentDocLocalCooperationBean> clazz()
  {
    return TencentDocLocalCooperationBean.class;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("TencentDocLocalCooperationProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 525;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor
 * JD-Core Version:    0.7.0.1
 */