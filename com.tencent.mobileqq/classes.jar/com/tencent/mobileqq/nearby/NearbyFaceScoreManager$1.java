package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x938.cmd0x938.ClientConfig;
import tencent.im.oidb.cmd0x938.cmd0x938.DataCardConfig;
import tencent.im.oidb.cmd0x938.cmd0x938.RspBody;

class NearbyFaceScoreManager$1
  extends ProtoUtils.AppProtocolObserver
{
  NearbyFaceScoreManager$1(NearbyFaceScoreManager paramNearbyFaceScoreManager, FaceScoreCallBack paramFaceScoreCallBack) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle = new cmd0x938.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (cmd0x938.ClientConfig)paramBundle.msg_client_config.get();
        if (paramArrayOfByte.uint32_show_card.get() != 1) {
          break label228;
        }
        bool1 = true;
        if (paramArrayOfByte.uint32_show_list.get() != 1) {
          break label234;
        }
        bool2 = true;
        long l = paramArrayOfByte.uint64_next_time.get();
        if (paramBundle.msg_datacard_config.has()) {
          ((cmd0x938.DataCardConfig)paramBundle.msg_datacard_config.get()).uint32_entry_ability.get();
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("fetchGrayAbility onResult isShowCard=");
          paramBundle.append(bool1);
          paramBundle.append("  isShowList=");
          paramBundle.append(bool2);
          paramBundle.append("  expireTime=");
          paramBundle.append(l);
          QLog.e("Q..troop.faceScore", 2, paramBundle.toString());
        }
        paramArrayOfByte = new FaceScoreConfig(bool1, bool2, l, paramArrayOfByte.bytes_list_jump_url.get().toStringUtf8(), paramArrayOfByte.bytes_card_url_h.get().toStringUtf8(), paramArrayOfByte.bytes_card_url_g.get().toStringUtf8());
        this.b.a(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return;
      label228:
      boolean bool1 = false;
      continue;
      label234:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFaceScoreManager.1
 * JD-Core Version:    0.7.0.1
 */