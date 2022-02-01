package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class BirthdayRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService y;
  
  public BirthdayRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
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
    if (this.a != null)
    {
      if (this.a.h() == null) {
        return;
      }
      this.a.h().setVisibility(0);
    }
  }
  
  public boolean g()
  {
    boolean bool = super.g();
    if (bool) {
      return bool;
    }
    this.a.c().setVisibility(0);
    this.a.c().setText("QQ生日红包");
    return true;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.b.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo = this.y.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    Object localObject = localPasswdRedBagInfo;
    if (localPasswdRedBagInfo == null)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("hb_from", localQQWalletRedPacketMsg.elem.A);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localObject = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.b.senderuin, this.b.time + 90000L, localQQWalletRedPacketMsg.body.shengpiziMD5, false, false, 9, ((JSONObject)localObject).toString());
      this.y.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.d.c, this.b.senderuin, this.b.time + 90000L, String.valueOf(this.y.transType(this.b.istroop)), this.b.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 9);
    }
    if (!a((PasswdRedBagInfo)localObject))
    {
      this.a.e().setVisibility(8);
      return;
    }
    this.a.e().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BirthdayRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */