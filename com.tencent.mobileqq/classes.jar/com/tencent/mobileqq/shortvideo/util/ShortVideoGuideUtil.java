package com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.fragment.WebEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoGuideUtil
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "N1T", "ZTE A2015" };
  private static String jdField_b_of_type_JavaLangString;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = new String[0];
  private static String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoGuideUtil";
  }
  
  public static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(c))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
      localIntent.putExtra("shareto_web_mode", jdField_a_of_type_Int);
      localIntent.putExtra("edit_video_call_back", jdField_b_of_type_JavaLangString);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", c);
      localIntent.setFlags(536870912);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (!b(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGuideReaded isPubicSo= true");
    }
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startPTVActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameramode:" + paramString3 + ", beauty:" + paramString4 + ", unfoldDDStr:" + paramString6 + ", dDCategoryName:" + paramString7 + ", dDItemID:" + paramString8 + ", unfoldFilter:" + paramString10 + ", filterCategoryName:" + paramString11 + ", filterItemID:" + paramString12 + ", dealtype:" + paramString14 + ", activityType:" + paramString15 + ", activityId:" + paramString16 + ", callback:" + paramString17 + " subtitle:" + paramString13 + ", callerType:" + paramString18 + ", topicId:" + paramString19 + ", topicName:" + paramString20 + ", adTag=" + paramString21);
    }
    boolean bool3 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    boolean bool8;
    boolean bool9;
    if ("1".equals(paramString3))
    {
      i = 2;
      bool4 = "1".equals(paramString4);
      bool5 = "1".equals(paramString5);
      bool6 = "1".equals(paramString9);
      bool7 = "1".equals(paramString6);
      bool8 = "1".equals(paramString10);
      bool9 = "1".equals(paramString13);
      if (!"1".equals(paramString14)) {
        break label459;
      }
    }
    boolean bool1;
    label459:
    for (int j = 1;; j = 0)
    {
      bool1 = bool2;
      if (bool2)
      {
        c = PlusPanelUtils.a(AppConstants.aV);
        paramString1 = new File(AppConstants.aV);
        if (!paramString1.exists()) {
          paramString1.mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", c).commit();
        bool1 = bool2;
        if (!ShortVideoUtils.e())
        {
          if (!bool3) {
            break label465;
          }
          bool1 = false;
        }
      }
      bool2 = d(paramAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startPTVActivity resAllReady=:" + bool2);
      }
      if (CaptureUtil.a()) {
        break label499;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "supportMediaCodec = false");
      }
      return false;
      i = 1;
      break;
    }
    label465:
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "enter system camera");
    }
    jdField_b_of_type_JavaLangString = paramString17;
    jdField_a_of_type_Int = j;
    PlusPanelUtils.a(paramAppInterface, paramActivity, 1, null);
    return false;
    label499:
    if (bool2)
    {
      CameraCaptureActivity.a(paramActivity, WebEffectsCameraCaptureFragment.class.getName(), WebEffectsCameraCaptureFragment.a(bool3, bool1, i, bool4, bool5, bool7, paramString7, paramString8, bool6, bool8, paramString11, paramString12, bool9, j, paramString15, paramString16, paramString17, paramString18, paramString19, paramString20, paramString21), 11000);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "launch CameraCaptureActivity");
      }
    }
    for (;;)
    {
      return true;
      paramAppInterface = CameraCaptureActivity.a(paramActivity, WebEffectsCameraCaptureFragment.class.getName(), WebEffectsCameraCaptureFragment.a(bool3, bool1, i, bool4, bool5, bool7, paramString7, paramString8, bool6, bool8, paramString11, paramString12, bool9, j, paramString15, paramString16, paramString17, paramString18, paramString19, paramString20, paramString21));
      CaptureSoDownloadActivity.a(paramActivity, WebEffectsCameraCaptureFragment.class.getName(), paramAppInterface.getExtras(), 11000);
    }
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool2 = PtvFilterSoLoad.b();
    boolean bool1;
    if (!bool2)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (VideoEnvironment.b(paramAppInterface)) {
        break;
      }
      bool1 = false;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady isVersion fasle");
    return false;
    return true;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (paramAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isAccLoginSucdess false.");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (a(paramAppInterface)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isGuideReaded false.");
        return false;
        if (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ispublicResReady iissupportFilterSo is false");
      return false;
    } while (!CaptureUtil.a());
    if (ShortVideoUtils.a()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        bool = false;
      }
    }
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.a() == null) {}
    do
    {
      do
      {
        return false;
        if (ShortVideoUtils.a()) {
          break;
        }
        ShortVideoUtils.a(paramAppInterface);
      } while (!ShortVideoUtils.a());
    } while ((PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2) || (!GestureMgr.a().a()) || (PtvFilterSoLoad.a() == 2));
    return true;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    if (!ShortVideoUtils.a())
    {
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean f(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.b(paramAppInterface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isMobileSupportPTV fasle");
    }
    return bool;
  }
  
  public static boolean g(AppInterface paramAppInterface)
  {
    boolean bool = PtvFilterSoLoad.b();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "issupportFilterSo false");
    }
    return bool;
  }
  
  public static boolean h(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 21) {}
    label63:
    for (;;)
    {
      return false;
      if ((f(paramAppInterface)) && (g(paramAppInterface))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label63;
        }
        if (QmcfManager.a().c(2)) {
          break label65;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportDanceGame false");
        return false;
      }
    }
    label65:
    int i = QmcfDevicesStrategy.a();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "gpuSupportFrame:" + i);
    if (i > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean i(AppInterface paramAppInterface)
  {
    if ((f(paramAppInterface)) && (g(paramAppInterface))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (FaceDanceEntryUtil.b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isSupportDanceGame false");
        }
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */