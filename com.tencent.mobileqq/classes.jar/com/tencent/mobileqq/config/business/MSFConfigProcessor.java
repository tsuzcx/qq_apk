package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class MSFConfigProcessor
  extends IQConfigProcessor<MSFConfigBean>
{
  public static boolean a()
  {
    MSFConfigBean localMSFConfigBean = (MSFConfigBean)QConfigManager.b().b(661);
    if (localMSFConfigBean != null) {
      return localMSFConfigBean.a;
    }
    return false;
  }
  
  @NonNull
  public MSFConfigBean a(int paramInt)
  {
    return new MSFConfigBean();
  }
  
  @Nullable
  public MSFConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      MSFConfigBean localMSFConfigBean = MSFConfigBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("MSFConfigProcessor", 2, localStringBuilder.toString());
      }
      return localMSFConfigBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFConfigProcessor", 2, "onParsed is null");
    }
    return new MSFConfigBean();
  }
  
  public void a(MSFConfigBean paramMSFConfigBean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      try
      {
        paramMSFConfigBean = MSFConfigBean.a(paramMSFConfigBean);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onUpdate], strConfig = ");
        ((StringBuilder)localObject).append(paramMSFConfigBean);
        QLog.i("MSFConfigProcessor", 1, ((StringBuilder)localObject).toString());
        localObject = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
        ((NewIntent)localObject).putExtra("action", 2214);
        ((NewIntent)localObject).putExtra("manager_config", paramMSFConfigBean);
        ThreadManager.getUIHandler().post(new MSFConfigProcessor.1(this, localAppRuntime, (NewIntent)localObject));
        return;
      }
      catch (Throwable paramMSFConfigBean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramMSFConfigBean);
        }
      }
    }
  }
  
  public Class<MSFConfigBean> clazz()
  {
    return MSFConfigBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("MSFConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MSFConfigProcessor
 * JD-Core Version:    0.7.0.1
 */