package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.open.agent.entity.QQLiteBridgeParam;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.widget.ActionSheet;

public class QQLiteStatusUtil
{
  public static Drawable a(int paramInt)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(1);
    localQQLiteBridgeParam.j = paramInt;
    return (Drawable)a(localQQLiteBridgeParam);
  }
  
  private static Object a(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    return AbstractOpenSdkAppInterface.c().a(paramQQLiteBridgeParam);
  }
  
  public static String a(Intent paramIntent)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(9);
    localQQLiteBridgeParam.f = paramIntent;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static String a(String paramString)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(8);
    localQQLiteBridgeParam.e = paramString;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static void a(int paramInt, Activity paramActivity, Uri paramUri)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(13);
    localQQLiteBridgeParam.i = paramInt;
    localQQLiteBridgeParam.b = paramActivity;
    localQQLiteBridgeParam.h = paramUri;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(Activity paramActivity)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(11);
    localQQLiteBridgeParam.b = paramActivity;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(Bundle paramBundle)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(6);
    localQQLiteBridgeParam.d = paramBundle;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(ActionSheet paramActionSheet)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(10);
    localQQLiteBridgeParam.g = paramActionSheet;
    a(localQQLiteBridgeParam);
  }
  
  public static boolean a()
  {
    Object localObject = b(4);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(7);
    localQQLiteBridgeParam.c = paramContext;
    paramContext = a(localQQLiteBridgeParam);
    if ((paramContext instanceof Boolean)) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static Uri b(Activity paramActivity)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(12);
    localQQLiteBridgeParam.b = paramActivity;
    return (Uri)a(localQQLiteBridgeParam);
  }
  
  private static Object b(int paramInt)
  {
    return a(new QQLiteBridgeParam(paramInt));
  }
  
  public static String b(String paramString)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(2);
    localQQLiteBridgeParam.k = paramString;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static boolean b()
  {
    Object localObject = b(5);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static DownloadParams.DecodeHandler c()
  {
    return (DownloadParams.DecodeHandler)b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.QQLiteStatusUtil
 * JD-Core Version:    0.7.0.1
 */