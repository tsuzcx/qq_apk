package com.tencent.mobileqq.qqexpand.profilecard;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.DisplayUtils;

class ProfileCardExtendFriendView$5
  implements Runnable
{
  ProfileCardExtendFriendView$5(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void run()
  {
    if (DisplayUtils.a(this.this$0.c, this.this$0.b.getWidth()) > 4)
    {
      this.this$0.c.setText(this.a.schoolName);
      ImageView localImageView = this.this$0.a;
      int i;
      if (this.a.authState == 2L) {
        i = 1912864769;
      } else {
        i = 1912864770;
      }
      localImageView.setImageResource(i);
      this.this$0.a.setVisibility(0);
      if (ProfileCardExtendFriendView.e(this.this$0)) {
        this.this$0.a.setOnClickListener(new ProfileCardExtendFriendView.5.1(this));
      }
    }
    else
    {
      this.this$0.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.5
 * JD-Core Version:    0.7.0.1
 */