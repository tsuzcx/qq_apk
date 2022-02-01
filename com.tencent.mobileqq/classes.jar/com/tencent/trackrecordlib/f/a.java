package com.tencent.trackrecordlib.f;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.trackrecordlib.core.c;

public class a
  extends View.AccessibilityDelegate
{
  private static final String a = "a";
  private View.AccessibilityDelegate b;
  
  public a(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.b = paramAccessibilityDelegate;
  }
  
  public View.AccessibilityDelegate a()
  {
    return this.b;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    c.a().a(paramView, paramInt);
    View.AccessibilityDelegate localAccessibilityDelegate = this.b;
    if (localAccessibilityDelegate != null)
    {
      localAccessibilityDelegate.sendAccessibilityEvent(paramView, paramInt);
      return;
    }
    super.sendAccessibilityEvent(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.f.a
 * JD-Core Version:    0.7.0.1
 */