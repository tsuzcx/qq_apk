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
  static int g = Color.parseColor("#12B7F5");
  TextView a;
  TextView b;
  QQAppInterface c;
  ChatMessage d;
  Context e;
  oidb_0x496.RobotSubscribeCategory f;
  
  public TroopRobotNextTipsView(Context paramContext1, Context paramContext2, QQAppInterface paramQQAppInterface)
  {
    this(paramContext1, null);
    this.c = paramQQAppInterface;
    this.e = paramContext2;
  }
  
  private TroopRobotNextTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = AIOUtils.b(6.0F, getResources());
    if (this.a == null)
    {
      this.a = new TextView(getContext());
      this.a.setId(2131430603);
      this.a.setBackgroundResource(2130842559);
      this.a.setTextSize(2, 13.0F);
      this.a.setTextColor(-1);
      this.a.setGravity(17);
      this.a.setPadding(i, 0, i, 0);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(9);
      paramContext.addRule(10);
      addView(this.a, paramContext);
    }
    if (this.b == null)
    {
      this.b = new TextView(getContext());
      this.b.setId(2131430604);
      this.b.setBackgroundResource(2130843542);
      this.b.setTextSize(2, 14.0F);
      this.b.setTextColor(g);
      this.b.setGravity(17);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(11);
      paramContext.addRule(10);
      this.b.setPadding(i, 0, i, 0);
      addView(this.b, paramContext);
    }
    this.a.setText(HardCodeUtil.a(2131913010));
    this.b.setText(HardCodeUtil.a(2131912998));
    this.b.setOnClickListener(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.d = paramChatMessage;
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = (TroopRobotManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    localObject2 = (ITroopRobotService)((QQAppInterface)localObject2).getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = ((ITroopRobotService)localObject2).hasNext(paramChatMessage);
    this.f = ((ITroopRobotService)localObject2).findSubscribeCategory(((TroopRobotManager)localObject1).a(paramChatMessage));
    localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject1 = ((oidb_0x496.RobotSubscribeCategory)localObject1).name.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.a.setText((CharSequence)localObject1);
        this.a.setVisibility(0);
      }
      else
      {
        this.a.setVisibility(8);
      }
      localObject1 = this.f.next_wording.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (bool))
      {
        this.b.setVisibility(0);
        this.b.setText((CharSequence)localObject1);
      }
      else
      {
        this.b.setVisibility(8);
      }
      int i = BaseChatItemLayout.getTextPaddingAlignHead();
      int j = BaseChatItemLayout.getTextPaddingAlignError();
      if (paramChatMessage.isSend())
      {
        i = BaseChatItemLayout.getTextPaddingAlignError();
        j = BaseChatItemLayout.getTextPaddingAlignHead();
      }
      setPadding(i, 0, j, AIOUtils.b(10.0F, getContext().getResources()));
      return;
    }
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430604)
    {
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.c.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      Object localObject = ((BaseActivity)this.e).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).k() != null))
      {
        localObject = ((ChatFragment)localObject).k();
        if (this.f != null) {
          localTroopRobotManager.a(getContext(), (BaseChatPie)localObject, this.c, ((BaseChatPie)localObject).Y, ((BaseChatPie)localObject).ah, this.d, this.f.next_content.get());
        } else {
          localTroopRobotManager.a(getContext(), (BaseChatPie)localObject, this.c, ((BaseChatPie)localObject).Y, ((BaseChatPie)localObject).ah, this.d, this.b.getText().toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView
 * JD-Core Version:    0.7.0.1
 */