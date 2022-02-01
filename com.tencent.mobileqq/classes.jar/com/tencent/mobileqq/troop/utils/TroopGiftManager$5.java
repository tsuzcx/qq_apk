package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.GiftBagInfo;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.RspBody;

class TroopGiftManager$5
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$5(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback, String paramString1, String paramString2) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null)) {
      try
      {
        oidb_0x6c2.RspBody localRspBody = new oidb_0x6c2.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramInt = localRspBody.uint32_result.get();
        if ((paramInt == 0) && (paramBundle != null))
        {
          paramInt = paramBundle.getInt("subCmd");
          if ((paramInt == 0) && (localRspBody.msg_gift_bag_info.has()))
          {
            paramBundle = (oidb_0x6c2.GiftBagInfo)localRspBody.msg_gift_bag_info.get();
            paramArrayOfByte = null;
            if (localRspBody.msg_winner.has()) {
              paramArrayOfByte = (oidb_0x6c2.Player)localRspBody.msg_winner.get();
            }
            paramBundle = new TroopGiftBagInfo(paramBundle, paramArrayOfByte);
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(this.jdField_a_of_type_JavaLangString);
              paramArrayOfByte.append("_");
              paramArrayOfByte.append(this.b);
              paramArrayOfByte = paramArrayOfByte.toString();
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a.put(paramArrayOfByte, paramBundle);
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftManager.a(paramBundle);
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramBundle);
            return;
          }
          if ((paramInt == 1) && (localRspBody.int32_player.has()))
          {
            paramInt = localRspBody.int32_player.get();
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.c(paramInt);
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
          paramBundle.append("send_oidb_0x6c2. InvalidProtocolBufferMicroException:");
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
      paramBundle.append("send_oidb_0x6c2. onResult error=");
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
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.5
 * JD-Core Version:    0.7.0.1
 */