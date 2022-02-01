package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import Wallet.SongRedPackMatchRsp;
import android.os.Bundle;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

class VoiceRedPacketHelperImpl$3$1$1
  implements Runnable
{
  VoiceRedPacketHelperImpl$3$1$1(VoiceRedPacketHelperImpl.3.1 param1, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.d.a;
    Object localObject2 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.d.b.l.onVoiceRedPacketListenerRef.get();
    int i;
    if (localObject2 != null) {
      i = localObject2.hashCode();
    } else {
      i = 0;
    }
    Object localObject1 = QWalletTools.b();
    if (!this.a) {
      VoiceRedPacketHelperImpl.access$100(this.d.b.l, 3, l1 - l2, 1, this.d.b.h);
    }
    if ((this.a) && (this.b != null) && (this.c == 21) && (localObject1 != null) && (this.d.b.a != null) && (localObject2 != null) && (!((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject2).p()) && (!this.d.b.l.isCancel) && (i == this.d.b.l.identify))
    {
      SongRedPackMatchRsp localSongRedPackMatchRsp = (SongRedPackMatchRsp)this.b.getSerializable("rsp");
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("SongRedPackMatchRsp onReceive:");
        ((StringBuilder)localObject3).append(localSongRedPackMatchRsp);
        QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localSongRedPackMatchRsp != null) && (localSongRedPackMatchRsp.grabUin == ((BaseQQAppInterface)localObject1).getLongAccountUin()) && (localSongRedPackMatchRsp.billno != null) && (localSongRedPackMatchRsp.billno.equals(this.d.b.a.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("VoiceRedPackMatchRsp status:");
          ((StringBuilder)localObject3).append(localSongRedPackMatchRsp.status);
          QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = this.d.b.l;
        ((VoiceRedPacketHelperImpl)localObject3).serverTryTime += 1;
        i = localSongRedPackMatchRsp.status;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              localObject2 = localSongRedPackMatchRsp.strErr;
              l1 = NetConnInfoCenter.getServerTime();
              ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putLong(((BaseQQAppInterface)localObject1).getCurrentAccountUin(), "voice_recognieze_in_phone", l1 + localSongRedPackMatchRsp.timeInterval);
              ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putString(((BaseQQAppInterface)localObject1).getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("server is busy interval is ");
                ((StringBuilder)localObject1).append(localSongRedPackMatchRsp.timeInterval);
                ((StringBuilder)localObject1).append(",tips is ");
                ((StringBuilder)localObject1).append((String)localObject2);
                QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject1).toString());
              }
              VoiceRedPacketHelperImpl.access$300(this.d.b.l, (String)localObject2);
            }
          }
          else
          {
            this.d.b.l.syncVoiceScoreIdToMr(localSongRedPackMatchRsp.degree, this.d.b.i, this.d.b.j);
            this.d.b.l.saveVoiceScoreId(localSongRedPackMatchRsp.degree, this.d.b.a);
            ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject2).a(true, localSongRedPackMatchRsp.degree);
            ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage((AppRuntime)localObject1, this.d.b.i, this.d.b.k);
          }
        }
        else {
          ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject2).a(false, "");
        }
        this.d.b.l.redPacketCacheMap.remove(this.d.b.i);
        this.d.b.l.mix2RecordMap.remove(this.d.b.i);
        return;
      }
      this.d.b.l.onError("rsp is null");
      return;
    }
    this.d.b.l.onError("onReceive SongRedPackMatchRsp erorr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.3.1.1
 * JD-Core Version:    0.7.0.1
 */