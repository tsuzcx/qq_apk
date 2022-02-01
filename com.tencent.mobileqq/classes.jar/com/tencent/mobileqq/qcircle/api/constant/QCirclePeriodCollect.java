package com.tencent.mobileqq.qcircle.api.constant;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class QCirclePeriodCollect
{
  private static final ArrayList<Pair<String, Long>> BASE_PERIOD_LIST = new ArrayList();
  public static final String PERIOD_ENTER_CLICK = "enter_click";
  public static final String PERIOD_GET_NEARBY_GPSINFO = "get_nearby_gpsinfo";
  public static final String PERIOD_GET_PAGE_CACHE_RSP = "get_page_cache_rsp";
  public static final String PERIOD_GET_PAGE_NET_RSP = "get_page_net_rsp";
  public static final String PERIOD_GET_TAB_CAHCE_RSP = "get_tab_cahce_rsp";
  public static final String PERIOD_GET_TAB_NET_RSP = "get_tab_net_rsp";
  public static final String PERIOD_PAGE_CREATE = "page_create";
  public static final String PERIOD_PLUGIN_LOADED = "plugin_loaded";
  public static final String PERIOD_REQUEST_PAGE_BY_CACHE = "request_page_by_cache";
  public static final String PERIOD_REQUEST_PAGE_BY_NET = "request_page_by_net";
  public static final String PERIOD_REQUEST_TAB = "request_tab";
  private static final String TAG = "QCirclePeriodCollect";
  private static final HashMap<String, QCirclePeriodCollect.TypeParms> TYPE_PARM_MAP = new HashMap();
  private static final HashMap<String, Boolean> TYPE_PERIOD_COLLECT_FINISH_MAP = new HashMap();
  private static boolean sEnableCollect = false;
  private static boolean sIsInMemCachePeroid = false;
  
  static
  {
    initEnablePeriodCollect();
  }
  
  public static void flushPeriodReport(String paramString)
  {
    if (pass()) {
      return;
    }
    if (isFinish(paramString)) {
      return;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportLaunchPeriodEvent(new QCircleAlphaUserReportDataBuilder().setType(paramString).setAttachInfo(getPeriodStr(paramString)));
  }
  
  public static String getPeriodStr(String paramString)
  {
    Object localObject2 = new ArrayList(BASE_PERIOD_LIST);
    Object localObject1 = (QCirclePeriodCollect.TypeParms)TYPE_PARM_MAP.get(paramString);
    if (localObject1 != null) {
      ((ArrayList)localObject2).addAll(QCirclePeriodCollect.TypeParms.access$100((QCirclePeriodCollect.TypeParms)localObject1));
    }
    localObject1 = new JSONObject();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject2).next();
      if (localPair != null) {
        try
        {
          ((JSONObject)localObject1).put((String)localPair.first, localPair.second);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    localObject1 = ((JSONObject)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getPeriodStr type=");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",attachInfo=");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("QCirclePeriodCollect", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private static void initEnablePeriodCollect()
  {
    sEnableCollect = QCircleHostConfig.getEnablePeriodCollect();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initEnablePeriodCollect value:");
    localStringBuilder.append(sEnableCollect);
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  private static boolean isFinish(String paramString)
  {
    Boolean localBoolean = (Boolean)TYPE_PERIOD_COLLECT_FINISH_MAP.get(paramString);
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    TYPE_PERIOD_COLLECT_FINISH_MAP.put(paramString, Boolean.valueOf(true));
    return false;
  }
  
  private static boolean pass()
  {
    return (!sEnableCollect) || (sIsInMemCachePeroid);
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
    if (!TYPE_PARM_MAP.containsKey(paramString1)) {
      TYPE_PARM_MAP.put(paramString1, new QCirclePeriodCollect.TypeParms());
    }
    QCirclePeriodCollect.TypeParms localTypeParms = (QCirclePeriodCollect.TypeParms)TYPE_PARM_MAP.get(paramString1);
    if (localTypeParms != null) {
      localTypeParms.record(paramString1, paramString2);
    }
  }
  
  private static void reset()
  {
    BASE_PERIOD_LIST.clear();
    TYPE_PARM_MAP.clear();
    TYPE_PERIOD_COLLECT_FINISH_MAP.clear();
    sIsInMemCachePeroid = false;
  }
  
  public static void setEnableCollect(boolean paramBoolean)
  {
    sEnableCollect = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableCollect value:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
  
  public static void setIsInMemCachePeroid()
  {
    sIsInMemCachePeroid = true;
    QLog.d("QCirclePeriodCollect", 1, "setIsInMemCachePeroid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect
 * JD-Core Version:    0.7.0.1
 */