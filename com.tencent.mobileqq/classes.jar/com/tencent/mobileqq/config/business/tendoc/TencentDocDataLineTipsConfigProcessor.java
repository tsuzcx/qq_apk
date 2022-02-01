package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IDataLineMessageSpreadManager;

public class TencentDocDataLineTipsConfigProcessor
  extends IQConfigProcessor<TencentDocDataLineTipsConfigBean>
{
  public static TencentDocDataLineTipsConfigBean a()
  {
    return (TencentDocDataLineTipsConfigBean)QConfigManager.b().b(383);
  }
  
  @NonNull
  public TencentDocDataLineTipsConfigBean a(int paramInt)
  {
    return new TencentDocDataLineTipsConfigBean();
  }
  
  @Nullable
  public TencentDocDataLineTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocDataLineTipsConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    ((IDataLineMessageSpreadManager)QRoute.api(IDataLineMessageSpreadManager.class)).updateConfig(paramTencentDocDataLineTipsConfigBean);
  }
  
  public Class<TencentDocDataLineTipsConfigBean> clazz()
  {
    return TencentDocDataLineTipsConfigBean.class;
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
    return 383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */