package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public final class TencentDocUrl2DocConfigProcessor
  extends IQConfigProcessor<TencentDocUrl2DocConfigBean>
{
  public static TencentDocUrl2DocConfigBean a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (TencentDocUrl2DocConfigBean)QConfigManager.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    TencentDocUrl2DocConfigBean localTencentDocUrl2DocConfigBean = a();
    return (localTencentDocUrl2DocConfigBean != null) && (localTencentDocUrl2DocConfigBean.a()) && (localTencentDocUrl2DocConfigBean.a(paramString));
  }
  
  @NonNull
  public TencentDocUrl2DocConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent type:");
    localStringBuilder.append(paramInt);
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, localStringBuilder.toString());
    return new TencentDocUrl2DocConfigBean();
  }
  
  @Nullable
  public TencentDocUrl2DocConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return TencentDocUrl2DocConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(TencentDocUrl2DocConfigBean paramTencentDocUrl2DocConfigBean)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public Class<TencentDocUrl2DocConfigBean> clazz()
  {
    return TencentDocUrl2DocConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    localStringBuilder.append("onReqFailed: ");
    localStringBuilder.append(paramInt);
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocUrl2DocConfigProcessor
 * JD-Core Version:    0.7.0.1
 */