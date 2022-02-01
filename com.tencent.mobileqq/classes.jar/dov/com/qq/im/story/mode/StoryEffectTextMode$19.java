package dov.com.qq.im.story.mode;

import android.os.Handler;
import bqav;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(bqav parambqav) {}
  
  public void run()
  {
    if (bqav.e(this.this$0) != 0) {
      bqav.a(this.this$0, bqav.a(this.this$0), bqav.a(this.this$0), bqav.c(this.this$0), bqav.d(this.this$0), bqav.e(this.this$0), null);
    }
    if (bqav.c(this.this$0))
    {
      bqav.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */