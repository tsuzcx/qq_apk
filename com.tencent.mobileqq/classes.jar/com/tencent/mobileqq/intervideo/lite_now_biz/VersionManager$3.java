package com.tencent.mobileqq.intervideo.lite_now_biz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.now.ilive_grey_interface.GreyInterfaceRsp;

class VersionManager$3
  implements CsTask.Callback
{
  VersionManager$3(VersionManager paramVersionManager, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ilive_grey_interface.GreyInterfaceRsp();
    boolean bool2 = false;
    boolean bool1;
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      bool1 = bool2;
      if (paramBundle.result.has()) {
        bool1 = TextUtils.equals(paramBundle.result.get(), "1");
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getVersionGrayConfig, InvalidProtocolBufferMicroException=");
      paramBundle.append(paramArrayOfByte.getMessage());
      QLog.i("VersionManager", 1, paramBundle.toString());
      bool1 = bool2;
    }
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.3
 * JD-Core Version:    0.7.0.1
 */