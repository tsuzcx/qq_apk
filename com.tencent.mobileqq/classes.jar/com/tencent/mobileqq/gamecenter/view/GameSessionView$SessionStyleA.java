package com.tencent.mobileqq.gamecenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameSessionView$SessionStyleA
  extends GameSessionView.ViewSwitcherSession<View>
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  protected void a(View paramView, GameSessionView.WrappedMessage paramWrappedMessage)
  {
    super.a(paramView, paramWrappedMessage);
    GameSessionView.SessionInfoDecorator localSessionInfoDecorator = new GameSessionView.SessionInfoDecorator(paramWrappedMessage.a());
    CornerImageView localCornerImageView = (CornerImageView)paramView.findViewById(2131364762);
    paramView = (TextView)paramView.findViewById(2131380461);
    GameSessionView.a(this.this$0, localCornerImageView, localSessionInfoDecorator.a());
    paramView.setText(new QQText(String.format(this.jdField_a_of_type_JavaLangString, new Object[] { localSessionInfoDecorator.b(), paramWrappedMessage.a.jdField_a_of_type_JavaLangString }), 3, 16));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559284, paramViewGroup, false);
    a((ViewSwitcher)localView.findViewById(2131372661));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380686));
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(GameMsgUtil.a(paramInt));
    paramList = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramInt > 0) {}
    for (int i = 0;; i = 4)
    {
      paramList.setVisibility(i);
      this.jdField_a_of_type_Int = paramInt;
      GameCenterSessionInfo localGameCenterSessionInfo = a();
      paramList = "";
      String str = "";
      if (localGameCenterSessionInfo != null)
      {
        paramList = localGameCenterSessionInfo.e();
        str = String.valueOf(localGameCenterSessionInfo.a());
      }
      GameMsgUtil.a(paramList, "1", "145", "920", "92001", "207617", "0", str, "", "", "", "", String.valueOf(this.jdField_a_of_type_Int));
      return;
    }
  }
  
  public View makeView()
  {
    View localView = LayoutInflater.from(this.this$0.getContext()).inflate(2131559279, a(), false);
    ((CornerImageView)localView.findViewById(2131364762)).setRadius(AIOUtils.a(15.0F, this.this$0.getResources()));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    GameCenterSessionInfo localGameCenterSessionInfo = a();
    String str1 = "";
    String str2 = "";
    if (localGameCenterSessionInfo != null)
    {
      str1 = localGameCenterSessionInfo.e();
      str2 = String.valueOf(localGameCenterSessionInfo.a());
    }
    GameMsgUtil.a(str1, "1", "145", "920", "92001", "207618", "0", str2, "", "", "", "", String.valueOf(this.jdField_a_of_type_Int));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionStyleA
 * JD-Core Version:    0.7.0.1
 */