package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StructPicLimitConfigProcessor
  extends IQConfigProcessor<StructPicLimitDataBean>
{
  public static StructPicLimitDataBean a()
  {
    if (!MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
      return new StructPicLimitDataBean();
    }
    return (StructPicLimitDataBean)QConfigManager.b().b(724);
  }
  
  @NonNull
  public StructPicLimitDataBean a(int paramInt)
  {
    return new StructPicLimitDataBean();
  }
  
  @Nullable
  public StructPicLimitDataBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("StructPicLimitConfigProcessor", 1, "[onParsed] config");
    Object localObject;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      StructPicLimitDataBean localStructPicLimitDataBean = StructPicLimitDataBean.a(paramArrayOfQConfItem[0].b);
      localObject = localStructPicLimitDataBean;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].b);
        QLog.d("StructPicLimitConfigProcessor", 2, ((StringBuilder)localObject).toString());
        return localStructPicLimitDataBean;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructPicLimitConfigProcessor", 2, "onParsed is null");
      }
      localObject = null;
    }
    return localObject;
  }
  
  public void a(StructPicLimitDataBean paramStructPicLimitDataBean)
  {
    QLog.i("StructPicLimitConfigProcessor", 1, "[onUpdate]");
  }
  
  public Class<StructPicLimitDataBean> clazz()
  {
    return StructPicLimitDataBean.class;
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
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("StructPicLimitConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 724;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor
 * JD-Core Version:    0.7.0.1
 */