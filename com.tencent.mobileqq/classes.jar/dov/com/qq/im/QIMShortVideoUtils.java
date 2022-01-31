package dov.com.qq.im;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import ankf;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.Iterator;
import java.util.Set;

public class QIMShortVideoUtils
{
  private static Intent a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    NewFlowCameraReporter.a("jumpToCamera");
    if (!VideoEnvironment.b(paramBaseActivity.app))
    {
      DialogUtil.a(paramBaseActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433016, new ankf()).show();
      return null;
    }
    if (paramQQAppInterface.c())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131428992, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      return null;
    }
    return a(paramBaseActivity, false, paramQQAppInterface, true);
  }
  
  private static Intent a(BaseActivity paramBaseActivity, boolean paramBoolean1, QQAppInterface paramQQAppInterface, boolean paramBoolean2)
  {
    a(paramBaseActivity, paramQQAppInterface);
    if ((!paramBoolean2) && (paramBaseActivity.getIntent() != null)) {}
    for (paramBaseActivity = paramBaseActivity.getIntent();; paramBaseActivity = new Intent())
    {
      paramBaseActivity.putExtra("PhotoConst.MY_UIN", paramQQAppInterface.getAccount());
      paramBaseActivity.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
      paramBaseActivity.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      paramBaseActivity.putExtra("flow_camera_video_mode", true);
      paramBaseActivity.putExtra("flow_camera_use_filter_function", true);
      paramBaseActivity.putExtra("extra_now_tab", StoryApi.b());
      NewFlowCameraReporter.a("start activity");
      if (MediaPlayerManager.a(paramQQAppInterface).b()) {
        MediaPlayerManager.a(paramQQAppInterface).a(false);
      }
      return paramBaseActivity;
    }
  }
  
  private static void a(BaseActivity paramBaseActivity, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    paramIntent.setClass(paramBaseActivity, QIMCameraCaptureActivity.class);
    paramIntent.putExtra("edit_video_type", paramInt1);
    paramIntent.putExtra("take_video_entrance_type", paramInt2);
    if (PtvFilterSoLoad.a() == 2)
    {
      CaptureQmcfSoDownloadActivity.a(paramBaseActivity, QIMWebEffectCameraCaptureUnit.class.getName(), paramIntent.getExtras(), 11000);
      return;
    }
    if (paramInt3 != -1)
    {
      paramBaseActivity.startActivityForResult(paramIntent, paramInt3);
      return;
    }
    paramBaseActivity.startActivity(paramIntent);
  }
  
  public static boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, boolean paramBoolean, int paramInt8, int paramInt9, int paramInt10, Bundle paramBundle)
  {
    Intent localIntent = a(paramBaseActivity, paramBaseActivity.app);
    if (localIntent == null) {
      return false;
    }
    ((CaptureComboManager)QIMManager.a(5)).f();
    localIntent.putExtra("firsttab", paramInt5);
    localIntent.putExtra("secondtab", paramInt6);
    localIntent.putExtra("itemid", paramString);
    if (paramInt8 != 0) {
      localIntent.putExtra("type", paramInt8);
    }
    localIntent.putExtra("qim_camera_open_specific", paramBoolean);
    localIntent.addFlags(603979776);
    if (paramInt7 != 0) {
      localIntent.putExtra("videoId", paramInt7);
    }
    localIntent.putExtra("WebSceneType", paramInt10);
    if ((paramInt2 == 10004) || (paramInt2 == 10002))
    {
      localIntent.putExtra("need_show_banner", true);
      if (paramBundle != null) {
        paramString = paramBundle.keySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label247;
        }
        String str = (String)paramString.next();
        if ("succUrl".startsWith(str))
        {
          localIntent.putExtra(str, paramBundle.getString(str));
          continue;
          localIntent.putExtra("need_show_banner", false);
          break;
        }
        if ("failedUrl".startsWith(str)) {
          localIntent.putExtra(str, paramBundle.getString(str));
        }
      }
    }
    label247:
    localIntent.putExtra("flow_camera_qim_tab_direction", paramInt1);
    localIntent.putExtra("cameraDirection", paramInt9);
    a(paramBaseActivity, localIntent, paramInt2, paramInt3, paramInt4);
    return true;
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    ShortVideoUtils.a(paramQQAppInterface);
    return ShortVideoUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */