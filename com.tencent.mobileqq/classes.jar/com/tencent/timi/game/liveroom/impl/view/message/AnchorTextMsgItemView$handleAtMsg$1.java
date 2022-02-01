package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.chat.at.AtMessageClickListener;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/message/AnchorTextMsgItemView$handleAtMsg$1", "Lcom/tencent/timi/game/component/chat/at/AtMessageClickListener;", "onClick", "", "atUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTextMsgItemView$handleAtMsg$1
  implements AtMessageClickListener
{
  public void a(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.uid;
      if (paramQQUserId != null)
      {
        long l = paramQQUserId.get();
        paramQQUserId = (MessageOuterClass.AtUser)AnchorTextMsgItemView.a(this.a).get(Long.valueOf(l));
        if (paramQQUserId != null)
        {
          LivingOperateHelper localLivingOperateHelper = LivingOperateHelper.a;
          Object localObject = this.a;
          View localView = (View)localObject;
          localObject = CommonExKt.a((View)localObject);
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          localObject = (Context)localObject;
          l = this.a.getRoomId();
          LiveUserInfo localLiveUserInfo = new LiveUserInfo();
          localLiveUserInfo.nick = paramQQUserId.nick_name.get();
          localLiveUserInfo.uid = paramQQUserId.user_id.uid.get();
          localLiveUserInfo.headUrl = paramQQUserId.head_url.get();
          localLivingOperateHelper.a(localView, (Context)localObject, l, localLiveUserInfo, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorTextMsgItemView.handleAtMsg.1
 * JD-Core Version:    0.7.0.1
 */