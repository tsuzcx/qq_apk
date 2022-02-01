package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class AppShortcutBarScrollView
  extends HorizontalScrollView
{
  protected View a;
  protected Rect b = new Rect();
  protected float c;
  protected boolean d = false;
  protected boolean e = true;
  protected AppShortcutBarScrollView.OnScrollChangedListener f;
  
  public AppShortcutBarScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.a.getLeft(), this.b.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.a.setAnimation(localTranslateAnimation);
    this.a.layout(this.b.left, this.b.top, this.b.right, this.b.bottom);
    this.b.setEmpty();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (this.e)
        {
          this.c = paramMotionEvent.getX();
          this.e = false;
        }
        float f1 = this.c;
        float f2 = paramMotionEvent.getX();
        double d1 = f1 - f2;
        Double.isNaN(d1);
        i = (int)(d1 / 2.5D);
        this.c = f2;
        if (c())
        {
          if (this.b.isEmpty()) {
            this.b.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
          }
          int j = this.a.getMeasuredWidth();
          int k = getWidth();
          int m = getScrollX();
          if (((m == 0) && (i < 0)) || ((j - k == m) && (i > 0)))
          {
            paramMotionEvent = this.a;
            paramMotionEvent.layout(paramMotionEvent.getLeft() - i, this.a.getTop(), this.a.getRight() - i, this.a.getBottom());
          }
        }
        else
        {
          scrollBy(i, 0);
        }
      }
      else
      {
        if (b()) {
          a();
        }
        this.e = true;
      }
    }
    else {
      this.c = paramMotionEvent.getX();
    }
  }
  
  private boolean b()
  {
    return this.b.isEmpty() ^ true;
  }
  
  private boolean c()
  {
    int i = this.a.getMeasuredWidth();
    int j = getWidth();
    int k = getScrollX();
    return (k == 0) || (i - j == k);
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() > 0) {
      this.a = getChildAt(0);
    }
    super.onFinishInflate();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppShortcutBarScrollView.OnScrollChangedListener localOnScrollChangedListener = this.f;
    if (localOnScrollChangedListener != null) {
      localOnScrollChangedListener.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return false;
    }
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMove(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnScrollChangedListener(AppShortcutBarScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.f = paramOnScrollChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AppShortcutBarScrollView
 * JD-Core Version:    0.7.0.1
 */