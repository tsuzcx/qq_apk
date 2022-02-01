package com.tencent.timi.game.liveroom.impl.blacklist;

import android.view.View;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryKickOutHistoryCallback;
import com.tencent.mobileqq.qqlive.data.supervision.KickOutHistoryListData;
import com.tencent.timi.game.utils.Logger;
import java.util.List;

class AnchorRoomBlackListFragment$3
  implements QueryKickOutHistoryCallback
{
  AnchorRoomBlackListFragment$3(AnchorRoomBlackListFragment paramAnchorRoomBlackListFragment, int paramInt) {}
  
  public void a(KickOutHistoryListData paramKickOutHistoryListData)
  {
    AnchorRoomBlackListFragment.a(this.b, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadPageData - onSuccess - ");
    localStringBuilder.append(paramKickOutHistoryListData.isEnd);
    localStringBuilder.append(", sum = ");
    localStringBuilder.append(paramKickOutHistoryListData.sum);
    Logger.a("AnchorRoomBlackListFragment", localStringBuilder.toString());
    AnchorRoomBlackListFragment.b(this.b, paramKickOutHistoryListData.isEnd);
    AnchorRoomBlackListFragment.a(this.b, paramKickOutHistoryListData.sum);
    paramKickOutHistoryListData = paramKickOutHistoryListData.list;
    if ((paramKickOutHistoryListData != null) && (paramKickOutHistoryListData.size() > 0))
    {
      AnchorRoomBlackListFragment.e(this.b).setVisibility(0);
      AnchorRoomBlackListFragment.a(this.b, paramKickOutHistoryListData);
      return;
    }
    if ((this.a == 0) && (AnchorRoomBlackListFragment.f(this.b) == 0)) {
      AnchorRoomBlackListFragment.d(this.b);
    }
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    AnchorRoomBlackListFragment.a(this.b, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadPageData - onFailed - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("AnchorRoomBlackListFragment", localStringBuilder.toString());
    if ((this.a == 0) && (AnchorRoomBlackListFragment.f(this.b) == 0)) {
      AnchorRoomBlackListFragment.d(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.blacklist.AnchorRoomBlackListFragment.3
 * JD-Core Version:    0.7.0.1
 */