package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocAIOPlusPanelEntryConfigProcessor
  extends IQConfigProcessor<TencentDocAIOPlusPanelEntryConfigBean>
{
  public static TencentDocAIOPlusPanelEntryConfigBean a()
  {
    return (TencentDocAIOPlusPanelEntryConfigBean)QConfigManager.a().a(334);
  }
  
  @NonNull
  public TencentDocAIOPlusPanelEntryConfigBean a(int paramInt)
  {
    return new TencentDocAIOPlusPanelEntryConfigBean();
  }
  
  @Nullable
  public TencentDocAIOPlusPanelEntryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocAIOPlusPanelEntryConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocAIOPlusPanelEntryConfigBean paramTencentDocAIOPlusPanelEntryConfigBean) {}
  
  public Class<TencentDocAIOPlusPanelEntryConfigBean> clazz()
  {
    return TencentDocAIOPlusPanelEntryConfigBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:");
    localStringBuilder.append(paramInt);
    QLog.d("TencentDocAIOPlusPanelEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 334;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */