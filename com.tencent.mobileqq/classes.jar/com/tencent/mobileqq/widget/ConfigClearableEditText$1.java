package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ConfigClearableEditText$1
  implements View.OnTouchListener
{
  ConfigClearableEditText$1(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a;
    int i;
    if (paramMotionEvent.getX() > ConfigClearableEditText.a(this.a)) {
      i = 1;
    } else {
      i = 0;
    }
    if (ConfigClearableEditText.b(this.a) != null) {
      if ((i != 0) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
        ConfigClearableEditText.b(this.a).b(true);
      } else {
        ConfigClearableEditText.b(this.a).b(false);
      }
    }
    if ((paramView.getCompoundDrawables()[2] == null) && ((!ConfigClearableEditText.c(this.a)) || (ConfigClearableEditText.b(this.a) == null))) {
      return false;
    }
    if (paramMotionEvent.getAction() != 1) {
      return false;
    }
    if (i != 0)
    {
      this.a.setText("");
      this.a.setClearButtonVisible(false);
      if (this.a.b != null) {
        this.a.b.f();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ConfigClearableEditText.1
 * JD-Core Version:    0.7.0.1
 */