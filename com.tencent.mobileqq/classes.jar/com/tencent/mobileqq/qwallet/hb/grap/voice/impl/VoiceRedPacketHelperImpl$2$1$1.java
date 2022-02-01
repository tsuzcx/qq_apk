package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import Wallet.VoiceRedPackMatchRsp;
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

class VoiceRedPacketHelperImpl$2$1$1
  implements Runnable
{
  VoiceRedPacketHelperImpl$2$1$1(VoiceRedPacketHelperImpl.2.1 param1, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.d.a;
    Object localObject1 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.d.b.j.onVoiceRedPacketListenerRef.get();
    int i;
    if (localObject1 != null) {
      i = localObject1.hashCode();
    } else {
      i = 0;
    }
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.b();
    if (!this.a) {
      VoiceRedPacketHelperImpl.access$100(this.d.b.j, 3, l, 1, this.d.b.b);
    }
    if ((this.a) && (this.b != null) && (this.c == 13) && (localBaseQQAppInterface != null) && (this.d.b.b != null) && (localObject1 != null) && (!((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).p()) && (!this.d.b.j.isCancel) && (i == this.d.b.j.identify))
    {
      Object localObject2 = (VoiceRedPackMatchRsp)this.b.getSerializable("rsp");
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("VoiceRedPackMatchRsp onReceive:");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject2 != null) && (((VoiceRedPackMatchRsp)localObject2).grabUin == localBaseQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject2).billno != null) && (((VoiceRedPackMatchRsp)localObject2).billno.equals(this.d.b.b.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("VoiceRedPackMatchRsp status:");
          ((StringBuilder)localObject3).append(((VoiceRedPackMatchRsp)localObject2).status);
          QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = this.d.b.j;
        ((VoiceRedPacketHelperImpl)localObject3).serverTryTime += 1;
        VoiceRedPacketHelperImpl.access$100(this.d.b.j, ((VoiceRedPackMatchRsp)localObject2).status, l, 1, this.d.b.b);
        i = ((VoiceRedPackMatchRsp)localObject2).status;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              localObject3 = ((VoiceRedPackMatchRsp)localObject2).strErr;
              l = NetConnInfoCenter.getServerTime();
              ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putLong(localBaseQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject2).timeInterval);
              ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putString(localBaseQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject3);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("server is busy interval is ");
                localStringBuilder.append(((VoiceRedPackMatchRsp)localObject2).timeInterval);
                localStringBuilder.append(",tips is ");
                localStringBuilder.append((String)localObject3);
                QLog.d("VoiceRedPacketHelperImpl", 2, localStringBuilder.toString());
              }
              if (this.d.b.j.isInitSuccess)
              {
                localObject2 = VoiceRedPacketHelperImpl.access$200(this.d.b.j, this.d.b.j.fileBytes, this.d.b.b);
                if (((VoiceRedPacketHelperImpl.RecogResult)localObject2).a)
                {
                  this.d.b.j.syncVoiceScoreIdToMr(((VoiceRedPacketHelperImpl.RecogResult)localObject2).c, this.d.b.g, this.d.b.h);
                  ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage(localBaseQQAppInterface, this.d.b.g, this.d.b.i);
                }
                ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(((VoiceRedPacketHelperImpl.RecogResult)localObject2).a, ((VoiceRedPacketHelperImpl.RecogResult)localObject2).c);
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("check in phone, result is ");
                  ((StringBuilder)localObject1).append(localObject2);
                  QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject1).toString());
                }
              }
              else
              {
                VoiceRedPacketHelperImpl.access$300(this.d.b.j, (String)localObject3);
              }
            }
          }
          else
          {
            this.d.b.j.syncVoiceScoreIdToMr(((VoiceRedPackMatchRsp)localObject2).degree, this.d.b.g, this.d.b.h);
            this.d.b.j.saveVoiceScoreId(((VoiceRedPackMatchRsp)localObject2).degree, this.d.b.b);
            ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(true, ((VoiceRedPackMatchRsp)localObject2).degree);
            ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage(localBaseQQAppInterface, this.d.b.g, this.d.b.i);
          }
        }
        else {
          ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(false, "");
        }
        this.d.b.j.redPacketCacheMap.remove(this.d.b.g);
        return;
      }
      this.d.b.j.onError("rsp is null");
      return;
    }
    this.d.b.j.onError("onReceive VoiceRedPackMatchRsp erorr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.2.1.1
 * JD-Core Version:    0.7.0.1
 */