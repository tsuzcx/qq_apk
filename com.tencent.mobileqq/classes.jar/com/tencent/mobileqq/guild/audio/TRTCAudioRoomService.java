package com.tencent.mobileqq.guild.audio;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import mqq.app.AppService;

public class TRTCAudioRoomService
  extends AppService
  implements ITRTCAudioRoom.ITRTCAudioRoomListener
{
  TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule a;
  TRTCAudioRoomLocal b = TRTCAudioRoomLocal.f();
  boolean c = false;
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pushOnTRTCExitRoom reason:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", msg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TRTCAudioRoomService", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("EXIT_ROOM_REASON", paramInt);
    ((Bundle)localObject).putString("EXIT_ROOM_MSG", paramString);
    QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "PUSH_ON_TRTC_EXIT_ROOM", (Bundle)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pushOnTRTCAudioAvailable: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", available:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("TRTCAudioRoomService", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("USER_ID", paramString);
    ((Bundle)localObject).putBoolean("USER_AUDIO_AVAILABLE", paramBoolean);
    QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_AUDIO_AVAILABLE", (Bundle)localObject);
  }
  
  public void a(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("USER_VOLUME_INFO_LIST", paramArrayList);
    localBundle.putInt("ROOM_TOTAL_VOLUME", paramInt);
    QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_USER_VOICE_VOLUME", localBundle);
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pushOnTRTCAnchorEnter: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TRTCAudioRoomService", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("USER_ID", paramString);
    QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_ANCHOR_ENTER", (Bundle)localObject);
  }
  
  public void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pushOnTRTCAnchorExit: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TRTCAudioRoomService", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("USER_ID", paramString);
    QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_ANCHOR_EXIT", (Bundle)localObject);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    QLog.i("TRTCAudioRoomService", 2, "onBind");
    return null;
  }
  
  public void onCreate()
  {
    QLog.i("TRTCAudioRoomService", 2, "onCreate start");
    try
    {
      super.onCreate();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate e = ");
      localStringBuilder.append(localException);
      QLog.e("TRTCAudioRoomService", 1, localStringBuilder.toString());
      stopSelf();
    }
  }
  
  public void onDestroy()
  {
    QLog.i("TRTCAudioRoomService", 2, "onDestroy start");
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    QLog.i("TRTCAudioRoomService", 2, "onLowMemory");
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QLog.i("TRTCAudioRoomService", 2, "onStart");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    QLog.i("TRTCAudioRoomService", 2, "onStartCommand");
    if (paramIntent != null)
    {
      this.b.a(this);
      paramIntent = paramIntent.getStringExtra("key_trtc_so_path");
      this.b.a(getApplicationContext(), paramIntent);
      if (this.a == null)
      {
        this.a = new TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule(this, "TRTCAudioRoomClientQIPCModule");
        QIPCClientHelper.getInstance().register(this.a);
      }
      if (!this.c) {
        QIPCClientHelper.getInstance().getClient().connect(new TRTCAudioRoomService.1(this));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartCommand trtcSoPath:");
      localStringBuilder.append(paramIntent);
      QLog.i("TRTCAudioRoomService", 2, localStringBuilder.toString());
    }
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i("TRTCAudioRoomService", 2, "onUnbind");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomService
 * JD-Core Version:    0.7.0.1
 */