package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileNameView$1
  implements View.OnClickListener
{
  ProfileNameView$1(ProfileNameView paramProfileNameView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    String str = ((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).getTroopMemberHonorUrl(this.a.troopUin, this.a.allInOne.uin);
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.getContext().startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800A708", "0X800A708", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView.1
 * JD-Core Version:    0.7.0.1
 */