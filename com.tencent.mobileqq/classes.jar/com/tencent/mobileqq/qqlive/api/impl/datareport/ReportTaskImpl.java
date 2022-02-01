package com.tencent.mobileqq.qqlive.api.impl.datareport;

import com.tencent.mobileqq.qqlive.api.datareport.IBeaconAction;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import java.util.HashMap;
import java.util.Map;

class ReportTaskImpl
  implements ReportTask
{
  private static final String TAG = "ReportTaskImpl";
  IBeaconAction beaconAction;
  Map<String, String> dataMap = new HashMap();
  String eventName;
  String page;
  boolean realTimeEvent = false;
  
  public ReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.dataMap.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, int paramInt)
  {
    this.dataMap.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, long paramLong)
  {
    this.dataMap.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.dataMap.put(paramString1, paramString2);
    return this;
  }
  
  public Map getData()
  {
    return this.dataMap;
  }
  
  public void send()
  {
    this.beaconAction.reportEvent(this.eventName, this.dataMap, this.realTimeEvent);
  }
  
  public void setDataReportModule(IBeaconAction paramIBeaconAction)
  {
    this.beaconAction = paramIBeaconAction;
  }
  
  public ReportTask setEventName(String paramString)
  {
    this.eventName = paramString;
    return this;
  }
  
  public ReportTask setPage(String paramString)
  {
    this.page = paramString;
    this.dataMap.put("page", paramString);
    return this;
  }
  
  public ReportTask setRealTimeUpload(boolean paramBoolean)
  {
    this.realTimeEvent = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.datareport.ReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */