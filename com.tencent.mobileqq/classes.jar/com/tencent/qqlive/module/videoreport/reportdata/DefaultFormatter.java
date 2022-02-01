package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultFormatter
  implements IFormatter
{
  public Map<String, Object> formatElementParams(@NonNull List<ReportData> paramList, ReportData paramReportData)
  {
    HashMap localHashMap = new HashMap();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      Object localObject = (ReportData)paramList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i -= 1;
        break;
        String str = ((ReportData)localObject).getId();
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put("eid", str);
        }
        localObject = ((ReportData)localObject).getParams();
        if (!BaseUtils.isEmpty((Map)localObject)) {
          localHashMap.putAll((Map)localObject);
        }
      }
    }
    paramList = new ArrayMap();
    if (paramReportData != null)
    {
      paramList.put("pgid", paramReportData.getId());
      if (!BaseUtils.isEmpty(paramReportData.getParams())) {
        paramList.putAll(paramReportData.getParams());
      }
    }
    localHashMap.put("cur_pg", paramList);
    return localHashMap;
  }
  
  public Map<String, Object> formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    paramString = new HashMap();
    if (paramMap1 != null) {
      paramString.putAll(paramMap1);
    }
    paramString.put("udf_kv", paramMap2);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter
 * JD-Core Version:    0.7.0.1
 */