package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayout;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addHistoryMsg", "", "msgs", "", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "addSendMsg", "msg", "deleteMsg", "msgId", "", "firstMsg", "getContentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMsgNumOnList", "insertLocalMsg", "localMsg", "isBottom", "", "onMsgRevoked", "onNewMsg", "scrollToBottom", "setChatId", "chatId", "", "setLayoutClickListener", "listener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$LayoutClickListener;", "setLayoutClickUpListener", "setOnScrollMsgListener", "onScrollMsgListener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$OnScrollMsgListener;", "setQQUserId", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setRoomInfo", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setViewProvider", "viewProvider", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;", "updateMsg", "IIMConfig", "IView", "IViewProvider", "LayoutClickListener", "OnScrollMsgListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class MessageLayout
  extends FrameLayout
{
  @JvmOverloads
  public MessageLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public MessageLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public MessageLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NotNull
  public abstract RecyclerView getContentRecyclerView();
  
  public abstract int getMsgNumOnList();
  
  public abstract void setChatId(long paramLong);
  
  public abstract void setLayoutClickListener(@NotNull MessageLayout.LayoutClickListener paramLayoutClickListener);
  
  public abstract void setLayoutClickUpListener(@NotNull MessageLayout.LayoutClickListener paramLayoutClickListener);
  
  public abstract void setOnScrollMsgListener(@Nullable MessageLayout.OnScrollMsgListener paramOnScrollMsgListener);
  
  public abstract void setQQUserId(@NotNull CommonOuterClass.QQUserId paramQQUserId);
  
  public abstract void setRoomInfo(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo);
  
  public abstract void setViewProvider(@Nullable MessageLayout.IViewProvider paramIViewProvider);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayout
 * JD-Core Version:    0.7.0.1
 */