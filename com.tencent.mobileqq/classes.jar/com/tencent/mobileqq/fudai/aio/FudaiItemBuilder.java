package com.tencent.mobileqq.fudai.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.app.BaseActivity;
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
  private int jdField_a_of_type_Int;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private ArraySet<Long> b = new ArraySet();
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
    this.jdField_a_of_type_Int = paramQQAppInterface.getDimensionPixelSize(2131297128);
    this.d = paramQQAppInterface.getDimensionPixelSize(2131297127);
    this.jdField_e_of_type_Int = paramQQAppInterface.getDimensionPixelSize(2131297132);
    this.f = paramQQAppInterface.getDimensionPixelSize(2131297131);
    this.g = paramQQAppInterface.getDimensionPixelSize(2131297134);
    this.h = paramQQAppInterface.getDimensionPixelSize(2131297133);
    this.i = paramQQAppInterface.getDimensionPixelSize(2131297130);
    this.j = paramQQAppInterface.getDimensionPixelSize(2131297129);
  }
  
  @Nullable
  private BaseChatPie a()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity;
    Object localObject = null;
    if (bool)
    {
      localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        return null;
      }
      localObject = ((ChatFragment)localObject).a();
    }
    return localObject;
  }
  
  private String a(MessageForFuDai paramMessageForFuDai)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForFuDai.aioTails);
    if (paramMessageForFuDai.isExpired())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692675));
    }
    else if (paramMessageForFuDai.isGrabByMe())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692674));
    }
    else if (paramMessageForFuDai.isEmpty())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692676));
    }
    return localStringBuilder.toString();
  }
  
  private void a(MessageForFuDai paramMessageForFuDai, int paramInt) {}
  
  private void a(FudaiItemBuilder.Holder paramHolder)
  {
    FudaiItemBuilder.Holder.a(paramHolder).setFilter(-1711276033);
    FudaiItemBuilder.Holder.c(paramHolder).setVisibility(0);
    FudaiItemBuilder.Holder.d(paramHolder).setVisibility(8);
    FudaiItemBuilder.Holder.a(paramHolder).setImageResource(2130845259);
    FudaiItemBuilder.Holder.c(paramHolder).setImageResource(2130845260);
  }
  
  public static void e()
  {
    Object localObject = jdField_a_of_type_AndroidSupportV4UtilArraySet;
    if (localObject == null) {
      return;
    }
    localObject = ((ArraySet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)((Iterator)localObject).next()).get();
      if (localCustomFrameAnimationDrawable != null) {
        localCustomFrameAnimationDrawable.e();
      }
    }
  }
  
  public static void f()
  {
    Object localObject = jdField_a_of_type_AndroidSupportV4UtilArraySet;
    if (localObject == null) {
      return;
    }
    localObject = ((ArraySet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)((Iterator)localObject).next()).get();
      if (localCustomFrameAnimationDrawable != null) {
        localCustomFrameAnimationDrawable.d();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FudaiItemBuilder.Holder)paramViewHolder;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561109, paramBaseChatItemLayout, false);
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
    }
    else
    {
      FudaiItemBuilder.Holder.a(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.a(paramViewHolder).setText(localMessageForFuDai.aioTails);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FudaiItemBuilder", 2, "no logo res");
    }
    FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(8);
    if (localMessageForFuDai.isExpired())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.b(paramViewHolder).setText(2131692675);
    }
    else if (localMessageForFuDai.isGrabByMe())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(8);
    }
    else if (localMessageForFuDai.isEmpty())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.b(paramViewHolder).setText(2131692676);
    }
    if (!this.b.contains(Long.valueOf(localMessageForFuDai.uniseq)))
    {
      this.b.add(Long.valueOf(localMessageForFuDai.uniseq));
      a(localMessageForFuDai, 110);
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new FudaiItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    } else {
      localStringBuilder.append("发来");
    }
    localStringBuilder.append(a((MessageForFuDai)paramChatMessage));
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    localObject = jdField_a_of_type_AndroidSupportV4UtilArraySet;
    if (localObject != null) {
      ((ArraySet)localObject).clear();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
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
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131367389)
    {
      super.onClick(paramView);
    }
    else
    {
      BaseChatPie localBaseChatPie = a();
      if (localBaseChatPie != null)
      {
        MessageForFuDai localMessageForFuDai = (MessageForFuDai)((FudaiItemBuilder.Holder)AIOUtils.a(paramView)).a;
        a(localMessageForFuDai, 111);
        ((FuDaiHelper)localBaseChatPie.a(2)).a(localMessageForFuDai);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FudaiItemBuilder
 * JD-Core Version:    0.7.0.1
 */