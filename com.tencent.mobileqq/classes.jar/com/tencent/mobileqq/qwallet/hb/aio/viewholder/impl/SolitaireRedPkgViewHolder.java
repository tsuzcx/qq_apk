package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SolitaireRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService y;
  
  public SolitaireRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramBaseSessionInfo, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.y = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.y.getPasswdRedBagInfoById(this.b.mQQWalletRedPacketMsg.redPacketId))) {
      this.o = 0;
    } else {
      this.o = paramQQWalletBaseMsgElem.w;
    }
    this.r = R.drawable.I;
  }
  
  public boolean g()
  {
    boolean bool = super.g();
    if (bool) {
      return bool;
    }
    this.a.c().setVisibility(0);
    this.a.c().setText("接龙红包");
    this.a.c().setSingleLine(true);
    this.a.c().setEllipsize(TextUtils.TruncateAt.END);
    this.a.c().setSelected(true);
    return false;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.b.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo = this.y.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    Object localObject2 = localPasswdRedBagInfo;
    Object localObject1;
    if (localPasswdRedBagInfo == null)
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
        PasswdRedBagInfo.a((JSONObject)localObject2, localQQWalletRedPacketMsg.body.poemRule);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (localQQWalletRedPacketMsg.body.subChannel == 2) {
        localObject1 = localQQWalletRedPacketMsg.elem.D;
      } else {
        localObject1 = "";
      }
      localObject2 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.b.senderuin, this.b.time + 90000L, this.d.c, false, false, 4, (String)localObject1, ((JSONObject)localObject2).toString());
      this.y.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.d.c, this.b.senderuin, 90000L + this.b.time, String.valueOf(this.y.transType(this.b.istroop)), this.b.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
    }
    if ((StringUtil.isEmpty(((PasswdRedBagInfo)localObject2).i)) || (StringUtil.isEmpty(((PasswdRedBagInfo)localObject2).i.trim()))) {
      this.y.setPasswdRedBagLastedWord(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.c, localQQWalletRedPacketMsg.elem.D, 0, localQQWalletRedPacketMsg.body.poemRule);
    }
    if (!a((PasswdRedBagInfo)localObject2)) {
      this.a.e().setVisibility(8);
    } else {
      this.a.e().setVisibility(0);
    }
    if (!StringUtil.isEmpty(((PasswdRedBagInfo)localObject2).i))
    {
      if (((PasswdRedBagInfo)localObject2).g)
      {
        this.a.c().setText("接龙红包");
        return;
      }
      localObject1 = ((PasswdRedBagInfo)localObject2).i;
      String str1 = this.y.getLastIdiomPinyin((String)localObject1);
      String str2 = this.y.getLastIdiom((String)localObject1);
      if (!StringUtil.isEmpty(str1))
      {
        int i = localQQWalletRedPacketMsg.body.subChannel;
        if (i != 2)
        {
          if (i != 3)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.cP));
            ((StringBuilder)localObject1).append(str1.trim());
            ((StringBuilder)localObject1).append(" ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("接龙红包：");
            ((StringBuilder)localObject1).append(str2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.cO));
          ((StringBuilder)localObject1).append(str1.trim());
          ((StringBuilder)localObject1).append(" ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        this.a.c().setText((CharSequence)localObject1);
        if (((PasswdRedBagInfo)localObject2).b() == 3) {
          localObject1 = str2;
        } else {
          localObject1 = str1;
        }
        this.y.updateIdiomBubbleView(this.e, (String)localObject1, ((PasswdRedBagInfo)localObject2).a);
      }
    }
    else if (((PasswdRedBagInfo)localObject2).g)
    {
      this.a.c().setText("接龙红包");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.SolitaireRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */