package com.tencent.mobileqq.qqlive.trtc.audio;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.ipc.ITRTCIPCHandler;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.qphone.base.util.QLog;

public class TRTCFakeAudioSource
  implements ITRTCAudioSource, ITRTCIPCHandler
{
  public TRTCFakeAudioSource()
  {
    TRTCServerIPCModule.a().a(this);
  }
  
  public void a()
  {
    TRTCServerIPCModule.a().b(this);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("Key_trtc_audio_params", paramInt);
    TRTCServerIPCModule.a("Action_Client_Audio_StartMic", localBundle, null);
  }
  
  public void a(@NonNull Handler paramHandler) {}
  
  public boolean a(@NonNull TRTCEngineContext paramTRTCEngineContext)
  {
    return false;
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    TRTCEngineProxy.a().l();
    if ("Action_Client_Audio_StartMic".equals(paramString))
    {
      int i = 2;
      if (paramBundle != null) {
        i = paramBundle.getInt("Key_trtc_audio_params");
      }
      paramString = new StringBuilder();
      paramString.append("Action_Client_Audio_StartMic ");
      paramString.append(i);
      QLog.d("TRTCFakeAudioSource", 1, paramString.toString());
      TRTCEngineProxy.a().g();
      return true;
    }
    if ("Action_Client_Audio_StopMic".equals(paramString))
    {
      TRTCEngineProxy.a().h();
      return true;
    }
    return false;
  }
  
  public void b() {}
  
  public boolean b(String paramString, Bundle paramBundle)
  {
    return false;
  }
  
  public void c() {}
  
  public void d()
  {
    TRTCServerIPCModule.a("Action_Client_Audio_StopMic", null, null);
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.audio.TRTCFakeAudioSource
 * JD-Core Version:    0.7.0.1
 */