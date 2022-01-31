package com.tencent.mobileqq.profile.musicbox;

import android.view.View;
import android.widget.TextView;
import auxa;
import bbll;

class ProfileMusicBox$1$1
  implements Runnable
{
  ProfileMusicBox$1$1(ProfileMusicBox.1 param1) {}
  
  public void run()
  {
    TextView localTextView = (TextView)auxa.a(this.a.this$0).findViewById(2131377185);
    if (localTextView != null)
    {
      if (!auxa.a(this.a.this$0)) {
        break label79;
      }
      localTextView.setCompoundDrawablePadding(bbll.b(3.0F));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841728, 0);
      if (auxa.b(this.a.this$0)) {
        this.a.this$0.a(true);
      }
    }
    return;
    label79:
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox.1.1
 * JD-Core Version:    0.7.0.1
 */