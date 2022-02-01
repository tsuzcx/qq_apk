package com.tencent.rfw.barrage.util;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.richframework.delegate.impl.RFApplication;

public class RFWQQUtils
{
  private static boolean a = false;
  
  public static Resources a()
  {
    return RFApplication.getApplication().getResources();
  }
  
  public static boolean b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWQQUtils
 * JD-Core Version:    0.7.0.1
 */