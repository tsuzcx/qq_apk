package com.tencent.qapmsdk.impl.instrumentation;

import android.view.View;

public class QAPMFragmentSession
{
  private static QAPMFragmentSession instance;
  
  public static void fragmentOnCreateEnd(String paramString) {}
  
  public static void fragmentOnCreateViewBegin(String paramString1, String paramString2) {}
  
  public static void fragmentOnCreateViewEnd(String paramString1, View paramView, String paramString2) {}
  
  public static void fragmentSessionResumeBegin(String paramString1, String paramString2) {}
  
  public static void fragmentSessionResumeEnd(String paramString1, String paramString2) {}
  
  public static void fragmentStartEnd(String paramString1, String paramString2) {}
  
  public static QAPMFragmentSession getInstance()
  {
    if (instance == null) {
      instance = new QAPMFragmentSession();
    }
    return instance;
  }
  
  public void fragmentSessionPause(String paramString, boolean paramBoolean) {}
  
  public void fragmentSessionStarted(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMFragmentSession
 * JD-Core Version:    0.7.0.1
 */