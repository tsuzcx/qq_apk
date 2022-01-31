package dov.com.qq.im.story.mode;

import android.os.Handler;
import bmhu;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(bmhu parambmhu) {}
  
  public void run()
  {
    if (bmhu.e(this.this$0) != 0) {
      bmhu.a(this.this$0, bmhu.a(this.this$0), bmhu.a(this.this$0), bmhu.c(this.this$0), bmhu.d(this.this$0), bmhu.e(this.this$0), null);
    }
    if (bmhu.c(this.this$0))
    {
      bmhu.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */