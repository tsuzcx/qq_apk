package dov.com.qq.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
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

public class QIMProfileCoverEffectCameraCaptureUnit
  extends QIMEffectCameraCaptureUnit
{
  protected TextView a;
  
  public QIMProfileCoverEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10009, 19, 2);
    this.jdField_a_of_type_Int = 4;
  }
  
  protected int a()
  {
    return 2130970090;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363993));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
    CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(false).a(8).b(102).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    CaptureVideoParams localCaptureVideoParams = new CaptureVideoParams.CaptureVideoParamsBuilder().b(102).c(5).b(false).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCaptureVideoParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void e()
  {
    super.e();
    if (!this.b) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.e.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMProfileCoverEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */