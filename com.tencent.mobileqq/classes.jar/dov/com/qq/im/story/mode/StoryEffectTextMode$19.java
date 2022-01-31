package dov.com.qq.im.story.mode;

import android.os.Handler;
import bjry;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(bjry parambjry) {}
  
  public void run()
  {
    if (bjry.e(this.this$0) != 0) {
      bjry.a(this.this$0, bjry.a(this.this$0), bjry.a(this.this$0), bjry.c(this.this$0), bjry.d(this.this$0), bjry.e(this.this$0), null);
    }
    if (bjry.c(this.this$0))
    {
      bjry.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */