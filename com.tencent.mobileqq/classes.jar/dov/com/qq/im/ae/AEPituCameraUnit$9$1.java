package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.Intent;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class AEPituCameraUnit$9$1
  implements Runnable
{
  AEPituCameraUnit$9$1(AEPituCameraUnit.9 param9) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    this.a.a.a().sendBroadcast(localIntent);
    this.a.a.a.a(131078, new Object[0]);
    AEBaseDataReporter.a().aq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.9.1
 * JD-Core Version:    0.7.0.1
 */