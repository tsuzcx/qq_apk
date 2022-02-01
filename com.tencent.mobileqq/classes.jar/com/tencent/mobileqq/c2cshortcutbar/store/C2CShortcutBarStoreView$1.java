package com.tencent.mobileqq.c2cshortcutbar.store;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.utils.UITools;

class C2CShortcutBarStoreView$1
  implements View.OnTouchListener
{
  C2CShortcutBarStoreView$1(C2CShortcutBarStoreView paramC2CShortcutBarStoreView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      C2CShortcutBarStoreView.a(this.a, paramMotionEvent.getY());
      UITools.a(paramView, 0.5F);
    }
    for (;;)
    {
      bool = false;
      do
      {
        return bool;
        if (paramMotionEvent.getAction() != 1) {
          break label101;
        }
        UITools.a(paramView, 1.0F);
        C2CShortcutBarStoreView.b(this.a, paramMotionEvent.getY());
        if (C2CShortcutBarStoreView.a(this.a) - C2CShortcutBarStoreView.b(this.a) <= 50.0F) {
          break;
        }
      } while (C2CShortcutBarStoreView.a(this.a) == null);
      C2CShortcutBarStoreView.a(this.a).c();
      return true;
      label101:
      if (paramMotionEvent.getAction() == 3) {
        UITools.a(paramView, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.1
 * JD-Core Version:    0.7.0.1
 */