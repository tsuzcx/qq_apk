package dov.com.qq.im;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.util.ArrayList;
import java.util.List;

public class QIMQuickShootEffectCameraCaptureUnit
  extends QIMEffectCameraCaptureUnit
{
  protected TextView a;
  
  public QIMQuickShootEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10004, 8, 2);
    this.jdField_a_of_type_Int = 6;
  }
  
  protected int a()
  {
    return 2130970102;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364018));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return localView;
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
    if ((paramInt1 == 10004) && (paramInt2 == -1))
    {
      ShortVideoProcessUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper, this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
      if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h();
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
      }
      g(false);
    }
    for (;;)
    {
      return;
      if (((paramInt1 == 10006) || (paramInt1 == 1012)) && (paramInt2 == 0))
      {
        if (paramIntent != null) {}
        for (boolean bool = paramIntent.getBooleanExtra("mark_from_artfilter_bridge_activity", false); (!bool) && (paramIntent == null) && ((this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a() instanceof SplashActivity)); bool = false)
        {
          if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null)
          {
            this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h();
            this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
          }
          g(false);
          return;
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b();
    }
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
    CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(2).b(101).e(true).d(true).c(true).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    CaptureVideoParams localCaptureVideoParams = new CaptureVideoParams.CaptureVideoParamsBuilder().b(101).c(2).f(true).e(true).d(true).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCaptureVideoParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void e()
  {
    super.e();
    if (!this.c) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMQuickShootEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */