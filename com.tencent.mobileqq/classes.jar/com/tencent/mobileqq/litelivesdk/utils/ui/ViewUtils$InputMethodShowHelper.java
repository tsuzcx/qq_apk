package com.tencent.mobileqq.litelivesdk.utils.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

public class ViewUtils$InputMethodShowHelper
{
  public ViewUtils.OnInputMethodChangeListener a;
  private ViewTreeObserver.OnGlobalLayoutListener c = new ViewUtils.InputMethodShowHelper.1(this);
  private View d;
  private int e;
  
  public ViewUtils$InputMethodShowHelper(ViewUtils paramViewUtils, Activity paramActivity)
  {
    paramViewUtils = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramViewUtils != null)
    {
      this.d = paramViewUtils.getChildAt(0);
      paramViewUtils = this.d;
      if (paramViewUtils != null) {
        paramViewUtils.getViewTreeObserver().addOnGlobalLayoutListener(this.c);
      }
    }
    else
    {
      Log.e("ViewUtils", "获取android.R.id.content为空！！！！");
    }
  }
  
  private void a()
  {
    int i = b();
    if (i != this.e)
    {
      int j = this.d.getRootView().getHeight();
      if (j - i > j / 4) {
        this.a.a(true);
      } else {
        this.a.a(false);
      }
      this.e = i;
    }
  }
  
  private int b()
  {
    Rect localRect = new Rect();
    this.d.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public void a(Activity paramActivity)
  {
    this.d = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    paramActivity = this.d;
    if (paramActivity != null) {
      paramActivity.getViewTreeObserver().removeOnGlobalLayoutListener(this.c);
    }
    this.a = null;
  }
  
  public void a(ViewUtils.OnInputMethodChangeListener paramOnInputMethodChangeListener)
  {
    this.a = paramOnInputMethodChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.InputMethodShowHelper
 * JD-Core Version:    0.7.0.1
 */