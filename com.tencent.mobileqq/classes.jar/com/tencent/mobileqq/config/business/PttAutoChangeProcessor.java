package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PttAutoChangeProcessor
  extends IQConfigProcessor<PttAutoChangeBean>
{
  @NonNull
  public PttAutoChangeBean a(int paramInt)
  {
    return new PttAutoChangeBean();
  }
  
  @Nullable
  public PttAutoChangeBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      PttAutoChangeBean localPttAutoChangeBean = PttAutoChangeBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("PttAutoChangeProcessor", 2, localStringBuilder.toString());
      }
      return localPttAutoChangeBean;
    }
    return null;
  }
  
  public void a(PttAutoChangeBean paramPttAutoChangeBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramPttAutoChangeBean.toString());
      QLog.d("PttAutoChangeProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<PttAutoChangeBean> clazz()
  {
    return PttAutoChangeBean.class;
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
    return 442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttAutoChangeProcessor
 * JD-Core Version:    0.7.0.1
 */