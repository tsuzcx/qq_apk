package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.os.Bundle;
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
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class QQWalletHbItemApiImpl$2
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$2(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(9);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    Object localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.b))
    {
      localIPasswdRedBagService.createPasswdRedBagAnonymousTips(this.a.sessionInfo.b, 9);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    if (this.a.sessionInfo.a == 1)
    {
      localObject1 = (ITroopGagMgr)this.a.mAppInterface.getRuntimeService(ITroopGagMgr.class);
      boolean bool = ((ITroopGagMgr)localObject1).isTroopMemberGag(this.a.sessionInfo.b, this.a.mAppInterface.getCurrentAccountUin());
      localObject1 = ((ITroopGagMgr)localObject1).getSelfGagInfo(this.a.sessionInfo.b, false);
      if ((bool) || ((localObject1 != null) && (((SelfGagInfo)localObject1).b)))
      {
        localIPasswdRedBagService.createPasswdRedBagBanTips(this.a.sessionInfo.b, 9);
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        }
        return;
      }
    }
    Object localObject1 = localIPasswdRedBagService.getPasswdRedBagInfoById(((QQWalletRedPacketMsg)localObject2).redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject1 != null) && ((((PasswdRedBagInfo)localObject1).f) || (((PasswdRedBagInfo)localObject1).g) || (((PasswdRedBagInfo)localObject1).d < l)))
    {
      localIPasswdRedBagService.setPasswdRedBagOpen(((QQWalletRedPacketMsg)localObject2).redPacketId, this.a.sessionInfo.b, this.a.sessionInfo.a);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
      paramView = VoiceRedPacketHelperImpl.getVoiceScoreId(localMessageForQQWalletMsg);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
      localIPasswdRedBagService.openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject1, l, 262144, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.v, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject2);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open passwdredbag, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject1).f);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject1).g);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject1).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else
    {
      QQToast.makeText(paramView.getContext(), "当前平台版本暂不支持抢该类型红包", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.2
 * JD-Core Version:    0.7.0.1
 */