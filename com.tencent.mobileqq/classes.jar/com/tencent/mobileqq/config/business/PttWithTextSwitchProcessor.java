package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PttWithTextSwitchProcessor
  extends IQConfigProcessor<PttWithTextSwitchBean>
{
  @NonNull
  public PttWithTextSwitchBean a(int paramInt)
  {
    return new PttWithTextSwitchBean();
  }
  
  @Nullable
  public PttWithTextSwitchBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      PttWithTextSwitchBean localPttWithTextSwitchBean = PttWithTextSwitchBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localPttWithTextSwitchBean;
    }
    return null;
  }
  
  public void a(PttWithTextSwitchBean paramPttWithTextSwitchBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramPttWithTextSwitchBean.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttWithTextSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */