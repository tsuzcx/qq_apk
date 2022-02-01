package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.content.Intent;

public class ActivityClassHandler
  extends AbsActivityHandler
{
  final Class<? extends Activity> activityClass;
  
  ActivityClassHandler(Class<? extends Activity> paramClass, ActivityLauncher paramActivityLauncher)
  {
    super(paramActivityLauncher);
    this.activityClass = paramClass;
  }
  
  protected Intent createIntent(URIRequest paramURIRequest)
  {
    return new Intent(paramURIRequest.getContext(), this.activityClass);
  }
  
  public String toString()
  {
    return "ActivityClassHandler<" + this.activityClass.getSimpleName() + ">";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.ActivityClassHandler
 * JD-Core Version:    0.7.0.1
 */