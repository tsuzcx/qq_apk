package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.os.Handler;
import behu;
import bhrs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOMusicSkin$5
  implements Runnable
{
  public AIOMusicSkin$5(behu parambehu) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    boolean bool2;
    if (this.this$0.k_())
    {
      bool2 = behu.a(behu.b(this.this$0));
      bool1 = bool2;
      if (!bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMusicSkin", 2, "download themeId:" + behu.b(this.this$0));
        }
        bhrs.a.download(null, behu.b(this.this$0), behu.a(this.this$0), false);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOMusicSkin", 2, "refresh, needSkin:" + this.this$0.k_() + " isShow: " + bool1);
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