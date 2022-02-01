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
    View localView = this.b.k.findViewById(2131427425);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (this.a.getHeight() / 2 + this.a.getTop() - localView.getHeight() / 2);
    localView.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
    }
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.2
 * JD-Core Version:    0.7.0.1
 */