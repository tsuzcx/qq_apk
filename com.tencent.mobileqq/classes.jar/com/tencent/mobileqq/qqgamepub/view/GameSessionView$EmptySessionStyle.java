package com.tencent.mobileqq.qqgamepub.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$EmptySessionStyle
  implements GameSessionView.SessionStyle
{
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624918, paramViewGroup, false);
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207615", "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    GameSessionView localGameSessionView = this.a;
    GameSessionView.a(localGameSessionView, localGameSessionView.getContext(), null);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(GameSessionView.a(this.a).getAccount(), System.currentTimeMillis());
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "145", "920", "92001", "207616", "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.EmptySessionStyle
 * JD-Core Version:    0.7.0.1
 */