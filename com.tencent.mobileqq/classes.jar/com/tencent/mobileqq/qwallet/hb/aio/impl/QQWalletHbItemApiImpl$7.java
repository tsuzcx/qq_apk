package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.os.Bundle;
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
import java.util.ArrayList;

class QQWalletHbItemApiImpl$7
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$7(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(10);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    Object localObject3 = (MessageForQQWalletMsg)paramView.getTag();
    paramView = ((MessageForQQWalletMsg)localObject3).mQQWalletRedPacketMsg;
    Object localObject1 = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.jdField_a_of_type_JavaLangString))
    {
      ((IPasswdRedBagService)localObject1).createPasswdRedBagAnonymousTips(this.a.sessionInfo.jdField_a_of_type_JavaLangString, 10);
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
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("msgType=");
      ((StringBuilder)localObject4).append(((MessageForQQWalletMsg)localObject3).messageType);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", ((StringBuilder)localObject4).toString(), 0, null);
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("subchannel", paramView.body.subChannel);
      ((IPasswdRedBagService)localObject1).openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject2, l, ((MessageForQQWalletMsg)localObject3).fromHBList, (Bundle)localObject4);
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
    else if (this.a.mBaseChatPie != null)
    {
      localObject3 = this.a.mBaseChatPie.a();
      if ((localObject3 != null) && (localObject2 != null)) {
        ((IQWalletAIOLifeCycleHelper)localObject3).a(paramView.redPacketId, ((PasswdRedBagInfo)localObject2).e, paramView.body.subChannel);
      }
    }
    try
    {
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(paramView.redPacketId);
      ((IPasswdRedBagService)localObject1).refreshCureentIdomResbag(this.a.sessionInfo, (ArrayList)localObject2);
      label512:
      ((IPasswdRedBagService)localObject1).reportPasswdRedBagClick(paramView.redPacketId, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("show passwdredbag tips = ");
        ((StringBuilder)localObject1).append(paramView.elem.jdField_a_of_type_JavaLangString);
        QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label512;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.7
 * JD-Core Version:    0.7.0.1
 */