package com.tencent.timi.game.liveroom.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.chat.at.AtMsgManager;
import com.tencent.timi.game.component.chat.at.AtMsgManager.Companion;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.message.MessageLayout.LayoutClickListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import com.tencent.timi.game.liveroom.impl.view.message.MsgRecyclerViewPool;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.ui.widget.shadow.ShadowUtilKt;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chatId", "", "datas", "", "", "eventReceiver", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$eventReceiver$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$eventReceiver$1;", "iQQLiveAnnouncePushListener", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveAnnouncePushListener$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveAnnouncePushListener$1;", "iQQLiveReceiveFollowListener", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveReceiveFollowListener$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveReceiveFollowListener$1;", "iQQLiveReceiveMessageListener", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveReceiveMessageListener;", "iQQLiveSysMessageListener", "isAttachingWindow", "", "layoutClickListener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$LayoutClickListener;", "layoutClickUpListener", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "newAtMsgView", "Landroid/widget/TextView;", "newMsgCount", "newMsgView", "ownerId", "", "receiveGiftMessageListener", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$receiveGiftMessageListener$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$receiveGiftMessageListener$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "roomAudienceInfoListener", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$roomAudienceInfoListener$1", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$roomAudienceInfoListener$1;", "roomId", "showAtMsgId", "sizeHeight", "acquireAtText", "Landroid/text/SpannableStringBuilder;", "addNewMsg", "", "msg", "clearAtMsgShortCut", "clearUnreadNewMsg", "findAtFromHistory", "findAtPosition", "hasAtMeMessage", "isBottom", "onDetachedFromWindow", "onEnterRoom", "onExitRoom", "onNewMsg", "onSizeChanged", "w", "h", "oldw", "oldh", "onUpdateMsg", "pos", "register", "scrollToBottom", "showAtMsgShortCut", "showAtMsgWhenFirstLoad", "showNewAtMsgShortCut", "up", "listener", "Landroid/view/View$OnClickListener;", "unregister", "unregisterSysEvent", "completeScrollToPos", "useScrollTo", "Companion", "MsgRecyclerView", "ViewHolder", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout
  extends FrameLayout
{
  public static final AnchorMessageLayout.Companion a = new AnchorMessageLayout.Companion(null);
  private int b;
  private String c = "999L";
  private long d;
  private long e;
  private final List<Object> f = (List)new ArrayList();
  private LinearLayoutManager g;
  private RecyclerView h;
  private TextView i;
  private TextView j;
  private int k;
  private MessageLayout.LayoutClickListener l;
  private MessageLayout.LayoutClickListener m;
  private String n = "";
  private boolean o;
  private final IQQLiveReceiveMessageListener p = (IQQLiveReceiveMessageListener)new AnchorMessageLayout.iQQLiveReceiveMessageListener.1(this);
  private final IQQLiveReceiveMessageListener q = (IQQLiveReceiveMessageListener)new AnchorMessageLayout.iQQLiveSysMessageListener.1(this);
  private final AnchorMessageLayout.iQQLiveAnnouncePushListener.1 r = new AnchorMessageLayout.iQQLiveAnnouncePushListener.1(this);
  private final AnchorMessageLayout.iQQLiveReceiveFollowListener.1 s = new AnchorMessageLayout.iQQLiveReceiveFollowListener.1(this);
  private final AnchorMessageLayout.roomAudienceInfoListener.1 t = new AnchorMessageLayout.roomAudienceInfoListener.1(this);
  private final AnchorMessageLayout.receiveGiftMessageListener.1 u = new AnchorMessageLayout.receiveGiftMessageListener.1(this);
  private final AnchorMessageLayout.eventReceiver.1 v = new AnchorMessageLayout.eventReceiver.1(this);
  
  @JvmOverloads
  public AnchorMessageLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorMessageLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorMessageLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = new AnchorMessageLayout.MsgRecyclerView(this, paramContext, null, 0, 6, null);
    paramAttributeSet = (RecyclerView)paramContext;
    this.h = paramAttributeSet;
    paramContext.setEnabled(true);
    paramContext.setOverScrollMode(2);
    paramContext.setOnTouchListener((View.OnTouchListener)new AnchorMessageLayout..special..inlined.apply.lambda.1(this));
    paramContext.setRecycledViewPool((RecyclerView.RecycledViewPool)new MsgRecyclerViewPool());
    ShadowUtilKt.a(paramAttributeSet, LayoutExKt.a(30), LayoutExKt.a(30), -16777216);
    paramContext = (View)paramContext;
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.b(this), LayoutExKt.a(this));
    paramAttributeSet.gravity = 80;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new TextView(getContext());
    this.i = paramContext;
    LayoutExKt.a(paramContext, 12.0F);
    paramContext.setPadding(LayoutExKt.b(10), 0, LayoutExKt.b(10), 0);
    paramContext.setOnClickListener((View.OnClickListener)new AnchorMessageLayout..special..inlined.textView.lambda.1(this));
    paramContext.setTextColor(Color.parseColor("#6666FF"));
    paramContext.setGravity(17);
    paramContext.setVisibility(8);
    paramContext = (View)paramContext;
    ViewExKt.a(paramContext, LayoutExKt.b(18), new int[] { ResUtils.b(2131168464) });
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.a(this), LayoutExKt.b(26));
    paramAttributeSet.gravity = 83;
    paramAttributeSet.bottomMargin = LayoutExKt.b(14);
    paramAttributeSet.leftMargin = LayoutExKt.b(16);
    setMinimumWidth(LayoutExKt.b(80));
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new TextView(getContext());
    this.j = paramContext;
    LayoutExKt.a(paramContext, 12.0F);
    paramContext.setPadding(LayoutExKt.b(11), 0, LayoutExKt.b(11), 0);
    paramContext.setOnClickListener((View.OnClickListener)new AnchorMessageLayout..special..inlined.textView.lambda.2(this));
    paramContext.setCompoundDrawablePadding(LayoutExKt.b(3));
    paramContext.setTextColor(ResUtils.b(2131165564));
    paramContext.setGravity(17);
    paramContext.setVisibility(8);
    paramContext = (View)paramContext;
    ViewExKt.a(paramContext, LayoutExKt.b(18), new int[] { ResUtils.b(2131168464) });
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.a(this), LayoutExKt.b(26));
    paramAttributeSet.gravity = 81;
    paramAttributeSet.bottomMargin = LayoutExKt.b(14);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    setOverScrollMode(2);
    this.g = new LinearLayoutManager(getContext());
    this.g.setOrientation(1);
    this.h.setLayoutManager((RecyclerView.LayoutManager)this.g);
    this.h.setItemViewCacheSize(20);
    paramContext = this.h.getItemAnimator();
    if (paramContext != null)
    {
      paramContext.setAddDuration(0L);
      paramContext.setRemoveDuration(0L);
      paramContext.setChangeDuration(0L);
      paramContext.setMoveDuration(0L);
    }
    this.h.addItemDecoration((RecyclerView.ItemDecoration)new AnchorMessageLayout.8());
    this.h.setAdapter((RecyclerView.Adapter)new AnchorMessageLayout.9(this));
  }
  
  private final void a(@NotNull RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.f.size())
    {
      if (paramInt < 0) {
        return;
      }
      paramRecyclerView.post((Runnable)new AnchorMessageLayout.completeScrollToPos.1(this, paramRecyclerView, paramBoolean, paramInt));
    }
  }
  
  private final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setVisibility(0);
    localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setOnClickListener(paramOnClickListener);
  }
  
  private final boolean c(Object paramObject)
  {
    if ((paramObject instanceof ILiveMsg))
    {
      ILiveMsg localILiveMsg = (ILiveMsg)paramObject;
      paramObject = localILiveMsg.d();
      if (paramObject != null)
      {
        paramObject = paramObject.content;
        if (paramObject != null)
        {
          paramObject = paramObject.at_user_msg;
          if (paramObject != null)
          {
            paramObject = paramObject.user_list;
            if ((paramObject != null) && (paramObject.size() == 0)) {
              break label171;
            }
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)this.n))
      {
        SpecialMsgUtil localSpecialMsgUtil = SpecialMsgUtil.a;
        paramObject = localILiveMsg.d();
        Long localLong = null;
        if (paramObject != null)
        {
          paramObject = paramObject.content;
          if (paramObject != null)
          {
            paramObject = paramObject.at_user_msg;
            break label107;
          }
        }
        paramObject = null;
        label107:
        Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
        localObject = ((ITgLiveRoomService)localObject).f();
        if (localObject != null) {
          localLong = Long.valueOf(((LiveUserInfo)localObject).uid);
        }
        if (localSpecialMsgUtil.a(paramObject, localLong))
        {
          this.n = localILiveMsg.a();
          return true;
        }
      }
      label171:
      return TextUtils.isEmpty((CharSequence)this.n) ^ true;
    }
    return false;
  }
  
  private final void f()
  {
    TextView localTextView = this.i;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    ViewExKt.a((View)localTextView, false);
    this.k = 0;
  }
  
  private final SpannableStringBuilder g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)"有人@你");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(ResUtils.b(2131168293)), 2, 4, 33);
    return localSpannableStringBuilder;
  }
  
  private final void h()
  {
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    ((TextView)localObject).setText((CharSequence)g());
    int i1 = i();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showAtMsgShortCut: ");
    ((StringBuilder)localObject).append(i1);
    Logger.b("AnchorMessageLayout", ((StringBuilder)localObject).toString());
    a(false, (View.OnClickListener)new AnchorMessageLayout.showAtMsgShortCut.1(this, i1));
  }
  
  private final int i()
  {
    if (!TextUtils.isEmpty((CharSequence)this.n))
    {
      Iterator localIterator = ((Iterable)this.f).iterator();
      int i1 = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        if (((localObject instanceof ILiveMsg)) && (Intrinsics.areEqual(this.n, ((ILiveMsg)localObject).a())))
        {
          int i2 = this.f.size() - i1;
          if (i2 >= 0) {
            return i2;
          }
        }
        i1 += 1;
      }
    }
    return 0;
  }
  
  private final int j()
  {
    Iterator localIterator = ((Iterable)CollectionsKt.reversed((Iterable)this.f)).iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i1 < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (((localObject instanceof ILiveMsg)) && (AtMsgManager.a.a().a(this.c, ((ILiveMsg)localObject).a()))) {
        return this.f.size() - i1 - 1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private final void k()
  {
    this.n = "";
    this.k = 0;
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setVisibility(8);
  }
  
  public final void a()
  {
    Logger.a("AnchorMessageLayout", "register");
    ILiveRoomMessage localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerRoomChatMsgListener(this.p);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerSystemMsgListener(this.q);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerAnnounceMessageListener((IQQLiveAnnouncePushListener)this.r);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerFollowMessageListener((IQQLiveReceiveFollowListener)this.s);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerAudienceInfoListener((RoomAudienceInfoListener)this.t);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.registerReceiveGiftMessageListener((ReceiveGiftMessageListener)this.u);
    }
  }
  
  public final void a(int paramInt)
  {
    RecyclerView.Adapter localAdapter = this.h.getAdapter();
    if (localAdapter != null) {
      localAdapter.notifyItemChanged(paramInt);
    }
  }
  
  public final void a(long paramLong)
  {
    Logger.a("AnchorMessageLayout", "onExitRoom");
    if (paramLong == this.d)
    {
      b();
      this.f.clear();
      RecyclerView.Adapter localAdapter = this.h.getAdapter();
      if (localAdapter != null) {
        localAdapter.notifyDataSetChanged();
      }
      this.d = 0L;
    }
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom roomId[");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(']');
    Logger.a("AnchorMessageLayout", ((StringBuilder)localObject).toString());
    b();
    if (this.d == paramLong1)
    {
      a();
      return;
    }
    this.d = paramLong1;
    this.c = String.valueOf(paramLong1);
    this.e = paramLong2;
    localObject = this.h.getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = LayoutExKt.a(this);
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.h.setHasFixedSize(false);
    }
    this.f.clear();
    localObject = this.h.getAdapter();
    if (localObject != null) {
      ((RecyclerView.Adapter)localObject).notifyDataSetChanged();
    }
    a();
    this.h.post((Runnable)new AnchorMessageLayout.onEnterRoom.2(this, paramLong1, paramLong2));
  }
  
  public final void a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "msg");
    if (d())
    {
      b(paramObject);
      e();
      return;
    }
    this.k += 1;
    Object localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    ViewExKt.a((View)localObject, true);
    b(paramObject);
    TextView localTextView = this.i;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = this.k;
    if (i1 > 99) {
      localObject = "99+";
    } else {
      localObject = String.valueOf(i1);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("条新消息");
    localTextView.setText((CharSequence)localStringBuilder.toString());
    if (c(paramObject))
    {
      paramObject = new StringBuilder();
      paramObject.append("hasAtMeMessage: ");
      paramObject.append(this.n);
      Logger.b("AnchorMessageLayout", paramObject.toString());
      h();
    }
  }
  
  public final void b()
  {
    Logger.a("AnchorMessageLayout", "unregister");
    ILiveRoomMessage localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterRoomChatMsgListener(this.p);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterSystemMsgListener(this.q);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterAnnounceMessageListener((IQQLiveAnnouncePushListener)this.r);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterFollowMessageListener((IQQLiveReceiveFollowListener)this.s);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterAudienceInfoListener((RoomAudienceInfoListener)this.t);
    }
    localILiveRoomMessage = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).j(this.d);
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterReceiveGiftMessageListener((ReceiveGiftMessageListener)this.u);
    }
    c();
  }
  
  public final void b(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "msg");
    this.f.add(paramObject);
    paramObject = this.h.getAdapter();
    if (paramObject != null) {
      paramObject.notifyItemInserted(this.f.size() - 1);
    }
  }
  
  public final void c()
  {
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this.v);
  }
  
  public final boolean d()
  {
    return this.g.findLastVisibleItemPosition() == this.f.size() - 1;
  }
  
  public final void e()
  {
    RecyclerView.Adapter localAdapter = this.h.getAdapter();
    int i1;
    if (localAdapter != null) {
      i1 = localAdapter.getItemCount();
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return;
    }
    this.h.stopScroll();
    this.g.scrollToPositionWithOffset(i1 - 1, 0);
    f();
    k();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Logger.a("AnchorMessageLayout", "onDetachedFromWindow");
    ITgLiveRoomService localITgLiveRoomService = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    long l1 = this.d;
    List localList = (List)new ArrayList();
    localList.addAll((Collection)this.f);
    localITgLiveRoomService.a(l1, localList);
    b();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("w = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], h = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], oldw = [");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], oldh = [");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(']');
    Logger.a("AnchorMessageLayout", localStringBuilder.toString());
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout
 * JD-Core Version:    0.7.0.1
 */