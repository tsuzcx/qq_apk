package com.tencent.mobileqq.profile;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileCardShareHelper$2
  implements AdapterView.OnItemClickListener
{
  ProfileCardShareHelper$2(ProfileCardShareHelper paramProfileCardShareHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ProfileCardShareHelper.d(this.a).isShowing()) {
      ProfileCardShareHelper.d(this.a).dismiss();
    }
    int i = -1;
    int j = (int)paramLong;
    if (j != 0)
    {
      if (j == 1)
      {
        ProfileCardShareHelper.f(this.a);
        i = 2;
      }
    }
    else
    {
      ProfileCardShareHelper.e(this.a);
      i = 0;
    }
    if (ProfileCardShareHelper.g(this.a) != null) {
      ProfileCardShareHelper.g(this.a).a(i, ProfileCardShareHelper.a(this.a));
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.2
 * JD-Core Version:    0.7.0.1
 */