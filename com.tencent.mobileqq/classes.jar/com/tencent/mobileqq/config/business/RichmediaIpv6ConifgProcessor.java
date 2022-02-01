package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class RichmediaIpv6ConifgProcessor
  extends IQConfigProcessor<RichmediaIpv6ConifgBean>
{
  @NonNull
  public RichmediaIpv6ConifgBean a(int paramInt)
  {
    return new RichmediaIpv6ConifgBean();
  }
  
  @Nullable
  public RichmediaIpv6ConifgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("RichmediaIpv6ConifgProcessor", 2, localStringBuilder.toString());
      }
      return RichmediaIpv6ConifgBean.a(paramArrayOfQConfItem);
    }
    return new RichmediaIpv6ConifgBean();
  }
  
  public void a(RichmediaIpv6ConifgBean paramRichmediaIpv6ConifgBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    ((BaseTransFileController)localAppInterface.getRuntimeService(ITransFileController.class, "")).mRichmediaIpv6ConifgBean = paramRichmediaIpv6ConifgBean;
    localAppInterface.getHwEngine().ipv6Switch = paramRichmediaIpv6ConifgBean.a;
  }
  
  public Class clazz()
  {
    return RichmediaIpv6ConifgBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 538;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichmediaIpv6ConifgProcessor
 * JD-Core Version:    0.7.0.1
 */