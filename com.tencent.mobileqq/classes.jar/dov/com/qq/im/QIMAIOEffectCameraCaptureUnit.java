package dov.com.qq.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
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

public class QIMAIOEffectCameraCaptureUnit
  extends QIMEffectCameraCaptureUnit
{
  protected TextView a;
  private QIMAIOEffectCameraCaptureUnit.Session a;
  private int c = 10000;
  private String d;
  
  public QIMAIOEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void A_()
  {
    super.A_();
    CaptureFreqMonitor.jdField_a_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.a(3, System.currentTimeMillis());
    CaptureFreqMonitor.a();
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
  
  public void a()
  {
    super.a();
    CaptureFreqMonitor.jdField_a_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.a(2, System.currentTimeMillis());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session.convertTo());
    }
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      g(false);
      ShortVideoProcessUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper, this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session = ((QIMAIOEffectCameraCaptureUnit.Session)this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getSerializableExtra("ARG_SESSION_INFO"));
    this.c = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("edit_video_type", 10000);
    this.d = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    paramBundle = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent();
    long l = paramBundle.getLongExtra("ACTIVITY_START_TIME", -1L);
    int i = paramBundle.getIntExtra("edit_video_type", 10000);
    if ((CaptureFreqMonitor.jdField_a_of_type_Boolean) && (i == 10000)) {}
    for (boolean bool = true;; bool = false)
    {
      CaptureFreqMonitor.jdField_b_of_type_Boolean = bool;
      if (CaptureFreqMonitor.jdField_b_of_type_Boolean)
      {
        CaptureFreqMonitor.jdField_a_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.b();
        CaptureFreqMonitor.jdField_a_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.a(0, l);
        CaptureFreqMonitor.jdField_a_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.a(1, System.currentTimeMillis());
        CaptureFreqMonitor.jdField_b_of_type_DovComQqImCaptureUtilCaptureFreqMonitorItem.jdField_b_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
    CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(this.jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session).a(this.d).b(true).a(1).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    CaptureVideoParams localCaptureVideoParams = new CaptureVideoParams.CaptureVideoParamsBuilder().c(true).d(false).c(1).a();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCaptureVideoParams);
    JumpUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  protected void e()
  {
    super.e();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMAIOEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */