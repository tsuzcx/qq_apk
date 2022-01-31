package com.tencent.proxyinner.report;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DataReport
{
  public static final int SDK_DATA_VERSION = 2;
  private static final String TAG = "ODSDK|DataReport";
  static HashMap<String, DataReport> mapReportObj = new HashMap();
  long bootCompleteTime = 0L;
  long bootTimeStart = 0L;
  long cancelTime = 0L;
  long downloadCompleteTime = 0L;
  long downloadStartTime = 0L;
  long installComplete = 0L;
  long installStart = 0L;
  long loadCompleteTime = 0L;
  long loadStartTime = 0L;
  List<Event> mEventList = new ArrayList();
  boolean mHasLocalPlugin = false;
  String mHostID;
  String mPluginID;
  
  public static DataReport getInstance(String paramString)
  {
    try
    {
      Object localObject1 = (DataReport)mapReportObj.get(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramString.equals("Live")) {
          localObject1 = new DataReportForQQ(paramString);
        }
        mapReportObj.put(paramString, localObject1);
        localObject2 = localObject1;
      }
      return localObject2;
    }
    finally {}
  }
  
  public void addListener(Event paramEvent)
  {
    if (paramEvent != null) {}
    try
    {
      this.mEventList.add(paramEvent);
      return;
    }
    finally
    {
      paramEvent = finally;
      throw paramEvent;
    }
  }
  
  public void removeListener(Event paramEvent)
  {
    try
    {
      this.mEventList.remove(paramEvent);
      return;
    }
    finally
    {
      paramEvent = finally;
      throw paramEvent;
    }
  }
  
  public abstract void reportBootComplete(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4);
  
  public abstract void reportBootFail(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4);
  
  public abstract void reportBootStart(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reportCancelRun(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void reportCheckVersionComplete(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void reportCheckVersionStart(String paramString);
  
  public abstract void reportConfigCheck(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  public abstract void reportDex2Oat(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void reportDownloadComplete(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, int paramInt6, String paramString2);
  
  public abstract void reportDownloadFail(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, int paramInt6, String paramString2);
  
  public abstract void reportDownloadStart(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void reportInstallComplete(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void reportInstallStart(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract void reportLoadComplete(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString);
  
  public abstract void reportLoadDirect(int paramInt1, int paramInt2);
  
  public abstract void reportLoadStart(int paramInt1, int paramInt2);
  
  public void setUid(String paramString)
  {
    try
    {
      this.mHostID = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static abstract interface Event
  {
    public abstract void onDataReport(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.report.DataReport
 * JD-Core Version:    0.7.0.1
 */