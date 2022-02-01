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
    if (paramString == null)
    {
      localObject1 = "";
      QLog.d((String)localObject2, 2, (String)localObject1);
      localObject1 = new MostUsedSearch();
      if (paramString != null) {
        break label36;
      }
    }
    for (;;)
    {
      return localObject1;
      localObject1 = paramString;
      break;
      try
      {
        label36:
        paramString = new JSONObject(paramString);
        if (paramString.has("orgKey")) {
          ((MostUsedSearch)localObject1).orgKey = paramString.getString("orgKey");
        }
        if (paramString.has("latestUsedTime")) {
          ((MostUsedSearch)localObject1).latestUsedTime = paramString.getLong("latestUsedTime");
        }
        if (!paramString.has("items")) {
          continue;
        }
        paramString = paramString.getJSONArray("items");
        if (paramString == null) {
          continue;
        }
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
        return localObject1;
      }
      catch (JSONException paramString)
      {
        QLog.e(a, 2, "MostUsedSearch fromJson ERR;" + paramString.toString());
      }
    }
  }
  
  public static JSONObject toJson(MostUsedSearch paramMostUsedSearch)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramMostUsedSearch == null) {
      return localJSONObject1;
    }
    try
    {
      localJSONObject1.put("orgKey", paramMostUsedSearch.orgKey);
      localJSONObject1.put("latestUsedTime", paramMostUsedSearch.latestUsedTime);
      localJSONArray = new JSONArray();
      i = 0;
    }
    catch (JSONException paramMostUsedSearch)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int i;
        JSONObject localJSONObject2;
        QLog.e(a, 2, "MostUsedSearch fromJson ERR;" + paramMostUsedSearch.toString());
        continue;
        i += 1;
      }
    }
    if (i < paramMostUsedSearch.items.size())
    {
      localJSONObject2 = MostUsedSearchItem.toJson((MostUsedSearchItem)paramMostUsedSearch.items.get(i));
      if ((localJSONObject2 != null) && (!TextUtils.isEmpty(localJSONObject2.toString()))) {
        localJSONArray.put(localJSONObject2);
      }
    }
    else
    {
      localJSONObject1.put("items", localJSONArray);
      return localJSONObject1;
    }
  }
  
  public static String toJsonString(MostUsedSearch paramMostUsedSearch)
  {
    String str1 = null;
    if (paramMostUsedSearch != null) {
      str1 = toJson(paramMostUsedSearch).toString();
    }
    String str2 = a;
    if (str1 == null) {}
    for (paramMostUsedSearch = "";; paramMostUsedSearch = str1)
    {
      QLog.d(str2, 2, paramMostUsedSearch);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearch
 * JD-Core Version:    0.7.0.1
 */