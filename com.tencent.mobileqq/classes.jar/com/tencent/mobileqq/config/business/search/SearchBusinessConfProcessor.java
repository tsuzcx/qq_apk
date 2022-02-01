package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SearchBusinessConfProcessor
  extends IQConfigProcessor<SearchBusinessConfBean>
{
  @NonNull
  public SearchBusinessConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new SearchBusinessConfBean();
  }
  
  @Nullable
  public SearchBusinessConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
      }
      return SearchBusinessConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchBusinessConfBean paramSearchBusinessConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramSearchBusinessConfBean != null) {
        paramSearchBusinessConfBean = paramSearchBusinessConfBean.toString();
      } else {
        paramSearchBusinessConfBean = " empty";
      }
      localStringBuilder.append(paramSearchBusinessConfBean);
      QLog.d("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<SearchBusinessConfBean> clazz()
  {
    return SearchBusinessConfBean.class;
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
      QLog.e("SearchBusinessConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 434;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchBusinessConfProcessor
 * JD-Core Version:    0.7.0.1
 */