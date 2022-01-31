package dov.com.qq.im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.data.BusinessVideoParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QIMWebEffectCameraCaptureUnit
  extends QIMEffectCameraCaptureUnit
{
  protected TextView a;
  protected int c;
  public int d;
  public int e;
  
  public QIMWebEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10007, 7, 6);
    this.jdField_a_of_type_Int = 5;
  }
  
  private Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363969));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    return localView;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    localCaptureParam.c(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("cameraDirection", 2));
    return localCaptureParam;
  }
  
  protected List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_AndroidWidgetTextView);
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (this.jdField_e_of_type_Int != FlowCameraConstant.jdField_b_of_type_Int) {
        break label339;
      }
      localObject2 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) != 1003) {
        break label66;
      }
    }
    label66:
    label339:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
        return;
        if (((PublishParam)localObject2).jdField_j_of_type_Int == 1)
        {
          localObject1 = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
          ((Activity)localObject1).getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          Object localObject3 = ((PublishParam)localObject2).jdField_c_of_type_JavaLangString;
          if (QLog.isColorLevel())
          {
            QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject3);
            QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + ((PublishParam)localObject2).toString());
          }
          PtvFilterUtils.a(new File(((PublishParam)localObject2).jdField_j_of_type_JavaLangString).getParent(), ((PublishParam)localObject2).jdField_b_of_type_JavaLangString);
          Bundle localBundle = a(paramIntent);
          localObject3 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
          ShortVideoProcessUtil.a((Activity)localObject1, (SessionInfo)localObject3, (PublishParam)localObject2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, localBundle);
          if ((localObject3 != null) && (bool))
          {
            paramIntent = AIOUtils.a(new Intent((Context)localObject1, SplashActivity.class), new int[] { 2 });
            paramIntent.putExtra("uin", ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString);
            paramIntent.putExtra("uintype", ((SessionInfo)localObject3).jdField_a_of_type_Int);
            paramIntent.putExtra("troop_uin", ((SessionInfo)localObject3).jdField_b_of_type_JavaLangString);
            ((Activity)localObject1).startActivity(paramIntent);
          }
          else if (paramIntent.getBooleanExtra("short_video_multi_share", false))
          {
            JumpUtil.a((Activity)localObject1, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
          }
        }
      }
      localObject1 = paramIntent.getStringExtra("uuid");
      localObject2 = paramIntent.getStringExtra("video_md5");
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebEffectCameraCaptureUnit", 2, "onActivityResult|web md5=" + (String)localObject2 + ",uuid=" + (String)localObject1);
      }
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    paramIntent = new StringBuilder();
    paramIntent.append("https://qvq.qq.com/pretend_trip/view.html?_wv=16777217&_wwv=8").append("&md5=").append((String)localObject2).append("&uuid=").append((String)localObject1);
    Object localObject1 = new Intent(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("hide_more_button", true);
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    ((Intent)localObject1).putExtra("url", paramIntent.toString());
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivity((Intent)localObject1);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
    g(false);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("videoId", 0);
    if (this.jdField_c_of_type_Int != 0) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(5000.0F);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("type", 1);
      this.jdField_e_of_type_Int = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("WebSceneType", FlowCameraConstant.jdField_d_of_type_Int);
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(10000.0F);
    }
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
    CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(3).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    super.a(paramVideoCaptureResult);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool2 = true;
    Object localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().c(3).a(this.jdField_c_of_type_Int).g(true).a();
    ((CaptureVideoParams)localObject).jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    ((CaptureVideoParams)localObject).jdField_b_of_type_Int = this.jdField_e_of_type_Int;
    ((CaptureVideoParams)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("succUrl");
    ((CaptureVideoParams)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("failedUrl");
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a((CaptureVideoParams)localObject);
    localObject = new BusinessVideoParam();
    if (this.jdField_e_of_type_Int == FlowCameraConstant.jdField_b_of_type_Int)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((QIMPtvTemplateManager)QIMManager.a(3)).a();
      if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo.kind == 5) || (localPtvTemplateInfo.kind == 6) || (localPtvTemplateInfo.kind == 8) || (localPtvTemplateInfo.kind == 9) || (localPtvTemplateInfo.kind == 10)))
      {
        ((BusinessVideoParam)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ((BusinessVideoParam)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((BusinessVideoParam)localObject).g = this.jdField_c_of_type_JavaLangString;
        ((BusinessVideoParam)localObject).f = this.jdField_b_of_type_JavaLangString;
        ((BusinessVideoParam)localObject).jdField_b_of_type_JavaLangString = (localPtvTemplateInfo.categoryId + "");
        ((BusinessVideoParam)localObject).jdField_c_of_type_JavaLangString = localPtvTemplateInfo.id;
        ((BusinessVideoParam)localObject).jdField_a_of_type_Boolean = true;
        if (localPtvTemplateInfo.kind != 8) {
          break label362;
        }
        bool1 = true;
        ((BusinessVideoParam)localObject).jdField_b_of_type_Boolean = bool1;
        if (localPtvTemplateInfo.kind != 9) {
          break label367;
        }
        bool1 = true;
        label299:
        ((BusinessVideoParam)localObject).jdField_c_of_type_Boolean = bool1;
        if (localPtvTemplateInfo.kind != 10) {
          break label372;
        }
      }
    }
    label362:
    label367:
    label372:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((BusinessVideoParam)localObject).d = bool1;
      ((BusinessVideoParam)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.d();
      JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, 5, (BusinessVideoParam)localObject);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label299;
    }
  }
  
  protected void e()
  {
    super.e();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMWebEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */