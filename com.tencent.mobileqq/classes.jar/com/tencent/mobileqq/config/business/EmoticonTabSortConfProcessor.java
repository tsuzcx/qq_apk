package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class EmoticonTabSortConfProcessor
  extends IQConfigProcessor<EmoticonTabSortConfBean>
{
  public static EmoticonTabSortConfBean a()
  {
    return (EmoticonTabSortConfBean)QConfigManager.b().b(622);
  }
  
  @NonNull
  public EmoticonTabSortConfBean a(int paramInt)
  {
    return new EmoticonTabSortConfBean();
  }
  
  @Nullable
  public EmoticonTabSortConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return EmoticonTabSortConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(EmoticonTabSortConfBean paramEmoticonTabSortConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<EmoticonTabSortConfBean> clazz()
  {
    return EmoticonTabSortConfBean.class;
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
    return 622;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor
 * JD-Core Version:    0.7.0.1
 */