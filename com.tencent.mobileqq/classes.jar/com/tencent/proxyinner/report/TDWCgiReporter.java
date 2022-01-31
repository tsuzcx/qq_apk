package com.tencent.proxyinner.report;

import com.tencent.proxyinner.log.XLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class TDWCgiReporter
  extends CgiReporter
{
  private static final String DATAREPORT_TABLENAME = "xproxy_quality";
  private static final String REPORT_URL = "http://now.qq.com/cgi-bin/now/web/tdw/report?a=1";
  private static final String TAG = "ODSDK|DataReport|TDW";
  
  protected CgiReporter.ReportType getReportType()
  {
    return CgiReporter.ReportType.REPORT_TYPE_POST;
  }
  
  protected String getReportUrl()
  {
    return "http://now.qq.com/cgi-bin/now/web/tdw/report?a=1";
  }
  
  protected Map<String, String> reportPairs2CgiPairs(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localJSONArray1.put(localEntry.getKey());
      localJSONArray2.put(localEntry.getValue());
    }
    paramMap = new JSONArray();
    paramMap.put(localJSONArray2);
    localHashMap.put("table", "xproxy_quality");
    localHashMap.put("fields", localJSONArray1.toString());
    localHashMap.put("datas", paramMap.toString());
    XLog.i("ODSDK|DataReport|TDW", "准备数据上报,fields = " + localJSONArray1.toString() + " datas=" + paramMap.toString());
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.report.TDWCgiReporter
 * JD-Core Version:    0.7.0.1
 */