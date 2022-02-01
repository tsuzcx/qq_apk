package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.RspBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerRsp;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerRsp;

class TroopGiftManager$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$1(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (this.b != null)) {
      try
      {
        oidb_0x6b6.RspBody localRspBody = new oidb_0x6b6.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramInt = localRspBody.int32_ret.get();
        if ((paramInt == 0) && (paramBundle != null))
        {
          paramInt = paramBundle.getInt("subCmd");
          if (localRspBody.msg_send_flower.has())
          {
            paramArrayOfByte = (oidb_0x6b6.SendFlowerRsp)localRspBody.msg_send_flower.get();
            this.b.a(paramArrayOfByte.uint32_product_id.get());
            return;
          }
          if (localRspBody.msg_throw_flower.has())
          {
            paramArrayOfByte = (oidb_0x6b6.ThrowFlowerRsp)localRspBody.msg_throw_flower.get();
            this.b.b(paramArrayOfByte.uint32_product_id.get());
            return;
          }
          paramArrayOfByte = this.b;
          paramBundle = new StringBuilder();
          paramBundle.append("Invalid RspData. subCmd:");
          paramBundle.append(paramInt);
          paramArrayOfByte.a(-1, paramBundle.toString());
          return;
        }
        paramArrayOfByte = localRspBody.bytes_error_notify.get().toStringUtf8();
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
      paramBundle.append("send_oidb_0x6b6. onResult error=");
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
        paramBundle = new oidb_0x6b6.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.bytes_error_notify.get().toStringUtf8();
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
      paramBundle.a(paramInt, "sso request error or callback is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.1
 * JD-Core Version:    0.7.0.1
 */