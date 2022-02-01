package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TogetherBusinessConfProcessor
  extends IQConfigProcessor<TogetherConfigureBean>
{
  @NonNull
  public TogetherConfigureBean a(int paramInt)
  {
    return new TogetherConfigureBean();
  }
  
  @Nullable
  public TogetherConfigureBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      TogetherConfigureBean localTogetherConfigureBean = TogetherConfigureBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("TogetherBusinessConfProcessor", 2, localStringBuilder.toString());
      }
      return localTogetherConfigureBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(TogetherConfigureBean paramTogetherConfigureBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramTogetherConfigureBean.toString());
      QLog.d("TogetherBusinessConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<TogetherConfigureBean> clazz()
  {
    return TogetherConfigureBean.class;
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
      QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 535;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherBusinessConfProcessor
 * JD-Core Version:    0.7.0.1
 */