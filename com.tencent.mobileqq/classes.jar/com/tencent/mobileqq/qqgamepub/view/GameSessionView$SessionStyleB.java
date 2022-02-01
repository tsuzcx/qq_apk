package com.tencent.mobileqq.qqgamepub.view;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameSessionView$SessionStyleB
  extends GameSessionView.ViewSwitcherSession<TextView>
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageViewWithCircle[] jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle = new CornerImageViewWithCircle[2];
  private TextView b;
  
  private GameSessionView$SessionStyleB(GameSessionView paramGameSessionView)
  {
    super(paramGameSessionView);
  }
  
  public int a()
  {
    return 15;
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559161, paramViewGroup, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject = a();
    String str;
    if (localObject != null)
    {
      str = ((GameCenterSessionInfo)localObject).e();
      localObject = String.valueOf(((GameCenterSessionInfo)localObject).a());
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
    View localView = a(paramViewGroup);
    a((ViewSwitcher)localView.findViewById(2131372239));
    this.b = ((TextView)localView.findViewById(2131379960));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[0] = ((CornerImageViewWithCircle)localView.findViewById(2131364649));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[1] = ((CornerImageViewWithCircle)localView.findViewById(2131364650));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[0].setRadius(UIUtils.a(a(), this.this$0.getResources()));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[1].setRadius(UIUtils.a(a(), this.this$0.getResources()));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[0].setCircle(UIUtils.a(a(), this.this$0.getResources()), UIUtils.a(a(), this.this$0.getResources()), UIUtils.a(a() - 0.5F, this.this$0.getResources()), -920584);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[1].setCircle(UIUtils.a(a(), this.this$0.getResources()), UIUtils.a(a(), this.this$0.getResources()), UIUtils.a(a(), this.this$0.getResources()), -920584);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[0].invalidate();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[1].invalidate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379773));
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  protected void a(TextView paramTextView, GameSessionView.WrappedMessage paramWrappedMessage)
  {
    super.a(paramTextView, paramWrappedMessage);
    GameSessionView.SessionInfoDecorator localSessionInfoDecorator = new GameSessionView.SessionInfoDecorator(paramWrappedMessage.a());
    paramWrappedMessage = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { localSessionInfoDecorator.b(), paramWrappedMessage.a.jdField_a_of_type_JavaLangString });
    paramTextView.setTextColor(Color.parseColor("#7f333333"));
    paramTextView.setText(new QQText(paramWrappedMessage, 3, 16));
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    this.jdField_a_of_type_Int = paramInt;
    int m = 0;
    int j = 0;
    Object localObject;
    int k;
    for (int i = 0; j < paramList.size(); i = k)
    {
      localObject = (GameCenterSessionInfo)paramList.get(j);
      k = i;
      if (((GameCenterSessionInfo)localObject).c() > 0)
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle.length)
        {
          localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)localObject);
          GameSessionView.a(this.this$0, this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[i], ((GameSessionView.SessionInfoDecorator)localObject).a());
          this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[i].setVisibility(0);
        }
        k = i + 1;
      }
      j += 1;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.this$0.getResources().getString(2131695192), new Object[] { Integer.valueOf(i) }));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695175);
      k = 0;
      j = i;
      i = k;
      while ((i < paramList.size()) && (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle.length))
      {
        localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)paramList.get(i));
        GameSessionView.a(this.this$0, this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[j], ((GameSessionView.SessionInfoDecorator)localObject).a());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqQqgamepubViewCornerImageViewWithCircle[j].setVisibility(0);
        j += 1;
        i += 1;
      }
    }
    this.b.setText(((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getUnreadStr(paramInt));
    paramList = this.b;
    if (paramInt > 0) {
      i = m;
    } else {
      i = 4;
    }
    paramList.setVisibility(i);
    a(paramInt);
  }
  
  public void b(int paramInt)
  {
    Object localObject = a();
    String str;
    if (localObject != null)
    {
      str = ((GameCenterSessionInfo)localObject).e();
      localObject = String.valueOf(((GameCenterSessionInfo)localObject).a());
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
    return LayoutInflater.from(this.this$0.getContext()).inflate(2131559156, a(), false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    b(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionStyleB
 * JD-Core Version:    0.7.0.1
 */