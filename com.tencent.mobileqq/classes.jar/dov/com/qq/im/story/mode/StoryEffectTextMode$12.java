package dov.com.qq.im.story.mode;

import android.os.Handler;
import bjry;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import ved;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(bjry parambjry, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = bjry.a(this.this$0, "qg_InitConfig", this.a.toString());
    bjry.c(this.this$0, false);
    bjry.a(this.this$0, bjry.a(this.this$0), bjry.a(this.this$0), bjry.c(this.this$0), bjry.d(this.this$0), 27, null);
    if (bool)
    {
      if (bjry.c(this.this$0))
      {
        bjry.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    bjry.b(this.this$0, 27);
    ved.b("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */