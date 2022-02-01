package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import android.os.Handler.Callback;
import android.os.Message;

class ProfileMediaWallComponent$1
  implements Handler.Callback
{
  ProfileMediaWallComponent$1(ProfileMediaWallComponent paramProfileMediaWallComponent) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      ProfileMediaWallComponent.access$000(this.this$0, paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent.1
 * JD-Core Version:    0.7.0.1
 */