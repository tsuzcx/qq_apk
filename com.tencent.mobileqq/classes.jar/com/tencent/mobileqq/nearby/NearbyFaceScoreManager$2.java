package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x938.cmd0x938.FloatButtonConfig;
import tencent.im.oidb.cmd0x938.cmd0x938.RspBody;

class NearbyFaceScoreManager$2
  extends ProtoUtils.AppProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new cmd0x938.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramBundle = (cmd0x938.FloatButtonConfig)paramBundle.msg_floatbutton_config.get();
        paramInt = paramBundle.uint32_button_word_color.get();
        int i = paramBundle.uint32_button_back_color.get();
        int j = paramBundle.uint32_like_count.get();
        paramArrayOfByte = paramBundle.bytes_button_wording.get().toStringUtf8();
        paramBundle = paramBundle.bytes_button_image_url.get().toStringUtf8();
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fetchEntranceConfig onResult entranceTextColor=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("  entranceBgColor=");
          localStringBuilder.append(i);
          localStringBuilder.append("  entranceWording=");
          localStringBuilder.append(paramArrayOfByte);
          QLog.e("Q..troop.faceScore", 2, localStringBuilder.toString());
        }
        if (this.b != null)
        {
          this.b.a(paramArrayOfByte, paramBundle, paramInt, i, j);
          return;
        }
        QLog.e("Q..troop.faceScore", 2, "fetchEntranceConfig onResult callback is null.");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFaceScoreManager.2
 * JD-Core Version:    0.7.0.1
 */