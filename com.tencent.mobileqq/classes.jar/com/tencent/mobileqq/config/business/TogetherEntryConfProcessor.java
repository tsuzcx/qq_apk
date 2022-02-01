package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class TogetherEntryConfProcessor
  extends IQConfigProcessor<TogetherEntryBean>
{
  @NonNull
  public TogetherEntryBean a(int paramInt)
  {
    return new TogetherEntryBean();
  }
  
  @Nullable
  public TogetherEntryBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      TogetherEntryBean localTogetherEntryBean = TogetherEntryBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherEntryConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localTogetherEntryBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(TogetherEntryBean paramTogetherEntryBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onUpdate " + paramTogetherEntryBean.toString());
    }
  }
  
  public Class<TogetherEntryBean> clazz()
  {
    return TogetherEntryBean.class;
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
      QLog.d("TogetherEntryConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherEntryConfProcessor
 * JD-Core Version:    0.7.0.1
 */