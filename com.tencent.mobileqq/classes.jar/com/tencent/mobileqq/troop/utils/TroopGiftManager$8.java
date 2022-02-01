package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.RspBody;

class TroopGiftManager$8
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$8(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new cmd0x9e9.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramBundle.int64_total_point.get() / 100L);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("requestGiftPoint. error=");
          paramBundle.append(QLog.getStackTraceString(paramArrayOfByte));
          QLog.i(".troop.send_gift", 2, paramBundle.toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("requestGiftPoint. onResult error=");
      paramBundle.append(paramInt);
      paramBundle.append(" data=");
      paramBundle.append(paramArrayOfByte);
      QLog.i(".troop.send_gift", 2, paramBundle.toString());
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(paramInt, "sso request error or callback is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.8
 * JD-Core Version:    0.7.0.1
 */