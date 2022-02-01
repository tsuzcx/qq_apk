package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.qphone.base.util.QLog;

class QQWalletHbItemApiImpl$6
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$6(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(1);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    paramView = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject1 = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.b))
    {
      ((IPasswdRedBagService)localObject1).createPasswdRedBagAnonymousTips(this.a.sessionInfo.b, 1);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    Object localObject2 = ((IPasswdRedBagService)localObject1).getPasswdRedBagInfoById(paramView.redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject2 != null) && ((((PasswdRedBagInfo)localObject2).f) || (((PasswdRedBagInfo)localObject2).g) || (((PasswdRedBagInfo)localObject2).d < l)))
    {
      ((IPasswdRedBagService)localObject1).setPasswdRedBagOpen(paramView.redPacketId, this.a.sessionInfo.b, this.a.sessionInfo.a);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
      ((IPasswdRedBagService)localObject1).openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject2, l, localMessageForQQWalletMsg.fromHBList);
      ((IPasswdRedBagService)localObject1).reportPasswdRedBagClick(paramView.redPacketId, true);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open passwdredbag, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject2).f);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject2).g);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject2).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else
    {
      if (this.a.mBaseChatPie != null)
      {
        localObject2 = this.a.mBaseChatPie.f();
        if (localObject2 != null) {
          ((IQWalletAIOLifeCycleHelper)localObject2).a(paramView.redPacketId, paramView.elem.c, HardCodeUtil.a(R.string.bM));
        }
      }
      ((IPasswdRedBagService)localObject1).reportPasswdRedBagClick(paramView.redPacketId, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("show passwdredbag tips = ");
        ((StringBuilder)localObject1).append(paramView.elem.c);
        QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.6
 * JD-Core Version:    0.7.0.1
 */