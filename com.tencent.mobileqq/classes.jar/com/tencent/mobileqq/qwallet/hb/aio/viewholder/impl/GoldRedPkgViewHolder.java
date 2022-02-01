package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.graphics.Color;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class GoldRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService a;
  
  public GoldRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.i = 0;
      return;
    }
    this.i = paramQQWalletBaseMsgElem.j;
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("黄金红包");
    return true;
  }
  
  public void e()
  {
    super.e();
    try
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText(QWalletTools.a(this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getContext(), this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, 330, this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.GoldRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */