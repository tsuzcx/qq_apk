package com.tencent.mobileqq.widget;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhmg;
import bjat;
import com.tencent.mobileqq.data.Card;

public class ProfileCardExtendFriendView$5
  implements Runnable
{
  ProfileCardExtendFriendView$5(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void run()
  {
    if (bhmg.a(this.this$0.c, this.this$0.b.getWidth()) > 4)
    {
      this.this$0.c.setText(this.a.schoolName);
      ImageView localImageView = this.this$0.a;
      if (this.a.authState == 2L) {}
      for (int i = 2130845158;; i = 2130845159)
      {
        localImageView.setImageResource(i);
        this.this$0.a.setVisibility(0);
        if (ProfileCardExtendFriendView.e(this.this$0)) {
          this.this$0.a.setOnClickListener(new bjat(this));
        }
        return;
      }
    }
    this.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5
 * JD-Core Version:    0.7.0.1
 */