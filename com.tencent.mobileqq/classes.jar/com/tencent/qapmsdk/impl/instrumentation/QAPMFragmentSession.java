package com.tencent.qapmsdk.impl.instrumentation;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.appstate.i;
import com.tencent.qapmsdk.impl.g.b;
import java.util.concurrent.ConcurrentHashMap;

public class QAPMFragmentSession
{
  private static final String TAG = "QAPM_impl_QAPMFragmentSession";
  private static ConcurrentHashMap<String, i> fragmentTraces = new ConcurrentHashMap();
  private static QAPMFragmentSession instance;
  
  public static void fragmentOnCreateBegin(String paramString)
  {
    try
    {
      if (!b.g) {
        return;
      }
      i locali = new i(paramString);
      locali.b(paramString, "#onCreate");
      fragmentTraces.put(paramString, locali);
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentOnCreateBegin() has an error :", paramString);
    }
  }
  
  public static void fragmentOnCreateEnd(String paramString)
  {
    try
    {
      paramString = getFragmentTrace(paramString);
      if (paramString == null) {
        return;
      }
      paramString.d();
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentOnCreateEnd() has an error :", paramString);
    }
  }
  
  public static void fragmentOnCreateViewBegin(String paramString1, String paramString2)
  {
    try
    {
      i locali = getFragmentTrace(paramString1);
      if (locali == null) {
        return;
      }
      locali.b.a(paramString1, paramString2);
      locali.c(paramString1, "#onCreateView");
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentOnCreateViewBegin() has an error :", paramString1);
    }
  }
  
  public static void fragmentOnCreateViewEnd(String paramString1, View paramView, String paramString2)
  {
    try
    {
      paramView = getFragmentTrace(paramString1);
      if (paramView == null) {
        return;
      }
      paramView.b.a(paramString1, paramString2);
      paramView.e();
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentOnCreateViewEnd() has an error :", paramString1);
    }
  }
  
  public static void fragmentSessionResumeBegin(String paramString1, String paramString2)
  {
    try
    {
      i locali = getFragmentTrace(paramString1);
      if (locali == null) {
        return;
      }
      locali.d.a(paramString1, paramString2);
      locali.d(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentSessionResumeBegin() has an error :", paramString1);
    }
  }
  
  public static void fragmentSessionResumeEnd(String paramString1, String paramString2)
  {
    try
    {
      i locali = getFragmentTrace(paramString1);
      if (locali == null) {
        return;
      }
      locali.d.a(paramString1, paramString2);
      locali.g();
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentSessionResumeEnd() has an error :", paramString1);
    }
  }
  
  public static void fragmentStartEnd(String paramString1, String paramString2)
  {
    try
    {
      i locali = getFragmentTrace(paramString1);
      if (locali == null) {
        return;
      }
      locali.c.a(paramString1, paramString2);
      locali.f();
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentStartEnd() has an error :", paramString1);
    }
  }
  
  private static i getFragmentTrace(String paramString)
  {
    if ((b.g) && (!TextUtils.isEmpty(paramString))) {
      return (i)fragmentTraces.get(paramString);
    }
    return null;
  }
  
  public static QAPMFragmentSession getInstance()
  {
    if (instance == null) {
      instance = new QAPMFragmentSession();
    }
    return instance;
  }
  
  public void fragmentSessionPause(String paramString, boolean paramBoolean) {}
  
  public void fragmentSessionStarted(String paramString1, String paramString2)
  {
    try
    {
      i locali = getFragmentTrace(paramString1);
      if (locali == null) {
        return;
      }
      locali.c.a(paramString1, paramString2);
      locali.c(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_impl_QAPMFragmentSession", "QAPMFragmentSession  fragmentSessionStarted() has an error :", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMFragmentSession
 * JD-Core Version:    0.7.0.1
 */