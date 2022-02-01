package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.IEventMapHandler;
import com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DTParamsFlattenFormatter
  extends DefaultFormatter
{
  private static final String VIDEO_PROTO_VERSION = "1";
  
  public Map<String, Object> formatElementParams(@NonNull List<ReportData> paramList, ReportData paramReportData)
  {
    return super.formatElementParams(paramList, paramReportData);
  }
  
  public Map<String, Object> formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    DTHandleEventFormatFactory.fetchEventHandler(paramString).formatEvent(paramString, paramMap1, paramMap2);
    paramString = new HashMap();
    if (paramMap1 != null) {
      paramString.putAll(paramMap1);
    }
    paramString.put("dt_protoversion", "1");
    paramString.put("udf_kv", paramMap2);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsFlattenFormatter
 * JD-Core Version:    0.7.0.1
 */