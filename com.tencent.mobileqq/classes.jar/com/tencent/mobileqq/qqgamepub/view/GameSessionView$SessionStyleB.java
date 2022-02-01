package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.graphics.Color;
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

class GameSessionView$SessionStyleB
  extends GameSessionView.ViewSwitcherSession<TextView>
{
  private CornerImageViewWithCircle[] b = new CornerImageViewWithCircle[2];
  private TextView c;
  private TextView d;
  private int e;
  
  private GameSessionView$SessionStyleB(GameSessionView paramGameSessionView)
  {
    super(paramGameSessionView);
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
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", "145", "920", "92001", "207619", "0", (String)localObject, "", "", "", "", String.valueOf(paramInt));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = b(paramViewGroup);
    a((ViewSwitcher)localView.findViewById(2131439744));
    this.d = ((TextView)localView.findViewById(2131448848));
    this.b[0] = ((CornerImageViewWithCircle)localView.findViewById(2131430736));
    this.b[1] = ((CornerImageViewWithCircle)localView.findViewById(2131430737));
    this.b[0].setRadius(UIUtils.a(b(), this.this$0.getResources()));
    this.b[1].setRadius(UIUtils.a(b(), this.this$0.getResources()));
    this.b[0].setCircle(UIUtils.a(b(), this.this$0.getResources()), UIUtils.a(b(), this.this$0.getResources()), UIUtils.a(b() - 0.5F, this.this$0.getResources()), -920584);
    this.b[1].setCircle(UIUtils.a(b(), this.this$0.getResources()), UIUtils.a(b(), this.this$0.getResources()), UIUtils.a(b(), this.this$0.getResources()), -920584);
    this.b[0].invalidate();
    this.b[1].invalidate();
    this.c = ((TextView)localView.findViewById(2131448583));
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  protected void a(TextView paramTextView, GameSessionView.WrappedMessage paramWrappedMessage)
  {
    super.a(paramTextView, paramWrappedMessage);
    GameSessionView.SessionInfoDecorator localSessionInfoDecorator = new GameSessionView.SessionInfoDecorator(paramWrappedMessage.a());
    paramWrappedMessage = String.format(this.a, new Object[] { localSessionInfoDecorator.b(), paramWrappedMessage.b.b });
    paramTextView.setTextColor(Color.parseColor("#7f333333"));
    paramTextView.setText(new QQText(paramWrappedMessage, 3, 16));
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    this.e = paramInt;
    int m = 0;
    int j = 0;
    Object localObject;
    int k;
    for (int i = 0; j < paramList.size(); i = k)
    {
      localObject = (GameCenterSessionInfo)paramList.get(j);
      k = i;
      if (((GameCenterSessionInfo)localObject).o() > 0)
      {
        if (i < this.b.length)
        {
          localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)localObject);
          GameSessionView.a(this.this$0, this.b[i], ((GameSessionView.SessionInfoDecorator)localObject).a());
          this.b[i].setVisibility(0);
        }
        k = i + 1;
      }
      j += 1;
    }
    if (i > 0)
    {
      this.c.setText(String.format(this.this$0.getResources().getString(2131892925), new Object[] { Integer.valueOf(i) }));
    }
    else
    {
      this.c.setText(2131892908);
      k = 0;
      j = i;
      i = k;
      while ((i < paramList.size()) && (j < this.b.length))
      {
        localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)paramList.get(i));
        GameSessionView.a(this.this$0, this.b[j], ((GameSessionView.SessionInfoDecorator)localObject).a());
        this.b[j].setVisibility(0);
        j += 1;
        i += 1;
      }
    }
    this.d.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(paramInt));
    paramList = this.d;
    if (paramInt > 0) {
      i = m;
    } else {
      i = 4;
    }
    paramList.setVisibility(i);
    a(paramInt);
  }
  
  public int b()
  {
    return 15;
  }
  
  public View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624916, paramViewGroup, false);
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
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "1", "145", "920", "92001", "207620", "0", (String)localObject, "", "", "", "", String.valueOf(paramInt));
  }
  
  public View makeView()
  {
    return LayoutInflater.from(this.this$0.getContext()).inflate(2131624911, c(), false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    b(this.e);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
 * JD-Core Version:    0.7.0.1
 */