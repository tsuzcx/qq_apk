package com.tencent.mobileqq.qcircle.api.hybird;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

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
      QLog.e("QCircleHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
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
      QLog.e("QCircleHybirdStyleFactory", 1, paramString.toString());
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
      QLog.e("QCircleHybirdStyleFactory", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return false;
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext)
  {
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    if (paramContext == null)
    {
      QLog.d("QCircleHybirdStyleFactory", 1, "context is null return default");
      return localQCircleWebViewTitleStyle;
    }
    localQCircleWebViewTitleStyle.b = paramContext.getResources().getColor(2131167016);
    localQCircleWebViewTitleStyle.c = paramContext.getResources().getColor(2131167016);
    localQCircleWebViewTitleStyle.d = paramContext.getResources().getColor(2131165564);
    localQCircleWebViewTitleStyle.e = paramContext.getResources().getColor(2131165564);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStyleFromUrl error ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleHybirdStyleFactory", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdStyleFactory
 * JD-Core Version:    0.7.0.1
 */