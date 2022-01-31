package dov.com.qq.im.story.mode;

import android.app.Activity;
import bbmv;
import bhdi;
import bhzq;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class StoryEffectTextMode$8
  implements Runnable
{
  public StoryEffectTextMode$8(bhzq parambhzq, bbmv parambbmv) {}
  
  public void run()
  {
    if ((bhzq.b(this.this$0)) || (bhzq.a(this.this$0).a().isFinishing())) {
      return;
    }
    if (this.a.a()) {
      this.a.b();
    }
    bhzq.b(this.this$0, true);
    bhzq.c(this.this$0).k();
    bhzq.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.8
 * JD-Core Version:    0.7.0.1
 */