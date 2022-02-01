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
import com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QQWalletHbItemApiImpl$4
  implements View.OnClickListener
{
  QQWalletHbItemApiImpl$4(QQWalletHbItemApiImpl paramQQWalletHbItemApiImpl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    if (this.a.mHbItemClickListener != null) {
      this.a.mHbItemClickListener.a(8);
    }
    long l = System.currentTimeMillis();
    if (!((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(QQWalletHbItemApiImpl.mLastClickedTime, l)) {
      return;
    }
    QQWalletHbItemApiImpl.mLastClickedTime = l;
    MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
    Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = (IPasswdRedBagService)this.a.mAppInterface.getRuntimeService(IPasswdRedBagService.class, "");
    if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.a.sessionInfo.b))
    {
      ((IPasswdRedBagService)localObject2).createPasswdRedBagAnonymousTips(this.a.sessionInfo.b, 8);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont show passwdredbag tips");
      }
      return;
    }
    if (this.a.sessionInfo.a == 1)
    {
      localObject3 = (ITroopGagMgr)this.a.mAppInterface.getRuntimeService(ITroopGagMgr.class);
      boolean bool = ((ITroopGagMgr)localObject3).isTroopMemberGag(this.a.sessionInfo.b, this.a.mAppInterface.getCurrentAccountUin());
      localObject3 = ((ITroopGagMgr)localObject3).getSelfGagInfo(this.a.sessionInfo.b, false);
      if ((bool) || ((localObject3 != null) && (((SelfGagInfo)localObject3).b)))
      {
        ((IPasswdRedBagService)localObject2).createPasswdRedBagBanTips(this.a.sessionInfo.b, 8);
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        }
        return;
      }
    }
    Object localObject3 = ((IPasswdRedBagService)localObject2).getPasswdRedBagInfoById(((QQWalletRedPacketMsg)localObject1).redPacketId);
    l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if ((localObject3 != null) && ((((PasswdRedBagInfo)localObject3).f) || (((PasswdRedBagInfo)localObject3).g) || (((PasswdRedBagInfo)localObject3).d < l)))
    {
      ((IPasswdRedBagService)localObject2).setPasswdRedBagOpen(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.sessionInfo.b, this.a.sessionInfo.a);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=18", 0, null);
      paramView = VoiceRedPacketHelperImpl.getVoiceScoreId(localMessageForQQWalletMsg);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("feedsid", VoiceRedPacketHelperImpl.getKSongFeedsId(localMessageForQQWalletMsg));
      ((IPasswdRedBagService)localObject2).openPasswdBagByTenpay(this.a.sessionInfo, (PasswdRedBagInfo)localObject3, l, 131072, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.v, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject1);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("click open passwdredbag, isPasswdRedBagOpen=");
        paramView.append(((PasswdRedBagInfo)localObject3).f);
        paramView.append(",isPasswdRedBagFinish=");
        paramView.append(((PasswdRedBagInfo)localObject3).g);
        paramView.append(",isPasswdRedBagOverDue=");
        paramView.append(((PasswdRedBagInfo)localObject3).a());
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
    else
    {
      localObject2 = new Intent();
      if ((this.a.sessionInfo instanceof Parcelable)) {
        ((Intent)localObject2).putExtra("session", (Parcelable)this.a.sessionInfo);
      }
      ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject5 = QWalletRedPkgUtils.a(this.a.mAppInterface, this.a.sessionInfo);
      int j = ((Bundle)localObject5).getInt("groupType");
      localObject5 = ((Bundle)localObject5).getString("name");
      int i;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.u;
      } else {
        i = 0;
      }
      localObject3 = QWalletRedPkgUtils.a(this.a.mAppInterface, this.a.sessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.sessionInfo.b, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
      ((Bundle)localObject4).putString("callbackSn", "0");
      ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramView.getContext() instanceof Activity)) {
        ((Intent)localObject2).addFlags(268435456);
      }
      QPublicFragmentActivity.Launcher.a(paramView.getContext(), (Intent)localObject2, QPublicTransFragmentActivity.class, RedPacketKSongFragment.class);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("show passwdredbag ksong tips = ");
        paramView.append(((QQWalletRedPacketMsg)localObject1).elem.c);
        QLog.d("PasswdRedBagSgervice", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.QQWalletHbItemApiImpl.4
 * JD-Core Version:    0.7.0.1
 */