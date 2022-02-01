package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TenDocDirectShareConfigProcessor
  extends IQConfigProcessor<TenDocDirectShareConfigBean>
{
  public static TenDocDirectShareConfigBean a()
  {
    return (TenDocDirectShareConfigBean)QConfigManager.b().b(486);
  }
  
  @NonNull
  public TenDocDirectShareConfigBean a(int paramInt)
  {
    return new TenDocDirectShareConfigBean();
  }
  
  @Nullable
  public TenDocDirectShareConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TenDocDirectShareConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TenDocDirectShareConfigBean paramTenDocDirectShareConfigBean) {}
  
  public Class<TenDocDirectShareConfigBean> clazz()
  {
    return TenDocDirectShareConfigBean.class;
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
    return 486;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigProcessor
 * JD-Core Version:    0.7.0.1
 */