package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;

class MessengerService$10
  extends FriendListObserver
{
  MessengerService$10(MessengerService paramMessengerService) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    if (this.a.p != null)
    {
      this.a.p.putString("cmd", "ipc_signature_setlike");
      paramObject = new Bundle();
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 101;
      }
      paramObject.putInt("result", i);
      this.a.p.putBundle("response", paramObject);
      paramObject = this.a;
      paramObject.a(paramObject.p);
      this.a.p = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.10
 * JD-Core Version:    0.7.0.1
 */