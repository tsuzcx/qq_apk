package com.tencent.mobileqq.qqguildsdk.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.qqguildsdk.manager.GProConfigManager;
import com.tencent.qphone.base.util.QLog;

public class GProSdkConfigProcessor
  extends IQConfigProcessor<GProSdkConfigBean>
{
  public GProSdkConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("【gpro_sdk】GProSdkConfigProcessor", 1, localStringBuilder.toString());
    return new GProSdkConfigBean();
  }
  
  public GProSdkConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("【gpro_sdk】GProSdkConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (GProSdkConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, GProSdkConfigBean.class);
    }
    return null;
  }
  
  public void a(GProSdkConfigBean paramGProSdkConfigBean)
  {
    if (paramGProSdkConfigBean == null)
    {
      QLog.i("【gpro_sdk】GProSdkConfigProcessor", 1, "GProSdkConfig onUpdate: newConf is null.");
      return;
    }
    GProConfigManager.a().a(paramGProSdkConfigBean);
  }
  
  public Class<GProSdkConfigBean> clazz()
  {
    return GProSdkConfigBean.class;
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
    localStringBuilder.append("onReqFailed: failCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("【gpro_sdk】GProSdkConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 748;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.config.GProSdkConfigProcessor
 * JD-Core Version:    0.7.0.1
 */