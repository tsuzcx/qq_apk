package com.tencent.mobileqq.qqlive.trtc.room;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule;
import com.tencent.qphone.base.util.QLog;

class TRTCFakeRoomCtrl$HostRoomImpl
  implements ITRTCRoomListener
{
  private Bundle b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("Key_TRTC_EventID", paramInt1);
    localBundle.putInt("Key_TRTC_ErrCode", paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("Key_TRTC_ErrMsg", paramString);
    }
    if (paramBundle != null) {
      localBundle.putBundle("Key_TRTC_Extra", paramBundle);
    }
    return localBundle;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TRTCFakeRoomCtrl", 2, "onFirstLocalAudioFrameSent ");
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onFirstLocalAudioFrameSent", null);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitRoom ");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onExitRoom", b(0, paramInt, "", null));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEvent, event ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", code: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onEvent", b(paramInt1, paramInt2, paramString, paramBundle));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchRoom ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onSwitchRoom", b(0, paramInt, paramString, null));
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoom ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onEnterRoom", b(0, (int)paramLong, paramString, null));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRemoteUserEnterRoom ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onRemoteUserEnterRoom", b(0, 0, paramString, null));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRemoteUserLeaveRoom ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", reason: ");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onRemoteUserLeaveRoom", b(0, paramInt, paramString, null));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstLocalVideoFrameSent, streamType ");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCFakeRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCClientIPCModule.a("Action_Server_Room_Callback_onFirstLocalVideoFrameSent", b(0, paramInt, "message", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.room.TRTCFakeRoomCtrl.HostRoomImpl
 * JD-Core Version:    0.7.0.1
 */