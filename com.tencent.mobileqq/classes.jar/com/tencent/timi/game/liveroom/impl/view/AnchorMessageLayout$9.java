package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveSysMsg;
import com.tencent.timi.game.liveroom.impl.view.message.AnchorAnnounceMsgItemView;
import com.tencent.timi.game.liveroom.impl.view.message.AnchorBaseTextMsgItemView;
import com.tencent.timi.game.liveroom.impl.view.message.AnchorGiftMsgItemView;
import com.tencent.timi.game.liveroom.impl.view.message.AnchorMsgRegistryKt;
import com.tencent.timi.game.liveroom.impl.view.message.AnchorTextMsgItemView;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$9", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$ViewHolder;", "Lcom/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$9
  extends RecyclerView.Adapter<AnchorMessageLayout.ViewHolder>
{
  @NotNull
  public AnchorMessageLayout.ViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateViewHolder, viewType = [");
    paramViewGroup.append(paramInt);
    paramViewGroup.append(']');
    Logger.b("AnchorMessageLayout", paramViewGroup.toString());
    AnchorMessageLayout localAnchorMessageLayout = this.a;
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        paramViewGroup = localAnchorMessageLayout.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
        paramViewGroup = (View)new AnchorTextMsgItemView(paramViewGroup, null, 0, 6, null);
        break;
      case 100: 
      case 101: 
      case 102: 
        paramViewGroup = localAnchorMessageLayout.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
        paramViewGroup = (View)new AnchorTextMsgItemView(paramViewGroup, null, 0, 6, null);
      }
      break;
    case 5: 
      paramViewGroup = localAnchorMessageLayout.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
      paramViewGroup = (View)new AnchorGiftMsgItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 4: 
      paramViewGroup = localAnchorMessageLayout.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
      paramViewGroup = (View)new AnchorAnnounceMsgItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 1: 
    case 2: 
    case 3: 
    case 6: 
      paramViewGroup = localAnchorMessageLayout.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "context");
      paramViewGroup = (View)new AnchorTextMsgItemView(paramViewGroup, null, 0, 6, null);
    }
    return new AnchorMessageLayout.ViewHolder(localAnchorMessageLayout, paramViewGroup);
  }
  
  public void a(@NotNull AnchorMessageLayout.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    Object localObject = AnchorMessageLayout.c(this.a).get(paramInt);
    if ((paramViewHolder.itemView instanceof AnchorBaseTextMsgItemView)) {
      ((AnchorBaseTextMsgItemView)paramViewHolder.itemView).setRoomId(AnchorMessageLayout.k(this.a));
    }
    View localView = paramViewHolder.itemView;
    if ((localView instanceof AnchorTextMsgItemView))
    {
      if ((localObject instanceof ILiveMsg)) {
        ((AnchorTextMsgItemView)paramViewHolder.itemView).a((ILiveMsg)localObject, AnchorMessageLayout.n(this.a));
      } else if ((localObject instanceof FollowPushMessage)) {
        ((AnchorTextMsgItemView)paramViewHolder.itemView).a((FollowPushMessage)localObject);
      } else if ((localObject instanceof LiveMessageData.SpeakerInfo)) {
        ((AnchorTextMsgItemView)paramViewHolder.itemView).a((LiveMessageData.SpeakerInfo)localObject);
      } else if ((localObject instanceof AnchorLiveSysMsg)) {
        ((AnchorTextMsgItemView)paramViewHolder.itemView).a((AnchorLiveSysMsg)localObject);
      }
    }
    else if ((localView instanceof AnchorAnnounceMsgItemView))
    {
      paramViewHolder = (AnchorAnnounceMsgItemView)paramViewHolder.itemView;
      if (localObject != null) {
        paramViewHolder.a((AnnouncePushMessage)localObject, AnchorMessageLayout.k(this.a));
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage");
      }
    }
    else if ((localView instanceof AnchorGiftMsgItemView))
    {
      paramViewHolder = (AnchorGiftMsgItemView)paramViewHolder.itemView;
      if (localObject != null) {
        paramViewHolder.a((GiftMessage)localObject);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.gift.GiftMessage");
      }
    }
    if (paramInt == AnchorMessageLayout.c(this.a).size() - 1)
    {
      AnchorMessageLayout.o(this.a);
      AnchorMessageLayout.j(this.a);
    }
  }
  
  public int getItemCount()
  {
    return AnchorMessageLayout.c(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return AnchorMsgRegistryKt.a(AnchorMessageLayout.c(this.a).get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.9
 * JD-Core Version:    0.7.0.1
 */