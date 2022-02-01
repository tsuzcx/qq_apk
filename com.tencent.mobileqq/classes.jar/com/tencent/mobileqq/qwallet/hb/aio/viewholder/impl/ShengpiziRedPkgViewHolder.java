package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ShengpiziRedPkgViewHolder
  extends BaseViewHolder
{
  IPasswdRedBagService a;
  public String a;
  public String b = "";
  
  public ShengpiziRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {
      this.i = 0;
    } else {
      this.i = paramQQWalletBaseMsgElem.j;
    }
    this.j = R.drawable.N;
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("生僻字红包");
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder != null)
    {
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b() == null) {
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setVisibility(0);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setTextSize(15.0F);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setTextColor(-1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.body.shengpiziMask)) {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setText(this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.body.shengpiziMask);
      }
    }
  }
  
  public void e()
  {
    super.e();
    try
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setTextColor(-1);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setTextSize(48.0F);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText(QWalletTools.a(this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getContext(), this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString, 330, this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getPaint()));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().getLayoutParams();
      localLayoutParams.width = ScreenUtil.dip2px(64.0F);
      localLayoutParams.height = ScreenUtil.dip2px(64.0F);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = ScreenUtil.dip2px(9.0F);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setBackgroundResource(R.drawable.i);
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    PasswdRedBagInfo localPasswdRedBagInfo;
    if (localObject2 == null)
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("hb_from", localQQWalletRedPacketMsg.elem.m);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localPasswdRedBagInfo = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, localQQWalletRedPacketMsg.body.shengpiziMD5, false, false, 8, ((JSONObject)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, localQQWalletRedPacketMsg.body.shengpiziMask, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioPasswdIPasswdRedBagService.transType(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 8, "", ((JSONObject)localObject2).toString());
    }
    if (!a(localPasswdRedBagInfo))
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.ShengpiziRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */