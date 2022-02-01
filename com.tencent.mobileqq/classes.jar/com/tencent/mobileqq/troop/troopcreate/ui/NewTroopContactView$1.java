package com.tencent.mobileqq.troop.troopcreate.ui;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

class NewTroopContactView$1
  extends Handler
{
  NewTroopContactView$1(NewTroopContactView paramNewTroopContactView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 2) {
      return;
    }
    this.a.h.scrollTo(this.a.i.getLayoutParams().width, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.1
 * JD-Core Version:    0.7.0.1
 */