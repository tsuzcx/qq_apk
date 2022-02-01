package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class StoryNewGuideDialog$1
  implements View.OnTouchListener
{
  StoryNewGuideDialog$1(StoryNewGuideDialog paramStoryNewGuideDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return true;
    }
    this.a.dismiss();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog.1
 * JD-Core Version:    0.7.0.1
 */