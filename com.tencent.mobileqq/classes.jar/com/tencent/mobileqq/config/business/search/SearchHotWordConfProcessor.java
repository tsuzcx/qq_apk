package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SearchHotWordConfProcessor
  extends IQConfigProcessor<SearchHotWordConfBean>
{
  @NonNull
  public SearchHotWordConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchHotWordConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new SearchHotWordConfBean();
  }
  
  @Nullable
  public SearchHotWordConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchHotWordConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return SearchHotWordConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchHotWordConfBean paramSearchHotWordConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramSearchHotWordConfBean == null) {
        break label43;
      }
    }
    label43:
    for (paramSearchHotWordConfBean = paramSearchHotWordConfBean.toString();; paramSearchHotWordConfBean = " empty")
    {
      QLog.d("SearchHotWordConfProcessor", 2, paramSearchHotWordConfBean);
      return;
    }
  }
  
  public Class clazz()
  {
    return SearchHotWordConfBean.class;
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
      QLog.e("SearchHotWordConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 433;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchHotWordConfProcessor
 * JD-Core Version:    0.7.0.1
 */