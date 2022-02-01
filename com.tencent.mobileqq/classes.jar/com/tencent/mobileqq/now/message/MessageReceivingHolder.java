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
  private int a;
  private boolean b = false;
  private BaseActivity c;
  private QQAppInterface d;
  private BaseChatPie e;
  private TextView f;
  private DecoratorViewPager g;
  private MessageReceivingAdapter h;
  private SimpleCircleIndicator i;
  private ViewPager.OnPageChangeListener j = new MessageReceivingHolder.1(this);
  
  public MessageReceivingHolder(BaseActivity paramBaseActivity, RecyclerView paramRecyclerView, View paramView)
  {
    super(paramView);
    this.c = paramBaseActivity;
    this.d = paramBaseActivity.app;
    QQAppInterface localQQAppInterface = this.c.app;
    DecoratorViewPager localDecoratorViewPager = this.g;
    BaseActivity localBaseActivity = this.c;
    this.e = new PublicAccountChatPie(localQQAppInterface, localDecoratorViewPager, localBaseActivity, localBaseActivity);
    this.e.ah.a = 1008;
    this.f = ((TextView)paramView.findViewById(2131438157));
    this.g = ((DecoratorViewPager)paramView.findViewById(2131449829));
    this.g.setNestedpParent(paramRecyclerView);
    this.h = new MessageReceivingAdapter(paramBaseActivity, this.e);
    this.g.setAdapter(this.h);
    this.g.setOnPageChangeListener(this.j);
    this.i = ((SimpleCircleIndicator)paramView.findViewById(2131430728));
    this.i.setViewPager(this.g);
    this.i.setMaxCount(3);
    b();
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      this.f.setText(TimeFormatterUtils.a(this.c, 3, paramChatMessage.time * 1000L, true));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)this.itemView.getLayoutParams();
    int k;
    if (paramBoolean) {
      k = ScreenUtil.dip2px(255.0F);
    } else {
      k = 0;
    }
    localLayoutParams.height = k;
    this.itemView.setLayoutParams(localLayoutParams);
  }
  
  private void b()
  {
    List localList = this.d.getMessageFacade().c(NowQQLiveConstant.a, 1008, -1L, true);
    ArrayList localArrayList = new ArrayList();
    int k;
    if (localList != null)
    {
      k = localList.size() - 1;
      while (k >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(k);
        if (!TextUtils.isEmpty(ChatMessageHelper.a(localChatMessage))) {
          localArrayList.add(localChatMessage);
        } else if ((localChatMessage instanceof MessageForArkApp)) {
          localArrayList.add(localChatMessage);
        }
        k -= 1;
      }
    }
    this.h.a(localArrayList);
    if (this.h.getCount() > 0)
    {
      a(true);
      if (this.a < localArrayList.size()) {
        k = this.a;
      } else {
        k = localArrayList.size() - 1;
      }
      a(this.h.a(k));
      this.g.setCurrentItem(k);
      this.g.invalidate();
      return;
    }
    a(false);
  }
  
  private void c()
  {
    Object localObject = UserInfoMgr.c();
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
    localIntent.setComponent(new ComponentName(this.c, ChatActivity.class));
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
    this.c.startActivity(localIntent);
  }
  
  public void a()
  {
    if (!this.b)
    {
      b();
      return;
    }
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingHolder
 * JD-Core Version:    0.7.0.1
 */