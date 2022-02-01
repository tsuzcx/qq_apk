package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class QConfLogProcessor
  extends IQConfigProcessor<QConfLogBean>
{
  @NonNull
  public QConfLogBean a(int paramInt)
  {
    return new QConfLogBean();
  }
  
  @Nullable
  public QConfLogBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QConfLogBean.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(QConfLogBean paramQConfLogBean) {}
  
  public Class<QConfLogBean> clazz()
  {
    return QConfLogBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 419;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfLogProcessor
 * JD-Core Version:    0.7.0.1
 */