package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Map;
import java.util.TreeMap;

public class DTDebugChannel
  implements IInnerReporter, IReporter
{
  private static final String TAG = "DTDebugChannel";
  private Map<String, Long> mEventCount = new TreeMap();
  
  private void addReport(String paramString)
  {
    try
    {
      Long localLong = (Long)this.mEventCount.get(paramString);
      if (localLong == null) {
        this.mEventCount.put(paramString, Long.valueOf(1L));
      } else {
        this.mEventCount.put(paramString, Long.valueOf(localLong.longValue() + 1L));
      }
      Log.d("DTDebugChannel", this.mEventCount.toString());
      return;
    }
    finally {}
  }
  
  public void report(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    addReport(paramString);
  }
  
  public void report(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    addReport(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTDebugChannel
 * JD-Core Version:    0.7.0.1
 */