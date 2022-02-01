package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.tim.api.group.IGroupListener;
import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class YoloRoomManager$4
  implements IGroupListener
{
  YoloRoomManager$4(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(@NotNull long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo) {}
  
  public void a(@NotNull long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo, @NotNull List<? extends IGroupMemberInfo> paramList) {}
  
  public void b(@NotNull long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo)
  {
    if ((YoloRoomManager.a(this.a) != null) && (YoloRoomManager.a(this.a).tim_group_id.get() == paramLong))
    {
      paramIGroupMemberInfo = new StringBuilder();
      paramIGroupMemberInfo.append("TIM group dismissed !!! - IMGroupId = ");
      paramIGroupMemberInfo.append(paramLong);
      paramIGroupMemberInfo.append(" - ");
      paramIGroupMemberInfo.append(YoloRoomManager.a(this.a));
      Logger.c("YoloRoomManager", paramIGroupMemberInfo.toString());
      CustomToastView.a("房间已解散");
      YoloRoomManager.a(this.a, -10000, "TIM group dismissed");
    }
  }
  
  public void b(@NotNull long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo, @NotNull List<? extends IGroupMemberInfo> paramList)
  {
    YoloRoomManager.a(this.a, paramLong, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.4
 * JD-Core Version:    0.7.0.1
 */