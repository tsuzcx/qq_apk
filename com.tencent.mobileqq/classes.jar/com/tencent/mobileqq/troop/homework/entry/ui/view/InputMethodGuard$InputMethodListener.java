package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class InputMethodGuard$InputMethodListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private InputMethodGuard$InputMethodListener(InputMethodGuard paramInputMethodGuard) {}
  
  private int a()
  {
    if (ScreenUtil.SCREEN_HIGHT > 0) {
      return ScreenUtil.SCREEN_HIGHT;
    }
    return ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public void onGlobalLayout()
  {
    boolean bool = InputMethodGuard.a(this.a);
    Rect localRect = new Rect();
    ((Activity)this.a.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = a();
    int j = i - localRect.bottom;
    if (Math.abs(j) > i / 5)
    {
      InputMethodGuard.a(this.a, true);
      InputMethodGuard.a(this.a, j);
    }
    else
    {
      InputMethodGuard.a(this.a, false);
      InputMethodGuard.a(this.a, 0);
    }
    if ((InputMethodGuard.a(this.a) != null) && ((bool != InputMethodGuard.a(this.a)) || (InputMethodGuard.b(this.a)))) {
      InputMethodGuard.a(this.a).b(InputMethodGuard.a(this.a), InputMethodGuard.a(this.a));
    }
    if (InputMethodGuard.b(this.a)) {
      InputMethodGuard.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.InputMethodListener
 * JD-Core Version:    0.7.0.1
 */