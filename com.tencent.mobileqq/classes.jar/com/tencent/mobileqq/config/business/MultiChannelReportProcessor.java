package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class MultiChannelReportProcessor
  extends IQConfigProcessor<MultiChannelReportBean>
{
  @NonNull
  public MultiChannelReportBean a(int paramInt)
  {
    return new MultiChannelReportBean();
  }
  
  @Nullable
  public MultiChannelReportBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      localMultiChannelReportBean = MultiChannelReportBean.a(paramArrayOfQConfItem[0].a);
      localObject = localMultiChannelReportBean;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
        localObject = localMultiChannelReportBean;
      }
    }
    while (!QLog.isColorLevel())
    {
      MultiChannelReportBean localMultiChannelReportBean;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(MultiChannelReportBean paramMultiChannelReportBean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramMultiChannelReportBean = MultiChannelReportBean.a(paramMultiChannelReportBean);
      QLog.i("MultiChannelReportProcessor", 1, "[onUpdate], strConfig = " + paramMultiChannelReportBean);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramMultiChannelReportBean);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramMultiChannelReportBean)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramMultiChannelReportBean);
    }
  }
  
  public Class<MultiChannelReportBean> clazz()
  {
    return MultiChannelReportBean.class;
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
    QLog.i("MultiChannelReportProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MultiChannelReportProcessor
 * JD-Core Version:    0.7.0.1
 */