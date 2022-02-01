package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileExtendFriendComponent$5
  implements View.OnClickListener
{
  ProfileExtendFriendComponent$5(ProfileExtendFriendComponent paramProfileExtendFriendComponent, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((ProfileExtendFriendComponent.access$1300(this.this$0) != null) && (ProfileExtendFriendComponent.access$1300(this.this$0).isShowing())) {
        ProfileExtendFriendComponent.access$1300(this.this$0).dismiss();
      }
      if (TextUtils.isEmpty(this.val$card.declaration))
      {
        ReportController.b(ProfileExtendFriendComponent.access$1400(this.this$0), "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
      }
      else
      {
        ReportController.b(ProfileExtendFriendComponent.access$1500(this.this$0), "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
        continue;
        if (TextUtils.isEmpty(this.val$card.declaration)) {
          PublicFragmentActivity.a(ProfileExtendFriendComponent.access$1600(this.this$0), ExtendFriendEditFragment.class);
        }
        for (;;)
        {
          if ((ProfileExtendFriendComponent.access$1300(this.this$0) != null) && (ProfileExtendFriendComponent.access$1300(this.this$0).isShowing())) {
            ProfileExtendFriendComponent.access$1300(this.this$0).dismiss();
          }
          if (!TextUtils.isEmpty(this.val$card.declaration)) {
            break label284;
          }
          ReportController.b(ProfileExtendFriendComponent.access$1900(this.this$0), "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
          break;
          Intent localIntent = InterestSwitchEditActivity.a(ProfileExtendFriendComponent.access$1700(this.this$0));
          ProfileExtendFriendComponent.access$1800(this.this$0).startActivityForResult(localIntent, 1022);
        }
        label284:
        ReportController.b(ProfileExtendFriendComponent.access$2000(this.this$0), "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.5
 * JD-Core Version:    0.7.0.1
 */