package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocPreviewConfigProcessor
  extends IQConfigProcessor<TencentDocPreviewConfigBean>
{
  public static TencentDocPreviewConfigBean a()
  {
    return (TencentDocPreviewConfigBean)QConfigManager.b().b(451);
  }
  
  @NonNull
  public TencentDocPreviewConfigBean a(int paramInt)
  {
    return new TencentDocPreviewConfigBean();
  }
  
  @Nullable
  public TencentDocPreviewConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocPreviewConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocPreviewConfigBean paramTencentDocPreviewConfigBean) {}
  
  public Class<TencentDocPreviewConfigBean> clazz()
  {
    return TencentDocPreviewConfigBean.class;
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
    return 451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor
 * JD-Core Version:    0.7.0.1
 */