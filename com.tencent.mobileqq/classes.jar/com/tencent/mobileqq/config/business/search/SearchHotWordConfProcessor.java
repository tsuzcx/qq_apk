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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("SearchHotWordConfProcessor", 2, localStringBuilder.toString());
      }
      return SearchHotWordConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchHotWordConfBean paramSearchHotWordConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramSearchHotWordConfBean != null) {
        paramSearchHotWordConfBean = paramSearchHotWordConfBean.toString();
      } else {
        paramSearchHotWordConfBean = " empty";
      }
      localStringBuilder.append(paramSearchHotWordConfBean);
      QLog.d("SearchHotWordConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("SearchHotWordConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 433;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchHotWordConfProcessor
 * JD-Core Version:    0.7.0.1
 */