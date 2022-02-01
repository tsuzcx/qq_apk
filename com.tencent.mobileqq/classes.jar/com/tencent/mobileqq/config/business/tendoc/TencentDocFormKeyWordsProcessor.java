package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TencentDocFormKeyWordsProcessor
  extends IQConfigProcessor<TencentDocFormKeyWordsBean>
{
  public static TencentDocFormKeyWordsBean a()
  {
    return (TencentDocFormKeyWordsBean)QConfigManager.a().a(569);
  }
  
  @NonNull
  public TencentDocFormKeyWordsBean a(int paramInt)
  {
    return new TencentDocFormKeyWordsBean();
  }
  
  @Nullable
  public TencentDocFormKeyWordsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocFormKeyWordsBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocFormKeyWordsBean paramTencentDocFormKeyWordsBean) {}
  
  public Class<TencentDocFormKeyWordsBean> clazz()
  {
    return TencentDocFormKeyWordsBean.class;
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
    QLog.d("TencentDocFormKeyWordsProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 569;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsProcessor
 * JD-Core Version:    0.7.0.1
 */