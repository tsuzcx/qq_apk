package dov.com.qq.im.story.mode;

import android.app.Activity;
import beub;
import bkms;
import bmhu;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(bmhu parambmhu, beub parambeub) {}
  
  public void run()
  {
    if ((bmhu.b(this.this$0)) || (bmhu.a(this.this$0).a().isFinishing())) {
      return;
    }
    if (this.a.a()) {
      this.a.b();
    }
    bmhu.b(this.this$0, true);
    bmhu.c(this.this$0).k();
    bmhu.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */