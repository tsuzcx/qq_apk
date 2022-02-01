package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.capture.control.CaptureAsyncControl;

class AEPlayShowPart$9
  implements View.OnClickListener
{
  AEPlayShowPart$9(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onClick(View paramView)
  {
    AEPlayShowPart.access$1100(this.this$0);
    AEPlayShowPart.access$1200(this.this$0).setVisibility(8);
    AECameraPrefsUtil.a().a("CameraModuleSvc.GetPlayShowCatMatTree", "", 4);
    PeakAppInterface.a.a(1010);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.9
 * JD-Core Version:    0.7.0.1
 */