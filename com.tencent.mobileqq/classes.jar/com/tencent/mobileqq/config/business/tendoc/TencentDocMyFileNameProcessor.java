package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocMyFileNameProcessor
  extends IQConfigProcessor<TencentDocMyFileNameBean>
{
  public static TencentDocMyFileNameBean a()
  {
    return (TencentDocMyFileNameBean)QConfigManager.b().b(487);
  }
  
  @NonNull
  public TencentDocMyFileNameBean a(int paramInt)
  {
    return new TencentDocMyFileNameBean();
  }
  
  @Nullable
  public TencentDocMyFileNameBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocMyFileNameBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocMyFileNameBean paramTencentDocMyFileNameBean) {}
  
  public Class<TencentDocMyFileNameBean> clazz()
  {
    return TencentDocMyFileNameBean.class;
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
    return 487;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor
 * JD-Core Version:    0.7.0.1
 */