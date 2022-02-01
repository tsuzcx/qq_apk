package com.tencent.qqlive.module.videoreport.traversal;

import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Method;

class ViewGroupDrawingCompat$MethodHolder
{
  private static Method sGetChildDrawingOrderMethod;
  private static Method sIsOrderEnableMethod;
  
  static
  {
    try
    {
      sGetChildDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[] { Integer.TYPE, Integer.TYPE });
      sGetChildDrawingOrderMethod.setAccessible(true);
      sIsOrderEnableMethod = ViewGroup.class.getDeclaredMethod("isChildrenDrawingOrderEnabled", new Class[0]);
      sIsOrderEnableMethod.setAccessible(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      label55:
      break label55;
    }
    Log.e("ViewGroupDrawingCompat", "error happened in method reflection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat.MethodHolder
 * JD-Core Version:    0.7.0.1
 */