package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;

class TRTCClientIPCModule$2
  implements TRTCInitCallback
{
  TRTCClientIPCModule$2(TRTCClientIPCModule paramTRTCClientIPCModule) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("Key_trtc_engine_init_state", paramInt1);
    localBundle.putInt("Key_trtc_engine_init_code", paramInt2);
    TRTCClientIPCModule.a("Action_Server_Notify_Engine", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule.2
 * JD-Core Version:    0.7.0.1
 */