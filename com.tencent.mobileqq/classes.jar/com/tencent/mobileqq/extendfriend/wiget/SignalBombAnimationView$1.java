package com.tencent.mobileqq.extendfriend.wiget;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable.QQAnimationListener;
import com.tencent.qphone.base.util.QLog;

class SignalBombAnimationView$1
  implements QQAnimationDrawable.QQAnimationListener
{
  SignalBombAnimationView$1(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void a()
  {
    SignalBombAnimationView.a(this.a).setVisibility(4);
    if (SignalBombAnimationView.a(this.a) != null) {
      SignalBombAnimationView.a(this.a).b();
    }
    QLog.d("SignalBombAnimationViewExtendFriendLimitChat", 2, "onAnimationEnd");
    if (SignalBombAnimationView.a(this.a) != null) {
      SignalBombAnimationView.a(this.a).sendEmptyMessage(1);
    }
  }
  
  public void a(int paramInt) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView.1
 * JD-Core Version:    0.7.0.1
 */