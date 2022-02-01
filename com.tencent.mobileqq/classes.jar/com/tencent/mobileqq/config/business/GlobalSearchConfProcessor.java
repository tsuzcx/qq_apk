package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GlobalSearchConfProcessor
  extends IQConfigProcessor<GlobalSearchConfBean>
{
  @NonNull
  public GlobalSearchConfBean a(int paramInt)
  {
    return new GlobalSearchConfBean();
  }
  
  @Nullable
  public GlobalSearchConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      GlobalSearchConfBean localGlobalSearchConfBean = GlobalSearchConfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("GlobalSearchConfProcessor", 2, localStringBuilder.toString());
      }
      return localGlobalSearchConfBean;
    }
    return null;
  }
  
  public void a(GlobalSearchConfBean paramGlobalSearchConfBean)
  {
    com.tencent.mobileqq.search.base.util.SearchConfigManager.needSeparate = paramGlobalSearchConfBean.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramGlobalSearchConfBean.toString());
      QLog.d("GlobalSearchConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<GlobalSearchConfBean> clazz()
  {
    return GlobalSearchConfBean.class;
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
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GlobalSearchConfProcessor
 * JD-Core Version:    0.7.0.1
 */