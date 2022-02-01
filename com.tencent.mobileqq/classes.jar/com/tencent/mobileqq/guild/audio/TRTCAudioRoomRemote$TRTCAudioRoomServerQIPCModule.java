package com.tencent.mobileqq.guild.audio;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;

public class TRTCAudioRoomRemote$TRTCAudioRoomServerQIPCModule
  extends QIPCModule
{
  public TRTCAudioRoomRemote$TRTCAudioRoomServerQIPCModule(TRTCAudioRoomRemote paramTRTCAudioRoomRemote)
  {
    super("TRTCAudioRoomServerQIPCModule");
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomServerQIPCModule", 1, "handleAnchorEnter: ");
    paramInt = paramBundle.getInt("EXIT_ROOM_REASON");
    paramBundle = paramBundle.getString("EXIT_ROOM_MSG");
    TRTCAudioRoomRemote.a(this.a).a(paramInt, paramBundle);
  }
  
  private void b(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomServerQIPCModule", 1, "handleAnchorEnter: ");
    paramBundle = paramBundle.getString("USER_ID");
    TRTCAudioRoomRemote.a(this.a).b(paramBundle);
  }
  
  private void c(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomServerQIPCModule", 1, "handleAnchorExit: ");
    paramBundle = paramBundle.getString("USER_ID");
    TRTCAudioRoomRemote.a(this.a).c(paramBundle);
  }
  
  private void d(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomServerQIPCModule", 1, "handleAudioAvailable: ");
    String str = paramBundle.getString("USER_ID");
    boolean bool = paramBundle.getBoolean("USER_AUDIO_AVAILABLE");
    TRTCAudioRoomRemote.a(this.a).a(str, bool);
  }
  
  private void e(Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(ITRTCAudioRoom.TRTCVolumeInfo.class.getClassLoader());
    ArrayList localArrayList = paramBundle.getParcelableArrayList("USER_VOLUME_INFO_LIST");
    paramInt = paramBundle.getInt("ROOM_TOTAL_VOLUME", 0);
    TRTCAudioRoomRemote.a(this.a).a(localArrayList, paramInt);
  }
  
  private void f(Bundle paramBundle, int paramInt)
  {
    QLog.i("TRTCAudioRoomServerQIPCModule", 1, "handleOnError: ");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("PUSH_ON_TRTC_EXIT_ROOM".equals(paramString))
    {
      a(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ON_TRTC_ANCHOR_ENTER".equals(paramString))
    {
      b(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ON_TRTC_ANCHOR_EXIT".equals(paramString))
    {
      c(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ON_TRTC_AUDIO_AVAILABLE".equals(paramString))
    {
      d(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ON_TRTC_USER_VOICE_VOLUME".equals(paramString))
    {
      e(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    if ("ON_ERROR".equals(paramString))
    {
      f(paramBundle, paramInt);
      return EIPCResult.createSuccessResult(null);
    }
    return EIPCResult.UNKNOW_RESULT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomRemote.TRTCAudioRoomServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */