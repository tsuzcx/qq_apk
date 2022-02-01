package com.tencent.timi.game.liveroom.impl.message;

import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.MsgContent;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.MsgElement;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.TextElement;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.timi.game.liveroom.api.message.ILiveMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/message/AnchorLiveMsg;", "Lcom/tencent/timi/game/liveroom/api/message/ILiveMsg;", "liveMessageData", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "(Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;)V", "getLiveMessageData", "()Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "timMsg", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "content", "id", "", "message", "sender", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "type", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorLiveMsg
  implements ILiveMsg
{
  private MessageOuterClass.TimMsgBody a;
  @NotNull
  private final LiveMessageData b;
  
  public AnchorLiveMsg(@NotNull LiveMessageData paramLiveMessageData)
  {
    this.b = paramLiveMessageData;
  }
  
  @NotNull
  public String a()
  {
    String str = this.b.mMessageId;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  @NotNull
  public LiveMessageData.SpeakerInfo b()
  {
    LiveMessageData.SpeakerInfo localSpeakerInfo = this.b.mSpeakerInfo;
    Intrinsics.checkExpressionValueIsNotNull(localSpeakerInfo, "liveMessageData.mSpeakerInfo");
    return localSpeakerInfo;
  }
  
  @NotNull
  public String c()
  {
    Object localObject = this.b.msgContent.mMsgElements;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "liveMessageData.msgContent.mMsgElements");
    if ((((Collection)localObject).isEmpty() ^ true))
    {
      localObject = ((LiveMessageData.MsgElement)this.b.msgContent.mMsgElements.get(0)).mTextMsg.strText;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "liveMessageData.msgConte…ments[0].mTextMsg.strText");
      return localObject;
    }
    return "";
  }
  
  @Nullable
  public MessageOuterClass.TimMsgBody d()
  {
    Object localObject3;
    if (this.a == null) {
      localObject3 = null;
    }
    try
    {
      Object localObject1 = this.b.msgContent.mExtDatas;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "liveMessageData.msgContent.mExtDatas");
      Object localObject4 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = ((Iterator)localObject4).next();
        if (((LiveMessageData.ExtData)localObject1).mId == 100001)
        {
          i = 1;
          break label126;
          localObject4 = (LiveMessageData.ExtData)localObject1;
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = (MessageOuterClass.TimMsgBody)new MessageOuterClass.TimMsgBody().mergeFrom(Base64Util.decode(((LiveMessageData.ExtData)localObject4).mValue, 2));
          }
          this.a = ((MessageOuterClass.TimMsgBody)localObject1);
          return this.a;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        continue;
        int i = 0;
        label126:
        if (i != 0)
        {
          continue;
          localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.message.AnchorLiveMsg
 * JD-Core Version:    0.7.0.1
 */