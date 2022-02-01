package com.tencent.mobileqq.qqlive.trtc.room;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;
import com.tencent.mobileqq.qqlive.trtc.ipc.ITRTCIPCHandler;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;

public class TRTCFakeRoomCtrl
  implements ITRTCIPCHandler, ITRTCRoomCtrl
{
  private ITRTCRoomListener a;
  
  public TRTCFakeRoomCtrl()
  {
    TRTCServerIPCModule.a().a(this);
  }
  
  public void a(QQLiveRoomParams paramQQLiveRoomParams)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_trtc_room_params", paramQQLiveRoomParams);
    TRTCServerIPCModule.a("Action_Client_Room_Enter_Room", localBundle, null);
  }
  
  public void a(ITRTCRoomListener paramITRTCRoomListener)
  {
    this.a = paramITRTCRoomListener;
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(QQLiveRoomParams.class.getClassLoader());
    }
    boolean bool1 = true;
    boolean bool2 = "Action_Client_Room_Enter_Room".equals(paramString);
    Object localObject = null;
    ITRTCRoomCtrl localITRTCRoomCtrl = null;
    if (bool2)
    {
      paramString = localITRTCRoomCtrl;
      if (paramBundle != null) {
        paramString = (QQLiveRoomParams)paramBundle.getParcelable("Key_trtc_room_params");
      }
      if (paramString != null)
      {
        TRTCEngineProxy.a().a(new TRTCFakeRoomCtrl.HostRoomImpl());
        TRTCEngineProxy.a().a(paramString);
        return true;
      }
    }
    else
    {
      if ("Action_Client_Room_Exit_Room".equals(paramString))
      {
        TRTCEngineProxy.a().i();
        return true;
      }
      if ("Action_Client_Room_Switch_Room".equals(paramString))
      {
        localITRTCRoomCtrl = TRTCEngineProxy.a().p();
        if (localITRTCRoomCtrl != null)
        {
          paramString = localObject;
          if (paramBundle != null) {
            paramString = (QQLiveRoomParams)paramBundle.getParcelable("Key_trtc_room_params");
          }
          localITRTCRoomCtrl.b(paramString);
          return true;
        }
      }
      else if ("Action_Client_Room_Destroy_Room".equals(paramString))
      {
        paramString = TRTCEngineProxy.a().p();
        if (paramString != null)
        {
          paramString.c();
          return true;
        }
      }
      else
      {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    TRTCServerIPCModule.a("Action_Client_Room_Exit_Room", null, null);
  }
  
  public void b(QQLiveRoomParams paramQQLiveRoomParams)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_trtc_room_params", paramQQLiveRoomParams);
    TRTCServerIPCModule.a("Action_Client_Room_Switch_Room", localBundle, null);
  }
  
  public boolean b(String paramString, Bundle paramBundle)
  {
    Object localObject1 = this.a;
    boolean bool = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = "";
    int i;
    int j;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("Key_TRTC_ErrCode", 0);
      j = paramBundle.getInt("Key_TRTC_EventID", 0);
      localObject1 = paramBundle.getString("Key_TRTC_ErrMsg", "");
      localObject2 = paramBundle.getBundle("Key_TRTC_Extra");
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = null;
      i = 0;
      j = 0;
      paramBundle = (Bundle)localObject2;
    }
    if ("Action_Server_Room_Callback_onEnterRoom".equals(paramString))
    {
      this.a.a(i, paramBundle);
    }
    else if ("Action_Server_Room_Callback_onExitRoom".equals(paramString))
    {
      this.a.a(i);
    }
    else if ("Action_Server_Room_Callback_onSwitchRoom".equals(paramString))
    {
      this.a.a(i, paramBundle);
    }
    else if ("Action_Server_Room_Callback_onRemoteUserEnterRoom".equals(paramString))
    {
      this.a.a(paramBundle);
    }
    else if ("Action_Server_Room_Callback_onRemoteUserLeaveRoom".equals(paramString))
    {
      this.a.a(paramBundle, i);
    }
    else if ("Action_Server_Room_Callback_onFirstLocalVideoFrameSent".equals(paramString))
    {
      this.a.b(i);
    }
    else if ("Action_Server_Room_Callback_onFirstLocalAudioFrameSent".equals(paramString))
    {
      this.a.a();
    }
    else
    {
      if (!"Action_Server_Room_Callback_onEvent".equals(paramString)) {
        break label264;
      }
      this.a.a(j, i, paramBundle, (Bundle)localObject1);
    }
    bool = true;
    label264:
    return bool;
  }
  
  public void c()
  {
    TRTCServerIPCModule.a("Action_Client_Room_Destroy_Room", null, null);
    this.a = null;
    TRTCServerIPCModule.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.room.TRTCFakeRoomCtrl
 * JD-Core Version:    0.7.0.1
 */