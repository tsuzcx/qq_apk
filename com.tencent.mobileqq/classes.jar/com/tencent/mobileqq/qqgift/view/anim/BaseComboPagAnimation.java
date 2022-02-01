package com.tencent.mobileqq.qqgift.view.anim;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.utils.PagLoader;
import org.libpag.PAGView;

abstract class BaseComboPagAnimation
{
  protected PAGView a;
  private final View b;
  
  public BaseComboPagAnimation(View paramView)
  {
    this.b = paramView;
    b();
  }
  
  private void b()
  {
    if (QQGiftPAGAnimationViewImpl.a.a())
    {
      c();
      a();
      return;
    }
    if (this.b != null) {
      QQGiftPAGAnimationViewImpl.a.a(this.b.getContext(), new BaseComboPagAnimation.1(this));
    }
  }
  
  private void c()
  {
    this.a = new PAGView(this.b.getContext());
    ViewGroup localViewGroup = (ViewGroup)this.b.getParent();
    int i = localViewGroup.indexOfChild(this.b);
    this.a.setId(this.b.getId());
    localViewGroup.removeView(this.b);
    localViewGroup.addView(this.a, i, this.b.getLayoutParams());
  }
  
  abstract void a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.view.anim.BaseComboPagAnimation
 * JD-Core Version:    0.7.0.1
 */