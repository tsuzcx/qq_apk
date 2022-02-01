package com.tencent.mobileqq.now.message;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.RecyclerHolder;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;
import com.tencent.mobileqq.now.widget.SimpleCircleIndicator;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.ArrayList;
import java.util.List;

public class MessageReceivingHolder
  extends RecyclerHolder
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new MessageReceivingHolder.1(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageReceivingAdapter jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter;
  private DecoratorViewPager jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager;
  private SimpleCircleIndicator jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator;
  private boolean jdField_a_of_type_Boolean = false;
  
  public MessageReceivingHolder(BaseActivity paramBaseActivity, RecyclerView paramRecyclerView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    DecoratorViewPager localDecoratorViewPager = this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager;
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new PublicAccountChatPie(localQQAppInterface, localDecoratorViewPager, localBaseActivity, localBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Int = 1008;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370828));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager = ((DecoratorViewPager)paramView.findViewById(2131380851));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setNestedpParent(paramRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter = new MessageReceivingAdapter(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator = ((SimpleCircleIndicator)paramView.findViewById(2131364641));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setMaxCount(3);
    b();
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 3, paramChatMessage.time * 1000L, true));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)this.itemView.getLayoutParams();
    int i;
    if (paramBoolean) {
      i = ScreenUtil.dip2px(255.0F);
    } else {
      i = 0;
    }
    localLayoutParams.height = i;
    this.itemView.setLayoutParams(localLayoutParams);
  }
  
  private void b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(NowQQLiveConstant.a, 1008, -1L, true);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (localList != null)
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i);
        if (!TextUtils.isEmpty(ChatMessageHelper.a(localChatMessage))) {
          localArrayList.add(localChatMessage);
        } else if ((localChatMessage instanceof MessageForArkApp)) {
          localArrayList.add(localChatMessage);
        }
        i -= 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.a(localArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.getCount() > 0)
    {
      a(true);
      if (this.jdField_a_of_type_Int < localArrayList.size()) {
        i = this.jdField_a_of_type_Int;
      } else {
        i = localArrayList.size() - 1;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.a(i));
      this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setCurrentItem(i);
      this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.invalidate();
      return;
    }
    a(false);
  }
  
  private void c()
  {
    Object localObject = UserInfoMgr.a();
    if (localObject != null)
    {
      localObject = (IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(NowQQLiveConstant.a);
        break label39;
      }
    }
    localObject = null;
    label39:
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localIntent.setComponent(new ComponentName(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class));
    localBundle.putString("uin", NowQQLiveConstant.a);
    localBundle.putInt("uintype", 1008);
    if (localObject != null) {
      localObject = ((IPublicAccountDetail)localObject).getName();
    } else {
      localObject = "";
    }
    localBundle.putString("uinname", (String)localObject);
    localIntent.putExtras(localBundle);
    localIntent.setFlags(67108864);
    localIntent.putExtra("isforceRequestDetail", false);
    localIntent.putExtra("jump_from", 2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingHolder
 * JD-Core Version:    0.7.0.1
 */