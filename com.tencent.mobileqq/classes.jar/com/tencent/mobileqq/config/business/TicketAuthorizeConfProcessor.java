package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TicketAuthorizeConfProcessor
  extends IQConfigProcessor<TicketAuthorizeConfBean>
{
  @NonNull
  public TicketAuthorizeConfBean a(int paramInt)
  {
    return TicketAuthorizeConfBean.a();
  }
  
  @Nullable
  public TicketAuthorizeConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      TicketAuthorizeConfBean localTicketAuthorizeConfBean = TicketAuthorizeConfBean.b(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("TicketAuthorizeConf", 2, localStringBuilder.toString());
      }
      return localTicketAuthorizeConfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TicketAuthorizeConf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(TicketAuthorizeConfBean paramTicketAuthorizeConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TicketAuthorizeConf", 2, "onUpdate ");
    }
  }
  
  public Class<TicketAuthorizeConfBean> clazz()
  {
    return TicketAuthorizeConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("TicketAuthorizeConf", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TicketAuthorizeConf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 757;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TicketAuthorizeConfProcessor
 * JD-Core Version:    0.7.0.1
 */