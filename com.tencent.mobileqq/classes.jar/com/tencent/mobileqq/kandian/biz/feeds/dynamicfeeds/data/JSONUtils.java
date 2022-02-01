package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{
  public static JSONUtils.SerializableJSONArray a(JSONArray paramJSONArray)
  {
    JSONUtils.SerializableJSONArray localSerializableJSONArray = new JSONUtils.SerializableJSONArray();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if ((localObject instanceof JSONObject)) {
          localSerializableJSONArray.put(a((JSONObject)localObject));
        } else if ((localObject instanceof JSONArray)) {
          localSerializableJSONArray.put(a((JSONArray)localObject));
        } else {
          localSerializableJSONArray.put(paramJSONArray.optString(i));
        }
        i += 1;
      }
    }
    return localSerializableJSONArray;
  }
  
  public static JSONUtils.SerializableJSONObject a(JSONObject paramJSONObject)
  {
    JSONUtils.SerializableJSONObject localSerializableJSONObject = new JSONUtils.SerializableJSONObject();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          Object localObject = paramJSONObject.get(str);
          if ((localObject instanceof JSONObject)) {
            localSerializableJSONObject.put(str, a((JSONObject)localObject));
          } else if ((localObject instanceof JSONArray)) {
            localSerializableJSONObject.put(str, a((JSONArray)localObject));
          } else {
            localSerializableJSONObject.put(str, paramJSONObject.getString(str));
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("JSONUtils", 2, "convertJSONObjectToSerializable, e = ", localJSONException);
        }
      }
    }
    return localSerializableJSONObject;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new Bundle();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("queryParams");
      if (paramJSONObject != null) {
        a(paramJSONObject, (Bundle)localObject);
      }
    }
    localObject = HttpUtil.encodeUrl((Bundle)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramJSONObject = "?";
    if (paramString.contains("?")) {
      paramJSONObject = "&";
    }
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append((String)localObject);
    paramJSONObject = localStringBuilder.toString();
    QLog.d("JSONUtils", 2, new Object[] { "encodeUrlWithQueryParams, url = ", paramString, ", encodeParams = ", localObject, ", finalUrl = ", paramJSONObject });
    return paramJSONObject;
  }
  
  private static void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          Object localObject = paramJSONObject.get(str);
          if ((localObject instanceof JSONObject)) {
            paramBundle.putSerializable(str, a((JSONObject)localObject));
          } else if ((localObject instanceof JSONArray)) {
            paramBundle.putSerializable(str, a((JSONArray)localObject));
          } else {
            paramBundle.putString(str, paramJSONObject.getString(str));
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("JSONUtils", 2, "iterateJSON, e = ", localJSONException);
        }
      }
    }
  }
  
  public static Bundle b(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PostBodyType", 1);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(str1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str2);
    localBundle.putString("Cookie", localStringBuilder.toString());
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("requestBody");
      if (paramJSONObject != null) {
        a(paramJSONObject, localBundle);
      }
    }
    QLog.d("JSONUtils", 2, new Object[] { "covertJSONToBundle, params = ", localBundle });
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.JSONUtils
 * JD-Core Version:    0.7.0.1
 */