package dov.com.qq.im.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import bkpl;
import bkuh;

public class VideoStoryAIScenePart$19
  implements Runnable
{
  public VideoStoryAIScenePart$19(bkuh parambkuh) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    bkuh.a(this.this$0).a().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */