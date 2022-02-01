package dov.com.qq.im.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import bofh;
import bokv;

public class VideoStoryAIScenePart$20
  implements Runnable
{
  public VideoStoryAIScenePart$20(bokv parambokv) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    bokv.a(this.this$0).a().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.20
 * JD-Core Version:    0.7.0.1
 */