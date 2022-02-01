package com.tencent.mobileqq.gamecenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;

class GameSessionView$SessionStyleB4Hippy
  extends GameSessionView.SessionStyleB
{
  private GameSessionView$SessionStyleB4Hippy(GameSessionView paramGameSessionView)
  {
    super(paramGameSessionView, null);
  }
  
  public int a()
  {
    return 10;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559286, paramViewGroup, false);
  }
  
  public void a(int paramInt)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = a();
    String str1 = "";
    String str2 = "";
    if (localGameCenterSessionInfo != null)
    {
      str1 = localGameCenterSessionInfo.e();
      str2 = String.valueOf(localGameCenterSessionInfo.a());
    }
    GameMsgUtil.a(str1, "1", "145", "920", "92001", "207619", "0", str2, "", "", "", "", String.valueOf(paramInt), "3");
  }
  
  public void b(int paramInt)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = a();
    String str1 = "";
    String str2 = "";
    if (localGameCenterSessionInfo != null)
    {
      str1 = localGameCenterSessionInfo.e();
      str2 = String.valueOf(localGameCenterSessionInfo.a());
    }
    GameMsgUtil.a(str1, "1", "145", "920", "92001", "207620", "0", str2, "", "", "", "", String.valueOf(paramInt), "3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionStyleB4Hippy
 * JD-Core Version:    0.7.0.1
 */