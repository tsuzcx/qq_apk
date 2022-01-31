package dov.com.qq.im.story.mode;

import android.app.Activity;
import bcpt;
import bify;
import bjrh;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(bjrh parambjrh, bcpt parambcpt) {}
  
  public void run()
  {
    if ((bjrh.b(this.this$0)) || (bjrh.a(this.this$0).a().isFinishing())) {
      return;
    }
    if (this.a.a()) {
      this.a.b();
    }
    bjrh.b(this.this$0, true);
    bjrh.c(this.this$0).k();
    bjrh.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */