package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ForwardD55Manager$1
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardD55Manager$1(ForwardD55Manager paramForwardD55Manager, String paramString, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d("ForwardD55Manager", 1, "fetchAppInfoByD55 onResult errorCode: " + paramInt);
    ForwardStatisticsReporter.b("KEY_STAGE_1_D55");
    ThreadManager.getUIHandler().post(new ForwardD55Manager.1.1(this, paramArrayOfByte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1
 * JD-Core Version:    0.7.0.1
 */