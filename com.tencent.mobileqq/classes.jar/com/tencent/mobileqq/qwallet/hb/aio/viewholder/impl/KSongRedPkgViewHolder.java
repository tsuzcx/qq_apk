package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

public class KSongRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService y;
  
  public KSongRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramBaseSessionInfo, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.y = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.y.getPasswdRedBagInfoById(this.b.mQQWalletRedPacketMsg.redPacketId))) {
      this.o = 0;
    } else {
      this.o = paramQQWalletBaseMsgElem.w;
    }
    this.r = R.drawable.J;
  }
  
  public void e()
  {
    super.e();
    try
    {
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
    this.a.c().setText("K歌红包");
    return true;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.b.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo2 = this.y.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    PasswdRedBagInfo localPasswdRedBagInfo1 = localPasswdRedBagInfo2;
    if (localPasswdRedBagInfo2 == null)
    {
      localPasswdRedBagInfo1 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.b.senderuin, this.b.time + 90000L, this.d.c, false, false, 2);
      this.y.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.d.c, this.b.senderuin, this.b.time + 90000L, String.valueOf(this.y.transType(this.b.istroop)), this.b.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 2);
    }
    if (!a(localPasswdRedBagInfo1))
    {
      this.a.e().setVisibility(8);
      return;
    }
    this.a.e().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.KSongRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */