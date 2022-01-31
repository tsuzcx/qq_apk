package dov.com.qq.im.story.mode;

import android.os.Handler;
import bhzq;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class StoryEffectTextMode$19
  implements Runnable
{
  public StoryEffectTextMode$19(bhzq parambhzq) {}
  
  public void run()
  {
    if (bhzq.e(this.this$0) != 0) {
      bhzq.a(this.this$0, bhzq.a(this.this$0), bhzq.a(this.this$0), bhzq.c(this.this$0), bhzq.d(this.this$0), bhzq.e(this.this$0), null);
    }
    if (bhzq.c(this.this$0))
    {
      bhzq.d(this.this$0, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.19.1(this), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.19
 * JD-Core Version:    0.7.0.1
 */