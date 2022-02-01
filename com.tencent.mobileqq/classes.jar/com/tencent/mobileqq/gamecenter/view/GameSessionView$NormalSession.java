package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$NormalSession
  implements GameSessionView.SessionStyle
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  private void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null)
    {
      QLog.e(GameSessionView.a, 0, "[updateSession] info is null.");
      return;
    }
    GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, new GameSessionView.SessionInfoDecorator(paramGameCenterSessionInfo).a());
    String str;
    if (paramGameCenterSessionInfo.a() == 0)
    {
      this.b.setText(paramGameCenterSessionInfo.f() + "好友新消息");
      str = "[" + paramGameCenterSessionInfo.b() + "位好友请求] " + paramGameCenterSessionInfo.h() + ": " + paramGameCenterSessionInfo.i();
      this.d.setText(new QQText(str, 3, 16));
      if (!GameSessionView.a()) {
        this.e.setVisibility(4);
      }
    }
    for (;;)
    {
      this.c.setText(GameMsgUtil.a(paramGameCenterSessionInfo.a() * 1000L));
      return;
      this.e.setVisibility(0);
      this.e.setText("1");
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "action_set_clean_req_time", null);
      continue;
      this.b.setText(paramGameCenterSessionInfo.h());
      str = "[" + paramGameCenterSessionInfo.f() + "] " + paramGameCenterSessionInfo.i();
      this.d.setText(new QQText(str, 3, 16, -1));
      if (paramGameCenterSessionInfo.c() == 0)
      {
        this.e.setVisibility(4);
      }
      else
      {
        this.e.setVisibility(0);
        this.e.setText(GameMsgUtil.a(paramGameCenterSessionInfo.c()));
      }
    }
  }
  
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559283, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371854));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131377280);
    this.jdField_a_of_type_AndroidViewView.setId(2131367691);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(QQGameConstant.a(paramViewGroup.getContext()));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131364762));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.a(18.0F, paramViewGroup.getResources()));
    this.b = ((TextView)localView.findViewById(2131380481));
    this.c = ((TextView)localView.findViewById(2131380644));
    this.d = ((TextView)localView.findViewById(2131380461));
    this.e = ((TextView)localView.findViewById(2131380686));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a((GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).get(0));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramInt > 0)
    {
      paramList = String.format(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getResources().getString(2131695201), new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695185);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L)
    {
      QLog.i(GameSessionView.a, 1, "[onClick] click too frequently.");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_Long = l;
    GameSessionView.a(false);
    GameCenterSessionInfo localGameCenterSessionInfo;
    int k;
    switch (paramView.getId())
    {
    default: 
    case 2131367691: 
      do
      {
        GameMsgUtil.b(GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).getAccount(), this.jdField_a_of_type_Long);
        break;
      } while ((GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView) == null) || (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size() <= 0));
      localGameCenterSessionInfo = (GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).get(0);
      k = GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size();
      if (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size() > 2) {
        k = 3;
      }
      break;
    }
    for (;;)
    {
      int j;
      int i;
      if (localGameCenterSessionInfo.a() == 0)
      {
        if (!GameSessionView.a()) {
          break label566;
        }
        j = 0;
        i = 0;
      }
      for (;;)
      {
        GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getContext(), localGameCenterSessionInfo);
        GameMsgUtil.a(localGameCenterSessionInfo.e(), "1", "145", "920", "92001", "206342", i + "", localGameCenterSessionInfo.a() + "", GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView) + "", "20", "" + k, "", j + "");
        a(localGameCenterSessionInfo);
        break;
        j = localGameCenterSessionInfo.c();
        if (j > 0)
        {
          i = 0;
          continue;
          GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getContext(), null);
          if ((GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView) == null) || (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size() <= 0)) {
            break;
          }
          localGameCenterSessionInfo = (GameCenterSessionInfo)GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).get(0);
          i = GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size();
          if (GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView).size() > 2) {
            i = 3;
          }
          for (;;)
          {
            GameMsgUtil.a("", "1", "145", "920", "92001", "206342", localGameCenterSessionInfo.a() + "", GameSessionView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView) + "", "20", "" + i);
            break;
          }
        }
        i = 1;
        continue;
        label566:
        j = 0;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.NormalSession
 * JD-Core Version:    0.7.0.1
 */