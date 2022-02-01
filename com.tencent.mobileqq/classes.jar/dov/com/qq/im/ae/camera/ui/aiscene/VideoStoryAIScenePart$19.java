package dov.com.qq.im.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import dov.com.qq.im.ae.AEPituCameraUnit;

class VideoStoryAIScenePart$19
  implements Runnable
{
  VideoStoryAIScenePart$19(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    VideoStoryAIScenePart.a(this.this$0).a().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */