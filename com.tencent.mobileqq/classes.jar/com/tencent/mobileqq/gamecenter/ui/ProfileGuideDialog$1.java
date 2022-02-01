package com.tencent.mobileqq.gamecenter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileGuideDialog$1
  implements View.OnClickListener
{
  ProfileGuideDialog$1(ProfileGuideDialog paramProfileGuideDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    GameCenterUnissoHandler.a().f();
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(ProfileGuideDialog.a(this.a), "1", "145", "920", "92005", "208814", "", "", "20", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.ProfileGuideDialog.1
 * JD-Core Version:    0.7.0.1
 */