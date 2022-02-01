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
    Object localObject;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      MultiChannelReportBean localMultiChannelReportBean = MultiChannelReportBean.a(paramArrayOfQConfItem[0].b);
      localObject = localMultiChannelReportBean;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].b);
        QLog.d("MultiChannelReportProcessor", 2, ((StringBuilder)localObject).toString());
        return localMultiChannelReportBean;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
      }
      localObject = null;
    }
    return localObject;
  }
  
  public void a(MultiChannelReportBean paramMultiChannelReportBean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      try
      {
        paramMultiChannelReportBean = MultiChannelReportBean.a(paramMultiChannelReportBean);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onUpdate], strConfig = ");
        ((StringBuilder)localObject).append(paramMultiChannelReportBean);
        QLog.i("MultiChannelReportProcessor", 1, ((StringBuilder)localObject).toString());
        localObject = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
        ((NewIntent)localObject).putExtra("action", 2214);
        ((NewIntent)localObject).putExtra("manager_config", paramMultiChannelReportBean);
        localAppRuntime.startServlet((NewIntent)localObject);
        return;
      }
      catch (Throwable paramMultiChannelReportBean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramMultiChannelReportBean);
        }
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("MultiChannelReportProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MultiChannelReportProcessor
 * JD-Core Version:    0.7.0.1
 */