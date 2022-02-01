package com.tencent.open.agent;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class AuthorityAccountView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AuthorityAccountView$2(AuthorityAccountView paramAuthorityAccountView, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    View localView = AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView).findViewById(2131361865);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() / 2 + this.jdField_a_of_type_AndroidWidgetImageView.getTop() - localView.getHeight() / 2);
    localView.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.2
 * JD-Core Version:    0.7.0.1
 */