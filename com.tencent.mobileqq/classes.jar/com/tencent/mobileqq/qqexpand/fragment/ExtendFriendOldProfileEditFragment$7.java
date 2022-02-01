package com.tencent.mobileqq.qqexpand.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.utils.DisplayUtils;

class ExtendFriendOldProfileEditFragment$7
  implements Runnable
{
  ExtendFriendOldProfileEditFragment$7(ExtendFriendOldProfileEditFragment paramExtendFriendOldProfileEditFragment, ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void run()
  {
    if (DisplayUtils.a(ExtendFriendOldProfileEditFragment.o(this.this$0), ExtendFriendOldProfileEditFragment.p(this.this$0).getWidth()) > 4)
    {
      ExtendFriendOldProfileEditFragment.o(this.this$0).setText(this.a.m);
      ImageView localImageView = ExtendFriendOldProfileEditFragment.q(this.this$0);
      int i;
      if (this.a.n == 2L) {
        i = 2130846614;
      } else {
        i = 2130846615;
      }
      localImageView.setImageResource(i);
      ExtendFriendOldProfileEditFragment.q(this.this$0).setVisibility(0);
      return;
    }
    ExtendFriendOldProfileEditFragment.q(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.7
 * JD-Core Version:    0.7.0.1
 */