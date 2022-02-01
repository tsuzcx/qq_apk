package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tracker
{
  public static final String CANCL = "CANCL";
  public static final String FAIL = "FAIL";
  public static final String INITI = "INITI";
  public static final String PAUSE = "PAUSE";
  public static final String PRGRS = "PRGRS";
  public static final String QUERY = "QUERY";
  public static final String QUEUE = "QUEUE";
  public static final String RESPN = "RESPN";
  public static final String REUPLOAD = "REUPLOAD";
  public static final String SLICE = "SLICE";
  public static final String SND_E = "SND_E";
  public static final String SND_F = "SND_F";
  public static final String SND_R = "SND_R";
  public static final String SND_S = "SND_S";
  public static final String SUCES = "SUCES";
  public static final boolean TRACE = true;
  public boolean bLogTime = false;
  List<String> logStrings = Collections.synchronizedList(new ArrayList());
  
  public Tracker(int paramInt, long paramLong)
  {
    if (paramLong < 204800L) {
      this.bLogTime = true;
    }
    String str = "TransId:" + paramInt + "\tStartTime:" + SystemClock.uptimeMillis() + "\tFileSize:" + paramLong + "\n";
    this.logStrings.add(str);
  }
  
  public String dumpTrackerInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("_TRACKER_");
    try
    {
      Iterator localIterator = this.logStrings.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next());
      }
      Object localObject;
      return "_TRACKER_FAIL.";
    }
    catch (Exception localException)
    {
      localObject = null;
      for (;;)
      {
        this.logStrings.clear();
        if (localObject == null) {
          break;
        }
        return localObject.toString();
      }
    }
  }
  
  public void logStep(String paramString1, String paramString2)
  {
    if (!this.bLogTime) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    paramString1 = l + "\tStep:" + paramString1 + "\tInfo:" + paramString2 + "\n";
    this.logStrings.add(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Tracker
 * JD-Core Version:    0.7.0.1
 */