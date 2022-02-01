package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.qphone.base.util.QLog;

final class MsgBoxProtocol$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportMsgBoxMomentRead", 1, " reportMsgBoxMomentRead code:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol.1
 * JD-Core Version:    0.7.0.1
 */