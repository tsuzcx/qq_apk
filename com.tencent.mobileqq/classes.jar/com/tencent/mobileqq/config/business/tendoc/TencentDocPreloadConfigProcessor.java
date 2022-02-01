package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocPreloadConfigProcessor
  extends IQConfigProcessor<TencentDocPreloadConfigBean>
{
  public static TencentDocPreloadConfigBean a()
  {
    return (TencentDocPreloadConfigBean)QConfigManager.a().a(437);
  }
  
  @NonNull
  public TencentDocPreloadConfigBean a(int paramInt)
  {
    return new TencentDocPreloadConfigBean();
  }
  
  @Nullable
  public TencentDocPreloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocPreloadConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocPreloadConfigBean paramTencentDocPreloadConfigBean) {}
  
  public Class<TencentDocPreloadConfigBean> clazz()
  {
    return TencentDocPreloadConfigBean.class;
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
    return 437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */