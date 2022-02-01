package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MostUsedSearch
  implements Serializable
{
  private static String a = "MostUsedSearch";
  ArrayList<MostUsedSearchItem> items = new ArrayList();
  long latestUsedTime = -1L;
  String orgKey = "";
  
  public static MostUsedSearch fromJson(String paramString)
  {
    Object localObject2 = a;
    if (paramString == null) {
      localObject1 = "";
    } else {
      localObject1 = paramString;
    }
    QLog.d((String)localObject2, 2, (String)localObject1);
    localObject1 = new MostUsedSearch();
    if (paramString == null) {
      return localObject1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("orgKey")) {
        ((MostUsedSearch)localObject1).orgKey = paramString.getString("orgKey");
      }
      if (paramString.has("latestUsedTime")) {
        ((MostUsedSearch)localObject1).latestUsedTime = paramString.getLong("latestUsedTime");
      }
      if (paramString.has("items"))
      {
        paramString = paramString.getJSONArray("items");
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            localObject2 = paramString.optJSONObject(i);
            if (localObject2 != null)
            {
              localObject2 = MostUsedSearchItem.fromJson(((JSONObject)localObject2).toString());
              if (!((MostUsedSearchItem)localObject2).searchKey.isEmpty()) {
                ((MostUsedSearch)localObject1).items.add(localObject2);
              }
            }
            i += 1;
          }
        }
      }
      StringBuilder localStringBuilder;
      return localObject1;
    }
    catch (JSONException paramString)
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MostUsedSearch fromJson ERR;");
      localStringBuilder.append(paramString.toString());
      QLog.e((String)localObject2, 2, localStringBuilder.toString());
    }
  }
  
  public static JSONObject toJson(MostUsedSearch paramMostUsedSearch)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMostUsedSearch == null) {
      return localJSONObject;
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject.put("orgKey", paramMostUsedSearch.orgKey);
        localJSONObject.put("latestUsedTime", paramMostUsedSearch.latestUsedTime);
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramMostUsedSearch.items.size())
        {
          localObject2 = MostUsedSearchItem.toJson((MostUsedSearchItem)paramMostUsedSearch.items.get(i));
          if ((localObject2 != null) && (!TextUtils.isEmpty(((JSONObject)localObject2).toString()))) {
            ((JSONArray)localObject1).put(localObject2);
          }
        }
        else
        {
          localJSONObject.put("items", localObject1);
          return localJSONObject;
        }
      }
      catch (JSONException paramMostUsedSearch)
      {
        Object localObject1 = a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MostUsedSearch fromJson ERR;");
        ((StringBuilder)localObject2).append(paramMostUsedSearch.toString());
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return localJSONObject;
      }
      i += 1;
    }
  }
  
  public static String toJsonString(MostUsedSearch paramMostUsedSearch)
  {
    if (paramMostUsedSearch != null) {
      paramMostUsedSearch = toJson(paramMostUsedSearch).toString();
    } else {
      paramMostUsedSearch = null;
    }
    String str = a;
    Object localObject;
    if (paramMostUsedSearch == null) {
      localObject = "";
    } else {
      localObject = paramMostUsedSearch;
    }
    QLog.d(str, 2, (String)localObject);
    return paramMostUsedSearch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearch
 * JD-Core Version:    0.7.0.1
 */