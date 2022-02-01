package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocImportFileInfoProcessor
  extends IQConfigProcessor<TencentDocImportFileInfoBean>
{
  public static TencentDocImportFileInfoBean a()
  {
    return (TencentDocImportFileInfoBean)QConfigManager.a().a(377);
  }
  
  @NonNull
  public TencentDocImportFileInfoBean a(int paramInt)
  {
    return new TencentDocImportFileInfoBean();
  }
  
  @Nullable
  public TencentDocImportFileInfoBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocImportFileInfoBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocImportFileInfoBean paramTencentDocImportFileInfoBean) {}
  
  public Class<TencentDocImportFileInfoBean> clazz()
  {
    return TencentDocImportFileInfoBean.class;
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
    return 377;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor
 * JD-Core Version:    0.7.0.1
 */