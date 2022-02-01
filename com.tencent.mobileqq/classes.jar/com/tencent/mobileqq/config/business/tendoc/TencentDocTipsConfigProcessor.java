package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IAIOMessageSpreadManager;

public class TencentDocTipsConfigProcessor
  extends IQConfigProcessor<TencentDocTipsConfigBean>
{
  public static TencentDocTipsConfigBean a()
  {
    return (TencentDocTipsConfigBean)QConfigManager.b().b(346);
  }
  
  @NonNull
  public TencentDocTipsConfigBean a(int paramInt)
  {
    return new TencentDocTipsConfigBean();
  }
  
  @Nullable
  public TencentDocTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocTipsConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocTipsConfigBean paramTencentDocTipsConfigBean)
  {
    ((IAIOMessageSpreadManager)QRoute.api(IAIOMessageSpreadManager.class)).updateConfig(paramTencentDocTipsConfigBean);
  }
  
  public Class<TencentDocTipsConfigBean> clazz()
  {
    return TencentDocTipsConfigBean.class;
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
    return 346;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */