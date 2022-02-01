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
  private static final SparseArrayCompat<String[]> E = new SparseArrayCompat();
  @Nullable
  private static ArraySet<WeakReference<CustomFrameAnimationDrawable>> F;
  private int A;
  private int B;
  private int C;
  private final ArrayMap<String, Boolean> D = new ArrayMap();
  private ArraySet<Long> G = new ArraySet();
  private HandlerThread H;
  private int a;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public FudaiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = paramContext.getResources();
    this.a = paramQQAppInterface.getDimensionPixelSize(2131297513);
    this.w = paramQQAppInterface.getDimensionPixelSize(2131297512);
    this.x = paramQQAppInterface.getDimensionPixelSize(2131297517);
    this.y = paramQQAppInterface.getDimensionPixelSize(2131297516);
    this.z = paramQQAppInterface.getDimensionPixelSize(2131297519);
    this.A = paramQQAppInterface.getDimensionPixelSize(2131297518);
    this.B = paramQQAppInterface.getDimensionPixelSize(2131297515);
    this.C = paramQQAppInterface.getDimensionPixelSize(2131297514);
  }
  
  private String a(MessageForFuDai paramMessageForFuDai)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForFuDai.aioTails);
    if (paramMessageForFuDai.isExpired())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.e.getResources().getString(2131889745));
    }
    else if (paramMessageForFuDai.isGrabByMe())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.e.getResources().getString(2131889744));
    }
    else if (paramMessageForFuDai.isEmpty())
    {
      localStringBuilder.append("，");
      localStringBuilder.append(this.e.getResources().getString(2131889746));
    }
    return localStringBuilder.toString();
  }
  
  private void a(MessageForFuDai paramMessageForFuDai, int paramInt) {}
  
  private void a(FudaiItemBuilder.Holder paramHolder)
  {
    FudaiItemBuilder.Holder.e(paramHolder).setFilter(-1711276033);
    FudaiItemBuilder.Holder.f(paramHolder).setVisibility(0);
    FudaiItemBuilder.Holder.g(paramHolder).setVisibility(8);
    FudaiItemBuilder.Holder.a(paramHolder).setImageResource(2130846715);
    FudaiItemBuilder.Holder.f(paramHolder).setImageResource(2130846716);
  }
  
  public static void h()
  {
    Object localObject = F;
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
  
  public static void i()
  {
    Object localObject = F;
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
  
  @Nullable
  private BaseChatPie j()
  {
    boolean bool = this.e instanceof BaseActivity;
    Object localObject = null;
    if (bool)
    {
      localObject = ((BaseActivity)this.e).getChatFragment();
      if (localObject == null) {
        return null;
      }
      localObject = ((ChatFragment)localObject).k();
    }
    return localObject;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FudaiItemBuilder.Holder)paramViewHolder;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.e).inflate(2131627459, paramBaseChatItemLayout, false);
      FudaiItemBuilder.Holder.a(paramViewHolder, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnClickListener(this);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnTouchListener(paramOnLongClickAndTouchListener);
      FudaiItemBuilder.Holder.a(paramViewHolder).setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    if (v)
    {
      paramView = a(localMessageForFuDai);
      AccessibilityUtil.a(FudaiItemBuilder.Holder.a(paramViewHolder), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    FudaiItemBuilder.Holder.a(paramViewHolder, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(8);
    }
    else
    {
      FudaiItemBuilder.Holder.b(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.b(paramViewHolder).setText(localMessageForFuDai.aioTails);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FudaiItemBuilder", 2, "no logo res");
    }
    FudaiItemBuilder.Holder.c(paramViewHolder).setVisibility(8);
    if (localMessageForFuDai.isExpired())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.d(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.d(paramViewHolder).setText(2131889745);
    }
    else if (localMessageForFuDai.isGrabByMe())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.d(paramViewHolder).setVisibility(8);
    }
    else if (localMessageForFuDai.isEmpty())
    {
      a(paramViewHolder);
      FudaiItemBuilder.Holder.d(paramViewHolder).setVisibility(0);
      FudaiItemBuilder.Holder.d(paramViewHolder).setText(2131889746);
    }
    if (!this.G.contains(Long.valueOf(localMessageForFuDai.uniseq)))
    {
      this.G.add(Long.valueOf(localMessageForFuDai.uniseq));
      a(localMessageForFuDai, 110);
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new FudaiItemBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof FudaiItemBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.H = null;
    }
    localObject = F;
    if (localObject != null) {
      ((ArraySet)localObject).clear();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    } else {
      localStringBuilder.append("发来");
    }
    localStringBuilder.append(a((MessageForFuDai)paramChatMessage));
    return localStringBuilder.toString();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131433889)
    {
      super.onClick(paramView);
    }
    else
    {
      BaseChatPie localBaseChatPie = j();
      if (localBaseChatPie != null)
      {
        MessageForFuDai localMessageForFuDai = (MessageForFuDai)((FudaiItemBuilder.Holder)AIOUtils.b(paramView)).q;
        a(localMessageForFuDai, 111);
        ((FuDaiHelper)localBaseChatPie.q(2)).a(localMessageForFuDai);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FudaiItemBuilder
 * JD-Core Version:    0.7.0.1
 */