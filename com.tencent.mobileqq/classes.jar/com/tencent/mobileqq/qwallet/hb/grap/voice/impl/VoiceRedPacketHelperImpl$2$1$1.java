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
    long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_Long;
    Object localObject1 = (VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.onVoiceRedPacketListenerRef.get();
    int i;
    if (localObject1 != null) {
      i = localObject1.hashCode();
    } else {
      i = 0;
    }
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
    if (!this.jdField_a_of_type_Boolean) {
      VoiceRedPacketHelperImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl, 3, l, 1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_Int == 13) && (localBaseQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null) && (localObject1 != null) && (!((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).d()) && (!this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.isCancel) && (i == this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.identify))
    {
      Object localObject2 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("VoiceRedPackMatchRsp onReceive:");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject2 != null) && (((VoiceRedPackMatchRsp)localObject2).grabUin == localBaseQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject2).billno != null) && (((VoiceRedPackMatchRsp)localObject2).billno.equals(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("VoiceRedPackMatchRsp status:");
          ((StringBuilder)localObject3).append(((VoiceRedPackMatchRsp)localObject2).status);
          QLog.d("VoiceRedPacketHelperImpl", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl;
        ((VoiceRedPacketHelperImpl)localObject3).serverTryTime += 1;
        VoiceRedPacketHelperImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl, ((VoiceRedPackMatchRsp)localObject2).status, l, 1, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
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
              if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.isInitSuccess)
              {
                localObject2 = VoiceRedPacketHelperImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.fileBytes, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
                if (((VoiceRedPacketHelperImpl.RecogResult)localObject2).jdField_a_of_type_Boolean)
                {
                  this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.syncVoiceScoreIdToMr(((VoiceRedPacketHelperImpl.RecogResult)localObject2).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
                  ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage(localBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
                }
                ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(((VoiceRedPacketHelperImpl.RecogResult)localObject2).jdField_a_of_type_Boolean, ((VoiceRedPacketHelperImpl.RecogResult)localObject2).jdField_a_of_type_JavaLangString);
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
                VoiceRedPacketHelperImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl, (String)localObject3);
              }
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.syncVoiceScoreIdToMr(((VoiceRedPackMatchRsp)localObject2).degree, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
            this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.saveVoiceScoreId(((VoiceRedPackMatchRsp)localObject2).degree, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(true, ((VoiceRedPackMatchRsp)localObject2).degree);
            ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQAppInterface$getMessageFacade$addAndSendMessage(localBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
          }
        }
        else {
          ((VoiceRedPacketHelperImpl.OnVoiceRedPacketListener)localObject1).a(false, "");
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.redPacketCacheMap.remove(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.onError("rsp is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2$1.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl$2.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.onError("onReceive VoiceRedPackMatchRsp erorr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.2.1.1
 * JD-Core Version:    0.7.0.1
 */