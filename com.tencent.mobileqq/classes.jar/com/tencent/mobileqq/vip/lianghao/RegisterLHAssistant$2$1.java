package com.tencent.mobileqq.vip.lianghao;

import android.os.Looper;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class RegisterLHAssistant$2$1
  implements RegisterLiangHaoHelper.CheckCallBack
{
  RegisterLHAssistant$2$1(RegisterLHAssistant.2 param2) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(RegisterLHAssistant.a, 4, String.format(Locale.getDefault(), "checkVipQQStatus, needShow: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    RegisterLHAssistant.a(this.a.this$0, paramBoolean);
    if ((RegisterLHAssistant.c(this.a.this$0)) && (RegisterLHAssistant.d(this.a.this$0).isEnabled()) && (Thread.currentThread() == Looper.getMainLooper().getThread()) && (RegisterLHAssistant.e(this.a.this$0).getVisibility() == 8)) {
      this.a.this$0.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.2.1
 * JD-Core Version:    0.7.0.1
 */