package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class MSFConfigProcessor
  extends IQConfigProcessor<MSFConfigBean>
{
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
      MSFConfigBean localMSFConfigBean = MSFConfigBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("MSFConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
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
    if (localAppRuntime != null) {}
    try
    {
      paramMSFConfigBean = MSFConfigBean.a(paramMSFConfigBean);
      QLog.i("MSFConfigProcessor", 1, "[onUpdate], strConfig = " + paramMSFConfigBean);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramMSFConfigBean);
      ThreadManager.getUIHandler().post(new MSFConfigProcessor.1(this, localAppRuntime, localNewIntent));
      return;
    }
    catch (Throwable paramMSFConfigBean)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramMSFConfigBean);
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
    QLog.i("MSFConfigProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MSFConfigProcessor
 * JD-Core Version:    0.7.0.1
 */