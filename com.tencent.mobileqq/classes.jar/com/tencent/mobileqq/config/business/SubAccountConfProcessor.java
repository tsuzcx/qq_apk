package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SubAccountConfProcessor
  extends IQConfigProcessor<SubAccountConfigBean>
{
  @NonNull
  public SubAccountConfigBean a(int paramInt)
  {
    return new SubAccountConfigBean();
  }
  
  @Nullable
  public SubAccountConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      return SubAccountConfigBean.a(paramArrayOfQConfItem[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(SubAccountConfigBean paramSubAccountConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onUpdate " + paramSubAccountConfigBean.toString());
    }
  }
  
  public Class<SubAccountConfigBean> clazz()
  {
    return SubAccountConfigBean.class;
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
      QLog.d("SubAccountConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 607;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SubAccountConfProcessor
 * JD-Core Version:    0.7.0.1
 */