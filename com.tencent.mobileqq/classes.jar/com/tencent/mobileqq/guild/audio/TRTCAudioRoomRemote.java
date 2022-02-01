package com.tencent.mobileqq.guild.audio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;

public class TRTCAudioRoomRemote
  implements ITRTCAudioRoom
{
  private Handler a;
  private TRTCAudioRoomRemote.TRTCAudioRoomServerQIPCModule b;
  private ITRTCAudioRoom.ITRTCAudioRoomListener c;
  private boolean d = false;
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ROOM_TYPE", paramInt1);
    localBundle.putInt("SDK_APP_ID", paramInt2);
    localBundle.putString("PRIVATE_MAP_KEY", paramString1);
    localBundle.putString("ROOM_ID", paramString2);
    localBundle.putString("USER_ID", paramString3);
    localBundle.putString("USER_SIG", paramString4);
    localBundle.putInt("USER_ROLE", paramInt3);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "ENTER_ROOM", localBundle, new TRTCAudioRoomRemote.2(this, paramITRTCAudioRoomCallback));
  }
  
  public void a(Context paramContext, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init context:");
    localStringBuilder.append(paramContext);
    QLog.i("TRTCAudioRoomRemote", 1, localStringBuilder.toString());
    SoLoadManager.getInstance().load("trtc_entry", new TRTCAudioRoomRemote.1(this, paramITRTCAudioRoomCallback, paramContext));
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, TRTCAudioRoomService.class);
    localIntent.putExtra("key_trtc_so_path", paramString);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("TRTCAudioRoomRemote", 1, "startService", paramContext);
    }
  }
  
  public void a(ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    QLog.i("TRTCAudioRoomRemote", 1, "exitRoom has result");
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "EXIT_ROOM", null, new TRTCAudioRoomRemote.3(this, paramITRTCAudioRoomCallback));
  }
  
  public void a(ITRTCAudioRoom.ITRTCAudioRoomListener paramITRTCAudioRoomListener)
  {
    this.c = paramITRTCAudioRoomListener;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("USER_ID", paramString);
    localBundle.putBoolean("USER_REMOTE_MUTE", paramBoolean);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "MUTE_REMOTE_AUDIO", localBundle, null);
  }
  
  public void b()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "START_MICROPHONE", null, null);
  }
  
  public void c()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "STOP_MICROPHONE", null, null);
  }
  
  public void d()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "ROUTE_AUDIO_TO_SPEAKER", null, null);
  }
  
  public void e()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:guild_audio", "TRTCAudioRoomClientQIPCModule", "ROUTE_AUDIO_TO_EARPIECE", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomRemote
 * JD-Core Version:    0.7.0.1
 */