package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.IEventMapHandler;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class DTParamsNewsFlattenFormatter
  extends DTParamsNonFlattenFormatter
{
  static final String NEWS_PROTO_VERSION = "2";
  private static final String TAG = "DTParamsNewsFlatten_";
  
  @NonNull
  private List<String> getPrefix(@NonNull List<ReportData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ReportData)paramList.next();
      if (localObject != null)
      {
        localObject = ((ReportData)localObject).getId();
        int i = ((Integer)BaseUtils.getOrDefault(localHashMap, localObject, Integer.valueOf(0))).intValue();
        if (i == 0) {
          localArrayList.add("");
        }
        for (;;)
        {
          localHashMap.put(localObject, Integer.valueOf(i + 1));
          break;
          localArrayList.add("p" + i + "_");
        }
      }
    }
    return localArrayList;
  }
  
  private void printDebugLog(String paramString, Map<String, Object> paramMap)
  {
    if (!VideoReport.isDebugMode()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramMap != null) {
      localStringBuilder.append(new JSONObject(new TreeMap(paramMap)));
    }
    Log.i("DTParamsNewsFlatten_" + paramString, "打平参数： \n\n" + localStringBuilder.toString());
  }
  
  protected void formatElements(@NonNull List<ReportData> paramList, Map<String, Object> paramMap)
  {
    List localList = getPrefix(paramList);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious())
    {
      int i = paramList.previousIndex();
      Object localObject = (ReportData)paramList.previous();
      if (localObject != null)
      {
        String str1 = (String)localList.get(i);
        String str2 = ((ReportData)localObject).getId();
        paramMap.put("eid", str2);
        localObject = ((ReportData)localObject).getParams();
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            paramMap.put(str1 + (String)localEntry.getKey(), localEntry.getValue());
          }
        }
        localArrayList.add(0, str1 + str2);
      }
    }
    paramMap.put("element_path", localArrayList);
  }
  
  public Map<String, Object> formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    IEventMapHandler localIEventMapHandler = DTHandleEventFormatFactory.fetchEventHandler(paramString);
    printDebugLog(paramString, paramMap2);
    localIEventMapHandler.formatEvent(paramString, paramMap1, paramMap2);
    paramString = new HashMap();
    if (paramMap1 != null) {
      paramString.putAll(paramMap1);
    }
    paramString.put("dt_protoversion", "2");
    paramString.put("udf_kv", paramMap2);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNewsFlattenFormatter
 * JD-Core Version:    0.7.0.1
 */