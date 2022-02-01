package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.onPreShowListener;

class ProfileTitleContainer$7
  implements ActionSheet.onPreShowListener
{
  ProfileTitleContainer$7(ProfileTitleContainer paramProfileTitleContainer, ActionSheet paramActionSheet) {}
  
  public void onPreShow()
  {
    View localView = this.val$actionSheet.mContentContainer.findViewById(1);
    if (localView == null) {
      localView = null;
    } else {
      localView = localView.findViewById(2131361989);
    }
    if (localView != null)
    {
      localView = ProfileTitleContainer.access$700(this.this$0, localView, 5, 5, 7, 5);
      if (localView != null) {
        new RedTouch(ProfileTitleContainer.access$1900(this.this$0), localView).b(53).a().a(ProfileCardUtil.a());
      }
    }
    this.val$actionSheet.setOnPreShowListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.7
 * JD-Core Version:    0.7.0.1
 */