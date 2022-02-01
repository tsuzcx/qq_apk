package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocEditConvertConfigProcessor
  extends IQConfigProcessor<TencentDocEditConvertConfigBean>
{
  public static TencentDocEditConvertConfigBean a()
  {
    return (TencentDocEditConvertConfigBean)QConfigManager.b().b(429);
  }
  
  @NonNull
  public TencentDocEditConvertConfigBean a(int paramInt)
  {
    return new TencentDocEditConvertConfigBean();
  }
  
  @Nullable
  public TencentDocEditConvertConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocEditConvertConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocEditConvertConfigBean paramTencentDocEditConvertConfigBean) {}
  
  public Class<TencentDocEditConvertConfigBean> clazz()
  {
    return TencentDocEditConvertConfigBean.class;
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
    return 429;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigProcessor
 * JD-Core Version:    0.7.0.1
 */