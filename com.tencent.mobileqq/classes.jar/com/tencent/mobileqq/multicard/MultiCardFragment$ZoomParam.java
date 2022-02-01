package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

class MultiCardFragment$ZoomParam
{
  public ViewGroup.LayoutParams a;
  public float b;
  public float c;
  public int d;
  public MultiCardRootLayout e;
  public MultiCardCustomLayout f;
  public MultiCardCustomViewDelegate g;
  public int h;
  public int i;
  
  public MultiCardFragment$ZoomParam(MultiCardFragment paramMultiCardFragment, MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, MultiCardCustomViewDelegate paramMultiCardCustomViewDelegate, MultiCardCustomViewDelegate.MultiCardCustomViewDelegateListener paramMultiCardCustomViewDelegateListener)
  {
    this.e = paramMultiCardRootLayout;
    this.f = paramMultiCardCustomLayout;
    this.g = paramMultiCardCustomViewDelegate;
    paramMultiCardFragment = this.g;
    if (paramMultiCardFragment != null) {
      paramMultiCardFragment.a(paramMultiCardCustomViewDelegateListener);
    }
  }
  
  public void a()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((MultiCardRootLayout)localObject).a(false);
      this.b = this.e.getScaleX();
      this.c = this.e.getScaleY();
    }
    localObject = this.f;
    if (localObject != null)
    {
      this.a = ((MultiCardCustomLayout)localObject).getLayoutParams();
      localObject = new int[2];
      this.f.getLocationOnScreen((int[])localObject);
      this.h = localObject[0];
      this.i = localObject[1];
      this.f.a(true);
      localObject = this.f.findViewById(2131439021);
      if (localObject != null)
      {
        this.d = ((View)localObject).getVisibility();
        ((View)localObject).setVisibility(8);
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      MultiCardCustomLayout localMultiCardCustomLayout = this.f;
      if (localMultiCardCustomLayout != null) {
        ((MultiCardRootLayout)localObject).removeView(localMultiCardCustomLayout);
      }
    }
    localObject = this.g;
    if (localObject != null) {
      ((MultiCardCustomViewDelegate)localObject).b(0);
    }
  }
  
  public void b()
  {
    Object localObject = this.f;
    if ((localObject != null) && (this.e != null))
    {
      if ((((MultiCardCustomLayout)localObject).getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      }
      this.f.a(false);
      this.f.setLayoutParams(this.a);
      this.f.setScaleX(1.0F);
      this.f.setScaleY(1.0F);
      this.e.a(true);
      this.e.addView(this.f, 0);
    }
    localObject = this.g;
    if (localObject != null) {
      ((MultiCardCustomViewDelegate)localObject).b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.ZoomParam
 * JD-Core Version:    0.7.0.1
 */