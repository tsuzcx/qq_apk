package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class DrawRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService a;
  
  public DrawRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {
      this.i = 0;
    } else {
      this.i = paramQQWalletBaseMsgElem.j;
    }
    this.j = R.drawable.F;
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("画图红包");
    return true;
  }
  
  public void e()
  {
    super.e();
    try
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText(QWalletTools.a(this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getContext(), this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, 330, this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void h()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    PasswdRedBagInfo localPasswdRedBagInfo1 = localPasswdRedBagInfo2;
    if (localPasswdRedBagInfo2 == null)
    {
      localPasswdRedBagInfo1 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, false, false, 5);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.transType(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 5);
    }
    if (!a(localPasswdRedBagInfo1))
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.DrawRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */