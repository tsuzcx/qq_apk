package dov.com.qq.im.story.mode;

import android.os.Handler;
import bqav;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import yuk;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(bqav parambqav, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = bqav.a(this.this$0, "qg_InitConfig", this.a.toString());
    bqav.c(this.this$0, false);
    bqav.a(this.this$0, bqav.a(this.this$0), bqav.a(this.this$0), bqav.c(this.this$0), bqav.d(this.this$0), 27, null);
    if (bool)
    {
      if (bqav.c(this.this$0))
      {
        bqav.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    bqav.b(this.this$0, 27);
    yuk.b("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */