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
  private static final String TAG = "SPQuicInfoEvent";
  private Map<String, String> data = new HashMap();
  
  private void innerParseEvent(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject1 = paramString.keys();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(paramString.optString((String)localObject2))) {
          this.data.put(localObject2, paramString.optString((String)localObject2));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("innerParseEvent exception = ");
      ((StringBuilder)localObject2).append(paramString.toString());
      LogUtil.e((String)localObject1, ((StringBuilder)localObject2).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.report.SPQuicInfoEvent
 * JD-Core Version:    0.7.0.1
 */