package com.tencent.mobileqq.troop.widget;

import agej;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import bgty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopRobotNextTipsView
  extends RelativeLayout
  implements View.OnClickListener
{
  static int jdField_a_of_type_Int = Color.parseColor("#12B7F5");
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  oidb_0x496.RobotSubscribeCategory jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory;
  TextView b;
  
  public TroopRobotNextTipsView(Context paramContext1, Context paramContext2, QQAppInterface paramQQAppInterface)
  {
    this(paramContext1, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext2;
  }
  
  private TroopRobotNextTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = agej.a(6.0F, getResources());
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364447);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841569);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(9);
      paramContext.addRule(10);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    }
    if (this.b == null)
    {
      this.b = new TextView(getContext());
      this.b.setId(2131364448);
      this.b.setBackgroundResource(2130842468);
      this.b.setTextSize(2, 14.0F);
      this.b.setTextColor(jdField_a_of_type_Int);
      this.b.setGravity(17);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(11);
      paramContext.addRule(10);
      this.b.setPadding(i, 0, i, 0);
      addView(this.b, paramContext);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131714540));
    this.b.setText(anzj.a(2131714527));
    this.b.setOnClickListener(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    Object localObject = (bgty)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(203);
    boolean bool = ((bgty)localObject).c(paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory = ((bgty)localObject).a(((bgty)localObject).a(paramChatMessage));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory.name.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory.next_wording.get();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bool)) {
          break label189;
        }
        this.b.setVisibility(0);
        this.b.setText((CharSequence)localObject);
      }
      for (;;)
      {
        int j = BaseChatItemLayout.o;
        int i = BaseChatItemLayout.p;
        if (paramChatMessage.isSend())
        {
          j = BaseChatItemLayout.p;
          i = BaseChatItemLayout.o;
        }
        setPadding(j, 0, i, agej.a(10.0F, getContext().getResources()));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label189:
        this.b.setVisibility(8);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bgty localbgty = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory != null) {
          localbgty.a(getContext(), (BaseChatPie)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory.next_content.get());
        } else {
          localbgty.a(getContext(), (BaseChatPie)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.b.getText().toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView
 * JD-Core Version:    0.7.0.1
 */