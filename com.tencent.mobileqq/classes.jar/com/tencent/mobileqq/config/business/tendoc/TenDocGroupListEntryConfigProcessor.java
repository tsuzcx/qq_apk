package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TenDocGroupListEntryConfigProcessor
  extends IQConfigProcessor<TenDocGroupListEntryConfigBean>
{
  public static TenDocGroupListEntryConfigBean a()
  {
    return (TenDocGroupListEntryConfigBean)QConfigManager.b().b(500);
  }
  
  @NonNull
  public TenDocGroupListEntryConfigBean a(int paramInt)
  {
    return new TenDocGroupListEntryConfigBean();
  }
  
  @Nullable
  public TenDocGroupListEntryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TenDocGroupListEntryConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TenDocGroupListEntryConfigBean paramTenDocGroupListEntryConfigBean) {}
  
  public Class<TenDocGroupListEntryConfigBean> clazz()
  {
    return TenDocGroupListEntryConfigBean.class;
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
    return 500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */