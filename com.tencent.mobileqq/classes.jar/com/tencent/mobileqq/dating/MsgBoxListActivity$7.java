package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MsgBoxListActivity$7
  implements NowShortVideoProtoManager.Callback
{
  MsgBoxListActivity$7(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MsgBoxListActivity", 2, "follow onReceive errorCode = [" + paramInt + "]");
    }
    this.a.b.post(new MsgBoxListActivity.7.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.7
 * JD-Core Version:    0.7.0.1
 */