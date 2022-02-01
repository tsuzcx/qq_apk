package com.tencent.mobileqq.troop.activity;

import android.view.KeyEvent;
import com.tencent.mobileqq.troop.widget.XEditTextExWithListener.KeyPreImeListener;

class TroopBarReplyActivity$3
  implements XEditTextExWithListener.KeyPreImeListener
{
  TroopBarReplyActivity$3(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1)) {
      TroopBarReplyActivity.a(this.a, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.3
 * JD-Core Version:    0.7.0.1
 */