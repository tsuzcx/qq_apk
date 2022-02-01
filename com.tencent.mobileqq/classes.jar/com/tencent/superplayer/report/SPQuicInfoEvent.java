package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SPQuicInfoEvent
{
  private static final String TAG = SPQuicInfoEvent.class.getSimpleName();
  private Map<String, String> data = new HashMap();
  
  private void innerParseEvent(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(paramString.optString(str))) {
          this.data.put(str, paramString.optString(str));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      LogUtil.e(TAG, "innerParseEvent exception = " + paramString.toString());
    }
  }
  
  public static SPQuicInfoEvent parseEvent(String paramString)
  {
    SPQuicInfoEvent localSPQuicInfoEvent = new SPQuicInfoEvent();
    localSPQuicInfoEvent.innerParseEvent(paramString);
    return localSPQuicInfoEvent;
  }
  
  public Map<String, String> getDataMap()
  {
    return this.data;
  }
  
  public String getEventName()
  {
    return (String)this.data.get("report_event");
  }
  
  public boolean needReport()
  {
    return (!this.data.isEmpty()) && (this.data.containsKey("report_event"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.report.SPQuicInfoEvent
 * JD-Core Version:    0.7.0.1
 */