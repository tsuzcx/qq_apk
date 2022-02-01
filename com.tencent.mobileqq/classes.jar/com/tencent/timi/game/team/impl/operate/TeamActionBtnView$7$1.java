package com.tencent.timi.game.team.impl.operate;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class TeamActionBtnView$7$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  TeamActionBtnView$7$1(TeamActionBtnView.7 param7) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!TeamActionBtnView.a(this.a.a, paramInt, paramString, "guest doReady"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("准备失败, ");
      localStringBuilder.append(paramString);
      CustomToastView.a(localStringBuilder.toString());
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.7.1
 * JD-Core Version:    0.7.0.1
 */