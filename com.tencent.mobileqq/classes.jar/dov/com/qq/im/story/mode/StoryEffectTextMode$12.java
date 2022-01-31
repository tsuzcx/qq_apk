package dov.com.qq.im.story.mode;

import android.os.Handler;
import bhzq;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import urk;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(bhzq parambhzq, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = bhzq.a(this.this$0, "qg_InitConfig", this.a.toString());
    bhzq.c(this.this$0, false);
    bhzq.a(this.this$0, bhzq.a(this.this$0), bhzq.a(this.this$0), bhzq.c(this.this$0), bhzq.d(this.this$0), 27, null);
    if (bool)
    {
      if (bhzq.c(this.this$0))
      {
        bhzq.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    bhzq.b(this.this$0, 27);
    urk.b("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */