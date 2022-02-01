package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdad.cmd0xdad.RspBody;

class TroopGiftManager$7
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$7(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (this.b != null)) {
      try
      {
        cmd0xdad.RspBody localRspBody = new cmd0xdad.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramInt = (int)localRspBody.retcode.get();
        if ((paramInt == 0) && (paramBundle != null))
        {
          this.b.a(this.c.d);
          return;
        }
        paramArrayOfByte = localRspBody.errmsg.get();
        this.b.b(paramInt, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("send_oidb_0x6b6. InvalidProtocolBufferMicroException:");
          paramBundle.append(paramArrayOfByte);
          QLog.i(".troop.send_gift", 2, paramBundle.toString());
        }
        this.b.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("send_oidb_0xdad. onResult error=");
      paramBundle.append(paramInt);
      paramBundle.append(" data=");
      paramBundle.append(paramArrayOfByte);
      paramBundle.append(" callback=");
      paramBundle.append(this.b);
      QLog.i(".troop.send_gift", 2, paramBundle.toString());
    }
    paramBundle = this.b;
    if (paramBundle != null)
    {
      if (paramArrayOfByte != null)
      {
        paramBundle = new cmd0xdad.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.errmsg.get();
          this.b.b(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("send_oidb_0xdad. InvalidProtocolBufferMicroException:");
            paramBundle.append(paramArrayOfByte);
            QLog.i(".troop.send_gift", 2, paramBundle.toString());
          }
          this.b.a(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      paramBundle.a(paramInt, "sso request error or callback is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.7
 * JD-Core Version:    0.7.0.1
 */