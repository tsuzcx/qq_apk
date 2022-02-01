package com.tencent.mobileqq.extendfriend.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhmg;

class ExtendFriendProfileEditFragment$7
  implements Runnable
{
  ExtendFriendProfileEditFragment$7(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment, ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void run()
  {
    if (bhmg.a(ExtendFriendProfileEditFragment.a(this.this$0), ExtendFriendProfileEditFragment.a(this.this$0).getWidth()) > 4)
    {
      ExtendFriendProfileEditFragment.a(this.this$0).setText(this.a.d);
      ImageView localImageView = ExtendFriendProfileEditFragment.b(this.this$0);
      if (this.a.a == 2L) {}
      for (int i = 2130845158;; i = 2130845159)
      {
        localImageView.setImageResource(i);
        ExtendFriendProfileEditFragment.b(this.this$0).setVisibility(0);
        return;
      }
    }
    ExtendFriendProfileEditFragment.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.7
 * JD-Core Version:    0.7.0.1
 */