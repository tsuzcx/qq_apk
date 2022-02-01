package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchResultConfigBean
{
  private static GroupSearchResultConfigBean.SearchResultConfig c;
  public String a = null;
  private Map<String, GroupSearchResultConfigBean.SearchResultConfig> b = new ArrayMap();
  
  public static GroupSearchResultConfigBean.SearchResultConfig a()
  {
    QLog.d("search_manager_configGroupSearchResultConfigBean", 1, "getDefaultConfig");
    if (c == null) {
      c = new GroupSearchResultConfigBean.SearchResultConfig(new int[] { 1250, 1200, 1251, 1253, 1252, 1201, 1202, 1203, 1701, 1100, 268435456, 1207, 1204, 1205, 1206, 1106, 1105, 1003, 1101, 1000000, 12345 });
    }
    return c;
  }
  
  public static GroupSearchResultConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    GroupSearchResultConfigBean localGroupSearchResultConfigBean = new GroupSearchResultConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    } else {
      paramArrayOfQConfItem = null;
    }
    if (TextUtils.isEmpty(paramArrayOfQConfItem)) {
      return localGroupSearchResultConfigBean;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parse conf=");
    ((StringBuilder)localObject1).append(paramArrayOfQConfItem);
    QLog.d("search_manager_configGroupSearchResultConfigBean", 1, ((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(paramArrayOfQConfItem);
        i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        localObject1 = localJSONArray1.optJSONObject(i);
        if (localObject1 == null) {
          continue;
        }
        str = ((JSONObject)localObject1).optString("scene");
        JSONArray localJSONArray2 = ((JSONObject)localObject1).optJSONArray("sort");
        if (localJSONArray2 == null) {
          continue;
        }
        int[] arrayOfInt = new int[localJSONArray2.length()];
        int j = 0;
        localObject1 = arrayOfInt;
        if (j < localJSONArray2.length())
        {
          arrayOfInt[j] = localJSONArray2.getInt(j);
          j += 1;
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        String str;
        continue;
        Object localObject2 = null;
        continue;
      }
      localGroupSearchResultConfigBean.a(str, new GroupSearchResultConfigBean.SearchResultConfig((int[])localObject1));
      i += 1;
    }
    QLog.e("search_manager_configGroupSearchResultConfigBean", 1, "parse json error");
    localGroupSearchResultConfigBean.a = paramArrayOfQConfItem;
    return localGroupSearchResultConfigBean;
  }
  
  public GroupSearchResultConfigBean.SearchResultConfig a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSearchResultConfig: scene=");
    localStringBuilder.append(paramString);
    QLog.d("search_manager_configGroupSearchResultConfigBean", 1, localStringBuilder.toString());
    paramString = (GroupSearchResultConfigBean.SearchResultConfig)this.b.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return a();
  }
  
  void a(String paramString, GroupSearchResultConfigBean.SearchResultConfig paramSearchResultConfig)
  {
    this.b.put(paramString, paramSearchResultConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.config.GroupSearchResultConfigBean
 * JD-Core Version:    0.7.0.1
 */