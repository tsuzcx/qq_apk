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
    localQQLiteBridgeParam.c = paramInt;
    return (Drawable)a(localQQLiteBridgeParam);
  }
  
  public static Uri a(Activity paramActivity)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(12);
    localQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity = paramActivity;
    return (Uri)a(localQQLiteBridgeParam);
  }
  
  public static DownloadParams.DecodeHandler a()
  {
    return (DownloadParams.DecodeHandler)a(3);
  }
  
  private static Object a(int paramInt)
  {
    return a(new QQLiteBridgeParam(paramInt));
  }
  
  private static Object a(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    return AbstractOpenSdkAppInterface.a().a(paramQQLiteBridgeParam);
  }
  
  public static String a(Intent paramIntent)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(9);
    localQQLiteBridgeParam.jdField_a_of_type_AndroidContentIntent = paramIntent;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static String a(String paramString)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(8);
    localQQLiteBridgeParam.jdField_a_of_type_JavaLangString = paramString;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static void a(int paramInt, Activity paramActivity, Uri paramUri)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(13);
    localQQLiteBridgeParam.jdField_b_of_type_Int = paramInt;
    localQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localQQLiteBridgeParam.jdField_a_of_type_AndroidNetUri = paramUri;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(Activity paramActivity)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(11);
    localQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(Bundle paramBundle)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(6);
    localQQLiteBridgeParam.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a(localQQLiteBridgeParam);
  }
  
  public static void a(ActionSheet paramActionSheet)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(10);
    localQQLiteBridgeParam.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    a(localQQLiteBridgeParam);
  }
  
  public static boolean a()
  {
    Object localObject = a(4);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(7);
    localQQLiteBridgeParam.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = a(localQQLiteBridgeParam);
    if ((paramContext instanceof Boolean)) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    QQLiteBridgeParam localQQLiteBridgeParam = new QQLiteBridgeParam(2);
    localQQLiteBridgeParam.jdField_b_of_type_JavaLangString = paramString;
    return (String)a(localQQLiteBridgeParam);
  }
  
  public static boolean b()
  {
    Object localObject = a(5);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.QQLiteStatusUtil
 * JD-Core Version:    0.7.0.1
 */