package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class MiniAppApiReportProcessor
  extends IQConfigProcessor<MiniAppApiReportBean>
{
  public static MiniAppApiReportBean a()
  {
    return (MiniAppApiReportBean)QConfigManager.b().b(446);
  }
  
  @NonNull
  public MiniAppApiReportBean a(int paramInt)
  {
    return new MiniAppApiReportBean();
  }
  
  @Nullable
  public MiniAppApiReportBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return MiniAppApiReportBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(MiniAppApiReportBean paramMiniAppApiReportBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramMiniAppApiReportBean.toString());
      QLog.d("MiniAppApiReportProcessor", 2, localStringBuilder.toString());
    }
    paramMiniAppApiReportBean = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramMiniAppApiReportBean instanceof QQAppInterface))
    {
      paramMiniAppApiReportBean = ((QQAppInterface)paramMiniAppApiReportBean).getBusinessHandler(BusinessHandlerFactory.MINI_APP_ENTRY_HANDLER);
      if (paramMiniAppApiReportBean != null) {
        paramMiniAppApiReportBean.notifyUI(0, true, null);
      }
    }
  }
  
  public Class<MiniAppApiReportBean> clazz()
  {
    return MiniAppApiReportBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 446;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppApiReportProcessor
 * JD-Core Version:    0.7.0.1
 */