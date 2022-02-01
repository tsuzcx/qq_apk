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
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return VerticalSearchConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(VerticalSearchConfBean paramVerticalSearchConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramVerticalSearchConfBean == null) {
        break label43;
      }
    }
    label43:
    for (paramVerticalSearchConfBean = paramVerticalSearchConfBean.toString();; paramVerticalSearchConfBean = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramVerticalSearchConfBean);
      return;
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
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 456;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.VerticalSearchConfProcessor
 * JD-Core Version:    0.7.0.1
 */