package com.tencent.mobileqq.onlinestatus.binder;

import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper.IGetStatusRankCallback;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankResponse;

class AccountPanelBinder$13
  implements OlympicProtocolHelper.IGetStatusRankCallback
{
  AccountPanelBinder$13(AccountPanelBinder paramAccountPanelBinder, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel, AppRuntime paramAppRuntime) {}
  
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
        QLog.i("AccountPanelBinder", 2, paramStatusRankResponse.toString());
      }
      this.a.a(l);
      OnlineStatusSPUtil.a(this.b.getContext(), this.c.getCurrentUin(), true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSwitchToOlympicStatus onGetStatusRank error: ");
    localStringBuilder.append(paramStatusRankResponse.res.get());
    QLog.e("AccountPanelBinder", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.13
 * JD-Core Version:    0.7.0.1
 */