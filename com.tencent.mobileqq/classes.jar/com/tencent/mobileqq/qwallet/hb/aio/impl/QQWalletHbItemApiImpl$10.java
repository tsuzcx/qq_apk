package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
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
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.qphone.base.util.QLog;

class QQWalletHbItemApiImpl$10
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$10(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(15);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    paramView = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject1 = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.jdField_a_of_type_JavaLangString))
    {
      ((IPasswdRedBagService)localObject1).createPasswdRedBagAnonymousTips(this.a.sessionInfo.jdField_a_of_type_JavaLangString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    Object localObject2 = ((IPasswdRedBagService)localObject1).getPasswdRedBagInfoById(paramView.redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject2 != null) && ((((PasswdRedBagInfo)localObject2).jdField_a_of_type_Boolean) || (((PasswdRedBagInfo)localObject2).b) || (((PasswdRedBagInfo)localObject2).jdField_a_of_type_Long < l)))
    {
      ((IPasswdRedBagService)localObject1).setPasswdRedBagOpen(paramView.redPacketId, this.a.sessionInfo.jdField_a_of_type_JavaLangString, this.a.sessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
      ((IPasswdRedBagService)localObject1).openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject2, l, localMessageForQQWalletMsg.fromHBList);
      ((IPasswdRedBagService)localObject1).reportPasswdRedBagClick(paramView.redPacketId, true);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open passwdredbag, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject2).jdField_a_of_type_Boolean);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject2).b);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject2).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else
    {
      if (this.a.mBaseChatPie != null)
      {
        localObject2 = this.a.mBaseChatPie.a();
        if (localObject2 != null) {
          ((IQWalletAIOLifeCycleHelper)localObject2).b(paramView.redPacketId, paramView.elem.jdField_a_of_type_JavaLangString, paramView.body.shengpiziMask);
        }
      }
      ((IPasswdRedBagService)localObject1).reportPasswdRedBagClick(paramView.redPacketId, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("show passwdredbag tips = ");
        ((StringBuilder)localObject1).append(paramView.elem.jdField_a_of_type_JavaLangString);
        QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.10
 * JD-Core Version:    0.7.0.1
 */