package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class TroopMemberListSlideItem
  extends FrameLayout
{
  protected Scroller a;
  protected View b;
  protected View c;
  protected int d = 0;
  protected boolean e = false;
  private boolean f = false;
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TroopMemberListSlideItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.a = new Scroller(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (getScrollX() > 0) {
      return;
    }
    if (paramBoolean) {
      this.a.startScroll(0, 0, this.d, 0);
    } else {
      scrollTo(this.d, 0);
    }
    invalidate();
  }
  
  public void b(boolean paramBoolean)
  {
    if (getScrollX() == 0) {
      return;
    }
    if (paramBoolean)
    {
      Scroller localScroller = this.a;
      int i = this.d;
      localScroller.startScroll(i, 0, -i, 0);
    }
    else
    {
      scrollTo(0, 0);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), 0);
      invalidate();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = getChildAt(0);
    this.c = getChildAt(1);
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.width == -1)) {
      this.e = true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.b.getMeasuredWidth();
    if (this.e) {
      paramInt1 = getMeasuredWidth();
    }
    View localView = this.b;
    localView.layout(0, 0, paramInt1, localView.getMeasuredHeight());
    localView = this.c;
    localView.layout(paramInt1, 0, localView.getMeasuredWidth() + paramInt1, this.c.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d = this.c.getMeasuredWidth();
  }
  
  public void setSlideEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.f)
    {
      setClickable(true);
      return;
    }
    setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem
 * JD-Core Version:    0.7.0.1
 */