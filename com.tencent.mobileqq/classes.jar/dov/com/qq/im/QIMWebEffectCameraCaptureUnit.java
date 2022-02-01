package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AECameraConfig;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;

public class QIMWebEffectCameraCaptureUnit
  extends AEPituCameraUnit
{
  public static int a;
  public static int b = 1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QIMWebEffectCameraCaptureUnit.1(this);
  private String jdField_a_of_type_JavaLangString;
  private int g;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public QIMWebEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10007, this.jdField_a_of_type_DovComQqImAeAECameraConfig.d(), 6);
    this.d = 5;
  }
  
  private Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2, boolean paramBoolean6, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    paramString1 = new Bundle();
    int j = 1;
    int i;
    if ((paramBoolean2) && (!paramBoolean1))
    {
      i = 2;
      paramString1.putInt("ability_flag", i);
      paramString1.putInt("PeakConstants.ARG_FORCE_CAMERA", paramInt1);
      paramString1.putBoolean("PeakConstants.ARG_BEAUTY", paramBoolean3);
      paramString1.putBoolean("PeakConstants.ARG_SHARP_FACE", paramBoolean3);
      paramString1.putBoolean("PeakConstants.ARG_SUPPORT_DD", paramBoolean4);
      if ((paramBoolean4) && (paramBoolean5))
      {
        paramString1.putString("KEY_CURRENT_TAB", AECaptureMode.NORMAL.name);
        paramString1.putString("KEY_CURRENT_SELECT_ID", paramString2);
      }
      paramString1.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", paramBoolean6);
      paramString1.putInt("ARG_DEAL_TYPE", paramInt2);
      paramString1.putString("ARG_WEB_CALLBACK", paramString3);
      paramString1.putString("arg_topic_id", paramString4);
      paramString1.putString("arg_topic_name", paramString5);
      paramString1.putString("arg_ad_tag", paramString6);
      paramString1.putString("arg_callback", paramString3);
      paramString1.putInt("edit_video_type", 10007);
      paramString1.putInt("entrance_type", paramInt3);
      paramString1.putBoolean("PeakConstants.ARG_ALBUM", false);
      paramInt1 = AECameraEntry.F.a();
      if (paramInt3 != 107) {
        break label241;
      }
      paramInt1 = AECameraEntry.G.a();
    }
    for (;;)
    {
      paramString1.putInt("VIDEO_STORY_FROM_TYPE", paramInt1);
      return paramString1;
      i = j;
      if (paramBoolean2) {
        break;
      }
      i = j;
      if (!paramBoolean1) {
        break;
      }
      i = 3;
      break;
      label241:
      if (paramInt3 == 108) {
        paramInt1 = AECameraEntry.D.a();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    PublishParam localPublishParam;
    Activity localActivity;
    Object localObject;
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam.jdField_j_of_type_Int == 1)
      {
        localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
        localActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        localObject = localPublishParam.c;
        if (QLog.isColorLevel())
        {
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + localPublishParam.toString());
        }
        PtvFilterUtils.a(new File(localPublishParam.jdField_j_of_type_JavaLangString).getParent(), localPublishParam.b);
        if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.b() != 107) {
          break label244;
        }
      }
    }
    label244:
    for (paramInt1 = 15;; paramInt1 = 32)
    {
      localActivity.getIntent().putExtra("param_entrance", paramInt1);
      localActivity.getIntent().putExtra("fake_id", localPublishParam.b);
      paramIntent = a(paramIntent);
      localObject = new SessionInfo();
      ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = "0";
      ShortVideoProcessUtil.a(localActivity, (SessionInfo)localObject, localPublishParam, paramIntent, null);
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.i();
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getExtras();
    this.g = paramBundle.getInt("ARG_DEAL_TYPE");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARG_WEB_CALLBACK");
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().b(3).a();
      if (this.g == jdField_a_of_type_Int)
      {
        ((CaptureVideoParams)localObject).d = true;
        ((CaptureVideoParams)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a((CaptureVideoParams)localObject);
      return;
    }
    Object localObject = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(3).b(this.jdField_a_of_type_JavaLangString).b(this.g).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a((CapturePicParams)localObject);
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMWebEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */