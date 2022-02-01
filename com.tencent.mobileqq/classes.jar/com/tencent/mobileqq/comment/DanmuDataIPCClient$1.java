package com.tencent.mobileqq.comment;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class DanmuDataIPCClient$1
  implements EIPCResultCallback
{
  DanmuDataIPCClient$1(DanmuDataIPCClient paramDanmuDataIPCClient) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DanmuDataIPCClient", 1, new Object[] { "get barrage list, IPC success, msgSeq:", Long.valueOf(paramEIPCResult.data.getLong("key_barrage_msg_seq")) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataIPCClient.1
 * JD-Core Version:    0.7.0.1
 */