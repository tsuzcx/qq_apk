package com.tencent.mobileqq.qqgamepub.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qroute.QRoute;

class GameSessionView$SessionStyleB4Hippy
  extends GameSessionView.SessionStyleB
{
  private GameSessionView$SessionStyleB4Hippy(GameSessionView paramGameSessionView)
  {
    super(paramGameSessionView, null);
  }
  
  public void a(int paramInt)
  {
    Object localObject = d();
    String str;
    if (localObject != null)
    {
      str = ((GameCenterSessionInfo)localObject).h();
      localObject = String.valueOf(((GameCenterSessionInfo)localObject).f());
    }
    else
    {
      str = "";
      localObject = str;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", "145", "920", "92001", "207619", "0", (String)localObject, "", "", "", "", String.valueOf(paramInt), "3");
  }
  
  public int b()
  {
    return 10;
  }
  
  public View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624917, paramViewGroup, false);
  }
  
  public void b(int paramInt)
  {
    Object localObject = d();
    String str;
    if (localObject != null)
    {
      str = ((GameCenterSessionInfo)localObject).h();
      localObject = String.valueOf(((GameCenterSessionInfo)localObject).f());
    }
    else
    {
      str = "";
      localObject = str;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", "145", "920", "92001", "207620", "0", (String)localObject, "", "", "", "", String.valueOf(paramInt), "3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB4Hippy
 * JD-Core Version:    0.7.0.1
 */