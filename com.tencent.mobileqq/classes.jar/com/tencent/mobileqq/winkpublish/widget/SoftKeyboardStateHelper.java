package com.tencent.mobileqq.winkpublish.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoftKeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int a = 0;
  private final List<SoftKeyboardStateHelper.SoftKeyboardStateListener> b = new LinkedList();
  private final View c;
  private int d;
  private boolean e;
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.c = paramView;
    this.e = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.a();
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.d = paramInt;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.a(paramInt);
      }
    }
  }
  
  public void a(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.b.add(paramSoftKeyboardStateListener);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.c.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    int j = this.a;
    if (j == 0)
    {
      this.a = i;
      return;
    }
    i = j - i;
    if ((!this.e) && (i >= 250))
    {
      this.e = true;
      a(i);
      return;
    }
    if ((this.e) && (i < 100))
    {
      this.e = false;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */