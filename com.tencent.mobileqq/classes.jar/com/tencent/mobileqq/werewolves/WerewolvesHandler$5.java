package com.tencent.mobileqq.werewolves;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class WerewolvesHandler$5
  extends ProtoUtils.TroopProtocolObserver
{
  WerewolvesHandler$5(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback != null)
    {
      paramBundle = new oidb_0x8ed.RspBody();
      if (paramArrayOfByte != null) {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WerewolvesHandler", 2, paramArrayOfByte.getMessage());
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback.a(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.5
 * JD-Core Version:    0.7.0.1
 */