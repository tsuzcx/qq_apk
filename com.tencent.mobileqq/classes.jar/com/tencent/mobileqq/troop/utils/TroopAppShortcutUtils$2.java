package com.tencent.mobileqq.troop.utils;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class TroopAppShortcutUtils$2
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils.2
 * JD-Core Version:    0.7.0.1
 */