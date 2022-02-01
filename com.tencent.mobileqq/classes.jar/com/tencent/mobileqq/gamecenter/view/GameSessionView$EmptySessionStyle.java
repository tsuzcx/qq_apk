package com.tencent.mobileqq.gamecenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$EmptySessionStyle
  implements GameSessionView.SessionStyle
{
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559287, paramViewGroup, false);
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    GameMsgUtil.a("", "1", "145", "920", "92001", "207615", "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    GameSessionView.a(this.a, this.a.getContext(), null);
    GameMsgUtil.b(GameSessionView.a(this.a).getAccount(), System.currentTimeMillis());
    GameMsgUtil.a("", "1", "145", "920", "92001", "207616", "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.EmptySessionStyle
 * JD-Core Version:    0.7.0.1
 */