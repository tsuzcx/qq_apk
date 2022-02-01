package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.util.AEQLog;

class AEBottomListAdapter$3
  implements Runnable
{
  AEBottomListAdapter$3(AEBottomListAdapter paramAEBottomListAdapter, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    if (AEBottomListAdapter.a(this.this$0).getVisibility() == 0)
    {
      QLog.d("AEBottomListAdapter", 4, "### [bottom list] visible, select material " + this.a.a);
      AEBottomListAdapter.a(this.this$0).a(this.a, true);
    }
    if (AEBottomListAdapter.a(this.this$0).getVisibility() == 0)
    {
      if (AEBottomListAdapter.a(this.this$0).b())
      {
        AEBottomListAdapter.a(this.this$0).a(this.a);
        return;
      }
      AEQLog.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
      return;
    }
    AEQLog.d("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */