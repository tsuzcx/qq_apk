package com.tencent.mobileqq.guild.audio;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class TRTCAudioRoomService$TRTCAudioRoomClientQIPCModule
  extends QIPCModule
{
  public TRTCAudioRoomService$TRTCAudioRoomClientQIPCModule(TRTCAudioRoomService paramTRTCAudioRoomService, String paramString)
  {
    super(paramString);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    int i = paramBundle.getInt("ROOM_TYPE");
    int j = paramBundle.getInt("SDK_APP_ID");
    String str1 = paramBundle.getString("PRIVATE_MAP_KEY");
    String str2 = paramBundle.getString("ROOM_ID");
    String str3 = paramBundle.getString("USER_ID");
    String str4 = paramBundle.getString("USER_SIG");
    int k = paramBundle.getInt("USER_ROLE");
    paramBundle = new StringBuilder();
    paramBundle.append("handleEnterRoom: appScene:");
    paramBundle.append(i);
    paramBundle.append(", sdkAppId:");
    paramBundle.append(j);
    paramBundle.append(", privateMapKey:");
    paramBundle.append(str1);
    paramBundle.append(", roomId:");
    paramBundle.append(str2);
    paramBundle.append(", userId:");
    paramBundle.append(str3);
    paramBundle.append(", userSig");
    paramBundle.append(str4);
    paramBundle.append(", userRole");
    paramBundle.append(k);
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, paramBundle.toString());
    this.a.b.a(i, j, str1, str2, str3, str4, k, new TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule.1(this, paramInt));
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, "handleExitRoom: ");
    this.a.b.a(new TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule.2(this, paramInt));
  }
  
  private void c(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, "handleStartMicrophone: ");
    this.a.b.b();
  }
  
  private void d(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, "handleStopMicrophone: ");
    this.a.b.c();
  }
  
  private void e(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, "handleRouteAudioToSpeaker: ");
    this.a.b.d();
  }
  
  private void f(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomClientQIPCModule", 1, "handleRouteAudioToEarpiece: ");
    this.a.b.e();
  }
  
  private void g(Bundle paramBundle, int paramInt)
  {
    String str = paramBundle.getString("USER_ID");
    boolean bool = paramBundle.getBoolean("USER_REMOTE_MUTE");
    this.a.b.a(str, bool);
  }
  
  private void h(Bundle paramBundle, int paramInt)
  {
    this.a.b.g();
  }
  
  private void i(Bundle paramBundle, int paramInt)
  {
    this.a.b.h();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ENTER_ROOM".equals(paramString))
    {
      a(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("EXIT_ROOM".equals(paramString))
    {
      b(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("START_MICROPHONE".equals(paramString))
    {
      c(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("STOP_MICROPHONE".equals(paramString))
    {
      d(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ROUTE_AUDIO_TO_SPEAKER".equals(paramString))
    {
      e(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ROUTE_AUDIO_TO_EARPIECE".equals(paramString))
    {
      f(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("MUTE_REMOTE_AUDIO".equals(paramString))
    {
      g(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("SWITCH_TO_ANCHOR".equals(paramString))
    {
      h(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("SWITCH_TO_AUDIENCE".equals(paramString))
    {
      i(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    return EIPCResult.UNKNOW_RESULT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */