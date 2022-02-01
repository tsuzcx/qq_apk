package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import bive;

public class AppShortcutBarScrollView
  extends HorizontalScrollView
{
  protected float a;
  protected Rect a;
  protected View a;
  protected bive a;
  protected boolean a;
  protected boolean b = true;
  
  public AppShortcutBarScrollView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public AppShortcutBarScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  private void a()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidGraphicsRect.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.setAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      return;
      if (a()) {
        a();
      }
      this.b = true;
      return;
      if (this.b)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.b = false;
      }
      float f1 = this.jdField_a_of_type_Float;
      float f2 = paramMotionEvent.getX();
      i = (int)((f1 - f2) / 2.5D);
      this.jdField_a_of_type_Float = f2;
      if (!b()) {
        break;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
      }
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      k = getWidth();
      m = getScrollX();
    } while (((m != 0) || (i >= 0)) && ((j - k != m) || (i <= 0)));
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft() - i, this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight() - i, this.jdField_a_of_type_AndroidViewView.getBottom());
    return;
    scrollBy(i, 0);
  }
  
  private boolean a()
  {
    return !this.jdField_a_of_type_AndroidGraphicsRect.isEmpty();
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int j = getWidth();
    int k = getScrollX();
    return (k == 0) || (i - j == k);
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() > 0) {
      this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    }
    super.onFinishInflate();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Bive != null) {
      this.jdField_a_of_type_Bive.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMove(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollChangedListener(bive parambive)
  {
    this.jdField_a_of_type_Bive = parambive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AppShortcutBarScrollView
 * JD-Core Version:    0.7.0.1
 */