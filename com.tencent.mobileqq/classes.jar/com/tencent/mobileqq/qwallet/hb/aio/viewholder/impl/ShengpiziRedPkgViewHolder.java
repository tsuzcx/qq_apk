package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletHtmlOfflineConfigService;
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
  IPasswdRedBagService y;
  
  public ShengpiziRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramBaseSessionInfo, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.y = ((IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class, ""));
    if (a(this.y.getPasswdRedBagInfoById(this.b.mQQWalletRedPacketMsg.redPacketId))) {
      this.o = 0;
    } else {
      this.o = paramQQWalletBaseMsgElem.w;
    }
    this.r = R.drawable.N;
  }
  
  public void d()
  {
    if (this.a != null)
    {
      if (this.a.g() == null) {
        return;
      }
      this.a.g().setVisibility(0);
      this.a.g().setTextSize(15.0F);
      this.a.g().setTextColor(-1);
      if (!TextUtils.isEmpty(this.c.body.shengpiziMask)) {
        this.a.g().setText(this.c.body.shengpiziMask);
      }
    }
  }
  
  public void e()
  {
    super.e();
    try
    {
      this.a.h().setTextColor(-1);
      this.a.h().setTextSize(48.0F);
      this.a.h().setText(QWalletTools.a(this.a.h().getContext(), this.d.c, 330, this.a.h().getPaint()));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.h().getLayoutParams();
      localLayoutParams.width = ScreenUtil.dip2px(64.0F);
      localLayoutParams.height = ScreenUtil.dip2px(64.0F);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = ScreenUtil.dip2px(9.0F);
      this.a.h().setLayoutParams(localLayoutParams);
      this.a.h().setBackgroundResource(R.drawable.i);
      ((IQWalletHtmlOfflineConfigService)QRoute.api(IQWalletHtmlOfflineConfigService.class)).setShengpiziTypeface(this.a.h());
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
    this.a.c().setText("生僻字红包");
    return true;
  }
  
  public void i()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.b.mQQWalletRedPacketMsg;
    Object localObject2 = this.y.getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    PasswdRedBagInfo localPasswdRedBagInfo;
    if (localObject2 == null)
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("hb_from", localQQWalletRedPacketMsg.elem.A);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localPasswdRedBagInfo = new PasswdRedBagInfo(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.b.senderuin, this.b.time + 90000L, localQQWalletRedPacketMsg.body.shengpiziMD5, false, false, 8, ((JSONObject)localObject2).toString());
      this.y.savePasswdRedBag(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, localQQWalletRedPacketMsg.body.shengpiziMask, this.b.senderuin, this.b.time + 90000L, String.valueOf(this.y.transType(this.b.istroop)), this.b.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 8, "", ((JSONObject)localObject2).toString());
    }
    if (!a(localPasswdRedBagInfo))
    {
      this.a.e().setVisibility(8);
      return;
    }
    this.a.e().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.ShengpiziRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */