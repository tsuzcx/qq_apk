package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  protected InputMethodRelativeLayout.onSizeChangedListenner a;
  private int b;
  private ViewTreeObserver.OnGlobalLayoutListener c = new InputMethodRelativeLayout.1(this);
  private boolean d = false;
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getViewTreeObserver().addOnGlobalLayoutListener(this.c);
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(this.c);
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public void setOnSizeChangedListenner(InputMethodRelativeLayout.onSizeChangedListenner paramonSizeChangedListenner)
  {
    this.a = paramonSizeChangedListenner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */