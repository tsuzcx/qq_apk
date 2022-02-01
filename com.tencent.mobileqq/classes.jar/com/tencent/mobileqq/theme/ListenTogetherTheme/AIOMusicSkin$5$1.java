package com.tencent.mobileqq.theme.ListenTogetherTheme;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
import java.util.concurrent.ConcurrentHashMap;

class AIOMusicSkin$5$1
  implements Runnable
{
  AIOMusicSkin$5$1(AIOMusicSkin.5 param5, boolean paramBoolean) {}
  
  public void run()
  {
    AIOMusicSkin.a(this.b.this$0, this.a);
    if ((AIOMusicSkin.b(this.b.this$0) != null) && (AIOMusicSkin.b(this.b.this$0).h != null) && (AIOMusicSkin.b(this.b.this$0).f != null))
    {
      if (this.a)
      {
        Object localObject = MusicThemeCallback.sInstance;
        localObject = ((MusicThemeCallback)localObject).getDir(AIOMusicSkin.b(this.b.this$0).getBaseActivity(), ((MusicThemeCallback)localObject).getScid(AIOMusicSkin.f(this.b.this$0)));
        this.b.this$0.b((String)localObject);
        AIOMusicSkin.h(this.b.this$0).put(Integer.valueOf(AIOMusicSkin.f(this.b.this$0)), localObject);
      }
      AIOMusicSkin.a(this.b.this$0, AIOMusicSkin.b(this.b.this$0).h);
      this.b.this$0.a(AIOMusicSkin.b(this.b.this$0).e, AIOMusicSkin.b(this.b.this$0).h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5.1
 * JD-Core Version:    0.7.0.1
 */