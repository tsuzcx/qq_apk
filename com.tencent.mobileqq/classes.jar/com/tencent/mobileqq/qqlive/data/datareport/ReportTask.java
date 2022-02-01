package com.tencent.mobileqq.qqlive.data.datareport;

import com.tencent.mobileqq.qqlive.api.datareport.IBeaconAction;
import java.util.Map;

public abstract interface ReportTask
{
  public abstract ReportTask addKeyValue(String paramString, double paramDouble);
  
  public abstract ReportTask addKeyValue(String paramString, int paramInt);
  
  public abstract ReportTask addKeyValue(String paramString, long paramLong);
  
  public abstract ReportTask addKeyValue(String paramString1, String paramString2);
  
  public abstract Map getData();
  
  public abstract void send();
  
  public abstract void setDataReportModule(IBeaconAction paramIBeaconAction);
  
  public abstract ReportTask setEventName(String paramString);
  
  public abstract ReportTask setPage(String paramString);
  
  public abstract ReportTask setRealTimeUpload(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.datareport.ReportTask
 * JD-Core Version:    0.7.0.1
 */