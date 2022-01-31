package dov.com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.io.File;

public class ShortVideoGuideUtil
{
  public static String a;
  private static final String[] a;
  private static final String[] b = new String[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoGuideUtil";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "N1T", "ZTE A2015" };
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
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startPTVActivity callback:" + paramString1 + ", supportVideo:" + paramString2 + ", supportPhoto:" + paramString3 + ", cameramode:" + paramString4 + ", beauty:" + paramString5 + ", unfoldtemplate:" + paramString6 + ", defaulttemplate:" + paramString7 + ", templatebtn:" + paramString8 + ", dealtype:" + paramString9);
    }
    boolean bool1 = "1".equals(paramString2);
    boolean bool2 = "1".equals(paramString3);
    if ("1".equals(paramString4)) {}
    for (int i = 2;; i = 1)
    {
      boolean bool3 = "1".equals(paramString5);
      boolean bool4 = "1".equals(paramString6);
      boolean bool5 = "1".equals(paramString7);
      boolean bool6 = "1".equals(paramString8);
      boolean bool7 = d(paramAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startPTVActivity resAllReady=:" + bool7);
      }
      if (!bool7) {
        break;
      }
      paramAppInterface = new Intent(paramActivity, QIMCameraCaptureActivity.class);
      paramAppInterface.putExtra("callback", paramString1);
      paramAppInterface.putExtra("take_video_entrance_type", 7);
      paramAppInterface.putExtra("edit_video_type", 10007);
      paramAppInterface.putExtra("flow_key_from_guide", true);
      paramAppInterface.putExtra("from_web_to_share", true);
      paramString1 = new SessionInfo();
      paramString1.a = 0;
      paramAppInterface.putExtra("PhotoConst.SEND_SESSION_INFO", paramString1);
      paramAppInterface.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
      paramAppInterface.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      paramAppInterface.putExtra("flow_camera_use_filter_function", true);
      paramAppInterface.putExtra("flow_camera_video_mode", true);
      if (bool2)
      {
        paramString1 = PlusPanelUtils.a(AppConstants.aV);
        paramString2 = new File(AppConstants.aV);
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramString1).commit();
        paramAppInterface.putExtra("qcamera_photo_filepath", paramString1);
      }
      if (!bool3) {
        paramAppInterface.putExtra("flow_camera_disable_beauty_filter", bool3);
      }
      paramString1 = new Bundle();
      paramString1.putBoolean("support_video_shot", bool1);
      paramString1.putBoolean("support_photo_shot", bool2);
      paramString1.putBoolean("default_open_template", bool4);
      paramString1.putBoolean("default_use_first_template", bool5);
      paramString1.putBoolean("default_show_template_btn", bool6);
      paramString1.putInt("default_camera_mode", i);
      paramAppInterface.putExtras(paramString1);
      paramActivity.startActivityForResult(paramAppInterface, 11000);
      return true;
    }
    return false;
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
    if (dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.a()) {}
    for (;;)
    {
      return bool;
      dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.a(paramAppInterface);
      if (!dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.a()) {
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
        if (com.tencent.mobileqq.shortvideo.ShortVideoUtils.a()) {
          break;
        }
        com.tencent.mobileqq.shortvideo.ShortVideoUtils.a(paramAppInterface);
      } while (!com.tencent.mobileqq.shortvideo.ShortVideoUtils.a());
    } while ((PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2) || (!GestureMgr.a().a()) || (PtvFilterSoLoad.a() == 2));
    return true;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.a() == null) {}
    do
    {
      do
      {
        return false;
        if (com.tencent.mobileqq.shortvideo.ShortVideoUtils.a()) {
          break;
        }
        com.tencent.mobileqq.shortvideo.ShortVideoUtils.a(paramAppInterface);
      } while (!com.tencent.mobileqq.shortvideo.ShortVideoUtils.a());
    } while (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */