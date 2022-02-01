package com.tencent.mobileqq.qroute.route;

import android.content.Intent;

class ActivityClassNameHandler
  extends AbsActivityHandler
{
  private final String activityClassName;
  
  ActivityClassNameHandler(String paramString, ActivityLauncher paramActivityLauncher)
  {
    super(paramActivityLauncher);
    this.activityClassName = paramString;
  }
  
  protected Intent createIntent(URIRequest paramURIRequest)
  {
    return new Intent().setClassName(paramURIRequest.getContext(), this.activityClassName);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityClassNameHandler<");
    localStringBuilder.append(this.activityClassName);
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.ActivityClassNameHandler
 * JD-Core Version:    0.7.0.1
 */