package com.tencent.mobileqq.filemanager.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

public class HeaderScrollHelper
{
  private int a = Build.VERSION.SDK_INT;
  private HeaderScrollHelper.ScrollableContainer b;
  
  private boolean a(android.widget.AdapterView paramAdapterView)
  {
    if ((paramAdapterView != null) && (paramAdapterView.getFirstVisiblePosition() == 0))
    {
      paramAdapterView = paramAdapterView.getChildAt(0);
      if ((paramAdapterView == null) || (paramAdapterView.getTop() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ScrollView paramScrollView)
  {
    boolean bool = true;
    if (paramScrollView != null)
    {
      if (paramScrollView.getScrollY() <= 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(com.tencent.widget.AdapterView paramAdapterView)
  {
    if ((paramAdapterView != null) && (paramAdapterView.getFirstVisiblePosition() == 0))
    {
      paramAdapterView = paramAdapterView.getChildAt(0);
      if ((paramAdapterView == null) || (paramAdapterView.getTop() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private View b()
  {
    HeaderScrollHelper.ScrollableContainer localScrollableContainer = this.b;
    if (localScrollableContainer == null) {
      return null;
    }
    return localScrollableContainer.getScrollableView();
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = b();
    if ((localView instanceof android.widget.AbsListView))
    {
      ((android.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
      return;
    }
    if ((localView instanceof com.tencent.widget.AbsListView))
    {
      ((com.tencent.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
      return;
    }
    if ((localView instanceof ScrollView))
    {
      ((ScrollView)localView).fling(paramInt1);
      return;
    }
    if ((localView instanceof WebView)) {
      ((WebView)localView).flingScroll(0, paramInt1);
    }
  }
  
  public void a(HeaderScrollHelper.ScrollableContainer paramScrollableContainer)
  {
    this.b = paramScrollableContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    b();
  }
  
  public boolean a()
  {
    View localView = b();
    if (localView == null) {
      return true;
    }
    if ((localView instanceof com.tencent.widget.AdapterView)) {
      return a((com.tencent.widget.AdapterView)localView);
    }
    if ((localView instanceof android.widget.AdapterView)) {
      return a((android.widget.AdapterView)localView);
    }
    if ((localView instanceof ScrollView)) {
      return a((ScrollView)localView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.HeaderScrollHelper
 * JD-Core Version:    0.7.0.1
 */