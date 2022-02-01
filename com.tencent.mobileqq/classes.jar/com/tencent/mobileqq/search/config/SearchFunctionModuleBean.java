package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SearchFunctionModuleBean
{
  public String a = null;
  
  public static SearchFunctionModuleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    SearchFunctionModuleBean localSearchFunctionModuleBean = new SearchFunctionModuleBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    } else {
      paramArrayOfQConfItem = null;
    }
    if (TextUtils.isEmpty(paramArrayOfQConfItem))
    {
      QLog.i("search_manager_configSearchFunctionModuleBean", 1, "content is empty");
      return localSearchFunctionModuleBean;
    }
    try
    {
      localSearchFunctionModuleBean.a = new JSONObject(paramArrayOfQConfItem).optString("kFTSFunctionListUrlKey");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse config=");
      localStringBuilder.append(paramArrayOfQConfItem);
      localStringBuilder.append(",url=");
      localStringBuilder.append(localSearchFunctionModuleBean.a);
      QLog.i("search_manager_configSearchFunctionModuleBean", 1, localStringBuilder.toString());
      return localSearchFunctionModuleBean;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.i("search_manager_configSearchFunctionModuleBean", 1, "parse", paramArrayOfQConfItem);
    }
    return localSearchFunctionModuleBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.SearchFunctionModuleBean
 * JD-Core Version:    0.7.0.1
 */