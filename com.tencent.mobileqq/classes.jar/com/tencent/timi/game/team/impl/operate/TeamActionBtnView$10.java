package com.tencent.timi.game.team.impl.operate;

import android.app.Activity;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveRsp;

class TeamActionBtnView$10
  implements IResultListener<YoloRoomOuterClass.YoloRoomLeaveRsp>
{
  TeamActionBtnView$10(TeamActionBtnView paramTeamActionBtnView, Activity paramActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.a;
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      paramString = this.a;
      if ((paramString instanceof TimiGameBaseActivity)) {
        ((TimiGameBaseActivity)paramString).b();
      }
    }
    TeamActionBtnView.e(this.b);
  }
  
  public void a(YoloRoomOuterClass.YoloRoomLeaveRsp paramYoloRoomLeaveRsp)
  {
    paramYoloRoomLeaveRsp = this.a;
    if ((paramYoloRoomLeaveRsp != null) && (!paramYoloRoomLeaveRsp.isFinishing()))
    {
      paramYoloRoomLeaveRsp = this.a;
      if ((paramYoloRoomLeaveRsp instanceof TimiGameBaseActivity)) {
        ((TimiGameBaseActivity)paramYoloRoomLeaveRsp).b();
      }
    }
    TeamActionBtnView.e(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.10
 * JD-Core Version:    0.7.0.1
 */