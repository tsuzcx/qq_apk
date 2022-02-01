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
import java.util.TreeMap;
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
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      String str = (String)paramMap.getKey();
      Object localObject = paramMap.getValue();
      if (str != null)
      {
        paramMap = "";
        try
        {
          if ((localObject instanceof Map)) {
            paramMap = new JSONObject((Map)localObject).toString();
          } else if ((localObject instanceof List)) {
            paramMap = new JSONArray((List)localObject).toString();
          } else if (localObject != null) {
            paramMap = String.valueOf(localObject);
          }
          localHashMap.put(str, paramMap);
        }
        catch (Exception paramMap)
        {
          Log.e("DTReportChannel", paramMap.getLocalizedMessage());
        }
      }
    }
    return localHashMap;
  }
  
  private boolean shouldReportImmediately(String paramString)
  {
    return ("dt_act".equals(paramString)) || ("dt_vst".equals(paramString)) || ("dt_origin_vst".equals(paramString)) || ("dt_appin".equals(paramString)) || ("dt_appout".equals(paramString));
  }
  
  private String transformEvent(String paramString)
  {
    if (EVENT_KEY_DICT.containsKey(paramString)) {
      return (String)EVENT_KEY_DICT.get(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin event key:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" no need to transform");
    Log.i("DTReportChannel", localStringBuilder.toString());
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
    if (this.mDTReport == null) {
      return;
    }
    boolean bool1;
    if (TextUtils.isEmpty(paramString2)) {
      bool1 = this.mDTReport.dtEvent(paramObject, paramString1, localMap, bool2);
    } else {
      bool1 = this.mDTReport.dtEvent(paramObject, paramString1, localMap, bool2, paramString2);
    }
    if (VideoReport.isDebugMode())
    {
      paramObject = new StringBuilder();
      paramObject.append("eventId = BeaconReporter_");
      paramObject.append(paramString1);
      paramObject.append(", immediately = ");
      paramObject.append(bool2);
      paramObject.append(", isSuccess=");
      paramObject.append(bool1);
      paramObject.append(", params = ");
      paramObject.append(new JSONObject(new TreeMap(paramMap)));
      Log.i("DTReportChannel", paramObject.toString());
      paramObject = paramMap.get("udf_kv");
      if ((paramObject instanceof Map))
      {
        paramMap = new StringBuilder();
        paramMap.append("eventId = BeaconReporter_udfkv_");
        paramMap.append(paramString1);
        paramMap.append(", immediately = ");
        paramMap.append(bool2);
        paramMap.append(", isSuccess=");
        paramMap.append(bool1);
        paramMap.append(", params = ");
        paramMap.append(new JSONObject(new TreeMap((Map)paramObject)));
        Log.i("DTReportChannel", paramMap.toString());
      }
    }
  }
  
  public void setReport(IDTReport paramIDTReport)
  {
    this.mDTReport = paramIDTReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTReportChannel
 * JD-Core Version:    0.7.0.1
 */