package com.tencent.mobileqq.qwallet.widget;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;
import cooperation.qwallet.plugin.IQWalletHelper;

class QWalletAnimDialog$1
  implements AnimationView.MyAnimationListener
{
  QWalletAnimDialog$1(QWalletAnimDialog paramQWalletAnimDialog) {}
  
  public void onAnimationEnd(AnimationView paramAnimationView) {}
  
  public void onAnimationRepeat(AnimationView paramAnimationView)
  {
    if (!this.a.b)
    {
      this.a.b = true;
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).gotoF2FRedpack(this.a.c, this.a.d, this.a.f, this.a.e, true, this.a.a);
    }
  }
  
  public void onAnimationStart(AnimationView paramAnimationView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog.1
 * JD-Core Version:    0.7.0.1
 */