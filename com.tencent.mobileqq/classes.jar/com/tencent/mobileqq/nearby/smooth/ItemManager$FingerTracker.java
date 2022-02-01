package com.tencent.mobileqq.nearby.smooth;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ItemManager$FingerTracker
  implements View.OnTouchListener
{
  private ItemManager$FingerTracker(ItemManager paramItemManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    Object localObject = this.a;
    boolean bool1 = bool3;
    if (i != 1) {
      if (i != 3) {
        break label105;
      }
    }
    label105:
    for (bool1 = bool3;; bool1 = false)
    {
      ((ItemManager)localObject).c = bool1;
      if ((this.a.c) && (this.a.b != 2)) {
        this.a.b();
      }
      localObject = this.a.a.a();
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((View.OnTouchListener)localObject).onTouch(paramView, paramMotionEvent);
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager.FingerTracker
 * JD-Core Version:    0.7.0.1
 */