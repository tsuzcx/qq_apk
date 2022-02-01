package com.tencent.mobileqq.flashchat;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class FlashChatPanel$arkViewOnLongClickAndTouchListener
  implements OnLongClickAndTouchListener
{
  public FlashChatPanel$arkViewOnLongClickAndTouchListener(FlashChatPanel paramFlashChatPanel) {}
  
  public boolean onLongClick(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel.arkViewOnLongClickAndTouchListener
 * JD-Core Version:    0.7.0.1
 */