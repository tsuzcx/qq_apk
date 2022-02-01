package com.tencent.mobileqq.troop.troopconfig.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.qphone.base.util.QLog;

class TroopConfigHandler$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopConfigHandler$1(TroopConfigHandler paramTroopConfigHandler) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_0x496.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        TroopConfigHandler.a(this.a, paramBundle);
        TroopConfigHandler.b(this.a, paramBundle);
        TroopConfigHandler.c(this.a, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("getTroopConfig, e=");
      paramBundle.append(paramArrayOfByte.toString());
      QLog.i("TroopConfigHandler", 2, paramBundle.toString());
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getTroopConfig, errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.i("TroopConfigHandler", 1, paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopconfig.api.impl.TroopConfigHandler.1
 * JD-Core Version:    0.7.0.1
 */