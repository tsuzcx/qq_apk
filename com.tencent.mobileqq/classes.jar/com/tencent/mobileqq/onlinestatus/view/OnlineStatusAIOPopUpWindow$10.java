package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper.IGetStatusRankCallback;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankResponse;

class OnlineStatusAIOPopUpWindow$10
  implements OlympicProtocolHelper.IGetStatusRankCallback
{
  OnlineStatusAIOPopUpWindow$10(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void a(StatusRankMgr.StatusRankResponse paramStatusRankResponse)
  {
    if (paramStatusRankResponse.res.get() == 0)
    {
      long l = paramStatusRankResponse.rank.get();
      if (QLog.isColorLevel())
      {
        paramStatusRankResponse = new StringBuilder();
        paramStatusRankResponse.append("handleSwitchToOlympicStatus onGetStatusRank success: rank ");
        paramStatusRankResponse.append(l);
        QLog.i("OnlineStatusAIOPopUpWindow", 2, paramStatusRankResponse.toString());
      }
      StatusCardViewBuilder.a(OnlineStatusAIOPopUpWindow.f(this.a), l, null);
      OnlineStatusSPUtil.a(BaseApplication.getContext(), OnlineStatusAIOPopUpWindow.c(this.a).getCurrentUin(), true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSwitchToOlympicStatus onGetStatusRank error: ");
    localStringBuilder.append(paramStatusRankResponse.res.get());
    QLog.e("OnlineStatusAIOPopUpWindow", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.10
 * JD-Core Version:    0.7.0.1
 */