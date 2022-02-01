package com.tencent.mobileqq.nearby.gameroom;

import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$11
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$11(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt != 0) && (paramInt != 1004))
    {
      this.a.handle8e4Error(paramInt, paramRspBody, (String)GameRoomInviteActivity.errorCodeMsgs.get(paramInt));
    }
    else
    {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
      paramRspBody = this.a;
      SharedPreUtils.a(paramRspBody, paramRspBody.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      paramRspBody = this.a;
      paramRspBody.mIsOwner = true;
      paramRspBody.mOwnerUin = paramRspBody.app.getLongAccountUin();
      paramRspBody = this.a;
      paramRspBody.mInviteId = null;
      GameRoomConstants.a = null;
      paramRspBody.mUsers = null;
      paramRspBody.mRecentInviteLayout.setVisibility(8);
      if (this.a.mInviteUsers != null) {
        this.a.mInviteUsers.clear();
      }
      paramRspBody = this.a;
      paramRspBody.isRequested = false;
      paramRspBody.refreshUI();
      paramRspBody = this.a.getSelf();
      if ((paramRspBody != null) && (paramRspBody.b)) {
        QQToast.makeText(this.a, HardCodeUtil.a(2131903052), 0).show();
      }
      this.a.mAdapter.notifyDataSetChanged();
      this.a.mRightButton.setVisibility(8);
    }
    this.a.mRightButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.11
 * JD-Core Version:    0.7.0.1
 */