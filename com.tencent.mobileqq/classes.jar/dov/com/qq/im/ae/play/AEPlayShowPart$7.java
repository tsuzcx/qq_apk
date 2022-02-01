package dov.com.qq.im.ae.play;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import bluy;
import bmah;
import bmbg;
import dov.com.qq.im.ae.mode.AECaptureMode;

class AEPlayShowPart$7
  implements Observer<bmah>
{
  AEPlayShowPart$7(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onChanged(@Nullable bmah parambmah)
  {
    if (parambmah == null) {}
    do
    {
      do
      {
        do
        {
          return;
          parambmah = parambmah.b;
          if (parambmah != AECaptureMode.NORMAL) {
            break;
          }
          if ((AEPlayShowGridAdapter.selectedMaterial == null) || (AEPlayShowGridAdapter.selectedMaterial != bluy.a())) {
            bmbg.a().g("none");
          }
        } while (!this.this$0.hasInflated());
        AEPlayShowPart.access$800(this.this$0).setVisibility(8);
        return;
        if (parambmah != AECaptureMode.GIF) {
          break;
        }
      } while (!this.this$0.hasInflated());
      AEPlayShowPart.access$800(this.this$0).setVisibility(8);
      return;
    } while (parambmah != AECaptureMode.PLAY);
    AEPlayShowPart.access$900(this.this$0);
    if (AEPlayShowPart.access$700(this.this$0) != null)
    {
      parambmah = AEPlayShowPart.access$700(this.this$0).getLastMaterialTabId();
      if ((!TextUtils.isEmpty(parambmah)) && (!"-1".equals(parambmah))) {
        bmbg.a().g(parambmah);
      }
    }
    AEPlayShowPart.access$800(this.this$0).setVisibility(0);
    AEPlayShowPart.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.7
 * JD-Core Version:    0.7.0.1
 */