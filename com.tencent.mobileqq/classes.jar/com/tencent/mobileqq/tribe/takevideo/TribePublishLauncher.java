package com.tencent.mobileqq.tribe.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class TribePublishLauncher
{
  public static String a = "tribe_publish_TribePublishLauncher";
  
  public static Intent a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, byte paramByte, String paramString2)
  {
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      if (localAppActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        localAppActivity.requestPermissions(new TribePublishLauncher.1(localAppActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return null;
      }
    }
    if (QavCameraUsage.b(paramActivity)) {
      return null;
    }
    if (a(paramActivity)) {
      return null;
    }
    boolean bool = ShortVideoGuideUtil.e(paramAppInterface);
    if ((!bool) && (!NetworkUtil.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131718627, 0).a();
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "launchTakeVideoForTribe, videoSoUsable=" + bool);
    }
    paramAppInterface = new Bundle();
    paramAppInterface.putString("options", paramString1);
    paramAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramAppInterface.putBoolean("PeakConstants.ARG_ALBUM", false);
    paramAppInterface.putInt("edit_video_type", 10012);
    paramAppInterface.putInt("entrance_type", 105);
    paramAppInterface.putInt("extra.busi_type", 11);
    paramAppInterface.putInt("edit_video_way", 9);
    paramAppInterface.putInt("key_camera_photo_edit_type", 1);
    paramAppInterface.putInt("key_camera_video_edit_type", 5);
    paramAppInterface.putInt("ability_flag", 3);
    if (bool)
    {
      paramActivity = QIMCameraCaptureActivity.a(paramActivity, paramAppInterface);
      if (!"barindex".equals(paramString2)) {
        break label315;
      }
    }
    label315:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return paramActivity;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", QIMTribeEffectsCameraCaptureUnit.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      break;
    }
  }
  
  public static JSONObject a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "getTribeJsonExtra option: " + paramBundle);
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getTribeJsonExtra: " + paramBundle);
        }
      }
    }
    return null;
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!CaptureUtil.a())
    {
      DialogUtil.a(paramContext, 230).setMessage(HardCodeUtil.a(2131714948)).setPositiveButton(2131694615, new TribePublishLauncher.2()).show();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.takevideo.TribePublishLauncher
 * JD-Core Version:    0.7.0.1
 */