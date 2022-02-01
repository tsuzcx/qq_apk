package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;

public class EpRedPkgViewHolder
  extends BaseViewHolder
{
  public EpRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.a.a().setVisibility(0);
    this.a.a().setTextColor(-8947849);
    this.a.a().setText("企业红包");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.EpRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */