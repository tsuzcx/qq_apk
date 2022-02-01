package com.tencent.mobileqq.qroute.route;

import android.content.Intent;

abstract interface ActivityLauncher
{
  public static final String FIELD_INTENT_EXTRA = "com.tencent.mobileqq.qroute.route.intentExtra";
  public static final String FIELD_REQUEST_CODE = "com.tencent.mobileqq.qroute.route.requestCode";
  public static final String FIELD_START_ACTIVITY_ACTION = "com.tencent.mobileqq.qroute.route.action";
  public static final String FIELD_START_ACTIVITY_DATA = "com.tencent.mobileqq.qroute.route.data";
  public static final String FIELD_START_ACTIVITY_FLAGS = "com.tencent.mobileqq.qroute.route.flags";
  public static final String FIELD_START_ACTIVITY_INTENT_ACTION = "com.tencent.mobileqq.qroute.route.intentAction";
  public static final String FIELD_START_ACTIVITY_OPTIONS = "com.tencent.mobileqq.qroute.route.options";
  public static final String FIELD_START_ACTIVITY_OVERRIDE_PENDING_TRANSITION = "com.tencent.mobileqq.qroute.route.overridePendingTransition";
  public static final String FIELD_START_ACTIVITY_TYPE = "com.tencent.mobileqq.qroute.route.type";
  public static final String PACKAGE = "com.tencent.mobileqq.qroute.route.";
  
  public abstract int startActivity(Intent paramIntent, URIRequest paramURIRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.ActivityLauncher
 * JD-Core Version:    0.7.0.1
 */