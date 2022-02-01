package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class DTReportChannel
  implements IInnerReporter, IReporter
{
  private static final Map<String, String> EVENT_KEY_DICT = new HashMap();
  private static final String TAG = "DTReportChannel";
  private IDTReport mDTReport;
  
  static
  {
    EVENT_KEY_DICT.put("origin_vst", "dt_origin_vst");
    EVENT_KEY_DICT.put("vst", "dt_vst");
    EVENT_KEY_DICT.put("act", "dt_act");
    EVENT_KEY_DICT.put("appin", "dt_appin");
    EVENT_KEY_DICT.put("appout", "dt_appout");
    EVENT_KEY_DICT.put("clck", "dt_clck");
    EVENT_KEY_DICT.put("imp", "dt_imp");
    EVENT_KEY_DICT.put("pgin", "dt_pgin");
    EVENT_KEY_DICT.put("pgout", "dt_pgout");
    EVENT_KEY_DICT.put("imp_end", "dt_imp_end");
  }
  
  public static DTReportChannel getInstance()
  {
    return DTReportChannel.InstanceHolder.INSTANCE;
  }
  
  @NonNull
  private Map<String, String> getParamsMap(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (BaseUtils.isEmpty(paramMap)) {
      return localHashMap;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = (Map.Entry)localIterator.next();
      str = (String)paramMap.getKey();
      paramMap = paramMap.getValue();
    } while (str == null);
    for (;;)
    {
      try
      {
        if (!(paramMap instanceof Map)) {
          break label119;
        }
        paramMap = new JSONObject((Map)paramMap).toString();
        localHashMap.put(str, paramMap);
      }
      catch (Exception paramMap)
      {
        Log.e("DTReportChannel", paramMap.getLocalizedMessage());
      }
      break;
      label119:
      if ((paramMap instanceof List))
      {
        paramMap = new JSONArray((List)paramMap).toString();
      }
      else if (paramMap != null)
      {
        paramMap = String.valueOf(paramMap);
        continue;
        return localHashMap;
      }
      else
      {
        paramMap = "";
      }
    }
  }
  
  private boolean shouldReportImmediately(String paramString)
  {
    return ("dt_act".equals(paramString)) || ("dt_origin_vst".equals(paramString)) || ("dt_vst".equals(paramString));
  }
  
  private String transformEvent(String paramString)
  {
    if (EVENT_KEY_DICT.containsKey(paramString)) {
      return (String)EVENT_KEY_DICT.get(paramString);
    }
    Log.i("DTReportChannel", "origin event key:" + paramString + " no need to transform");
    return paramString;
  }
  
  public void report(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    report(paramObject, paramString, paramMap, DTAppKeyExtractor.getAppKey(paramString, paramMap));
  }
  
  public void report(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    paramString1 = transformEvent(paramString1);
    Map localMap = getParamsMap(paramMap);
    boolean bool2 = shouldReportImmediately(paramString1);
    if (this.mDTReport == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString2)) {}
      for (boolean bool1 = this.mDTReport.dtEvent(paramObject, paramString1, localMap, bool2); VideoReport.isDebugMode(); bool1 = this.mDTReport.dtEvent(paramObject, paramString1, localMap, bool2, paramString2))
      {
        Log.i("DTReportChannel", "eventId = " + paramString1 + ", immediately = " + bool2 + ", isSuccess=" + bool1 + ", params = " + new JSONObject(paramMap));
        return;
      }
    }
  }
  
  public void setReport(IDTReport paramIDTReport)
  {
    this.mDTReport = paramIDTReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTReportChannel
 * JD-Core Version:    0.7.0.1
 */