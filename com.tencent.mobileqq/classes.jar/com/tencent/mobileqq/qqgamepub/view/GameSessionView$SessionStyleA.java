package com.tencent.mobileqq.qqgamepub.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameSessionView$SessionStyleA
  extends GameSessionView.ViewSwitcherSession<View>
{
  private TextView b;
  private int c;
  
  protected void a(View paramView, GameSessionView.WrappedMessage paramWrappedMessage)
  {
    super.a(paramView, paramWrappedMessage);
    GameSessionView.SessionInfoDecorator localSessionInfoDecorator = new GameSessionView.SessionInfoDecorator(paramWrappedMessage.a());
    CornerImageView localCornerImageView = (CornerImageView)paramView.findViewById(2131430739);
    paramView = (TextView)paramView.findViewById(2131448583);
    GameSessionView.a(this.this$0, localCornerImageView, localSessionInfoDecorator.a());
    paramView.setText(new QQText(String.format(this.a, new Object[] { localSessionInfoDecorator.b(), paramWrappedMessage.b.b }), 3, 16));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624915, paramViewGroup, false);
    a((ViewSwitcher)localView.findViewById(2131439744));
    this.b = ((TextView)localView.findViewById(2131448848));
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    this.b.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(paramInt));
    paramList = this.b;
    int i;
    if (paramInt > 0) {
      i = 0;
    } else {
      i = 4;
    }
    paramList.setVisibility(i);
    this.c = paramInt;
    Object localObject = d();
    if (localObject != null)
    {
      paramList = ((GameCenterSessionInfo)localObject).h();
      localObject = String.valueOf(((GameCenterSessionInfo)localObject).f());
    }
    else
    {
      paramList = "";
      localObject = paramList;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(paramList, "1", "145", "920", "92001", "207617", "0", (String)localObject, "", "", "", "", String.valueOf(this.c));
  }
  
  public View makeView()
  {
    View localView = LayoutInflater.from(this.this$0.getContext()).inflate(2131624910, c(), false);
    ((CornerImageView)localView.findViewById(2131430739)).setRadius(UIUtils.a(15.0F, this.this$0.getResources()));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
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
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", "145", "920", "92001", "207618", "0", (String)localObject, "", "", "", "", String.valueOf(this.c));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleA
 * JD-Core Version:    0.7.0.1
 */