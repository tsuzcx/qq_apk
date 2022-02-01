package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler.Callback;
import android.os.Message;

class NearbyProfileDisplayTribePanel$1
  implements Handler.Callback
{
  NearbyProfileDisplayTribePanel$1(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    NearbyProfileDisplayTribePanel.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.1
 * JD-Core Version:    0.7.0.1
 */