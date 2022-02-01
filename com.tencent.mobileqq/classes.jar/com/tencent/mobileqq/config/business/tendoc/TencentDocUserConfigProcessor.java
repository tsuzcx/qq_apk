package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocUserConfigProcessor
  extends IQConfigProcessor<TencentDocUserConfigBean>
{
  public static TencentDocUserConfigBean a()
  {
    return (TencentDocUserConfigBean)QConfigManager.a().a(344);
  }
  
  @NonNull
  public TencentDocUserConfigBean a(int paramInt)
  {
    return new TencentDocUserConfigBean();
  }
  
  @Nullable
  public TencentDocUserConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocUserConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocUserConfigBean paramTencentDocUserConfigBean) {}
  
  public Class<TencentDocUserConfigBean> clazz()
  {
    return TencentDocUserConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    return 344;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigProcessor
 * JD-Core Version:    0.7.0.1
 */