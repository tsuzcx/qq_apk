package com.tencent.timi.game.component.chat.message;

import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.chat.at.AtMessageClickListener;
import com.tencent.timi.game.expand.hall.impl.util.ExpandProfileUtil;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.team.impl.team.FleetProfileUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TextMessageItemView$handleAtMsg$1", "Lcom/tencent/timi/game/component/chat/at/AtMessageClickListener;", "onClick", "", "atUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TextMessageItemView$handleAtMsg$1
  implements AtMessageClickListener
{
  public void a(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    ((TextView)this.a.a(2131447089)).performClick();
    if (paramQQUserId != null)
    {
      QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
      if (localQBaseActivity != null)
      {
        Object localObject = this.a.getRoomInfo();
        if (localObject != null)
        {
          localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_type;
          if ((localObject != null) && (((PBInt32Field)localObject).get() == 5))
          {
            localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5).room_id;
            ExpandProfileUtil.a.a(localQBaseActivity, paramQQUserId, ((PBUInt64Field)localObject).get());
            return;
          }
        }
        localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
        if (localObject != null)
        {
          localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_id;
          if (localObject != null)
          {
            long l = ((PBUInt64Field)localObject).get();
            boolean bool = ((ITeamService)ServiceCenter.a(ITeamService.class)).b(l);
            FleetProfileUtil.a.a(localQBaseActivity, paramQQUserId, bool, paramQQUserId.uid.get(), l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TextMessageItemView.handleAtMsg.1
 * JD-Core Version:    0.7.0.1
 */