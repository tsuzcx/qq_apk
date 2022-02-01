package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler.Callback;
import android.os.Message;

class NearbyProfileDisplayPanel$1
  implements Handler.Callback
{
  NearbyProfileDisplayPanel$1(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    NearbyProfileDisplayPanel.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.1
 * JD-Core Version:    0.7.0.1
 */