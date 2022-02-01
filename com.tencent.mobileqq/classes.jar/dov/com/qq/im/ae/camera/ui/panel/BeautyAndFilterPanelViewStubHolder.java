package dov.com.qq.im.ae.camera.ui.panel;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraProviderViewGesture;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.BaseViewStubHolder;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

public class BeautyAndFilterPanelViewStubHolder
  extends BaseViewStubHolder
{
  private AEProviderContainerView a;
  
  public BeautyAndFilterPanelViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void a(View paramView)
  {
    this.a = ((AEProviderContainerView)paramView.findViewById(2131363552));
  }
  
  public void a(CameraProviderViewGesture paramCameraProviderViewGesture)
  {
    a(new BeautyAndFilterPanelViewStubHolder.1(this, paramCameraProviderViewGesture));
  }
  
  public void a(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    a(new BeautyAndFilterPanelViewStubHolder.2(this, paramAECaptureController, paramVideoStoryCapturePartManager));
  }
  
  public void a(AECaptureMode paramAECaptureMode)
  {
    if (!a()) {
      return;
    }
    this.a.setCaptureMode(paramAECaptureMode);
  }
  
  public void b()
  {
    a();
    this.a.setVisibility(0);
    this.a.b();
  }
  
  public boolean b()
  {
    if (!a()) {
      return false;
    }
    return this.a.c();
  }
  
  public void c()
  {
    if (!a()) {
      return;
    }
    this.a.a();
  }
  
  public void d()
  {
    if (!a()) {
      return;
    }
    this.a.d();
  }
  
  public void e()
  {
    if (!a()) {
      return;
    }
    this.a.f();
  }
  
  public void f()
  {
    if (!a()) {
      return;
    }
    this.a.c();
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    this.a.g();
  }
  
  public void h()
  {
    if (!a()) {
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder
 * JD-Core Version:    0.7.0.1
 */