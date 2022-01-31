package com.tencent.mobileqq.widget;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdgz;
import beso;
import com.tencent.mobileqq.data.Card;

public class ProfileCardExtendFriendView$5
  implements Runnable
{
  ProfileCardExtendFriendView$5(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void run()
  {
    if (bdgz.a(this.this$0.c, this.this$0.b.getWidth()) > 4)
    {
      this.this$0.c.setText(this.a.schoolName);
      ImageView localImageView = this.this$0.a;
      if (this.a.authState == 2L) {}
      for (int i = 2130844751;; i = 2130844752)
      {
        localImageView.setImageResource(i);
        this.this$0.a.setVisibility(0);
        if (ProfileCardExtendFriendView.e(this.this$0)) {
          this.this$0.a.setOnClickListener(new beso(this));
        }
        return;
      }
    }
    this.this$0.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5
 * JD-Core Version:    0.7.0.1
 */