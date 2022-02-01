package com.tencent.mobileqq.teamwork.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocDrawerConfigProcessor
  extends IQConfigProcessor<TencentDocDrawerConfigBean>
{
  public static TencentDocDrawerConfigBean a()
  {
    return (TencentDocDrawerConfigBean)QConfigManager.a().a(740);
  }
  
  @NonNull
  public TencentDocDrawerConfigBean a(int paramInt)
  {
    return new TencentDocDrawerConfigBean();
  }
  
  @Nullable
  public TencentDocDrawerConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocDrawerConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocDrawerConfigBean paramTencentDocDrawerConfigBean) {}
  
  public Class<TencentDocDrawerConfigBean> clazz()
  {
    return TencentDocDrawerConfigBean.class;
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
    return 740;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.config.TencentDocDrawerConfigProcessor
 * JD-Core Version:    0.7.0.1
 */