package com.tencent.mobileqq.kandian.glue.pts;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeStyleLoaderHelper;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealTimeController
{
  private static Map<String, RealTimeController.DefaultRealTimeConfig> a = new ConcurrentHashMap();
  
  static
  {
    a();
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = (RealTimeController.DefaultRealTimeConfig)a.get(paramString);
      localJSONObject.put("app", "QQ");
      localJSONObject.put("appVersion", "8.8.17");
      localJSONObject.put("businessID", ((RealTimeController.DefaultRealTimeConfig)localObject).b);
      localJSONObject.put("os", "android");
      localObject = new JSONObject();
      paramString = RealTimeTemplateFactory.b(paramString, false);
      if (paramString != null)
      {
        paramString = paramString.g().entrySet().iterator();
        while (paramString.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramString.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      localJSONObject.put("styles", localObject);
      paramString = new StringBuilder();
      paramString.append("styles: ");
      paramString.append(localJSONObject);
      QLog.d("RealTimeController", 1, paramString.toString());
    }
    catch (Exception paramString)
    {
      QLog.d("RealTimeController", 1, "", paramString);
    }
    return localJSONObject.toString();
  }
  
  private static void a()
  {
    a(new RealTimeController.DefaultRealTimeConfig("default_feeds", "1"));
  }
  
  public static void a(RealTimeController.DefaultRealTimeConfig paramDefaultRealTimeConfig)
  {
    if (paramDefaultRealTimeConfig.a != null)
    {
      if (paramDefaultRealTimeConfig.b == null) {
        return;
      }
      a.put(paramDefaultRealTimeConfig.a, paramDefaultRealTimeConfig);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("serviceKey:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" styles:");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("RealTimeController", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    localObject1 = (RealTimeController.DefaultRealTimeConfig)a.get(paramString1);
    if (localObject1 == null) {
      return;
    }
    paramString1 = RealTimeTemplateFactory.b(paramString1, true);
    if (paramString1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("realTimeTemplateFactory == null styles:");
      paramString1.append(paramString2);
      QLog.d("RealTimeController", 1, paramString1.toString());
      return;
    }
    try
    {
      paramString1.a(StyleLoaderHelper.b());
      Object localObject2 = new JSONObject(paramString2);
      paramString2 = ((JSONObject)localObject2).getString("businessID");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("realTimeBusinessID: ");
      ((StringBuilder)localObject3).append(paramString2);
      QLog.d("RealTimeController", 1, ((StringBuilder)localObject3).toString());
      paramString2 = ((JSONObject)localObject2).getJSONArray("styleList");
      boolean bool = ((JSONObject)localObject2).has("deleteList");
      int j = 0;
      int i = j;
      if (bool)
      {
        localObject2 = ((JSONObject)localObject2).getJSONArray("deleteList");
        localObject3 = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          String str = ((JSONArray)localObject2).getString(i);
          ((List)localObject3).add(str);
          paramString1.d(str);
          i += 1;
        }
        ((RealTimeController.DefaultRealTimeConfig)localObject1).c.a((List)localObject3);
        i = j;
      }
      while (i < paramString2.length())
      {
        localObject2 = (JSONObject)paramString2.get(i);
        ((RealTimeController.DefaultRealTimeConfig)localObject1).c.a(paramString1, (JSONObject)localObject2, true);
        i += 1;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("RealTimeController", 1, "", paramString1);
    }
  }
  
  public static RealTimeTemplateFactory b(String paramString)
  {
    if (a.containsKey(paramString))
    {
      paramString = (RealTimeController.DefaultRealTimeConfig)a.get(paramString);
      if ((paramString != null) && (paramString.c != null)) {
        return paramString.c.a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.RealTimeController
 * JD-Core Version:    0.7.0.1
 */