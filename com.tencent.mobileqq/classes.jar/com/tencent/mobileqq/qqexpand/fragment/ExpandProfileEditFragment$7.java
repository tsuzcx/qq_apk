package com.tencent.mobileqq.qqexpand.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.utils.DisplayUtils;

class ExpandProfileEditFragment$7
  implements Runnable
{
  ExpandProfileEditFragment$7(ExpandProfileEditFragment paramExpandProfileEditFragment, ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void run()
  {
    if (DisplayUtils.a(ExpandProfileEditFragment.a(this.this$0), ExpandProfileEditFragment.a(this.this$0).getWidth()) > 4)
    {
      ExpandProfileEditFragment.a(this.this$0).setText(this.a.d);
      ImageView localImageView = ExpandProfileEditFragment.a(this.this$0);
      int i;
      if (this.a.a == 2L) {
        i = 2130845173;
      } else {
        i = 2130845174;
      }
      localImageView.setImageResource(i);
      ExpandProfileEditFragment.a(this.this$0).setVisibility(0);
      return;
    }
    ExpandProfileEditFragment.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.7
 * JD-Core Version:    0.7.0.1
 */