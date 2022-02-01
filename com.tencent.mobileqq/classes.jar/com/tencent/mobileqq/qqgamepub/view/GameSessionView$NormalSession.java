package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
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
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqQqgamepubViewCornerImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  private void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null)
    {
      QLog.e(GameSessionView.a, 2, "[updateSession] info is null.");
      return;
    }
    GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView, this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewCornerImageView, new GameSessionView.SessionInfoDecorator(paramGameCenterSessionInfo).a());
    Object localObject;
    if (paramGameCenterSessionInfo.a() == 0)
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramGameCenterSessionInfo.f());
      localStringBuilder.append("好友新消息");
      ((TextView)localObject).setText(localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.b());
      ((StringBuilder)localObject).append("位好友请求] ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.h());
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.i());
      localObject = ((StringBuilder)localObject).toString();
      this.d.setText(new QQText((CharSequence)localObject, 3, 16));
      if (!GameSessionView.a())
      {
        this.e.setVisibility(4);
      }
      else
      {
        this.e.setVisibility(0);
        this.e.setText("1");
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "action_set_clean_req_time", null);
      }
    }
    else
    {
      this.b.setText(paramGameCenterSessionInfo.h());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.f());
      ((StringBuilder)localObject).append("] ");
      ((StringBuilder)localObject).append(paramGameCenterSessionInfo.i());
      localObject = ((StringBuilder)localObject).toString();
      this.d.setText(new QQText((CharSequence)localObject, 3, 16, -1));
      if (paramGameCenterSessionInfo.c() == 0)
      {
        this.e.setVisibility(4);
      }
      else
      {
        this.e.setVisibility(0);
        this.e.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(paramGameCenterSessionInfo.c()));
      }
    }
    this.c.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getTimeString(paramGameCenterSessionInfo.a() * 1000L));
  }
  
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559159, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371476));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376737);
    this.jdField_a_of_type_AndroidViewView.setId(2131367444);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(GamePubAccountConstant.a(paramViewGroup.getContext()));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewCornerImageView = ((CornerImageView)localView.findViewById(2131364652));
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewCornerImageView.setRadius(UIUtils.a(18.0F, paramViewGroup.getResources()));
    this.b = ((TextView)localView.findViewById(2131379784));
    this.c = ((TextView)localView.findViewById(2131379924));
    this.d = ((TextView)localView.findViewById(2131379773));
    this.e = ((TextView)localView.findViewById(2131379960));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a((GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).get(0));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramInt > 0)
    {
      paramList = String.format(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.getResources().getString(2131695193), new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695176);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L)
    {
      QLog.i(GameSessionView.a, 1, "[onClick] click too frequently.");
    }
    else
    {
      this.jdField_a_of_type_Long = l;
      int i = 0;
      int k = 0;
      GameSessionView.a(false);
      int j = paramView.getId();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (j == 2131367444)
      {
        if ((GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView) != null) && (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size() > 0))
        {
          localObject1 = (GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).get(0);
          j = GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size();
          if (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size() > 2) {
            j = 3;
          }
          if (((GameCenterSessionInfo)localObject1).a() == 0)
          {
            if (GameSessionView.a()) {
              i = k;
            } else {
              i = 1;
            }
            k = 0;
          }
          else
          {
            k = ((GameCenterSessionInfo)localObject1).c();
            if (k <= 0) {
              i = 1;
            }
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
          GameSessionView.a((GameSessionView)localObject2, ((GameSessionView)localObject2).getContext(), (GameCenterSessionInfo)localObject1);
          localObject2 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          localObject3 = ((GameCenterSessionInfo)localObject1).e();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((GameCenterSessionInfo)localObject1).a());
          ((StringBuilder)localObject5).append("");
          localObject5 = ((StringBuilder)localObject5).toString();
          Object localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView));
          ((StringBuilder)localObject6).append("");
          localObject6 = ((StringBuilder)localObject6).toString();
          Object localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("");
          ((StringBuilder)localObject7).append(j);
          localObject7 = ((StringBuilder)localObject7).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(k);
          localStringBuilder.append("");
          ((IGameMsgHelperApi)localObject2).reportForGameMsg((String)localObject3, "1", "145", "920", "92001", "206342", (String)localObject4, (String)localObject5, (String)localObject6, "20", (String)localObject7, "", localStringBuilder.toString());
          a((GameCenterSessionInfo)localObject1);
        }
      }
      else if (j == 2131371476)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
        GameSessionView.a((GameSessionView)localObject1, ((GameSessionView)localObject1).getContext(), null);
        if ((GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView) != null) && (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size() > 0))
        {
          localObject2 = (GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).get(0);
          i = GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size();
          if (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).size() > 2) {
            i = 3;
          }
          localObject1 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((GameCenterSessionInfo)localObject2).a());
          ((StringBuilder)localObject3).append("");
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView));
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(i);
          ((IGameMsgHelperApi)localObject1).reportForGameMsg("", "1", "145", "920", "92001", "206342", (String)localObject2, (String)localObject3, "20", ((StringBuilder)localObject4).toString());
        }
      }
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).setLastGameSessionClicked(GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView).getAccount(), this.jdField_a_of_type_Long);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.NormalSession
 * JD-Core Version:    0.7.0.1
 */