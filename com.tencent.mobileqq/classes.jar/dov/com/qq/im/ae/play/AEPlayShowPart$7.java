package dov.com.qq.im.ae.play;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.report.AEBaseReportParam;

class AEPlayShowPart$7
  implements Observer<AECaptureModeChangingEvent>
{
  AEPlayShowPart$7(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onChanged(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
          if (paramAECaptureModeChangingEvent != AECaptureMode.NORMAL) {
            break;
          }
          if ((AEPlayShowGridAdapter.selectedMaterial == null) || (AEPlayShowGridAdapter.selectedMaterial != AEMaterialManager.a())) {
            AEBaseReportParam.a().j("none");
          }
        } while (!this.this$0.hasInflated());
        AEPlayShowPart.access$800(this.this$0).setVisibility(8);
        return;
        if (paramAECaptureModeChangingEvent != AECaptureMode.GIF) {
          break;
        }
      } while (!this.this$0.hasInflated());
      AEPlayShowPart.access$800(this.this$0).setVisibility(8);
      return;
    } while (paramAECaptureModeChangingEvent != AECaptureMode.PLAY);
    AEPlayShowPart.access$900(this.this$0);
    if (AEPlayShowPart.access$700(this.this$0) != null)
    {
      paramAECaptureModeChangingEvent = AEPlayShowPart.access$700(this.this$0).getLastMaterialTabId();
      if ((!TextUtils.isEmpty(paramAECaptureModeChangingEvent)) && (!"-1".equals(paramAECaptureModeChangingEvent))) {
        AEBaseReportParam.a().j(paramAECaptureModeChangingEvent);
      }
    }
    AEPlayShowPart.access$800(this.this$0).setVisibility(0);
    AEPlayShowPart.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.7
 * JD-Core Version:    0.7.0.1
 */