package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;

class TroopAioNewMessageBar$1
  extends Handler
{
  TroopAioNewMessageBar$1(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.j) && (TroopAioNewMessageBar.e == this.a.p)) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioNewMessageBar.1
 * JD-Core Version:    0.7.0.1
 */