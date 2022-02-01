package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.qphone.base.util.QLog;

final class MsgBoxProtocol$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(" reportMsgBoxMomentRead code:");
    paramArrayOfByte.append(paramInt);
    QLog.i("reportMsgBoxMomentRead", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol.1
 * JD-Core Version:    0.7.0.1
 */