package com.tencent.mobileqq.profilecard.bussiness.extendfriend;

import android.app.Dialog;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileExtendFriendComponent$4
  implements View.OnClickListener
{
  ProfileExtendFriendComponent$4(ProfileExtendFriendComponent paramProfileExtendFriendComponent, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (ExtendFriendManager.a(ProfileExtendFriendComponent.access$500(this.this$0).getCurrentAccountUin()))
    {
      localObject = ProfileGuideDialogUtils.a(ProfileExtendFriendComponent.access$600(this.this$0));
      int j = 1;
      int i = j;
      if ((ProfileExtendFriendComponent.access$700(this.this$0) instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)ProfileExtendFriendComponent.access$800(this.this$0)).e) {
          i = 2;
        }
      }
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((ProfileExtendFriendComponent.access$900(this.this$0) != null) && (!ProfileExtendFriendComponent.access$1000(this.this$0).isFinishing())) {
        ((Dialog)localObject).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.val$card);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
      PublicFragmentActivity.a(ProfileExtendFriendComponent.access$1100(this.this$0), localIntent, ExtendFriendEditFragment.class, 4097);
      ReportController.b(ProfileExtendFriendComponent.access$1200(this.this$0), "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent.4
 * JD-Core Version:    0.7.0.1
 */