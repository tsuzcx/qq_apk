package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class TRTCServerIPCModule$1
  implements Runnable
{
  TRTCServerIPCModule$1(TRTCServerIPCModule paramTRTCServerIPCModule, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ("Action_Server_OnBind".equals(this.a))
    {
      TRTCServerIPCModule.a(this.this$0);
      return;
    }
    if ("Action_Server_Notify_Engine".equals(this.a))
    {
      TRTCServerIPCModule.a(this.this$0, this.b);
      return;
    }
    Object localObject = TRTCServerIPCModule.b(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ITRTCIPCHandler localITRTCIPCHandler = (ITRTCIPCHandler)((Iterator)localObject).next();
      if (localITRTCIPCHandler.b(this.a, this.b)) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle ");
          ((StringBuilder)localObject).append(localITRTCIPCHandler.toString());
          QLog.d("TRTCServerIPCModule", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule.1
 * JD-Core Version:    0.7.0.1
 */