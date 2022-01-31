package com.tencent.mobileqq.structmsg.view;

import aiiy;
import aiiz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;

public class StructMsgItemLayout15
  extends AbsStructMsgItem
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aiiz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private RelativeLayout a(Context paramContext)
  {
    Object localObject1 = paramContext.getResources();
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(16);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = 2;
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.setId(2131362164);
    localObject2 = new Button(paramContext);
    ((Button)localObject2).setTextColor(Color.parseColor("#00a5e0"));
    ((Button)localObject2).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject2).setId(2131362165);
    ((Button)localObject2).setPadding(AIOUtils.a(14.0F, (Resources)localObject1), 0, AIOUtils.a(7.0F, (Resources)localObject1), 0);
    ((Button)localObject2).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((Button)localObject2).setBackgroundDrawable(null);
    localRelativeLayout.addView((View)localObject2);
    localObject3 = new ProgressBar(paramContext);
    ((ProgressBar)localObject3).setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838596));
    int i = AIOUtils.a(16.0F, paramContext.getResources());
    Object localObject4 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131362165);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
    ((ProgressBar)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((ProgressBar)localObject3).setId(2131362166);
    localRelativeLayout.addView((View)localObject3);
    localObject4 = new Button(paramContext);
    ((Button)localObject4).setTextColor(Color.parseColor("#777777"));
    ((Button)localObject4).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject4).setPadding(AIOUtils.a(7.0F, (Resources)localObject1), 0, 0, 0);
    ((Button)localObject4).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject5).addRule(11);
    ((RelativeLayout.LayoutParams)localObject5).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, AIOUtils.a(14.0F, (Resources)localObject1), 0);
    ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ((Button)localObject4).setBackgroundDrawable(null);
    ((Button)localObject4).setId(2131362170);
    localRelativeLayout.addView((View)localObject4);
    localObject5 = new ImageView(paramContext);
    Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject6).addRule(0, 2131362170);
    ((RelativeLayout.LayoutParams)localObject6).addRule(15, -1);
    ((ImageView)localObject5).setPadding(AIOUtils.a(15.0F, (Resources)localObject1), AIOUtils.a(15.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1));
    ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    ((ImageView)localObject5).setImageResource(2130841487);
    ((ImageView)localObject5).setId(2131362171);
    localRelativeLayout.addView((View)localObject5);
    localObject6 = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.a(13.0F, (Resources)localObject1));
    localLayoutParams.addRule(0, 2131362171);
    localLayoutParams.addRule(15, -1);
    ((ImageView)localObject6).setLayoutParams(localLayoutParams);
    ((ImageView)localObject6).setBackgroundResource(2130841488);
    ((ImageView)localObject6).setId(2131362169);
    localRelativeLayout.addView((View)localObject6);
    localObject6 = new Button(paramContext);
    ((Button)localObject6).setTextColor(Color.parseColor("#777777"));
    ((Button)localObject6).setTextSize(0, AIOUtils.a(14.0F, (Resources)localObject1));
    ((Button)localObject6).setPadding(AIOUtils.a(7.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1), 0);
    ((Button)localObject6).setMinHeight(AIOUtils.a(46.0F, (Resources)localObject1));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131362169);
    localLayoutParams.addRule(15, -1);
    ((Button)localObject6).setLayoutParams(localLayoutParams);
    ((Button)localObject6).setBackgroundDrawable(null);
    ((Button)localObject6).setId(2131362167);
    localRelativeLayout.addView((View)localObject6);
    paramContext = new ImageView(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131362167);
    localLayoutParams.addRule(15, -1);
    paramContext.setPadding(0, AIOUtils.a(15.0F, (Resources)localObject1), 0, AIOUtils.a(15.0F, (Resources)localObject1));
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setImageResource(2130841489);
    paramContext.setId(2131362168);
    localRelativeLayout.addView(paramContext);
    ((Button)localObject2).setTag(2131362172, Integer.valueOf(1));
    ((Button)localObject6).setTag(2131362172, Integer.valueOf(2));
    paramContext.setTag(2131362172, Integer.valueOf(2));
    ((Button)localObject4).setTag(2131362172, Integer.valueOf(3));
    ((ImageView)localObject5).setTag(2131362172, Integer.valueOf(3));
    localObject1 = new StructMsgItemLayout15.ViewHolder();
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)localObject2);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject3);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetButton = ((Button)localObject6);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = paramContext;
    ((StructMsgItemLayout15.ViewHolder)localObject1).c = ((Button)localObject4);
    ((StructMsgItemLayout15.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
    localRelativeLayout.setTag(localObject1);
    return localRelativeLayout;
  }
  
  public void a(Context paramContext, MessageForTroopTopic paramMessageForTroopTopic)
  {
    TroopTopicMgr localTroopTopicMgr;
    if ((SplashActivity.class.isInstance(paramContext)) || (ChatActivity.class.isInstance(paramContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic");
      }
      localTroopTopicMgr = (TroopTopicMgr)((FragmentActivity)paramContext).getChatFragment().a().getManager(97);
      if (!paramMessageForTroopTopic.isExpand) {
        break label106;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic isExpand refresh");
      }
      paramMessageForTroopTopic.isExpand = false;
      localTroopTopicMgr.a(paramMessageForTroopTopic.frienduin);
      paramMessageForTroopTopic.isLoading = false;
      ((FragmentActivity)paramContext).getChatFragment().a().b(131076);
    }
    label106:
    TroopTopicDetailInfo localTroopTopicDetailInfo;
    do
    {
      return;
      paramMessageForTroopTopic.isLoading = true;
      localTroopTopicDetailInfo = localTroopTopicMgr.a(paramMessageForTroopTopic);
    } while ((localTroopTopicDetailInfo == null) || (localTroopTopicDetailInfo.detailStructMsg == null));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick expandTroopTopic isExpand false. load data from cache");
    }
    paramMessageForTroopTopic.detailTopicContent = localTroopTopicDetailInfo.detailStructMsg;
    paramMessageForTroopTopic.isExpand = true;
    localTroopTopicMgr.a(paramMessageForTroopTopic);
    paramMessageForTroopTopic.isLoading = false;
    paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
    paramContext.a.setStackFromBottomWithoutRequestLayoutIfNecessary(false);
    paramContext.b(131076);
    paramContext.a.postDelayed(new aiiy(this, paramContext), 100L);
  }
  
  protected int b()
  {
    return 15;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout15 getView start.");
    }
    paramBundle = ((FragmentActivity)paramContext).getChatFragment();
    label51:
    MessageForTroopTopic localMessageForTroopTopic;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBundle.a();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label431;
      }
      paramContext = (RelativeLayout)paramView;
      if ((paramContext.getTag() instanceof StructMsgItemLayout15.ViewHolder))
      {
        paramBundle = (StructMsgItemLayout15.ViewHolder)paramContext.getTag();
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare)))
        {
          paramView = (StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message instanceof MessageForTroopTopic))
          {
            localMessageForTroopTopic = (MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
            if (localMessageForTroopTopic.isShowExpandButton) {
              break label440;
            }
            paramBundle.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "exp_full", 0, 0, "" + localMessageForTroopTopic.frienduin, "", "", "");
            label193:
            if (!localMessageForTroopTopic.isLoading) {
              break label482;
            }
            paramBundle.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            label209:
            Button localButton = paramBundle.jdField_b_of_type_AndroidWidgetButton;
            if (localMessageForTroopTopic.likeNum > 0L) {
              break label493;
            }
            paramView = " ";
            label229:
            localButton.setText(paramView);
            localButton = paramBundle.c;
            if (localMessageForTroopTopic.commentNum > 0L) {
              break label521;
            }
            paramView = " ";
            label255:
            localButton.setText(paramView);
            if (!localMessageForTroopTopic.isLike) {
              break label549;
            }
            paramBundle.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841490);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setTag(2131362173, paramBundle);
      paramBundle.jdField_b_of_type_AndroidWidgetButton.setTag(2131362173, paramBundle);
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setTag(2131362173, paramBundle);
      paramBundle.c.setTag(2131362173, paramBundle);
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362173, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout15 getView end.");
      }
      return paramContext;
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramBundle instanceof QQAppInterface)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      break;
      label431:
      paramContext = a(paramContext);
      break label51;
      label440:
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (localMessageForTroopTopic.isExpand)
      {
        paramBundle.jdField_a_of_type_AndroidWidgetButton.setText(2131430737);
        break label193;
      }
      paramBundle.jdField_a_of_type_AndroidWidgetButton.setText(2131430736);
      break label193;
      label482:
      paramBundle.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      break label209;
      label493:
      paramView = localMessageForTroopTopic.likeNum + "";
      break label229;
      label521:
      paramView = localMessageForTroopTopic.commentNum + "";
      break label255;
      label549:
      paramBundle.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841489);
    }
  }
  
  public String b()
  {
    return "Layout15";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15
 * JD-Core Version:    0.7.0.1
 */