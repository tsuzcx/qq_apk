package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.widget.QQToast;

class GameRoomInviteActivity$2
  implements View.OnClickListener
{
  GameRoomInviteActivity$2(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtils.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, 2131892104, 1).show();
      return;
    }
    this.a.exitInvite();
    this.a.report("invite_page", "clk_exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.2
 * JD-Core Version:    0.7.0.1
 */