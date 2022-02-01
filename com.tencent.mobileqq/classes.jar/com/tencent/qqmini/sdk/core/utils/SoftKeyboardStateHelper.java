package com.tencent.qqmini.sdk.core.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoftKeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final String TAG = "SoftKeyboardStateHelper";
  private final int KEY_BOARD_HIGH_DIFF = 200;
  private final View activityRootView;
  private boolean isSoftKeyboardOpened;
  private int lastSoftKeyboardHeightInPx;
  private final List<SoftKeyboardStateHelper.SoftKeyboardStateListener> listeners = new LinkedList();
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.activityRootView = paramView;
    this.isSoftKeyboardOpened = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void notifyOnSoftKeyboardClosed()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardClosed();
      }
    }
  }
  
  private void notifyOnSoftKeyboardOpened(int paramInt)
  {
    this.lastSoftKeyboardHeightInPx = paramInt;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  public void addSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.listeners.add(paramSoftKeyboardStateListener);
  }
  
  public int getLastSoftKeyboardHeightInPx()
  {
    return this.lastSoftKeyboardHeightInPx;
  }
  
  public boolean isSoftKeyboardOpened()
  {
    return this.isSoftKeyboardOpened;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.activityRootView.getWindowVisibleDisplayFrame(localRect);
    int i = this.activityRootView.getRootView().getHeight() - (localRect.bottom - localRect.top) - DisplayUtil.getStatusBarHeight(this.activityRootView.getContext());
    QMLog.d("SoftKeyboardStateHelper", "onGlobalLayout , activityRootView.Height = " + this.activityRootView.getRootView().getHeight() + " heightDiff = " + i + " (r.bottom - r.top) = " + (localRect.bottom - localRect.top));
    if ((!this.isSoftKeyboardOpened) && (i > 200))
    {
      this.isSoftKeyboardOpened = true;
      notifyOnSoftKeyboardOpened(i);
    }
    while ((!this.isSoftKeyboardOpened) || (i >= 200)) {
      return;
    }
    this.isSoftKeyboardOpened = false;
    notifyOnSoftKeyboardClosed();
  }
  
  public void removeSoftKeyboardStateListener()
  {
    this.listeners.clear();
    if (this.activityRootView != null) {
      this.activityRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.listeners.remove(paramSoftKeyboardStateListener);
  }
  
  public void setIsSoftKeyboardOpened(boolean paramBoolean)
  {
    this.isSoftKeyboardOpened = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper
 * JD-Core Version:    0.7.0.1
 */