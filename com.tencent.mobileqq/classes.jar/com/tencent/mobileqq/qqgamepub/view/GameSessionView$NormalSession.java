package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountConstant;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$NormalSession
  implements GameSessionView.SessionStyle
{
  private View b;
  private TextView c;
  private long d;
  private CornerImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  private void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null)
    {
      QLog.e(GameSessionView.a, 2, "[updateSession] info is null.");
      return;
    }
    GameSessionView.a(this.a, this.e, new GameSessionView.SessionInfoDecorator(paramGameCenterSessionInfo).a());
    Object localObject;
    if (paramGameCenterSessionInfo.f() == 0)
    {
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramGameCenterSessionInfo.i());
      localStringBuilder.append("好友新消息");
      ((TextView)localObject).setText(localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.l());
      ((StringBuilder)localObject).append("位好友请求] ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.k());
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.m());
      localObject = ((StringBuilder)localObject).toString();
      this.h.setText(new QQText((CharSequence)localObject, 3, 16));
      if (!GameSessionView.c())
      {
        this.i.setVisibility(4);
      }
      else
      {
        this.i.setVisibility(0);
        this.i.setText("1");
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "action_set_clean_req_time", null);
      }
    }
    else
    {
      this.f.setText(paramGameCenterSessionInfo.k());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.i());
      ((StringBuilder)localObject).append("] ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.m());
      localObject = ((StringBuilder)localObject).toString();
      this.h.setText(new QQText((CharSequence)localObject, 3, 16, -1));
      if (paramGameCenterSessionInfo.o() == 0)
      {
        this.i.setVisibility(4);
      }
      else
      {
        this.i.setVisibility(0);
        this.i.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(paramGameCenterSessionInfo.o()));
      }
    }
    this.g.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getTimeString(paramGameCenterSessionInfo.n() * 1000L));
  }
  
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624914, paramViewGroup, false);
    this.c = ((TextView)localView.findViewById(2131438851));
    this.b = localView.findViewById(2131445025);
    this.b.setId(2131433947);
    this.b.setBackgroundDrawable(GamePubAccountConstant.a(paramViewGroup.getContext()));
    this.e = ((CornerImageView)localView.findViewById(2131430739));
    this.e.setRadius(UIUtils.a(18.0F, paramViewGroup.getResources()));
    this.f = ((TextView)localView.findViewById(2131448606));
    this.g = ((TextView)localView.findViewById(2131448805));
    this.h = ((TextView)localView.findViewById(2131448583));
    this.i = ((TextView)localView.findViewById(2131448848));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    this.b.setVisibility(0);
    a((GameCenterSessionInfo)GameSessionView.e(this.a).get(0));
    this.c.setVisibility(0);
    if (paramInt > 0)
    {
      paramList = String.format(this.a.getResources().getString(2131892926), new Object[] { Integer.valueOf(paramInt) });
      this.c.setText(paramList);
      return;
    }
    this.c.setText(2131892909);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.d < 2000L)
    {
      QLog.i(GameSessionView.a, 1, "[onClick] click too frequently.");
    }
    else
    {
      this.d = l;
      int j = 0;
      int m = 0;
      GameSessionView.a(false);
      int k = paramView.getId();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (k == 2131433947)
      {
        if ((GameSessionView.e(this.a) != null) && (GameSessionView.e(this.a).size() > 0))
        {
          localObject1 = (GameCenterSessionInfo)GameSessionView.e(this.a).get(0);
          k = GameSessionView.e(this.a).size();
          if (GameSessionView.e(this.a).size() > 2) {
            k = 3;
          }
          if (((GameCenterSessionInfo)localObject1).f() == 0)
          {
            if (GameSessionView.c()) {
              j = m;
            } else {
              j = 1;
            }
            m = 0;
          }
          else
          {
            m = ((GameCenterSessionInfo)localObject1).o();
            if (m <= 0) {
              j = 1;
            }
          }
          localObject2 = this.a;
          GameSessionView.a((GameSessionView)localObject2, ((GameSessionView)localObject2).getContext(), (GameCenterSessionInfo)localObject1);
          localObject2 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          localObject3 = ((GameCenterSessionInfo)localObject1).h();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(j);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((GameCenterSessionInfo)localObject1).f());
          ((StringBuilder)localObject5).append("");
          localObject5 = ((StringBuilder)localObject5).toString();
          Object localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(GameSessionView.d(this.a));
          ((StringBuilder)localObject6).append("");
          localObject6 = ((StringBuilder)localObject6).toString();
          Object localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("");
          ((StringBuilder)localObject7).append(k);
          localObject7 = ((StringBuilder)localObject7).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(m);
          localStringBuilder.append("");
          ((IGameMsgHelperApi)localObject2).reportForGameMsg((String)localObject3, "1", "145", "920", "92001", "206342", (String)localObject4, (String)localObject5, (String)localObject6, "20", (String)localObject7, "", localStringBuilder.toString());
          a((GameCenterSessionInfo)localObject1);
        }
      }
      else if (k == 2131438851)
      {
        localObject1 = this.a;
        GameSessionView.a((GameSessionView)localObject1, ((GameSessionView)localObject1).getContext(), null);
        if ((GameSessionView.e(this.a) != null) && (GameSessionView.e(this.a).size() > 0))
        {
          localObject2 = (GameCenterSessionInfo)GameSessionView.e(this.a).get(0);
          j = GameSessionView.e(this.a).size();
          if (GameSessionView.e(this.a).size() > 2) {
            j = 3;
          }
          localObject1 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((GameCenterSessionInfo)localObject2).f());
          ((StringBuilder)localObject3).append("");
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(GameSessionView.d(this.a));
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(j);
          ((IGameMsgHelperApi)localObject1).reportForGameMsg("", "1", "145", "920", "92001", "206342", (String)localObject2, (String)localObject3, "20", ((StringBuilder)localObject4).toString());
        }
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(GameSessionView.a(this.a).getAccount(), this.d);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.NormalSession
 * JD-Core Version:    0.7.0.1
 */