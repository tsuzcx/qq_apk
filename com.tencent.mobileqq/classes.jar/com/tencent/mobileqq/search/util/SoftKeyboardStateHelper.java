package com.tencent.mobileqq.search.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoftKeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final List<SoftKeyboardStateHelper.SoftKeyboardStateListener> a = new LinkedList();
  private final View b;
  private int c;
  private boolean d;
  private int e = 200;
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.b = paramView;
    this.d = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardClosed();
      }
    }
  }
  
  public void a()
  {
    this.a.clear();
    View localView = this.b;
    if (localView != null) {
      localView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
  
  public void a(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.a.add(paramSoftKeyboardStateListener);
  }
  
  public void b(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.a.remove(paramSoftKeyboardStateListener);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.b.getWindowVisibleDisplayFrame(localRect);
    int i = this.b.getRootView().getHeight() - (localRect.bottom - localRect.top) - ImmersiveUtils.getStatusBarHeight(this.b.getContext());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGlobalLayout , activityRootView.Height = ");
      localStringBuilder.append(this.b.getRootView().getHeight());
      localStringBuilder.append(" heightDiff = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" (r.bottom - r.top) = ");
      localStringBuilder.append(localRect.bottom - localRect.top);
      QLog.d("SoftKeyboardStateHelper", 2, localStringBuilder.toString());
    }
    if ((!this.d) && (i > this.e))
    {
      this.d = true;
      a(i);
      return;
    }
    if ((this.d) && (i < this.e))
    {
      this.d = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */