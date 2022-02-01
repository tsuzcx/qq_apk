package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import avdu;
import avfe;
import avfg;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo.SimpleMessage;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameSessionView$SessionStyleB
  extends GameSessionView.ViewSwitcherSession<TextView>
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageView[] jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView = new CornerImageView[2];
  private TextView b;
  
  private GameSessionView$SessionStyleB(GameSessionView paramGameSessionView)
  {
    super(paramGameSessionView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559249, paramViewGroup, false);
    a((ViewSwitcher)localView.findViewById(2131372351));
    this.b = ((TextView)localView.findViewById(2131380246));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[0] = ((CornerImageView)localView.findViewById(2131364645));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[1] = ((CornerImageView)localView.findViewById(2131364646));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[0].setRadius(AIOUtils.dp2px(15.0F, this.this$0.getResources()));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[1].setRadius(AIOUtils.dp2px(15.0F, this.this$0.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380029));
    localView.setOnClickListener(this);
    paramViewGroup.addView(localView);
  }
  
  protected void a(TextView paramTextView, avfg paramavfg)
  {
    super.a(paramTextView, paramavfg);
    avfe localavfe = new avfe(paramavfg.a());
    paramTextView.setText(new QQText(String.format(this.jdField_a_of_type_JavaLangString, new Object[] { localavfe.b(), paramavfg.a.jdField_a_of_type_JavaLangString }), 3, 16));
  }
  
  public void a(List<GameCenterSessionInfo> paramList, int paramInt)
  {
    int m = 0;
    super.a(paramList, paramInt);
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    Object localObject;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      localObject = (GameCenterSessionInfo)paramList.get(i);
      k = j;
      if (((GameCenterSessionInfo)localObject).c() > 0)
      {
        if (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView.length)
        {
          localObject = new avfe((GameCenterSessionInfo)localObject);
          GameSessionView.a(this.this$0, this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[j], ((avfe)localObject).a());
          this.jdField_a_of_type_ArrayOfComTencentMobileqqProfilePersonalityLabelCornerImageView[j].setVisibility(0);
        }
        k = j + 1;
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.this$0.getResources().getString(2131694961), new Object[] { Integer.valueOf(j) }));
    this.b.setText(avdu.a(paramInt));
    paramList = this.b;
    if (paramInt > 0) {}
    for (paramInt = m;; paramInt = 4)
    {
      paramList.setVisibility(paramInt);
      GameCenterSessionInfo localGameCenterSessionInfo = a();
      paramList = "";
      localObject = "";
      if (localGameCenterSessionInfo != null)
      {
        paramList = localGameCenterSessionInfo.e();
        localObject = String.valueOf(localGameCenterSessionInfo.a());
      }
      avdu.a(paramList, "1", "145", "920", "92001", "207619", "0", (String)localObject, "", "", "", "", String.valueOf(this.jdField_a_of_type_Int));
      return;
    }
  }
  
  public View makeView()
  {
    return LayoutInflater.from(this.this$0.getContext()).inflate(2131559244, a(), false);
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
    avdu.a(str1, "1", "145", "920", "92001", "207620", "0", str2, "", "", "", "", String.valueOf(this.jdField_a_of_type_Int));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionStyleB
 * JD-Core Version:    0.7.0.1
 */