package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VerticalSearchConfProcessor
  extends IQConfigProcessor<VerticalSearchConfBean>
{
  @NonNull
  public VerticalSearchConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new VerticalSearchConfBean();
  }
  
  @Nullable
  public VerticalSearchConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("VerticalSearchConfProcessor", 2, localStringBuilder.toString());
      }
      return VerticalSearchConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(VerticalSearchConfBean paramVerticalSearchConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramVerticalSearchConfBean != null) {
        paramVerticalSearchConfBean = paramVerticalSearchConfBean.toString();
      } else {
        paramVerticalSearchConfBean = " empty";
      }
      localStringBuilder.append(paramVerticalSearchConfBean);
      QLog.d("VerticalSearchConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class clazz()
  {
    return VerticalSearchConfBean.class;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("VerticalSearchConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 456;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.VerticalSearchConfProcessor
 * JD-Core Version:    0.7.0.1
 */