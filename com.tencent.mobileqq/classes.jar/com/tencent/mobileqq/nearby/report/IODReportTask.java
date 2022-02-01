package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IODReportTask
  extends QRouteApi
{
  public abstract IODReportTask addKeyValue(String paramString, double paramDouble);
  
  public abstract IODReportTask addKeyValue(String paramString, int paramInt);
  
  public abstract IODReportTask addKeyValue(String paramString, long paramLong);
  
  public abstract IODReportTask addKeyValue(String paramString1, String paramString2);
  
  public abstract IODReportTask obj1(int paramInt);
  
  public abstract IODReportTask obj2(String paramString);
  
  public abstract IODReportTask obj3(int paramInt);
  
  public abstract void report();
  
  public abstract IODReportTask setAction(String paramString);
  
  public abstract IODReportTask setAnchor(long paramLong);
  
  public abstract IODReportTask setAnchorId(long paramLong);
  
  public abstract IODReportTask setBid(String paramString);
  
  public abstract IODReportTask setExtCol1(String paramString);
  
  public abstract IODReportTask setExtCol2(String paramString);
  
  public abstract IODReportTask setExtCol3(String paramString);
  
  public abstract IODReportTask setExtCol4(String paramString);
  
  public abstract IODReportTask setExtCol5(String paramString);
  
  public abstract IODReportTask setInstallSrc(String paramString);
  
  public abstract IODReportTask setIntCol1(int paramInt);
  
  public abstract IODReportTask setIntCol1(long paramLong);
  
  public abstract IODReportTask setIntCol2(int paramInt);
  
  public abstract IODReportTask setIntCol2(long paramLong);
  
  public abstract IODReportTask setModule(String paramString);
  
  public abstract IODReportTask setOperName(String paramString);
  
  public abstract IODReportTask setReferId(String paramString);
  
  public abstract IODReportTask setRes1(double paramDouble);
  
  public abstract IODReportTask setRes1(String paramString);
  
  public abstract IODReportTask setRes2(double paramDouble);
  
  public abstract IODReportTask setRes2(String paramString);
  
  public abstract IODReportTask setRes3(double paramDouble);
  
  public abstract IODReportTask setRes3(String paramString);
  
  public abstract IODReportTask setRoomId(int paramInt);
  
  public abstract IODReportTask setSource(String paramString);
  
  public abstract IODReportTask setTDBankImpDate(String paramString);
  
  public abstract IODReportTask setTid(String paramString);
  
  public abstract IODReportTask setType(String paramString);
  
  public abstract IODReportTask setUin(String paramString);
  
  public abstract IODReportTask setUserId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.IODReportTask
 * JD-Core Version:    0.7.0.1
 */