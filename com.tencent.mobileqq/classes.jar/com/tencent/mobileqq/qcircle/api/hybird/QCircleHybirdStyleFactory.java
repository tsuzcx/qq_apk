package com.tencent.mobileqq.qcircle.api.hybird;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class QCircleHybirdStyleFactory
{
  private static volatile QCircleHybirdStyleFactory a;
  
  public static QCircleHybirdStyleFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleHybirdStyleFactory();
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
      RFLog.e("QCircleHybirdStyleFactory", RFLog.USR, "getIntentByParseUrl intent is null");
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
      int i = RFLog.USR;
      paramString = new StringBuilder();
      paramString.append("getStyleFromUrl error ");
      paramString.append(paramIntent.getMessage());
      RFLog.e("QCircleHybirdStyleFactory", i, paramString.toString());
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
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStyleFromUrl error ");
      localStringBuilder.append(paramString.getMessage());
      RFLog.e("QCircleHybirdStyleFactory", i, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return false;
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext)
  {
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    if (paramContext == null)
    {
      RFLog.d("QCircleHybirdStyleFactory", RFLog.USR, "context is null return default");
      return localQCircleWebViewTitleStyle;
    }
    localQCircleWebViewTitleStyle.b = paramContext.getResources().getColor(2131166279);
    localQCircleWebViewTitleStyle.c = paramContext.getResources().getColor(2131166279);
    localQCircleWebViewTitleStyle.d = paramContext.getResources().getColor(2131165327);
    localQCircleWebViewTitleStyle.e = paramContext.getResources().getColor(2131165327);
    return localQCircleWebViewTitleStyle;
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext, String paramString)
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
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStyleFromUrl error ");
      localStringBuilder.append(paramString.getMessage());
      RFLog.e("QCircleHybirdStyleFactory", i, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdStyleFactory
 * JD-Core Version:    0.7.0.1
 */