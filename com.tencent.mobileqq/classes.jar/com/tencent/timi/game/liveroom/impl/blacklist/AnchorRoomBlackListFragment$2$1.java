package com.tencent.timi.game.liveroom.impl.blacklist;

import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import java.util.Iterator;
import java.util.List;

class AnchorRoomBlackListFragment$2$1
  implements KickOutUserCallback
{
  AnchorRoomBlackListFragment$2$1(AnchorRoomBlackListFragment.2 param2) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = AnchorRoomBlackListFragment.a(this.a.a).iterator();
    while (localIterator.hasNext())
    {
      localLimitUserInfo = (LimitUserInfo)localIterator.next();
      if (localLimitUserInfo.uid == paramLong) {
        break label52;
      }
    }
    LimitUserInfo localLimitUserInfo = null;
    label52:
    if (localLimitUserInfo != null)
    {
      AnchorRoomBlackListFragment.c(this.a.a).removeItem(localLimitUserInfo);
      if (AnchorRoomBlackListFragment.c(this.a.a).getItemCount() == 0) {
        AnchorRoomBlackListFragment.d(this.a.a);
      }
    }
  }
  
  public void onFailed(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment.2.1
 * JD-Core Version:    0.7.0.1
 */