package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
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
  IPasswdRedBagService a;
  
  public SolitaireRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {
      this.i = 0;
    } else {
      this.i = paramQQWalletBaseMsgElem.j;
    }
    this.j = R.drawable.I;
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("接龙红包");
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setSingleLine(true);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setSelected(true);
    return false;
  }
  
  public void h()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    PasswdRedBagInfo localPasswdRedBagInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
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
        localObject1 = localQQWalletRedPacketMsg.elem.n;
      } else {
        localObject1 = "";
      }
      localObject2 = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, false, false, 4, (String)localObject1, ((JSONObject)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, 90000L + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.transType(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
    }
    if ((StringUtil.a(((PasswdRedBagInfo)localObject2).e)) || (StringUtil.a(((PasswdRedBagInfo)localObject2).e.trim()))) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.setPasswdRedBagLastedWord(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.a, localQQWalletRedPacketMsg.elem.n, 0, localQQWalletRedPacketMsg.body.poemRule);
    }
    if (!a((PasswdRedBagInfo)localObject2)) {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(8);
    } else {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(0);
    }
    if (!StringUtil.a(((PasswdRedBagInfo)localObject2).e))
    {
      if (((PasswdRedBagInfo)localObject2).b)
      {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("接龙红包");
        return;
      }
      localObject1 = ((PasswdRedBagInfo)localObject2).e;
      String str1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getLastIdiomPinyin((String)localObject1);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getLastIdiom((String)localObject1);
      if (!StringUtil.a(str1))
      {
        int i = localQQWalletRedPacketMsg.body.subChannel;
        if (i != 2)
        {
          if (i != 3)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.cM));
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
          ((StringBuilder)localObject1).append(HardCodeUtil.a(R.string.cL));
          ((StringBuilder)localObject1).append(str1.trim());
          ((StringBuilder)localObject1).append(" ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText((CharSequence)localObject1);
        if (((PasswdRedBagInfo)localObject2).a() == 3) {
          localObject1 = str2;
        } else {
          localObject1 = str1;
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.updateIdiomBubbleView(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, ((PasswdRedBagInfo)localObject2).a);
      }
    }
    else if (((PasswdRedBagInfo)localObject2).b)
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("接龙红包");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.SolitaireRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */