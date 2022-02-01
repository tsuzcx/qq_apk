package com.tencent.mobileqq.search.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SearchConfigBean
{
  public String a = null;
  
  public static SearchConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    SearchConfigBean localSearchConfigBean = new SearchConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    } else {
      paramArrayOfQConfItem = null;
    }
    localSearchConfigBean.a = paramArrayOfQConfItem;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parse content=");
    localStringBuilder.append(paramArrayOfQConfItem);
    QLog.i("search_manager_configSearchConfigBean", 1, localStringBuilder.toString());
    return localSearchConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.SearchConfigBean
 * JD-Core Version:    0.7.0.1
 */