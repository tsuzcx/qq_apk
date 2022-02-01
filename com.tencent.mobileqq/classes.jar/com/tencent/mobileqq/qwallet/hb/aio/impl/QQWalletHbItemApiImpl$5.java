package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.ITroopGagMgr;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QQWalletHbItemApiImpl$5
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$5(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(2);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject1 = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.b))
    {
      ((IPasswdRedBagService)localObject1).createPasswdRedBagAnonymousTips(this.a.sessionInfo.b, 2);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    if (this.a.sessionInfo.a == 1)
    {
      localObject2 = (ITroopGagMgr)this.a.mAppInterface.getRuntimeService(ITroopGagMgr.class);
      boolean bool = ((ITroopGagMgr)localObject2).isTroopMemberGag(this.a.sessionInfo.b, this.a.mAppInterface.getCurrentAccountUin());
      localObject2 = ((ITroopGagMgr)localObject2).getSelfGagInfo(this.a.sessionInfo.b, false);
      if ((bool) || ((localObject2 != null) && (((SelfGagInfo)localObject2).b)))
      {
        ((IPasswdRedBagService)localObject1).createPasswdRedBagBanTips(this.a.sessionInfo.b, 2);
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        }
        return;
      }
    }
    Object localObject2 = ((IPasswdRedBagService)localObject1).getPasswdRedBagInfoById(localQQWalletRedPacketMsg.redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject2 != null) && ((((PasswdRedBagInfo)localObject2).f) || (((PasswdRedBagInfo)localObject2).g) || (((PasswdRedBagInfo)localObject2).d < l)))
    {
      ((IPasswdRedBagService)localObject1).setPasswdRedBagOpen(localQQWalletRedPacketMsg.redPacketId, this.a.sessionInfo.b, this.a.sessionInfo.a);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
      paramView = VoiceRedPacketHelperImpl.getVoiceScoreId(localMessageForQQWalletMsg);
      ((IPasswdRedBagService)localObject1).openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject2, l, 65536, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.v, localMessageForQQWalletMsg.fromHBList, null);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open passwdredbag, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject2).f);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject2).g);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject2).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else
    {
      localObject1 = new Intent();
      if ((this.a.sessionInfo instanceof Parcelable)) {
        ((Intent)localObject1).putExtra("session", (Parcelable)this.a.sessionInfo);
      }
      ((Intent)localObject1).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
      localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject4 = QWalletRedPkgUtils.a(this.a.mAppInterface, this.a.sessionInfo);
      int j = ((Bundle)localObject4).getInt("groupType");
      localObject4 = ((Bundle)localObject4).getString("name");
      int i;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.u;
      } else {
        i = 0;
      }
      localObject2 = QWalletRedPkgUtils.a(this.a.mAppInterface, this.a.sessionInfo, j, (String)localObject4, (String)localObject2, (String)localObject3, this.a.sessionInfo.b, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("json", ((JSONObject)localObject2).toString());
      ((Bundle)localObject3).putString("callbackSn", "0");
      ((Intent)localObject1).putExtra("detail_bundle", (Bundle)localObject3);
      ((Intent)localObject1).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject1).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramView.getContext() instanceof Activity)) {
        ((Intent)localObject1).addFlags(268435456);
      }
      QPublicFragmentActivity.Launcher.a(paramView.getContext(), (Intent)localObject1, QPublicTransFragmentActivity.class, RedPacketVoiceFragment.class);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("show passwdredbag tips = ");
        paramView.append(localQQWalletRedPacketMsg.elem.c);
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.5
 * JD-Core Version:    0.7.0.1
 */