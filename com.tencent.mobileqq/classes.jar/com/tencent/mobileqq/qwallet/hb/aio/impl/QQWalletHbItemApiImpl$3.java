package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.ITroopGagMgr;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.qphone.base.util.QLog;

class QQWalletHbItemApiImpl$3
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$3(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(11);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.b))
    {
      localIPasswdRedBagService.createPasswdRedBagAnonymousTips(this.a.sessionInfo.b, 11);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    if (this.a.sessionInfo.a == 1)
    {
      localObject = (ITroopGagMgr)this.a.mAppInterface.getRuntimeService(ITroopGagMgr.class);
      boolean bool = ((ITroopGagMgr)localObject).isTroopMemberGag(this.a.sessionInfo.b, this.a.mAppInterface.getCurrentAccountUin());
      localObject = ((ITroopGagMgr)localObject).getSelfGagInfo(this.a.sessionInfo.b, false);
      if ((bool) || ((localObject != null) && (((SelfGagInfo)localObject).b)))
      {
        localIPasswdRedBagService.createPasswdRedBagBanTips(this.a.sessionInfo.b, 11);
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        }
        return;
      }
    }
    Object localObject = localIPasswdRedBagService.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject != null) && ((((PasswdRedBagInfo)localObject).f) || (((PasswdRedBagInfo)localObject).g) || (((PasswdRedBagInfo)localObject).d < l)))
    {
      localIPasswdRedBagService.setPasswdRedBagOpen(localQQWalletRedPacketMsg.redPacketId, this.a.sessionInfo.b, this.a.sessionInfo.a);
      paramView = new StringBuilder();
      paramView.append("msgType=");
      paramView.append(localMessageForQQWalletMsg.messageType);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", paramView.toString(), 0, null);
      paramView = new Bundle();
      paramView.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
      localIPasswdRedBagService.openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.v, localMessageForQQWalletMsg.fromHBList, paramView);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open draw redpacket, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject).f);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject).g);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else if ((this.a.sessionInfo instanceof Parcelable))
    {
      DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), (Parcelable)this.a.sessionInfo, localMessageForQQWalletMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.3
 * JD-Core Version:    0.7.0.1
 */