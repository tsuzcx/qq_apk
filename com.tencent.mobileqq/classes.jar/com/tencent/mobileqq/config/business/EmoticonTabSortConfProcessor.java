package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class EmoticonTabSortConfProcessor
  extends IQConfigProcessor<EmoticonTabSortConfProcessor.EmoticonTabSortConfBean>
{
  public static EmoticonTabSortConfProcessor.EmoticonTabSortConfBean a()
  {
    return (EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)QConfigManager.a().a(622);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 13: 
    case 14: 
    default: 
      return "";
    case 7: 
      return "sysface";
    case 4: 
      return "favorite";
    case 8: 
      return "recommend";
    case 11: 
      return "camera";
    case 12: 
      return "hotpic";
    }
    return "cmshow";
  }
  
  @NonNull
  public EmoticonTabSortConfProcessor.EmoticonTabSortConfBean a(int paramInt)
  {
    return new EmoticonTabSortConfProcessor.EmoticonTabSortConfBean();
  }
  
  @Nullable
  public EmoticonTabSortConfProcessor.EmoticonTabSortConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return EmoticonTabSortConfProcessor.EmoticonTabSortConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(EmoticonTabSortConfProcessor.EmoticonTabSortConfBean paramEmoticonTabSortConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<EmoticonTabSortConfProcessor.EmoticonTabSortConfBean> clazz()
  {
    return EmoticonTabSortConfProcessor.EmoticonTabSortConfBean.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor
 * JD-Core Version:    0.7.0.1
 */