package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocConvertConfigProcessor
  extends IQConfigProcessor<TencentDocConvertConfigBean>
{
  public static TencentDocConvertConfigBean a()
  {
    return (TencentDocConvertConfigBean)QConfigManager.a().a(261);
  }
  
  @NonNull
  public TencentDocConvertConfigBean a(int paramInt)
  {
    return new TencentDocConvertConfigBean();
  }
  
  @Nullable
  public TencentDocConvertConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocConvertConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocConvertConfigBean paramTencentDocConvertConfigBean) {}
  
  public Class<TencentDocConvertConfigBean> clazz()
  {
    return TencentDocConvertConfigBean.class;
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
    QLog.d("TencentDocConvertConfigProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 261;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor
 * JD-Core Version:    0.7.0.1
 */