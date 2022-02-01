package com.tencent.timi.game.datareport.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.IReporter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class TimiGameDataReportImpl$1
  implements IReporter
{
  TimiGameDataReportImpl$1(TimiGameDataReportImpl paramTimiGameDataReportImpl) {}
  
  public void report(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    paramObject = new JSONObject();
    try
    {
      paramObject.put("EventID", paramString);
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        paramObject.put((String)paramMap.getKey(), paramMap.getValue());
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("TimiGameDataReportImpl", 4, "log json error", paramString);
      paramString = new StringBuilder();
      paramString.append("LogJson:\n");
      paramString.append(paramObject);
      QLog.d("TimiGameDataReportImpl", 4, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.datareport.impl.TimiGameDataReportImpl.1
 * JD-Core Version:    0.7.0.1
 */