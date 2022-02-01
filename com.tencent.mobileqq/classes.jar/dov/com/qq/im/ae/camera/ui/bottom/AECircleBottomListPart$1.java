package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

class AECircleBottomListPart$1
  implements AEBottomListAdapter.AEBottomListListener
{
  AECircleBottomListPart$1(AECircleBottomListPart paramAECircleBottomListPart) {}
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    this.a.a.a().sendBroadcast(localIntent);
    AECircleBottomListPart.a(this.a).a(131076, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleBottomListPart.1
 * JD-Core Version:    0.7.0.1
 */