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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TransId:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("\tStartTime:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
    ((StringBuilder)localObject).append("\tFileSize:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    this.logStrings.add(localObject);
  }
  
  public String dumpTrackerInfo()
  {
    StringBuilder localStringBuilder2 = new StringBuilder("_TRACKER_");
    try
    {
      Iterator localIterator = this.logStrings.iterator();
      for (;;)
      {
        localStringBuilder1 = localStringBuilder2;
        if (!localIterator.hasNext()) {
          break;
        }
        localStringBuilder2.append((String)localIterator.next());
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder1;
      label48:
      break label48;
    }
    localStringBuilder1 = null;
    this.logStrings.clear();
    if (localStringBuilder1 != null) {
      return localStringBuilder1.toString();
    }
    return "_TRACKER_FAIL.";
  }
  
  public void logStep(String paramString1, String paramString2)
  {
    if (!this.bLogTime) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append("\tStep:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\tInfo:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    paramString1 = localStringBuilder.toString();
    this.logStrings.add(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Tracker
 * JD-Core Version:    0.7.0.1
 */