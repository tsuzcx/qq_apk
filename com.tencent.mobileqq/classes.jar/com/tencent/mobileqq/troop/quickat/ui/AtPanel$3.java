package com.tencent.mobileqq.troop.quickat.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AtPanel$3
  implements View.OnTouchListener
{
  AtPanel$3(AtPanel paramAtPanel, View paramView1, View paramView2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (this.a.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    return (paramMotionEvent.getAction() == 4) && (AtPanelTouchController.a(this.b, paramMotionEvent)) && ((i == 0) || ((i != 0) && (!AtPanelTouchController.a(this.a, paramMotionEvent))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel.3
 * JD-Core Version:    0.7.0.1
 */