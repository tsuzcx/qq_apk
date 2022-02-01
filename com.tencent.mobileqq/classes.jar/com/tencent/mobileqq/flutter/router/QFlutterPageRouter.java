package com.tencent.mobileqq.flutter.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterContainerFragment;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QFlutterPageRouter
{
  public static void a(Activity paramActivity, PageRouter paramPageRouter, int paramInt)
  {
    if (paramPageRouter == null)
    {
      QLog.d("QFlutterPageRouter", 2, "openPage, pageRouter is null");
      return;
    }
    boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterPageRouter", 2, "openPage: " + paramPageRouter + ", isProcessExist: " + bool);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("entry_point", paramPageRouter.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("page_name", paramPageRouter.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("unique_id", paramPageRouter.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("params", paramPageRouter.jdField_a_of_type_ComTencentMobileqqFlutterRouterSerializableMap);
    localIntent.putExtra("status_bar_transparent", paramPageRouter.jdField_a_of_type_Boolean);
    localIntent.putExtra("status_text_dark", paramPageRouter.jdField_b_of_type_Boolean);
    localIntent.putExtra("preload_process", bool);
    localIntent.putExtra("open_page_time", SystemClock.elapsedRealtime());
    PublicFragmentActivityForTool.b(paramActivity, localIntent, QFlutterContainerFragment.class, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    a(paramActivity, new PageRouterBuilder().a(paramString1).b(paramString2).a(paramMap).a(), 1000);
  }
  
  public static void a(@NonNull Context paramContext, PageRouter paramPageRouter, @Nullable Bundle paramBundle)
  {
    if (paramPageRouter == null)
    {
      QLog.d("QFlutterPageRouter", 2, "openPage, pageRouter is null");
      return;
    }
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("entry_point", paramPageRouter.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("page_name", paramPageRouter.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("unique_id", paramPageRouter.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("params", paramPageRouter.jdField_a_of_type_ComTencentMobileqqFlutterRouterSerializableMap);
    localIntent.putExtra("background_transparent", paramPageRouter.jdField_c_of_type_Boolean);
    localIntent.putExtra("status_bar_transparent", paramPageRouter.jdField_a_of_type_Boolean);
    localIntent.putExtra("status_text_dark", paramPageRouter.jdField_b_of_type_Boolean);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("preload_process", true);
    localIntent.putExtra("open_page_time", SystemClock.elapsedRealtime());
    PublicTransFragmentActivity.b(paramContext, localIntent, QCircleFlutterContainerFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.QFlutterPageRouter
 * JD-Core Version:    0.7.0.1
 */