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
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return SearchRichConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(SearchRichConfBean paramSearchRichConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramSearchRichConfBean == null) {
        break label49;
      }
    }
    label49:
    for (paramSearchRichConfBean = paramSearchRichConfBean.toString();; paramSearchRichConfBean = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramSearchRichConfBean);
      RichNodeFactory.a().a();
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchRichConfProcessor
 * JD-Core Version:    0.7.0.1
 */