package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PttWithTextSwitchProcessor
  extends IQConfigProcessor<PttWithTextSwitchBean>
{
  public PttWithTextSwitchBean a(int paramInt)
  {
    return new PttWithTextSwitchBean();
  }
  
  public PttWithTextSwitchBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      PttWithTextSwitchBean localPttWithTextSwitchBean = PttWithTextSwitchBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("PttWithTextSwitchProcessor", 2, localStringBuilder.toString());
      }
      return localPttWithTextSwitchBean;
    }
    return null;
  }
  
  public void a(PttWithTextSwitchBean paramPttWithTextSwitchBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramPttWithTextSwitchBean.toString());
      QLog.d("PttWithTextSwitchProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<PttWithTextSwitchBean> clazz()
  {
    return PttWithTextSwitchBean.class;
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
    return 488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttWithTextSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */