package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Intent;

class AEMaterialPanel$1
  implements Runnable
{
  AEMaterialPanel$1(AEMaterialPanel paramAEMaterialPanel, Activity paramActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    this.a.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.1
 * JD-Core Version:    0.7.0.1
 */