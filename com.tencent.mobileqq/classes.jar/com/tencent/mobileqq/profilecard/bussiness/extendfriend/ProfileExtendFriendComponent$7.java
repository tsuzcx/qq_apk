package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.view.View;
import badl;
import bagl;

public class ProfileExtendFriendComponent$7
  implements Runnable
{
  public ProfileExtendFriendComponent$7(bagl parambagl) {}
  
  public void run()
  {
    if (bagl.a(this.this$0) != null)
    {
      int i = ((View)bagl.b(this.this$0)).getTop();
      if ((i >= 0) && (bagl.c(this.this$0) != null)) {
        bagl.d(this.this$0).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.7
 * JD-Core Version:    0.7.0.1
 */