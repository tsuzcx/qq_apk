package com.tencent.timi.game.teamlist.view;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TeamListItemViewHolder$1$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  TeamListItemViewHolder$1$1(TeamListItemViewHolder.1 param1) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setJoinTeam onError:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errorMessage:");
    localStringBuilder.append(paramString);
    Logger.b("TeamListItemViewHolder", localStringBuilder.toString());
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    Logger.b("TeamListItemViewHolder", "setJoinTeam onSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */