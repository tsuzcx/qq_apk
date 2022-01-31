package dov.com.qq.im.story.mode;

import android.os.Handler;
import bmdi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import wsv;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(bmdi parambmdi, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = bmdi.a(this.this$0, "qg_InitConfig", this.a.toString());
    bmdi.c(this.this$0, false);
    bmdi.a(this.this$0, bmdi.a(this.this$0), bmdi.a(this.this$0), bmdi.c(this.this$0), bmdi.d(this.this$0), 27, null);
    if (bool)
    {
      if (bmdi.c(this.this$0))
      {
        bmdi.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    bmdi.b(this.this$0, 27);
    wsv.b("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */