package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.app.Activity;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class AppForegroundInterceptActivities
{
  private static final String ACTIVITIES_DELIMITER = ",";
  private LinkedHashSet<String> mInterceptActivitiesSet = new LinkedHashSet();
  
  private String join(Collection paramCollection, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public void clear()
  {
    this.mInterceptActivitiesSet.clear();
  }
  
  public String get()
  {
    return join(this.mInterceptActivitiesSet, ",");
  }
  
  public void onIntercept(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    this.mInterceptActivitiesSet.add(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundInterceptActivities
 * JD-Core Version:    0.7.0.1
 */