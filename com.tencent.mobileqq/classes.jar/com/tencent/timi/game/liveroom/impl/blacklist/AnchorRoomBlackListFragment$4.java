package com.tencent.timi.game.liveroom.impl.blacklist;

import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class AnchorRoomBlackListFragment$4
  implements KickOutUserCallback
{
  AnchorRoomBlackListFragment$4(AnchorRoomBlackListFragment paramAnchorRoomBlackListFragment, KickOutUserCallback paramKickOutUserCallback, long paramLong) {}
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeUserFromBlack - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - success");
    Logger.a("AnchorRoomBlackListFragment", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((KickOutUserCallback)localObject).a(paramLong);
    }
    CustomToastView.a("操作成功");
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeUserFromBlack - ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" - onFailed - ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("AnchorRoomBlackListFragment", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("操作失败, ");
    ((StringBuilder)localObject).append(paramString);
    CustomToastView.a(((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((KickOutUserCallback)localObject).onFailed(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment.4
 * JD-Core Version:    0.7.0.1
 */