package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.graphics.Color;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class GoldRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService y;
  
  public GoldRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramBaseSessionInfo, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.y = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.y.getPasswdRedBagInfoById(this.b.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.o = 0;
      return;
    }
    this.o = paramQQWalletBaseMsgElem.w;
  }
  
  public void e()
  {
    super.e();
    try
    {
      this.a.h().setTextColor(Color.parseColor("#604121"));
      this.a.h().setText(QWalletTools.a(this.a.h().getContext(), this.d.c, 330, this.a.h().getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean g()
  {
    boolean bool = super.g();
    if (bool) {
      return bool;
    }
    this.a.c().setVisibility(0);
    this.a.c().setText("黄金红包");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.GoldRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */