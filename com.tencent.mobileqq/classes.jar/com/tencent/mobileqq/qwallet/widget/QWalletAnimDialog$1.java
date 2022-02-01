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
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Boolean = true;
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).gotoF2FRedpack(this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_AndroidAppActivity, this.a.c, true, this.a.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationStart(AnimationView paramAnimationView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog.1
 * JD-Core Version:    0.7.0.1
 */