package dov.com.qq.im.ae.camera.ui.topbar;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECompoundButton;
import org.light.DeviceSupportUtil;

class AEVideoStoryTopBarPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEVideoStoryTopBarPart$2(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    int i = 0;
    if (paramAECaptureModeChangingEvent == null) {}
    label481:
    for (;;)
    {
      return;
      paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
      if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL)
      {
        if (!AECameraEntry.k(AEVideoStoryTopBarPart.a(this.a).getIntent())) {
          AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2130844670);
        }
        AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
        if (!AECameraEntry.k(AEVideoStoryTopBarPart.b(this.a).getIntent())) {
          AEVideoStoryTopBarPart.b(this.a).a().setImageResource(2130838039);
        }
        AEVideoStoryTopBarPart.c(this.a).setVisibility(0);
        if (paramAECaptureModeChangingEvent.getHasCountDown())
        {
          AEVideoStoryTopBarPart.d(this.a).setVisibility(8);
          AEVideoStoryTopBarPart.e(this.a).a().setImageResource(2130838032);
          AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
          AEVideoStoryTopBarPart.a(this.a, 10);
          AEVideoStoryTopBarPart.f(this.a).setVisibility(8);
        }
      }
      for (;;)
      {
        if (!this.a.a()) {
          break label481;
        }
        AEVideoStoryTopBarPart.d(this.a).setVisibility(8);
        return;
        if (!AECameraEntry.k(AEVideoStoryTopBarPart.c(this.a).getIntent())) {
          AEVideoStoryTopBarPart.d(this.a).a().setImageResource(2130837696);
        }
        AEVideoStoryTopBarPart.d(this.a).setVisibility(0);
        AEVideoStoryTopBarPart.e(this.a).setVisibility(8);
        break;
        if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
        {
          AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2130844669);
          AEVideoStoryTopBarPart.a(this.a).setVisibility(0);
          AEVideoStoryTopBarPart.b(this.a).a().setImageResource(2130838038);
          AEVideoStoryTopBarPart.d(this.a).a().setImageResource(2130837695);
          AEVideoStoryTopBarPart.c(this.a).setVisibility(8);
          AEVideoStoryTopBarPart.e(this.a).a().setImageResource(2130837697);
          AEVideoStoryTopBarPart.e(this.a).setVisibility(0);
          AEVideoStoryTopBarPart.a(this.a, 3);
          try
          {
            bool = DeviceSupportUtil.isAbilityDeviceSupport("shareGLContextError");
            AEQLog.a("AEVideoStoryTopBarPart", "[initViewModel]: deviceNotSupportSegment = " + bool);
            paramAECaptureModeChangingEvent = AEVideoStoryTopBarPart.f(this.a);
            if (bool) {
              i = 8;
            }
            paramAECaptureModeChangingEvent.setVisibility(i);
          }
          catch (Exception paramAECaptureModeChangingEvent)
          {
            for (;;)
            {
              AEQLog.d("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + paramAECaptureModeChangingEvent.toString());
              boolean bool = false;
            }
          }
        }
        else if (paramAECaptureModeChangingEvent == AECaptureMode.PLAY)
        {
          AEVideoStoryTopBarPart.a(this.a).a().setImageResource(2130844670);
          AEVideoStoryTopBarPart.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart.2
 * JD-Core Version:    0.7.0.1
 */