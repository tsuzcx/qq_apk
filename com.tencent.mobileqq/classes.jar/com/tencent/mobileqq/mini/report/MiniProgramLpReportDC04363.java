package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramLpReportDC04363
{
  private static final String BUSINESS_ANALYTICS = "mmbizwxaanalytics";
  private static final String BUSINESS_JS_API = "mmbizwxajsapi";
  private static final String BUSINESS_MONITOR = "mmbizwxamonitor";
  private static final String BUSINESS_SERVICE_QUALITY = "mmbizwxaservicequality";
  private static final String KEY_DATA = "data";
  private static final String KEY_EVENT_ID = "eventID";
  private static final String KEY_NAME = "name";
  private static final String KEY_VALUE = "value";
  private static final String TAG = "MiniProgramLpReportDC04";
  
  public static void handleReportRealTimeAction(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.contains("mmbizwxajsapi")) || (paramString2.contains("mmbizwxaservicequality")))
    {
      QLog.w("MiniProgramLpReportDC04", 2, "handleReportRealTimeAction not handle data " + paramString2);
      return;
    }
    paramString1 = MiniProgramReportHelper.newSingleDcData(4, String.valueOf(3), newThirdPartyEntries(paramString1, paramString2), null);
    MiniProgramReporter.getInstance().add(paramString1);
  }
  
  private static List<COMM.Entry> newThirdPartyEntries(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(new JSONObject(paramString2).optString("actionData"));
        String str1 = paramString2.optString("business");
        if ("mmbizwxamonitor".equals(str1))
        {
          localArrayList.add(MiniProgramReportHelper.newEntry(paramString2.optString("name"), String.valueOf(paramString2.optInt("value"))));
          Iterator localIterator = paramString2.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          String str2 = (String)localIterator.next();
          if ((("mmbizwxamonitor".equals(str1)) && (("name".equals(str2)) || ("value".equals(str2)))) || (("mmbizwxaanalytics".equals(str1)) && (("eventID".equals(str2)) || ("data".equals(str2))))) {
            continue;
          }
          localArrayList.add(MiniProgramReportHelper.newEntry(str2, paramString2.optString(str2)));
          continue;
        }
        if (!"mmbizwxaanalytics".equals(str1)) {
          continue;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return localArrayList;
      }
      localArrayList.add(MiniProgramReportHelper.newEntry(paramString2.optString("eventID"), paramString2.optString("data")));
    }
    localArrayList.add(MiniProgramReportHelper.newEntry("appid", paramString1));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04363
 * JD-Core Version:    0.7.0.1
 */