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
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null)
      {
        if (paramArrayOfByte != null) {
          paramBundle = new oidb_0x6b6.RspBody();
        }
      }
      else {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.bytes_error_notify.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.b(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, "sso request error or callback is null.");
      return;
    }
    oidb_0x6b6.RspBody localRspBody;
    try
    {
      localRspBody = new oidb_0x6b6.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = localRspBody.int32_ret.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label354;
      }
      paramInt = paramBundle.getInt("subCmd");
      if (localRspBody.msg_send_flower.has())
      {
        paramArrayOfByte = (oidb_0x6b6.SendFlowerRsp)localRspBody.msg_send_flower.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.uint32_product_id.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    if (localRspBody.msg_throw_flower.has())
    {
      paramArrayOfByte = (oidb_0x6b6.ThrowFlowerRsp)localRspBody.msg_throw_flower.get();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.b(paramArrayOfByte.uint32_product_id.get());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label354:
    paramArrayOfByte = localRspBody.bytes_error_notify.get().toStringUtf8();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.b(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.1
 * JD-Core Version:    0.7.0.1
 */