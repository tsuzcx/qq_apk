package com.tencent.mobileqq.fudai.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.FilterRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class FudaiItemBuilder
  extends BaseBubbleBuilder
{
  @Nullable
  private static ArraySet<WeakReference<CustomFrameAnimationDrawable>> jdField_a_of_type_AndroidSupportV4UtilArraySet;
  private static final SparseArrayCompat<String[]> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private ArraySet<Long> b = new ArraySet();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public FudaiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = paramContext.getResources();
    this.c = paramQQAppInterface.getDimensionPixelSize(2131297146);
    this.d = paramQQAppInterface.getDimensionPixelSize(2131297145);
    this.jdField_e_of_type_Int = paramQQAppInterface.getDimensionPixelSize(2131297150);
    this.f = paramQQAppInterface.getDimensionPixelSize(2131297149);
    this.g = paramQQAppInterface.getDimensionPixelSize(2131297152);
    this.h = paramQQAppInterface.getDimensionPixelSize(2131297151);
    this.i = paramQQAppInterface.getDimensionPixelSize(2131297148);
    this.j = paramQQAppInterface.getDimensionPixelSize(2131297147);
  }
  
  @Nullable
  private BaseChatPie a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment == null) {
        return null;
      }
      return localChatFragment.a();
    }
    return null;
  }
  
  private String a(MessageForFuDai paramMessageForFuDai)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForFuDai.aioTails);
    if (paramMessageForFuDai.isExpired()) {
      localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692718));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramMessageForFuDai.isGrabByMe()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692717));
      } else if (paramMessageForFuDai.isEmpty()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692719));
      }
    }
  }
  
  private void a(MessageForFuDai paramMessageForFuDai, int paramInt) {}
  
  private void a(FudaiItemBuilder.Holder paramHolder)
  {
    FudaiItemBuilder.Holder.a(paramHolder).setFilter(-1711276033);
    FudaiItemBuilder.Holder.c(paramHolder).setVisibility(0);
    FudaiItemBuilder.Holder.d(paramHolder).setVisibility(8);
    FudaiItemBuilder.Holder.a(paramHolder).setImageResource(2130845386);
    FudaiItemBuilder.Holder.c(paramHolder).setImageResource(2130845387);
  }
  
  public static void e()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = jdField_a_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.e();
        }
      }
    }
  }
  
  public static void f()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = jdField_a_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.d();
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FudaiItemBuilder.Holder)paramViewHolder;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561266, paramBaseChatItemLayout, false);
      FudaiItemBuilder.Holder.a(paramViewHolder, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnClickListener(this);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnTouchListener(paramOnLongClickAndTouchListener);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    if (jdField_e_of_type_Boolean)
    {
      paramView = a(localMessageForFuDai);
      AccessibilityUtil.a(FudaiItemBuilder.Holder.a(paramViewHolder), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    FudaiItemBuilder.Holder.a(paramViewHolder, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      FudaiItemBuilder.Holder.a(paramViewHolder).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("FudaiItemBuilder", 2, "no logo res");
      }
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(8);
      if (!localMessageForFuDai.isExpired()) {
        break label255;
      }
      a(paramViewHolder);
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.b(paramViewHolder).setText(2131692718);
    }
    for (;;)
    {
      if (!this.b.contains(Long.valueOf(localMessageForFuDai.uniseq)))
      {
        this.b.add(Long.valueOf(localMessageForFuDai.uniseq));
        a(localMessageForFuDai, 110);
      }
      return paramChatMessage;
      FudaiItemBuilder.Holder.a(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.a(paramViewHolder).setText(localMessageForFuDai.aioTails);
      break;
      label255:
      if (localMessageForFuDai.isGrabByMe())
      {
        a(paramViewHolder);
        FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(8);
      }
      else if (localMessageForFuDai.isEmpty())
      {
        a(paramViewHolder);
        FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(0);
        FudaiItemBuilder.Holder.b(paramViewHolder).setText(2131692719);
      }
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new FudaiItemBuilder.Holder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(a((MessageForFuDai)paramChatMessage));
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet != null) {
      jdField_a_of_type_AndroidSupportV4UtilArraySet.clear();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof FudaiItemBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = a();
      if (localBaseChatPie != null)
      {
        MessageForFuDai localMessageForFuDai = (MessageForFuDai)((FudaiItemBuilder.Holder)AIOUtils.a(paramView)).a;
        a(localMessageForFuDai, 111);
        ((FuDaiHelper)localBaseChatPie.a(2)).a(localMessageForFuDai);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FudaiItemBuilder
 * JD-Core Version:    0.7.0.1
 */