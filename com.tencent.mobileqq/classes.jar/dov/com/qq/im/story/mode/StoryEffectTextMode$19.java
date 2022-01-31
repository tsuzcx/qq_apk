package dov.com.qq.im.story.mode;

import android.os.Handler;
import bmdi;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(bmdi parambmdi) {}
  
  public void run()
  {
    if (bmdi.e(this.this$0) != 0) {
      bmdi.a(this.this$0, bmdi.a(this.this$0), bmdi.a(this.this$0), bmdi.c(this.this$0), bmdi.d(this.this$0), bmdi.e(this.this$0), null);
    }
    if (bmdi.c(this.this$0))
    {
      bmdi.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */