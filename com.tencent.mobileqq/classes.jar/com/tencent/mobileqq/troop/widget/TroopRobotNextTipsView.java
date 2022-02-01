package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
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
    int i = AIOUtils.b(6.0F, getResources());
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364545);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130841644);
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
      this.b.setId(2131364546);
      this.b.setBackgroundResource(2130842589);
      this.b.setTextSize(2, 14.0F);
      this.b.setTextColor(jdField_a_of_type_Int);
      this.b.setGravity(17);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(11);
      paramContext.addRule(10);
      this.b.setPadding(i, 0, i, 0);
      addView(this.b, paramContext);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715538));
    this.b.setText(HardCodeUtil.a(2131715525));
    this.b.setOnClickListener(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = (TroopRobotManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    localObject2 = (ITroopRobotService)((QQAppInterface)localObject2).getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = ((ITroopRobotService)localObject2).hasNext(paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory = ((ITroopRobotService)localObject2).findSubscribeCategory(((TroopRobotManager)localObject1).a(paramChatMessage));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory;
    if (localObject1 != null)
    {
      localObject1 = ((oidb_0x496.RobotSubscribeCategory)localObject1).name.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory.next_wording.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (bool))
      {
        this.b.setVisibility(0);
        this.b.setText((CharSequence)localObject1);
      }
      else
      {
        this.b.setVisibility(8);
      }
      int i = BaseChatItemLayout.o;
      int j = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        i = BaseChatItemLayout.p;
        j = BaseChatItemLayout.o;
      }
      setPadding(i, 0, j, AIOUtils.b(10.0F, getContext().getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364546)
    {
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory != null) {
          localTroopRobotManager.a(getContext(), (BaseChatPie)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbOidb_0x496$RobotSubscribeCategory.next_content.get());
        } else {
          localTroopRobotManager.a(getContext(), (BaseChatPie)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.b.getText().toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView
 * JD-Core Version:    0.7.0.1
 */