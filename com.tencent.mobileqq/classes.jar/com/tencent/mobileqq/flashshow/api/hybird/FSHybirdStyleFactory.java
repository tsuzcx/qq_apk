package com.tencent.mobileqq.flashshow.api.hybird;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FSHybirdStyleFactory
{
  private static volatile FSHybirdStyleFactory a;
  
  public static FSHybirdStyleFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSHybirdStyleFactory();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      QLog.e("FSHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
      return;
    }
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        if ("1".equals(paramString.getQueryParameter("show_right_cancel"))) {
          paramIntent.putExtra("rightTopCancel", true);
        }
        if ("1".equals(paramString.getQueryParameter("move_web_view_top")))
        {
          paramIntent.putExtra("webViewMoveTop", true);
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      paramString = new StringBuilder();
      paramString.append("getStyleFromUrl error ");
      paramString.append(paramIntent.getMessage());
      QLog.e("FSHybirdStyleFactory", 1, paramString.toString());
      paramIntent.printStackTrace();
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("_wv");
        boolean bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          long l = Long.parseLong(paramString);
          bool1 = bool2;
          if ((l & 0x80000) != 0L) {
            bool1 = true;
          }
        }
        return bool1;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStyleFromUrl error ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("FSHybirdStyleFactory", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return false;
  }
  
  public FSWebViewTitleStyle a(Context paramContext)
  {
    FSWebViewTitleStyle localFSWebViewTitleStyle = new FSWebViewTitleStyle();
    if (paramContext == null)
    {
      QLog.d("FSHybirdStyleFactory", 1, "context is null return default");
      return localFSWebViewTitleStyle;
    }
    localFSWebViewTitleStyle.b = paramContext.getResources().getColor(2131166044);
    localFSWebViewTitleStyle.c = paramContext.getResources().getColor(2131166044);
    localFSWebViewTitleStyle.d = paramContext.getResources().getColor(2131165564);
    localFSWebViewTitleStyle.e = paramContext.getResources().getColor(2131165564);
    return localFSWebViewTitleStyle;
  }
  
  public FSWebViewTitleStyle a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("left_back_icon");
        if (!TextUtils.isEmpty(paramString))
        {
          paramContext.a = Integer.parseInt(paramString);
          return paramContext;
        }
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStyleFromUrl error ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("FSHybirdStyleFactory", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSHybirdStyleFactory
 * JD-Core Version:    0.7.0.1
 */