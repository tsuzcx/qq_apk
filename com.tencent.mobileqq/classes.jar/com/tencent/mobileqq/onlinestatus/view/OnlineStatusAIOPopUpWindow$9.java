package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper.IGetStatusRankCallback;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankResponse;

class OnlineStatusAIOPopUpWindow$9
  implements OlympicProtocolHelper.IGetStatusRankCallback
{
  OnlineStatusAIOPopUpWindow$9(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow, Friends paramFriends) {}
  
  public void a(StatusRankMgr.StatusRankResponse paramStatusRankResponse)
  {
    if (paramStatusRankResponse.res.get() == 0)
    {
      this.a.curOlympicRank = paramStatusRankResponse.rank.get();
      this.b.k();
      if (QLog.isColorLevel())
      {
        paramStatusRankResponse = new StringBuilder();
        paramStatusRankResponse.append("handleSwitchToOlympicStatus onGetStatusRank success: rank ");
        paramStatusRankResponse.append(OnlineStatusAIOPopUpWindow.a(this.b).curOlympicRank);
        QLog.i("OnlineStatusAIOPopUpWindow", 2, paramStatusRankResponse.toString());
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSwitchToOlympicStatus onGetStatusRank error: ");
      localStringBuilder.append(paramStatusRankResponse.res.get());
      QLog.e("OnlineStatusAIOPopUpWindow", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.9
 * JD-Core Version:    0.7.0.1
 */