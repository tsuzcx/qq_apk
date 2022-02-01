package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameSessionView$SessionStyleB
  extends GameSessionView.ViewSwitcherSession<TextView>
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageViewWithCircle[] jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle = new CornerImageViewWithCircle[2];
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
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559285, paramViewGroup, false);
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
    GameMsgUtil.a(str1, "1", "145", "920", "92001", "207619", "0", str2, "", "", "", "", String.valueOf(paramInt));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = a(paramViewGroup);
    a((ViewSwitcher)localView.findViewById(2131372661));
    this.b = ((TextView)localView.findViewById(2131380686));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[0] = ((CornerImageViewWithCircle)localView.findViewById(2131364759));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[1] = ((CornerImageViewWithCircle)localView.findViewById(2131364760));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[0].setRadius(AIOUtils.a(a(), this.this$0.getResources()));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[1].setRadius(AIOUtils.a(a(), this.this$0.getResources()));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[0].setCircle(AIOUtils.a(a(), this.this$0.getResources()), AIOUtils.a(a(), this.this$0.getResources()), AIOUtils.a(a() - 0.5F, this.this$0.getResources()), -920584);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[1].setCircle(AIOUtils.a(a(), this.this$0.getResources()), AIOUtils.a(a(), this.this$0.getResources()), AIOUtils.a(a(), this.this$0.getResources()), -920584);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[0].invalidate();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[1].invalidate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380461));
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
    int m = 0;
    super.a(paramList, paramInt);
    this.jdField_a_of_type_Int = paramInt;
    int j = 0;
    Object localObject;
    int k;
    for (int i = 0; j < paramList.size(); i = k)
    {
      localObject = (GameCenterSessionInfo)paramList.get(j);
      k = i;
      if (((GameCenterSessionInfo)localObject).c() > 0)
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle.length)
        {
          localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)localObject);
          GameSessionView.a(this.this$0, this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[i], ((GameSessionView.SessionInfoDecorator)localObject).a());
          this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[i].setVisibility(0);
        }
        k = i + 1;
      }
      j += 1;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.this$0.getResources().getString(2131695200), new Object[] { Integer.valueOf(i) }));
      this.b.setText(GameMsgUtil.a(paramInt));
      paramList = this.b;
      if (paramInt <= 0) {
        break label290;
      }
    }
    label290:
    for (i = m;; i = 4)
    {
      paramList.setVisibility(i);
      a(paramInt);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695184);
      k = 0;
      j = i;
      i = k;
      while ((i < paramList.size()) && (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle.length))
      {
        localObject = new GameSessionView.SessionInfoDecorator((GameCenterSessionInfo)paramList.get(i));
        GameSessionView.a(this.this$0, this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[j], ((GameSessionView.SessionInfoDecorator)localObject).a());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterViewCornerImageViewWithCircle[j].setVisibility(0);
        j += 1;
        i += 1;
      }
      break;
    }
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
    GameMsgUtil.a(str1, "1", "145", "920", "92001", "207620", "0", str2, "", "", "", "", String.valueOf(paramInt));
  }
  
  public View makeView()
  {
    return LayoutInflater.from(this.this$0.getContext()).inflate(2131559280, a(), false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    b(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionStyleB
 * JD-Core Version:    0.7.0.1
 */