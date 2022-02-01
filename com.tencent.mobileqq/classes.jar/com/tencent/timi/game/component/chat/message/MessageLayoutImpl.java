package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.component.chat.at.AtMsgManager;
import com.tencent.timi.game.component.chat.at.AtMsgManager.Companion;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "chatId", "datas", "", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "iImConfig", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "isAttachingWindow", "", "layoutClickListener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$LayoutClickListener;", "layoutClickUpListener", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "messageListener", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "messageViewProvider", "Lcom/tencent/timi/game/component/chat/message/MessageViewProvider;", "newAtMsgView", "Landroid/widget/TextView;", "newMsgCount", "newMsgView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "scrollMsgListener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$OnScrollMsgListener;", "selfUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "showAtMsgId", "viewProvider", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;", "acquireAtText", "Landroid/text/SpannableStringBuilder;", "addHistoryMsg", "", "msgs", "", "addNewMsg", "msg", "addSendMsg", "clearAtMsgShortCut", "clearUnreadNewMsg", "deleteMsg", "msgId", "findAtFromHistory", "findAtPosition", "firstMsg", "getContentRecyclerView", "getMsgNumOnList", "hasAtMeMessage", "insertLocalMsg", "localMsg", "isBottom", "onAttachedToWindow", "onDetachedFromWindow", "onMsgRevoked", "onNewMsg", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "scrollToBottom", "setChatId", "", "setLayoutClickListener", "listener", "setLayoutClickUpListener", "setMessageListener", "setOnScrollMsgListener", "onScrollMsgListener", "setQQUserId", "qqUserId", "setRoomInfo", "setViewProvider", "showAtMsgShortCut", "showAtMsgWhenFirstLoad", "showNewAtMsgShortCut", "up", "Landroid/view/View$OnClickListener;", "sortAndNotify", "updateMsg", "completeScrollToPos", "pos", "useScrollTo", "ViewHolder", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageLayoutImpl
  extends MessageLayout
  implements LifecycleEventObserver
{
  private final String a = "MessageLayoutImplDebug";
  private String b = "";
  private YoloRoomOuterClass.YoloRoomInfo c;
  private final List<IMsg> d = (List)new ArrayList();
  private LinearLayoutManager e;
  private MessageLayout.OnScrollMsgListener f;
  private MessageLayout.IViewProvider g;
  private MessageLayout.IIMConfig h;
  private RecyclerView i;
  private TextView j;
  private TextView k;
  private int l;
  private MessageLayout.LayoutClickListener m;
  private MessageLayout.LayoutClickListener n;
  private final MessageViewProvider o = new MessageViewProvider(null, 1, null);
  private IMessageListener p;
  private String q = "";
  private boolean r;
  private CommonOuterClass.QQUserId s;
  
  @JvmOverloads
  public MessageLayoutImpl(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public MessageLayoutImpl(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public MessageLayoutImpl(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new RecyclerView(paramContext);
    this.i = paramAttributeSet;
    paramAttributeSet.setEnabled(true);
    paramAttributeSet.setOverScrollMode(2);
    paramAttributeSet.setOnTouchListener((View.OnTouchListener)new MessageLayoutImpl..special..inlined.apply.lambda.1(this));
    addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(LayoutExKt.b(this), LayoutExKt.b(this)));
    paramAttributeSet = new TextView(getContext());
    this.j = paramAttributeSet;
    LayoutExKt.a(paramAttributeSet, 10.0F);
    paramAttributeSet.setPadding(0, LayoutExKt.b(2), 0, 0);
    paramAttributeSet.setOnClickListener((View.OnClickListener)new MessageLayoutImpl..special..inlined.textView.lambda.1(this));
    paramAttributeSet.setTextColor(ResUtils.b(2131168464));
    paramAttributeSet.setGravity(1);
    paramAttributeSet.setVisibility(8);
    paramAttributeSet.setBackgroundResource(2130853019);
    paramAttributeSet = (View)paramAttributeSet;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(LayoutExKt.b(21), LayoutExKt.b(21));
    localLayoutParams.gravity = 85;
    localLayoutParams.bottomMargin = LayoutExKt.b(14);
    localLayoutParams.rightMargin = LayoutExKt.b(14);
    addView(paramAttributeSet, (ViewGroup.LayoutParams)localLayoutParams);
    paramAttributeSet = new TextView(getContext());
    this.k = paramAttributeSet;
    LayoutExKt.a(paramAttributeSet, 16.0F);
    paramAttributeSet.setPadding(LayoutExKt.b(11), LayoutExKt.b(3), LayoutExKt.b(11), LayoutExKt.b(3));
    paramAttributeSet.setOnClickListener((View.OnClickListener)new MessageLayoutImpl..special..inlined.textView.lambda.2(this));
    paramAttributeSet.setCompoundDrawablePadding(LayoutExKt.b(3));
    paramAttributeSet.setTextColor(ResUtils.b(2131165564));
    paramAttributeSet.setGravity(1);
    paramAttributeSet.setVisibility(8);
    paramAttributeSet.setBackgroundResource(2130852919);
    paramAttributeSet = (View)paramAttributeSet;
    localLayoutParams = new FrameLayout.LayoutParams(LayoutExKt.a(this), LayoutExKt.a(this));
    localLayoutParams.gravity = 81;
    localLayoutParams.bottomMargin = LayoutExKt.b(16);
    addView(paramAttributeSet, (ViewGroup.LayoutParams)localLayoutParams);
    setOverScrollMode(2);
    this.e = new LinearLayoutManager(paramContext);
    this.e.setOrientation(1);
    this.i.setLayoutManager((RecyclerView.LayoutManager)this.e);
    paramContext = this.i.getItemAnimator();
    if (paramContext != null)
    {
      paramContext.setChangeDuration(0L);
      paramContext.setAddDuration(100L);
      paramContext.setRemoveDuration(100L);
      paramContext.setMoveDuration(100L);
    }
    this.i.addItemDecoration((RecyclerView.ItemDecoration)new MessageLayoutImpl.7());
    this.i.setAdapter((RecyclerView.Adapter)new MessageLayoutImpl.8(this));
  }
  
  private final void a(@NotNull RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.d.size())
    {
      if (paramInt < 0) {
        return;
      }
      paramRecyclerView.post((Runnable)new MessageLayoutImpl.completeScrollToPos.1(this, paramRecyclerView, paramBoolean, paramInt));
    }
  }
  
  private final void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.k;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setVisibility(0);
    localTextView = this.k;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setOnClickListener(paramOnClickListener);
  }
  
  private final void d()
  {
    CollectionsKt.sortWith(this.d, (Comparator)MessageLayoutImpl.sortAndNotify.1.a);
    RecyclerView.Adapter localAdapter = this.i.getAdapter();
    if (localAdapter != null) {
      localAdapter.notifyDataSetChanged();
    }
  }
  
  private final void d(IMsg paramIMsg)
  {
    if (!MessageFilterUtilKt.a(paramIMsg)) {
      return;
    }
    this.d.add(paramIMsg);
    paramIMsg = this.i.getAdapter();
    if (paramIMsg != null) {
      paramIMsg.notifyItemInserted(this.d.size() - 1);
    }
  }
  
  private final void e()
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    ViewExKt.a((View)localTextView, false);
    this.l = 0;
  }
  
  private final boolean e(IMsg paramIMsg)
  {
    if ((paramIMsg.g().at_user_msg.user_list.size() > 0) && (TextUtils.isEmpty((CharSequence)this.q)) && (SpecialMsgUtil.a.a(paramIMsg, this.s)))
    {
      this.q = paramIMsg.a();
      return true;
    }
    return TextUtils.isEmpty((CharSequence)this.q) ^ true;
  }
  
  private final void f()
  {
    Object localObject1 = ((Iterable)this.d).iterator();
    boolean bool = false;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IMsg)((Iterator)localObject1).next();
      if (AtMsgManager.a.a().a(this.b, ((IMsg)localObject2).a())) {
        bool = true;
      }
    }
    localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showAtMsgWhenFirstLoad: ");
    ((StringBuilder)localObject2).append(bool);
    Logger.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if (bool) {
      ThreadPool.a((Runnable)new MessageLayoutImpl.showAtMsgWhenFirstLoad.2(this), 700L);
    }
  }
  
  private final SpannableStringBuilder g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)"有人@你");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(ResUtils.b(2131168293)), 2, 4, 33);
    return localSpannableStringBuilder;
  }
  
  private final void h()
  {
    Object localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    ((TextView)localObject).setText((CharSequence)g());
    int i1 = i();
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAtMsgShortCut: ");
    localStringBuilder.append(i1);
    Logger.b((String)localObject, localStringBuilder.toString());
    a(false, (View.OnClickListener)new MessageLayoutImpl.showAtMsgShortCut.1(this, i1));
  }
  
  private final int i()
  {
    if (!TextUtils.isEmpty((CharSequence)this.q))
    {
      Iterator localIterator = ((Iterable)this.d).iterator();
      int i1 = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i1 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject = (IMsg)localObject;
        if (Intrinsics.areEqual(this.q, ((IMsg)localObject).a()))
        {
          int i2 = this.d.size() - i1;
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
    Iterator localIterator = ((Iterable)CollectionsKt.reversed((Iterable)this.d)).iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i1 < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (IMsg)localObject;
      if (AtMsgManager.a.a().a(this.b, ((IMsg)localObject).a())) {
        return this.d.size() - i1 - 1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private final void k()
  {
    this.q = "";
    this.l = 0;
    TextView localTextView = this.k;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newAtMsgView");
    }
    localTextView.setVisibility(8);
  }
  
  public void a()
  {
    RecyclerView.Adapter localAdapter = this.i.getAdapter();
    int i1;
    if (localAdapter != null) {
      i1 = localAdapter.getItemCount();
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return;
    }
    this.i.stopScroll();
    this.e.scrollToPositionWithOffset(i1 - 1, 0);
    e();
    k();
  }
  
  public void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addSendMsg ");
    localStringBuilder.append(paramIMsg.a());
    Logger.b(str, localStringBuilder.toString());
    this.d.add(paramIMsg);
    paramIMsg = this.i.getAdapter();
    if (paramIMsg != null) {
      paramIMsg.notifyItemInserted(this.d.size());
    }
    a();
  }
  
  public void a(@Nullable String paramString)
  {
    Iterator localIterator = CollectionsKt.withIndex((Iterable)this.d).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(paramString, ((IMsg)((IndexedValue)localObject).getValue()).a()))
      {
        paramString = (String)localObject;
        break label61;
      }
    }
    paramString = null;
    label61:
    paramString = (IndexedValue)paramString;
    if (paramString != null)
    {
      ((IMsg)paramString.getValue()).a(MsgStatus.REVOKE);
      localObject = this.i.getAdapter();
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).notifyItemChanged(paramString.getIndex());
      }
    }
  }
  
  public void a(@NotNull List<? extends IMsg> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "msgs");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (MessageFilterUtilKt.a((IMsg)localObject2)) {
        paramList.add(localObject2);
      }
    }
    paramList = (List)paramList;
    if (paramList.isEmpty()) {
      return;
    }
    if (this.d.isEmpty())
    {
      this.d.addAll((Collection)paramList);
      d();
      a();
      ThreadPool.a((Runnable)new MessageLayoutImpl.addHistoryMsg.1(this), 100L);
      return;
    }
    this.d.addAll(0, (Collection)paramList);
    localObject1 = this.i.getAdapter();
    if (localObject1 != null) {
      ((RecyclerView.Adapter)localObject1).notifyItemRangeInserted(0, paramList.size());
    }
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (b())
    {
      d(paramIMsg);
      a();
      return;
    }
    this.l += 1;
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    ViewExKt.a((View)localObject, true);
    d(paramIMsg);
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("newMsgView");
    }
    int i1 = this.l;
    if (i1 > 99) {
      localObject = "99";
    } else {
      localObject = String.valueOf(i1);
    }
    localTextView.setText((CharSequence)String.valueOf(localObject));
    if (e(paramIMsg))
    {
      paramIMsg = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasAtMeMessage: ");
      ((StringBuilder)localObject).append(this.q);
      Logger.b(paramIMsg, ((StringBuilder)localObject).toString());
      h();
    }
  }
  
  public void b(@Nullable String paramString)
  {
    Iterator localIterator = CollectionsKt.withIndex((Iterable)this.d).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(paramString, ((IMsg)((IndexedValue)localObject).getValue()).a()))
      {
        paramString = (String)localObject;
        break label61;
      }
    }
    paramString = null;
    label61:
    paramString = (IndexedValue)paramString;
    if (paramString != null)
    {
      localObject = this.i.getAdapter();
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).notifyItemChanged(paramString.getIndex());
      }
    }
  }
  
  public boolean b()
  {
    return this.e.findLastVisibleItemPosition() == this.d.size() - 1;
  }
  
  @Nullable
  public IMsg c()
  {
    if ((((Collection)this.d).isEmpty() ^ true)) {
      return (IMsg)this.d.get(0);
    }
    return null;
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "localMsg");
    this.d.add(paramIMsg);
    paramIMsg = this.i.getAdapter();
    if (paramIMsg != null) {
      paramIMsg.notifyItemInserted(this.d.size());
    }
  }
  
  public void c(@Nullable String paramString)
  {
    CollectionsKt.removeAll(this.d, (Function1)new MessageLayoutImpl.deleteMsg.1(paramString));
    paramString = this.i.getAdapter();
    if (paramString != null) {
      paramString.notifyDataSetChanged();
    }
  }
  
  @NotNull
  public RecyclerView getContentRecyclerView()
  {
    return this.i;
  }
  
  public int getMsgNumOnList()
  {
    return this.d.size();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = true;
    if ((getContext() instanceof LifecycleOwner))
    {
      Context localContext = getContext();
      if (localContext != null)
      {
        ((LifecycleOwner)localContext).getLifecycle().addObserver((LifecycleObserver)this);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r = false;
    if ((getContext() instanceof LifecycleOwner))
    {
      localObject = getContext();
      if (localObject != null) {
        ((LifecycleOwner)localObject).getLifecycle().removeObserver((LifecycleObserver)this);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
      }
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_type;
      if ((localObject != null) && (((PBInt32Field)localObject).get() == 1)) {}
    }
    else
    {
      TeamInfoAutoUpdateService.a().b();
    }
  }
  
  public void onStateChanged(@NotNull LifecycleOwner paramLifecycleOwner, @NotNull Lifecycle.Event paramEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "source");
    Intrinsics.checkParameterIsNotNull(paramEvent, "event");
    paramLifecycleOwner = Lifecycle.Event.ON_PAUSE;
  }
  
  public void setChatId(long paramLong)
  {
    this.b = String.valueOf(paramLong);
  }
  
  public void setLayoutClickListener(@NotNull MessageLayout.LayoutClickListener paramLayoutClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutClickListener, "listener");
    this.m = paramLayoutClickListener;
  }
  
  public void setLayoutClickUpListener(@NotNull MessageLayout.LayoutClickListener paramLayoutClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutClickListener, "listener");
    this.n = paramLayoutClickListener;
  }
  
  public final void setMessageListener(@NotNull IMessageListener paramIMessageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIMessageListener, "listener");
    this.p = paramIMessageListener;
  }
  
  public void setOnScrollMsgListener(@Nullable MessageLayout.OnScrollMsgListener paramOnScrollMsgListener)
  {
    this.f = paramOnScrollMsgListener;
  }
  
  public void setQQUserId(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "qqUserId");
    this.s = paramQQUserId;
  }
  
  public void setRoomInfo(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.c = paramYoloRoomInfo;
    if (paramYoloRoomInfo != null)
    {
      paramYoloRoomInfo = paramYoloRoomInfo.room_id;
      if (paramYoloRoomInfo != null)
      {
        long l1 = paramYoloRoomInfo.get();
        this.o.a(l1);
      }
    }
  }
  
  public void setViewProvider(@Nullable MessageLayout.IViewProvider paramIViewProvider)
  {
    this.g = paramIViewProvider;
    this.o.a(paramIViewProvider);
    if (paramIViewProvider != null) {
      paramIViewProvider = paramIViewProvider.a();
    } else {
      paramIViewProvider = null;
    }
    this.h = paramIViewProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl
 * JD-Core Version:    0.7.0.1
 */