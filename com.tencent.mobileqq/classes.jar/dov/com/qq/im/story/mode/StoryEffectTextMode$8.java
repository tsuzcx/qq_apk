package dov.com.qq.im.story.mode;

import android.app.Activity;
import beps;
import bkil;
import bmdi;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(bmdi parambmdi, beps parambeps) {}
  
  public void run()
  {
    if ((bmdi.b(this.this$0)) || (bmdi.a(this.this$0).a().isFinishing())) {
      return;
    }
    if (this.a.a()) {
      this.a.b();
    }
    bmdi.b(this.this$0, true);
    bmdi.c(this.this$0).k();
    bmdi.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */