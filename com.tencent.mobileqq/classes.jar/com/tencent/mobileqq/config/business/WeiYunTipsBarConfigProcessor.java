package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class WeiYunTipsBarConfigProcessor
  extends IQConfigProcessor<WeiyunTipsBarConfigBean>
{
  public static WeiyunTipsBarConfigBean a()
  {
    return (WeiyunTipsBarConfigBean)QConfigManager.b().b(497);
  }
  
  @NonNull
  public WeiyunTipsBarConfigBean a(int paramInt)
  {
    return new WeiyunTipsBarConfigBean();
  }
  
  @Nullable
  public WeiyunTipsBarConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return WeiyunTipsBarConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(WeiyunTipsBarConfigBean paramWeiyunTipsBarConfigBean) {}
  
  public Class<WeiyunTipsBarConfigBean> clazz()
  {
    return WeiyunTipsBarConfigBean.class;
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
    return 497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiYunTipsBarConfigProcessor
 * JD-Core Version:    0.7.0.1
 */