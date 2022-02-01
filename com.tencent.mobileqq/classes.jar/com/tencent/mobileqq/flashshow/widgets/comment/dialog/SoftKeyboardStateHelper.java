package com.tencent.mobileqq.flashshow.widgets.comment.dialog;

import android.graphics.Rect;
import android.os.Build.VERSION;
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
  
  private void b()
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
  
  public void a()
  {
    this.b.clear();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
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
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */