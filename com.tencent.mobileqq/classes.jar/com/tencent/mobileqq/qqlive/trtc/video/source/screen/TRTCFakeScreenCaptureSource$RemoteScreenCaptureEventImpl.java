package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule;

class TRTCFakeScreenCaptureSource$RemoteScreenCaptureEventImpl
  implements IRTCScreenCaptureEventListener
{
  TRTCFakeScreenCaptureSource$RemoteScreenCaptureEventImpl(TRTCFakeScreenCaptureSource paramTRTCFakeScreenCaptureSource) {}
  
  public void a()
  {
    TRTCClientIPCModule.a("Action_Server_Screen_Callback_Start", null);
  }
  
  public void a(int paramInt)
  {
    new Bundle().putInt("Key_TRTC_ErrCode", paramInt);
    TRTCClientIPCModule.a("Action_Server_Screen_Callback_Stop", null);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("Key_TRTC_ErrCode", paramInt);
    localBundle.putString("Key_TRTC_ErrMsg", paramString);
    localBundle.putBundle("Key_TRTC_Extra", paramBundle);
    TRTCClientIPCModule.a("Action_Server_Screen_Callback_On_Error", localBundle);
  }
  
  public void b(int paramInt)
  {
    a();
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCFakeScreenCaptureSource.RemoteScreenCaptureEventImpl
 * JD-Core Version:    0.7.0.1
 */