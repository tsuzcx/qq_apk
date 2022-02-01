package com.tencent.ttpic.openapi.filter;

import android.view.MotionEvent;

public abstract interface GLGestureListener
{
  public static final int PRIORITY_2D = 1030;
  public static final int PRIORITY_2D_GROUP = 1031;
  public static final int PRIORITY_3D = 1040;
  public static final int PRIORITY_ARPARTICLE = 1020;
  public static final int PRIORITY_HEIGHTEN_LINE = 1032;
  public static final int PRIORITY_MAX_VALUE = 2147483647;
  public static final int PRIORITY_MIN_VALUE = 0;
  public static final int PRIORITY_MOVIE = 1050;
  public static final int PRIORITY_SWITCH_CAMERA = 1011;
  public static final int PRIORITY_SWITCH_FILTER = 1012;
  public static final int PRIORITY_TOUCH_TRIGGER = 1010;
  public static final int PROVIDER_VIEW_DISSMISS = 1060;
  public static final String TAG = "GLGestureListener";
  
  public abstract int onGetPriority();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GLGestureListener
 * JD-Core Version:    0.7.0.1
 */