package dov.com.qq.im.story.mode;

import android.os.Handler;
import bmhu;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.json.JSONObject;
import wxe;

public class StoryEffectTextMode$12
  implements Runnable
{
  public StoryEffectTextMode$12(bmhu parambmhu, JSONObject paramJSONObject) {}
  
  public void run()
  {
    boolean bool = bmhu.a(this.this$0, "qg_InitConfig", this.a.toString());
    bmhu.c(this.this$0, false);
    bmhu.a(this.this$0, bmhu.a(this.this$0), bmhu.a(this.this$0), bmhu.c(this.this$0), bmhu.d(this.this$0), 27, null);
    if (bool)
    {
      if (bmhu.c(this.this$0))
      {
        bmhu.d(this.this$0, false);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12.1(this), 600L);
      }
      return;
    }
    bmhu.b(this.this$0, 27);
    wxe.b("StoryEffectTextMode", "这里没有注册EVENT_NAME_QG_INIT_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.12
 * JD-Core Version:    0.7.0.1
 */