package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import mqq.app.AppRuntime;

class QQWalletHbItemApiImpl$9
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$9(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (((IQWalletTemp)QRoute.api(IQWalletTemp.class)).BaseChatItemLayout$CheckBoxVisible()) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(0);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    int m = QwUtils.a(paramView.getTag(R.id.cd), 0);
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    if ((localMessageForQQWalletMsg != null) && (this.a.sessionInfo != null))
    {
      Object localObject2 = this.a.sessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject1;
      Object localObject3;
      if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
      {
        localObject1 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = "";
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = "";
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = 0;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId = 0;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        ((IMessageFacade)this.a.mAppInterface.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(this.a.sessionInfo.jdField_a_of_type_JavaLangString, this.a.sessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
        localObject3 = localObject2;
        localObject2 = null;
      }
      else if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
      {
        if ((this.a.sessionInfo.jdField_a_of_type_Int != 0) && (this.a.sessionInfo.jdField_a_of_type_Int != 1000) && (this.a.sessionInfo.jdField_a_of_type_Int != 1004) && (this.a.sessionInfo.jdField_a_of_type_Int != 1001) && (this.a.sessionInfo.jdField_a_of_type_Int != 10002) && (this.a.sessionInfo.jdField_a_of_type_Int != 10004) && (this.a.sessionInfo.jdField_a_of_type_Int != 1008)) {
          i = 0;
        } else {
          i = 1;
        }
        localObject1 = localObject2;
        if (i != 0)
        {
          localObject1 = localObject2;
          if (!localMessageForQQWalletMsg.isSend()) {
            localObject1 = this.a.mAppInterface.getCurrentAccountUin();
          }
        }
        if ((localMessageForQQWalletMsg.fromHBList != 1) && ((localMessageForQQWalletMsg.istroop == 1) || (localMessageForQQWalletMsg.istroop == 3000)) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)) {
          NotifyMsgApiImpl.onGroupHbGrabbedNotify(localMessageForQQWalletMsg.frienduin, localMessageForQQWalletMsg.istroop, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
        }
        localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
        localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        ((IMessageFacade)this.a.mAppInterface.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(this.a.sessionInfo.jdField_a_of_type_JavaLangString, this.a.sessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
        localObject3 = this.a.mAppInterface;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("");
        localStringBuilder1.append(localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId);
        ReportController.b((AppRuntime)localObject3, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, localStringBuilder1.toString(), "", "", "");
        if ((((QQWalletBaseMsgElem)localObject4).i > 0) && ((localMessageForQQWalletMsg.messageType == 2) || (localMessageForQQWalletMsg.messageType == 3)))
        {
          localObject3 = this.a.mAppInterface;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("");
          localStringBuilder1.append(((QQWalletBaseMsgElem)localObject4).i);
          ReportController.b((AppRuntime)localObject3, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.click", 0, 0, localStringBuilder1.toString(), "", "", "");
        }
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
      else
      {
        localObject3 = localObject2;
        localObject1 = null;
        localObject2 = localObject1;
      }
      if (localObject1 == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("elem.actionsPriority: ");
        ((StringBuilder)localObject4).append(((QQWalletBaseMsgElem)localObject1).g);
        QLog.d("QQWalletHbItemApi", 2, ((StringBuilder)localObject4).toString());
      }
      if (TextUtils.isEmpty(((QQWalletBaseMsgElem)localObject1).g))
      {
        ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).d);
        return;
      }
      Object localObject4 = ((QQWalletBaseMsgElem)localObject1).g.split("\\|");
      int j = 0;
      int i = 0;
      while (j < localObject4.length)
      {
        if (!TextUtils.isEmpty(localObject4[j]))
        {
          int k;
          try
          {
            k = Integer.valueOf(localObject4[j]).intValue();
          }
          catch (Exception localException)
          {
            if (QLog.isDevelopLevel()) {
              localException.printStackTrace();
            }
            k = i;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("QQWalletMsgItemBuilder failed to convert String:");
              localStringBuilder2.append(localObject4[j]);
              localStringBuilder2.append(" to Interger,");
              QLog.d("QQWalletHbItemApi", 2, localStringBuilder2.toString(), localException);
              k = i;
            }
          }
          if (k == 1) {
            if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).d))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQWalletHbItemApi", 2, "start browser...");
              return;
            }
          }
          for (;;)
          {
            break;
            if (k == 2)
            {
              String str = QwUtils.a(((QQWalletBaseMsgElem)localObject1).h, QQWalletHbItemApiImpl.access$100(this.a, m), true);
              if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doJumpAction(paramView.getContext(), str))
              {
                if (!QLog.isColorLevel()) {
                  break label1182;
                }
                QLog.d("QQWalletHbItemApi", 2, "do jump action...");
              }
            }
            else if (k == 3)
            {
              if (QQWalletHbItemApiImpl.access$200(this.a, paramView.getContext(), (QQWalletBaseMsgElem)localObject1, (String)localObject2, (String)localObject3, localMessageForQQWalletMsg, this.a.sessionInfo))
              {
                if (!QLog.isColorLevel()) {
                  break label1182;
                }
                QLog.d("QQWalletHbItemApi", 2, "do wallet action...");
                return;
              }
            }
          }
          i = -1;
        }
        j += 1;
      }
      label1182:
      return;
    }
    paramView = new StringBuilder();
    paramView.append("error, qqWalletMsg: ");
    paramView.append(localMessageForQQWalletMsg);
    paramView.append(", sessionInfo: ");
    paramView.append(this.a.sessionInfo);
    QLog.i("QQWalletHbItemApi", 2, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.9
 * JD-Core Version:    0.7.0.1
 */