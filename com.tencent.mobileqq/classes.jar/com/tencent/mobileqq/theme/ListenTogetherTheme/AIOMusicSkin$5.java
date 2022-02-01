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
    boolean bool2;
    if (this.this$0.m_())
    {
      bool2 = AIOMusicSkin.a(AIOMusicSkin.b(this.this$0));
      bool1 = bool2;
      if (!bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMusicSkin", 2, "download themeId:" + AIOMusicSkin.b(this.this$0));
        }
        MusicThemeCallback.sInstance.download(AIOMusicSkin.b(this.this$0), AIOMusicSkin.a(this.this$0), false);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOMusicSkin", 2, "refresh, needSkin:" + this.this$0.m_() + " isShow: " + bool1);
      }
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.5.1(this, bool1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5
 * JD-Core Version:    0.7.0.1
 */