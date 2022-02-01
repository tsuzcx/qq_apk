package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class DarkModeConfigProcessor
  extends IQConfigProcessor<DarkModeConfigProcessor.DarkModeConfigBean>
{
  public static boolean a = false;
  private static boolean b = false;
  
  public static boolean a()
  {
    if (b) {
      return a;
    }
    b = true;
    a = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DarkModeConfigBean isSwitchOpened = ");
      localStringBuilder.append(a);
      QLog.d("DarkModeConfigProcessor", 2, localStringBuilder.toString());
    }
    return a;
  }
  
  private static boolean b()
  {
    Object localObject2 = (DarkModeConfigProcessor.DarkModeConfigBean)QConfigManager.a().a(531);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new DarkModeConfigProcessor.DarkModeConfigBean();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DarkModeConfigBean switch isOpened = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("DarkModeConfigProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1.a();
  }
  
  @NonNull
  public DarkModeConfigProcessor.DarkModeConfigBean a(int paramInt)
  {
    return new DarkModeConfigProcessor.DarkModeConfigBean();
  }
  
  @Nullable
  public DarkModeConfigProcessor.DarkModeConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("DarkModeConfigProcessor", 2, localStringBuilder.toString());
      }
      return DarkModeConfigProcessor.DarkModeConfigBean.a(paramArrayOfQConfItem[0].a);
    }
    return new DarkModeConfigProcessor.DarkModeConfigBean();
  }
  
  public void a(DarkModeConfigProcessor.DarkModeConfigBean paramDarkModeConfigBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramDarkModeConfigBean);
      QLog.d("DarkModeConfigProcessor", 2, localStringBuilder.toString());
    }
    if (paramDarkModeConfigBean != null) {
      a = paramDarkModeConfigBean.a();
    }
  }
  
  public Class<DarkModeConfigProcessor.DarkModeConfigBean> clazz()
  {
    return DarkModeConfigProcessor.DarkModeConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DarkModeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */