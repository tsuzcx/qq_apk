package dov.com.qq.im.story.mode;

import android.app.Activity;
import bcqi;
import bigp;
import bjry;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(bjry parambjry, bcqi parambcqi) {}
  
  public void run()
  {
    if ((bjry.b(this.this$0)) || (bjry.a(this.this$0).a().isFinishing())) {
      return;
    }
    if (this.a.a()) {
      this.a.b();
    }
    bjry.b(this.this$0, true);
    bjry.c(this.this$0).k();
    bjry.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */