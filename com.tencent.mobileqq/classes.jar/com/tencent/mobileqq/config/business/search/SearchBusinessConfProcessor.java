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
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return SearchBusinessConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchBusinessConfBean paramSearchBusinessConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramSearchBusinessConfBean == null) {
        break label43;
      }
    }
    label43:
    for (paramSearchBusinessConfBean = paramSearchBusinessConfBean.toString();; paramSearchBusinessConfBean = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramSearchBusinessConfBean);
      return;
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
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 434;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchBusinessConfProcessor
 * JD-Core Version:    0.7.0.1
 */