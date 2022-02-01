package com.tencent.timi.game.component.chat.message;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.aelight.camera.util.EaseCubicInterpolator;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.tim.api.impl.message.MessageOuterClassExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/MessageLayoutImpl$8", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl$ViewHolder;", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "getItemCount", "", "getItemViewType", "position", "handleLaneAnim", "", "view", "Landroid/view/View;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageLayoutImpl$8
  extends RecyclerView.Adapter<MessageLayoutImpl.ViewHolder>
{
  private final void a(View paramView)
  {
    paramView.setTranslationY(paramView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramView.getTranslationY(), 0.0F });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator, "ObjectAnimator.ofFloat(v…\", view.translationY, 0f)");
    localObjectAnimator.setInterpolator((TimeInterpolator)new EaseCubicInterpolator(0.165F, 0.84F, 0.44F, 1.0F));
    localObjectAnimator.setDuration(200L).start();
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    Intrinsics.checkExpressionValueIsNotNull(paramView, "ObjectAnimator.ofFloat(view, \"alpha\", 0f, 1f)");
    paramView.setInterpolator((TimeInterpolator)new EaseCubicInterpolator(0.165F, 0.84F, 0.44F, 1.0F));
    paramView.setDuration(200L).start();
  }
  
  @NotNull
  public MessageLayoutImpl.ViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    MessageLayoutImpl localMessageLayoutImpl = this.a;
    paramViewGroup = MessageLayoutImpl.l(localMessageLayoutImpl).a(paramViewGroup, paramInt);
    if (paramViewGroup != null) {
      return new MessageLayoutImpl.ViewHolder(localMessageLayoutImpl, (View)paramViewGroup);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.TouchPositionGetableRelativeLayout");
  }
  
  public void a(@NotNull MessageLayoutImpl.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    Object localObject2;
    if ((paramViewHolder.itemView instanceof BaseMessageView))
    {
      ((BaseMessageView)paramViewHolder.itemView).setImConfig(MessageLayoutImpl.m(this.a));
      ((BaseMessageView)paramViewHolder.itemView).setYoloRoomInfo(MessageLayoutImpl.n(this.a));
      ((BaseMessageView)paramViewHolder.itemView).setMessageListener(MessageLayoutImpl.o(this.a));
      localObject2 = (BaseMessageView)paramViewHolder.itemView;
      localObject1 = MessageLayoutImpl.p(this.a);
      if (localObject1 != null) {
        localObject1 = ((MessageLayout.IViewProvider)localObject1).b();
      } else {
        localObject1 = null;
      }
      ((BaseMessageView)localObject2).setFilterForwardOption((Boolean)localObject1);
    }
    else if ((paramViewHolder.itemView instanceof CenterMessageView))
    {
      ((CenterMessageView)paramViewHolder.itemView).setThemeConfig(MessageLayoutImpl.m(this.a));
    }
    IMsg localIMsg = (IMsg)MessageLayoutImpl.i(this.a).get(paramInt);
    if ((localIMsg.c() == MessageOuterClassExKt.a()) && (MessageLayoutImpl.n(this.a) != null))
    {
      localObject1 = MessageLayoutImpl.n(this.a);
      if (localObject1 != null)
      {
        localObject1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id;
        if (localObject1 != null)
        {
          long l = ((PBUInt64Field)localObject1).get();
          localObject2 = paramViewHolder.itemView;
          localObject1 = localObject2;
          if (!(localObject2 instanceof TextMessageItemView)) {
            localObject1 = null;
          }
          localObject1 = (TextMessageItemView)localObject1;
          if (localObject1 != null) {
            ((TextMessageItemView)localObject1).setRoomId(l);
          }
        }
      }
    }
    if ((paramViewHolder.itemView instanceof CenterMessageView)) {
      ((CenterMessageView)paramViewHolder.itemView).setPosition(paramInt);
    }
    Object localObject1 = paramViewHolder.itemView;
    if (localObject1 != null)
    {
      localObject2 = (IMessageView)localObject1;
      CommonOuterClass.QQUserId localQQUserId = MessageLayoutImpl.q(this.a);
      if (paramInt > 0) {
        localObject1 = (IMsg)MessageLayoutImpl.i(this.a).get(paramInt - 1);
      } else {
        localObject1 = null;
      }
      ((IMessageView)localObject2).a(localQQUserId, localIMsg, (IMsg)localObject1);
      if (paramInt == MessageLayoutImpl.i(this.a).size() - 1)
      {
        MessageLayoutImpl.r(this.a);
        MessageLayoutImpl.h(this.a);
      }
      localObject1 = MessageLayoutImpl.s(this.a);
      if (localObject1 != null) {
        ((MessageLayout.OnScrollMsgListener)localObject1).a(localIMsg, paramInt);
      }
      if (((paramViewHolder.itemView instanceof TextMessageItemView)) && (localIMsg.c() == 1) && (localIMsg.n() != null))
      {
        localIMsg.a(null);
        localObject1 = paramViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "holder.itemView");
        ((TextMessageItemView)localObject1).setVisibility(4);
        paramViewHolder.itemView.postDelayed((Runnable)new MessageLayoutImpl.8.onBindViewHolder.2(this, paramViewHolder), 100L);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.IMessageView");
  }
  
  public int getItemCount()
  {
    return MessageLayoutImpl.i(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return MessageLayoutImpl.l(this.a).a((IMsg)MessageLayoutImpl.i(this.a).get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.8
 * JD-Core Version:    0.7.0.1
 */