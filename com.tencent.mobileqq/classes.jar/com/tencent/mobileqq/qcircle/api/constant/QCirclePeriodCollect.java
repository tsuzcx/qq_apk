package com.tencent.mobileqq.qcircle.api.constant;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QCirclePeriodCollect
{
  private static final ArrayList<Pair<String, Long>> BASE_PERIOD_LIST = new ArrayList();
  public static final String PERIOD_ENTER_CLICK = "enter_click";
  public static final String PERIOD_FOLDER_CREATE = "folder_create";
  public static final String PERIOD_FOLDER_INIT = "folder_init";
  public static final String PERIOD_FOLDER_LAUNCH = "folder_launch";
  public static final String PERIOD_GET_NEARBY_GPSINFO = "get_nearby_gpsinfo";
  public static final String PERIOD_GET_PAGE_CACHE_RSP = "get_page_cache_rsp";
  public static final String PERIOD_GET_PAGE_NET_RSP = "get_page_net_rsp";
  public static final String PERIOD_GET_TAB_CACHE_RSP = "get_tab_cache_rsp";
  public static final String PERIOD_GET_TAB_NET_RSP = "get_tab_net_rsp";
  public static final String PERIOD_PAGE_LOADED = "page_loaded";
  public static final String PERIOD_PLUGIN_LOADED = "plugin_loaded";
  public static final String PERIOD_REQUEST_PAGE_BY_CACHE = "request_page_by_cache";
  public static final String PERIOD_REQUEST_PAGE_BY_NET = "request_page_by_net";
  public static final String PERIOD_REQUEST_TAB = "request_tab";
  public static final String STATE_CACHE = "2";
  public static final String STATE_NETWORK = "3";
  public static final String STATE_PRELOAD = "1";
  private static final String TAG = "QCirclePeriodCollect";
  private static final HashMap<String, QCirclePeriodCollect.TypeParams> TYPE_PARAM_MAP = new HashMap();
  private static final HashMap<String, Boolean> TYPE_PERIOD_COLLECT_FINISH_MAP = new HashMap();
  private static boolean sEnableCollect = false;
  private static long sStartTimeStamp = 0L;
  
  static
  {
    initEnablePeriodCollect();
  }
  
  public static void flushPeriodReport(String paramString1, String paramString2)
  {
    if (pass()) {
      return;
    }
    if (hasFlushed(paramString1))
    {
      QLog.e("QCirclePeriodCollect", 1, new Object[] { "flushPeriodReport hasFlushed type: ", paramString1 });
      return;
    }
    if (!shouldFlushNow(paramString1, paramString2))
    {
      QLog.e("QCirclePeriodCollect", 1, new Object[] { "flushPeriodReport should not flush now period: ", paramString2 });
      return;
    }
    TYPE_PERIOD_COLLECT_FINISH_MAP.put(paramString1, Boolean.valueOf(true));
    QLog.d("QCirclePeriodCollect", 1, new Object[] { "flushPeriodReport type: ", paramString1, ",period: ", paramString2 });
    ThreadManager.getSubThreadHandler().postDelayed(new QCirclePeriodCollect.1(paramString1), 1000L);
  }
  
  public static String getPeriodStr(String paramString)
  {
    Object localObject = new ArrayList(BASE_PERIOD_LIST);
    paramString = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString);
    if (paramString != null) {
      ((ArrayList)localObject).addAll(QCirclePeriodCollect.TypeParams.access$300(paramString));
    }
    paramString = new JSONObject();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if (localPair != null) {
        try
        {
          paramString.put((String)localPair.first, localPair.second);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return paramString.toString();
  }
  
  private static String getState(String paramString)
  {
    paramString = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString);
    if (paramString != null) {
      return QCirclePeriodCollect.TypeParams.access$500(paramString);
    }
    return "";
  }
  
  private static boolean hasFlushed(String paramString)
  {
    paramString = (Boolean)TYPE_PERIOD_COLLECT_FINISH_MAP.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  private static void initEnablePeriodCollect()
  {
    sEnableCollect = QCircleHostConfig.getEnablePeriodCollect();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initEnablePeriodCollect value:");
    localStringBuilder.append(sEnableCollect);
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  private static boolean pass()
  {
    return sEnableCollect ^ true;
  }
  
  public static void record(String paramString)
  {
    if (pass()) {
      return;
    }
    if ("enter_click".equals(paramString)) {
      reset();
    }
    paramString = new Pair(paramString, Long.valueOf(System.currentTimeMillis()));
    BASE_PERIOD_LIST.add(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record period:");
    localStringBuilder.append((String)paramString.first);
    localStringBuilder.append(",start :");
    localStringBuilder.append(paramString.second);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(((Long)paramString.second).longValue() - sStartTimeStamp);
    localStringBuilder.append("ms");
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  public static void record(String paramString1, String paramString2)
  {
    if (pass()) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!TYPE_PARAM_MAP.containsKey(paramString1)) {
      TYPE_PARAM_MAP.put(paramString1, new QCirclePeriodCollect.TypeParams());
    }
    QCirclePeriodCollect.TypeParams localTypeParams = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString1);
    if (localTypeParams != null) {
      localTypeParams.record(paramString1, paramString2);
    }
  }
  
  private static void reset()
  {
    sStartTimeStamp = System.currentTimeMillis();
    BASE_PERIOD_LIST.clear();
    TYPE_PARAM_MAP.clear();
    TYPE_PERIOD_COLLECT_FINISH_MAP.clear();
  }
  
  public static void setEnableCollect(boolean paramBoolean)
  {
    sEnableCollect = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableCollect value:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  public static void setIsPurelyMemCache(String paramString)
  {
    if (pass()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TYPE_PARAM_MAP.containsKey(paramString)) {
      TYPE_PARAM_MAP.put(paramString, new QCirclePeriodCollect.TypeParams());
    }
    QCirclePeriodCollect.TypeParams localTypeParams = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString);
    if (localTypeParams != null) {
      QCirclePeriodCollect.TypeParams.access$202(localTypeParams, true);
    }
    QLog.d("QCirclePeriodCollect", 1, new Object[] { "setIsPurelyMemCache type: ", paramString });
  }
  
  public static void setState(String paramString1, String paramString2)
  {
    if (pass()) {
      return;
    }
    if (hasFlushed(paramString1)) {
      return;
    }
    paramString1 = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString1);
    if (paramString1 != null) {
      paramString1.setState(paramString2);
    }
  }
  
  private static boolean shouldFlushNow(String paramString1, String paramString2)
  {
    paramString1 = (QCirclePeriodCollect.TypeParams)TYPE_PARAM_MAP.get(paramString1);
    if (paramString1 == null) {
      QLog.e("QCirclePeriodCollect", 1, "shouldFlushNow error,param is null");
    }
    if (QCirclePeriodCollect.TypeParams.access$200(paramString1)) {
      return "get_page_cache_rsp".equals(paramString2);
    }
    return "get_page_net_rsp".equals(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect
 * JD-Core Version:    0.7.0.1
 */