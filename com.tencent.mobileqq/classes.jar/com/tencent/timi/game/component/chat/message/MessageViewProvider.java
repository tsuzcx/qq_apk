package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.tim.api.impl.message.MessageOuterClassExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomRotateMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageViewProvider;", "", "viewProvider", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;)V", "roomId", "", "getViewProvider", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;", "setViewProvider", "getItemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "msgType", "", "getMessageType", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "setRoomId", "", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageViewProvider
{
  public static final MessageViewProvider.Companion a = new MessageViewProvider.Companion(null);
  private long b;
  @Nullable
  private MessageLayout.IViewProvider c;
  
  public MessageViewProvider()
  {
    this(null, 1, null);
  }
  
  public MessageViewProvider(@Nullable MessageLayout.IViewProvider paramIViewProvider)
  {
    this.c = paramIViewProvider;
  }
  
  public final int a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    int j = paramIMsg.c();
    int i = 4;
    if (j == 1) {}
    do
    {
      return 1;
      if (j == 79) {
        return 7;
      }
      if (j == 78)
      {
        if (paramIMsg.g().share_yolo_room_msg.room_info.room_type.get() != 1) {
          return 4;
        }
        return 5;
      }
      if (j == 49)
      {
        i = paramIMsg.g().yolo_room_action_msg.yolo_room_action.action_type.get();
        if ((i != 19) && (i != 108) && (i != 101) && (i != 102) && (i != 251))
        {
          if (i != 252) {
            return 4;
          }
          return 6;
        }
        return 10;
      }
      if (j == 48)
      {
        boolean bool = paramIMsg.j();
        if (bool == true) {
          return 2;
        }
        if (!bool) {
          return 3;
        }
        throw new NoWhenBranchMatchedException();
      }
      if (j == 63)
      {
        if (paramIMsg.g().yolo_room_rotate_msg.yolo_room_rotate_message.message_type.get() != 1) {
          return 4;
        }
        return 8;
      }
    } while (j == MessageOuterClassExKt.a());
    if (j == MessageOuterClassExKt.b()) {
      i = 9;
    }
    return i;
  }
  
  @NotNull
  public final View a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    switch (paramInt)
    {
    case 4: 
    default: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new TextMessageItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 10: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new TeamActionMessageItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 9: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new SmobaLoadSelectItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 8: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new SystemMessageItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 7: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new ProfileMessageItemView(paramViewGroup);
      break;
    case 6: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new SmobaCapInfoItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 5: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new TeamMessageItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 3: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new SendGiftMessageOtherItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 2: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new SendGiftMessageSelfItemView(paramViewGroup, null, 0, 6, null);
      break;
    case 1: 
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = (View)new TextMessageItemView(paramViewGroup, null, 0, 6, null);
    }
    if ((paramViewGroup instanceof TouchPositionGetableRelativeLayout)) {
      ((TouchPositionGetableRelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    return paramViewGroup;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(@Nullable MessageLayout.IViewProvider paramIViewProvider)
  {
    this.c = paramIViewProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewProvider
 * JD-Core Version:    0.7.0.1
 */