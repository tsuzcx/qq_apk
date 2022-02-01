package com.tencent.viola.core;

import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViolaReportManager
{
  public static final String BEACON_URL = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
  public static final int EVENT_BASE_CODE = 1000;
  public static final String EVENT_NAME_HTTP_PAGEDATE = "actKanDianViolaHttpData";
  public static final String EVENT_NAME_PAGEDATE = "actKanDianViolaData";
  public static final String EVENT_NAME_PROCESS_PAGEDATE = "actKanDianViolaPageDataNew";
  public static final String EVENT_NAME_RUNNING_PAGEDATE = "actKanDianViolaJsError";
  public static final int HTTP_TIMEOUT = 5000;
  public static final String TAG = "ViolaReportManager";
  private static volatile ViolaReportManager sManager;
  
  private String getEventCode(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 867497067: 
      if (paramString.equals("actKanDianViolaHttpData")) {
        i = 2;
      }
      break;
    case -1233911474: 
      if (paramString.equals("actKanDianViolaPageDataNew")) {
        i = 3;
      }
      break;
    case -1427247037: 
      if (paramString.equals("actKanDianViolaData")) {
        i = 0;
      }
      break;
    case -1732622586: 
      if (paramString.equals("actKanDianViolaJsError")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            i = 1000;
          } else {
            i = 1004;
          }
        }
        else {
          i = 1003;
        }
      }
      else {
        i = 1002;
      }
    }
    else {
      i = 1001;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(i);
    return paramString.toString();
  }
  
  public static ViolaReportManager getInstance()
  {
    if (sManager == null) {
      try
      {
        if (sManager == null) {
          sManager = new ViolaReportManager();
        }
      }
      finally {}
    }
    return sManager;
  }
  
  private void postBaseEventToBeacon(HashMap<String, String> paramHashMap)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
    localHttpRequset.method = "POST";
    localHttpRequset.timeoutMs = 5000;
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("Content-Type", "application/json;charset=UTF-8");
    localHttpRequset.paramMap = ((Map)localObject1);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("deviceId", FlexConvertUtils.getIMEI());
      ((JSONObject)localObject1).put("appkey", "JS0FEI6B3PZTEN");
      ((JSONObject)localObject1).put("versionCode", "1.0.1");
      ((JSONObject)localObject1).put("language", "zh-CN");
      ((JSONObject)localObject1).put("initTime", System.currentTimeMillis());
      ((JSONObject)localObject1).put("sdkVersion", "js_v1.1.0");
      ((JSONObject)localObject1).put("pixel", "2560*1440*2");
      ((JSONObject)localObject1).put("channelID", "");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", 2);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("id", Math.abs(new Random().nextInt()));
      localJSONObject1.put("start", System.currentTimeMillis());
      localJSONObject1.put("status", 2);
      localJSONObject1.put("duration", 0);
      JSONObject localJSONObject2 = new JSONObject();
      boolean bool = paramHashMap.containsKey(ViolaEnvironment.COMMON_PAGE_NAME);
      if (bool) {
        localJSONObject2.put("name", paramHashMap.get(ViolaEnvironment.COMMON_PAGE_NAME));
      } else {
        localJSONObject2.put("name", "https://viola.oa.com");
      }
      localJSONObject2.put("start", System.currentTimeMillis());
      localJSONObject2.put("duration", 1000);
      localJSONObject2.put("refer", "");
      localJSONObject1.put("pages", new JSONArray().put(localJSONObject2));
      localJSONObject1.put("events", new JSONArray());
      ((JSONObject)localObject2).put("data", localJSONObject1);
      ((JSONObject)localObject1).put("msgs", new JSONArray().put(localObject2));
    }
    catch (Exception paramHashMap)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("postDataToBeacon error:");
      ((StringBuilder)localObject2).append(paramHashMap.getMessage());
      ViolaLogUtils.e("ViolaReportManager", ((StringBuilder)localObject2).toString());
    }
    localHttpRequset.body = ((JSONObject)localObject1).toString();
    paramHashMap = ViolaSDKManager.getInstance().getHttpAdapter();
    if (paramHashMap != null) {
      paramHashMap.sendRequest(localHttpRequset, new ViolaReportManager.3(this), true);
    }
  }
  
  private void postEventToBeacon(String paramString, HashMap<String, String> paramHashMap)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
    localHttpRequset.method = "POST";
    localHttpRequset.timeoutMs = 5000;
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("Content-Type", "application/json;charset=UTF-8");
    localHttpRequset.paramMap = ((Map)localObject1);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("deviceId", FlexConvertUtils.getIMEI());
      ((JSONObject)localObject1).put("appkey", "JS0FEI6B3PZTEN");
      ((JSONObject)localObject1).put("versionCode", "1.0.1");
      ((JSONObject)localObject1).put("language", "zh-CN");
      ((JSONObject)localObject1).put("initTime", System.currentTimeMillis());
      ((JSONObject)localObject1).put("sdkVersion", "js_v1.1.0");
      ((JSONObject)localObject1).put("pixel", "2560*1440*2");
      ((JSONObject)localObject1).put("channelID", "");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", 2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("id", Math.abs(new Random().nextInt()));
      ((JSONObject)localObject2).put("start", System.currentTimeMillis());
      ((JSONObject)localObject2).put("status", 2);
      ((JSONObject)localObject2).put("duration", 0);
      ((JSONObject)localObject2).put("pages", new JSONArray());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("count", 1);
      localJSONObject2.put("start", System.currentTimeMillis());
      localJSONObject2.put("id", getEventCode(paramString));
      localJSONObject2.put("name", paramString);
      JSONObject localJSONObject3 = new JSONObject();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONObject3.put((String)localEntry.getKey(), localEntry.getValue());
      }
      localJSONObject2.put("params", localJSONObject3);
      ((JSONObject)localObject2).put("events", new JSONArray().put(localJSONObject2));
      localJSONObject1.put("data", localObject2);
      ((JSONObject)localObject1).put("msgs", new JSONArray().put(localJSONObject1));
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("postDataToBeacon error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ViolaLogUtils.e("ViolaReportManager", ((StringBuilder)localObject2).toString());
    }
    localHttpRequset.body = ((JSONObject)localObject1).toString();
    localObject1 = ViolaSDKManager.getInstance().getHttpAdapter();
    if (localObject1 != null) {
      ((IHttpAdapter)localObject1).sendRequest(localHttpRequset, new ViolaReportManager.2(this, paramString, paramHashMap), true);
    }
  }
  
  public void postDataToBeacon(String paramString, HashMap<String, String> paramHashMap)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new ViolaReportManager.1(this, paramHashMap, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager
 * JD-Core Version:    0.7.0.1
 */