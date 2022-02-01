package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AIOMusicSkin$5
  implements Runnable
{
  AIOMusicSkin$5(AIOMusicSkin paramAIOMusicSkin) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    boolean bool1;
    StringBuilder localStringBuilder;
    if (this.this$0.du_())
    {
      boolean bool2 = AIOMusicSkin.b(AIOMusicSkin.f(this.this$0));
      bool1 = bool2;
      if (!bool2)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download themeId:");
          localStringBuilder.append(AIOMusicSkin.f(this.this$0));
          QLog.i("AIOMusicSkin", 2, localStringBuilder.toString());
        }
        MusicThemeCallback.sInstance.download(AIOMusicSkin.f(this.this$0), AIOMusicSkin.g(this.this$0), false);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh, needSkin:");
      localStringBuilder.append(this.this$0.du_());
      localStringBuilder.append(" isShow: ");
      localStringBuilder.append(bool1);
      QLog.d("AIOMusicSkin", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.5.1(this, bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5
 * JD-Core Version:    0.7.0.1
 */