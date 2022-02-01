package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.component.chat.ChatView;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.yolo.esports.room.api.IRoomOperationService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomRotateMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;
import trpc.yes.wuji.WujiSafeOuterClass.WujiSafeConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/util/SafeNoticeMsgManager;", "", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "roomId", "", "chatId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;JJ)V", "getChatId", "()J", "setChatId", "(J)V", "lastTimeInsertMsgNum", "", "getLastTimeInsertMsgNum", "()I", "setLastTimeInsertMsgNum", "(I)V", "getQqUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setQqUserId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "getRoomId", "setRoomId", "rotateMsg", "Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;", "getRotateMsg", "()Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;", "setRotateMsg", "(Ltrpc/yes/common/MessageOuterClass$YoloRoomRotateMsg;)V", "checkInsertSafeNoticeMsg", "", "chatView", "Lcom/tencent/timi/game/component/chat/ChatView;", "obtainSafeNoticeMsg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "reportHistoryChatNum", "num", "shouldSkipSafeMsg", "", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SafeNoticeMsgManager
{
  public static final SafeNoticeMsgManager.Companion a = new SafeNoticeMsgManager.Companion(null);
  @Nullable
  private static SafeNoticeMsgManager g;
  private int b;
  @Nullable
  private MessageOuterClass.YoloRoomRotateMsg c;
  @NotNull
  private CommonOuterClass.QQUserId d;
  private long e;
  private long f;
  
  public SafeNoticeMsgManager(@NotNull CommonOuterClass.QQUserId paramQQUserId, long paramLong1, long paramLong2)
  {
    this.d = paramQQUserId;
    this.e = paramLong1;
    this.f = paramLong2;
    this.b = -1;
    Object localObject1 = (Iterable)((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).b();
    paramQQUserId = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      int i = 1;
      if (!bool) {
        break;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (((YoloRoomOuterClass.YoloRoomRotateMessage)localObject2).message_type.get() != 1) {
        i = 0;
      }
      if (i != 0) {
        paramQQUserId.add(localObject2);
      }
    }
    paramQQUserId = ((Iterable)paramQQUserId).iterator();
    while (paramQQUserId.hasNext())
    {
      localObject1 = (YoloRoomOuterClass.YoloRoomRotateMessage)paramQQUserId.next();
      if (this.c == null)
      {
        this.c = new MessageOuterClass.YoloRoomRotateMsg();
        localObject2 = this.c;
        if (localObject2 != null)
        {
          localObject2 = ((MessageOuterClass.YoloRoomRotateMsg)localObject2).yolo_room_rotate_message;
          if (localObject2 != null) {
            ((YoloRoomOuterClass.YoloRoomRotateMessage)localObject2).set((MessageMicro)localObject1);
          }
        }
      }
    }
    if (this.c == null)
    {
      this.c = new MessageOuterClass.YoloRoomRotateMsg();
      paramQQUserId = new YoloRoomOuterClass.YoloRoomRotateMessage();
      paramQQUserId.message_type.set(1);
      paramQQUserId.message_tpl.set("系统提示：用QQ开黑扩列大厅进行互动时，严禁传播含有违法违规、造谣传谣、诅咒恶搞、色情低俗、宣传售卖非法物品、导流广告类等违规内容。如有违规，将影响扩列功能的使用，违规严重时更会影响QQ帐号的使用。");
      localObject1 = this.c;
      if (localObject1 != null)
      {
        localObject1 = ((MessageOuterClass.YoloRoomRotateMsg)localObject1).yolo_room_rotate_message;
        if (localObject1 != null) {
          ((YoloRoomOuterClass.YoloRoomRotateMessage)localObject1).set((MessageMicro)paramQQUserId);
        }
      }
    }
  }
  
  private final IMsg d()
  {
    Ref.LongRef localLongRef = new Ref.LongRef();
    localLongRef.element = (NetConnInfoCenter.getServerTime() * 1000);
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = new MessageOuterClass.MsgContent();
    MessageOuterClass.YoloRoomRotateMsg localYoloRoomRotateMsg1 = ((MessageOuterClass.MsgContent)localObjectRef.element).yolo_room_rotate_msg;
    MessageOuterClass.YoloRoomRotateMsg localYoloRoomRotateMsg2 = this.c;
    if (localYoloRoomRotateMsg2 == null) {
      Intrinsics.throwNpe();
    }
    localYoloRoomRotateMsg1.set((MessageMicro)localYoloRoomRotateMsg2);
    return (IMsg)new SafeNoticeMsgManager.obtainSafeNoticeMsg.1(this, localLongRef, localObjectRef);
  }
  
  @NotNull
  public final CommonOuterClass.QQUserId a()
  {
    return this.d;
  }
  
  public final void a(int paramInt)
  {
    int i = this.b;
    if (i != -1) {
      this.b = (i + paramInt);
    }
  }
  
  public final void a(@NotNull ChatView paramChatView)
  {
    Intrinsics.checkParameterIsNotNull(paramChatView, "chatView");
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
    if (localObject != null)
    {
      localObject = ((IRoomGetDataService)localObject).c();
      if (localObject != null)
      {
        localObject = ((YoloRoomOuterClass.YoloRoomConf)localObject).yolo_room_common_conf;
        if (localObject != null)
        {
          localObject = ((YoloRoomOuterClass.YoloRoomCommonConf)localObject).safe_conf;
          if (localObject != null)
          {
            localObject = ((WujiSafeOuterClass.WujiSafeConf)localObject).system_notice_message_num;
            if (localObject != null)
            {
              i = ((PBInt32Field)localObject).get();
              break label91;
            }
          }
        }
      }
    }
    int i = 0;
    label91:
    int j = i;
    if (i == 0) {
      j = 100;
    }
    if (((this.b == -1) || (paramChatView.getMsgNumOnList() - this.b >= j)) && (this.c != null))
    {
      paramChatView.a(d());
      this.b = paramChatView.getMsgNumOnList();
    }
  }
  
  public final long b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager
 * JD-Core Version:    0.7.0.1
 */