package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.search.rich.RichNodeFactory;
import com.tencent.qphone.base.util.QLog;

public class SearchRichConfProcessor
  extends IQConfigProcessor<SearchRichConfBean>
{
  @NonNull
  public SearchRichConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new SearchRichConfBean();
  }
  
  @Nullable
  public SearchRichConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("SearchRichConfProcessor", 2, localStringBuilder.toString());
      }
      return SearchRichConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchRichConfBean paramSearchRichConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramSearchRichConfBean != null) {
        paramSearchRichConfBean = paramSearchRichConfBean.toString();
      } else {
        paramSearchRichConfBean = " empty";
      }
      localStringBuilder.append(paramSearchRichConfBean);
      QLog.d("SearchRichConfProcessor", 2, localStringBuilder.toString());
    }
    RichNodeFactory.a().a();
  }
  
  public Class<SearchRichConfBean> clazz()
  {
    return SearchRichConfBean.class;
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
      QLog.e("SearchRichConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchRichConfProcessor
 * JD-Core Version:    0.7.0.1
 */