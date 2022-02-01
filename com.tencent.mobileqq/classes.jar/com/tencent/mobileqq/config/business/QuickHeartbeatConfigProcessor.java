package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class QuickHeartbeatConfigProcessor
  extends IQConfigProcessor<QuickHeartbeatConfigBean>
{
  @NonNull
  public QuickHeartbeatConfigBean a(int paramInt)
  {
    return new QuickHeartbeatConfigBean();
  }
  
  @Nullable
  public QuickHeartbeatConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QuickHeartbeatConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      QuickHeartbeatConfigBean localQuickHeartbeatConfigBean = QuickHeartbeatConfigBean.a(paramArrayOfQConfItem[0].b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed ");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      QLog.d("QuickHeartbeatConfigProcessor", 1, localStringBuilder.toString());
      return localQuickHeartbeatConfigBean;
    }
    QLog.d("QuickHeartbeatConfigProcessor", 1, "onParsed is null");
    return new QuickHeartbeatConfigBean();
  }
  
  public void a(QuickHeartbeatConfigBean paramQuickHeartbeatConfigBean)
  {
    if (paramQuickHeartbeatConfigBean != null)
    {
      SharedPreUtils.a(BaseApplicationImpl.getContext(), "common_sp_for_msf", "", true, "isSendQuickHBBackToForeground", Boolean.valueOf(paramQuickHeartbeatConfigBean.a), 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate, newConf: ");
      localStringBuilder.append(paramQuickHeartbeatConfigBean.toString());
      QLog.d("QuickHeartbeatConfigProcessor", 1, localStringBuilder.toString());
    }
  }
  
  public Class<QuickHeartbeatConfigBean> clazz()
  {
    return QuickHeartbeatConfigBean.class;
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
    localStringBuilder.append("[onReqFailed] failCode = ");
    localStringBuilder.append(paramInt);
    QLog.i("QuickHeartbeatConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 703;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QuickHeartbeatConfigProcessor
 * JD-Core Version:    0.7.0.1
 */