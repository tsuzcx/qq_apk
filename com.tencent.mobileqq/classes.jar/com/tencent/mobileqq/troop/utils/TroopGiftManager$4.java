package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.Player;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.RspBody;

class TroopGiftManager$4
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$4(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback, String paramString1, String paramString2) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null)) {
      try
      {
        oidb_0x6b5.RspBody localRspBody = new oidb_0x6b5.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramInt = localRspBody.uint32_result.get();
        if ((paramInt == 0) && (paramBundle != null))
        {
          paramInt = paramBundle.getInt("subCmd");
          if ((paramInt == 0) && (localRspBody.msg_grab_result.has()))
          {
            paramArrayOfByte = (oidb_0x6b5.Player)localRspBody.msg_grab_result.get();
            paramBundle = new StringBuilder();
            paramBundle.append(this.jdField_a_of_type_JavaLangString);
            paramBundle.append("_");
            paramBundle.append(this.b);
            paramBundle = paramBundle.toString();
            paramBundle = (TroopGiftBagInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a.get(paramBundle);
            if (paramBundle != null)
            {
              paramBundle.myGrabResult = new TroopGiftBagPlayer(paramArrayOfByte.uint64_uin.get(), paramArrayOfByte.uint64_time.get(), paramArrayOfByte.int32_amount.get(), paramArrayOfByte.int32_index.get(), paramArrayOfByte.bytes_tips.get().toStringUtf8());
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(paramBundle);
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.uint64_uin.get(), paramArrayOfByte.uint64_time.get(), paramArrayOfByte.int32_amount.get(), paramArrayOfByte.int32_index.get(), paramArrayOfByte.bytes_tips.get().toStringUtf8());
            return;
          }
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
          paramBundle = new StringBuilder();
          paramBundle.append("Invalid RspData. subCmd:");
          paramBundle.append(paramInt);
          paramArrayOfByte.a(-1, paramBundle.toString());
          return;
        }
        paramArrayOfByte = localRspBody.bytes_errmsg.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("send_oidb_0x6b5. InvalidProtocolBufferMicroException:");
          paramBundle.append(paramArrayOfByte);
          QLog.i(".troop.send_gift", 2, paramBundle.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("send_oidb_0x6b5. onResult error=");
      paramBundle.append(paramInt);
      paramBundle.append(" data=");
      paramBundle.append(paramArrayOfByte);
      paramBundle.append(" callback=");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback);
      QLog.i(".troop.send_gift", 2, paramBundle.toString());
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(paramInt, "sso request error or callback is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.4
 * JD-Core Version:    0.7.0.1
 */