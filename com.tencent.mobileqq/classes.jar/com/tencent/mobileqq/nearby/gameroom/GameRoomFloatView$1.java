package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;

class GameRoomFloatView$1
  implements View.OnClickListener
{
  GameRoomFloatView$1(GameRoomFloatView paramGameRoomFloatView, int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (this.a == 1)
    {
      paramView = new Intent(this.f.c, SplashActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      paramView.putExtra("uin", localStringBuilder.toString());
      paramView.putExtra("uintype", 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      paramView.putExtra("troop_uin", localStringBuilder.toString());
      paramView.putExtra("uinname", this.c);
      paramView.putExtra("isGameRoom", true);
      paramView = AIOUtils.a(paramView, new int[] { 1, 2 });
      this.f.c.startActivity(paramView);
      if ((this.f.c instanceof ChatActivity)) {
        ((ChatActivity)this.f.c).finish();
      }
      ReportController.b(null, "dc00899", "Grp_wolf", "", "in_game", "active_ball", 0, 0, "", "", "", "");
      return;
    }
    paramView = AIOUtils.a(new Intent(), new int[] { 2 });
    paramView.putExtra("inviteId", this.d);
    paramView.putExtra("roomNum", this.e);
    RouteUtils.a(BaseApplicationImpl.getContext(), paramView, "/nearby/gameroom/invite");
    this.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView.1
 * JD-Core Version:    0.7.0.1
 */