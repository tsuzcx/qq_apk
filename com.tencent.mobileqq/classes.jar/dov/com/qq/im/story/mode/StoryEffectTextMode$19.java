package dov.com.qq.im.story.mode;

import android.os.Handler;
import boza;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(boza paramboza) {}
  
  public void run()
  {
    if (boza.e(this.this$0) != 0) {
      boza.a(this.this$0, boza.a(this.this$0), boza.a(this.this$0), boza.c(this.this$0), boza.d(this.this$0), boza.e(this.this$0), null);
    }
    if (boza.c(this.this$0))
    {
      boza.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */