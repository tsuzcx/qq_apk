package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.RspBody;

final class TroopFileVideoOnlinePlayManager$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopFileVideoOnlinePlayManager$1(TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback paramTroopFileWhiteListCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_0x6e7.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("is_white = ");
          paramArrayOfByte.append(paramBundle.uint32_is_white.get());
          paramArrayOfByte.append(", req_interval = ");
          paramArrayOfByte.append(paramBundle.uint32_interval.get());
          QLog.d("zivonchen", 2, paramArrayOfByte.toString());
        }
        if (this.a != null) {
          this.a.a(paramBundle.uint32_is_white.get(), paramBundle.uint32_interval.get());
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(paramArrayOfByte));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("requestWhiteList() errorCode = ");
      paramArrayOfByte.append(paramInt);
      QLog.d("zivonchen", 2, paramArrayOfByte.toString());
    }
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(0, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager.1
 * JD-Core Version:    0.7.0.1
 */