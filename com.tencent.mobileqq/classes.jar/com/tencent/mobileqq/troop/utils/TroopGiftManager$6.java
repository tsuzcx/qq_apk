package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class TroopGiftManager$6
  extends ProtoUtils.AppProtocolObserver
{
  TroopGiftManager$6(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0x962.RspBody();
    if (paramArrayOfByte != null) {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("send_oidb_0x962. InvalidProtocolBufferMicroException:");
          localStringBuilder.append(paramArrayOfByte);
          QLog.i(".troop.send_gift", 2, localStringBuilder.toString());
        }
      }
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.6
 * JD-Core Version:    0.7.0.1
 */