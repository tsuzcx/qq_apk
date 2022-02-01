package com.tencent.timi.game.trtc;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.trtc.roomservice.RoomParam;
import com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom;
import com.tencent.timi.game.trtc.tools.CloudListenerInformer;
import com.tencent.timi.game.trtc.tools.Printer;
import com.tencent.timi.game.utils.Logger;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;

public class TRTCInstance
{
  public volatile TRTCCloud a;
  Handler b = new Handler(Looper.getMainLooper());
  private volatile TRTCCloud c;
  private CloudListenerInformer d = new CloudListenerInformer();
  private TRTCInstance.LocalAudioRunnable e = new TRTCInstance.LocalAudioRunnable(this, null);
  
  private void c(RoomParam paramRoomParam)
  {
    if (this.c == null) {
      try
      {
        if (this.c == null)
        {
          this.c = TRTCCloud.sharedInstance(Env.a());
          this.c.enableAudioVolumeEvaluation(300);
          TRTCCloud.setLogLevel(2);
          TRTCCloud.setLogDirPath(Logger.a(System.currentTimeMillis()));
          this.c.setListener(new TRTCInstance.3(this, this.d));
        }
        return;
      }
      finally {}
    }
  }
  
  public void a()
  {
    Printer.a("exitRoom", new Object[0]);
    this.c.exitRoom();
  }
  
  public void a(int paramInt)
  {
    Printer.a("switchRole", new Object[] { Integer.valueOf(paramInt) });
    this.c.switchRole(paramInt);
  }
  
  public void a(RoomParam paramRoomParam)
  {
    Printer.a("create", new Object[0]);
    c(paramRoomParam);
  }
  
  public void a(TRTCRoom paramTRTCRoom, TRTCCloudListener paramTRTCCloudListener)
  {
    Printer.a("enterSubCloud", new Object[0]);
    this.a = this.c.createSubCloud();
    this.a.enableAudioVolumeEvaluation(300);
    this.a.setListener(new TRTCInstance.1(this, paramTRTCRoom, paramTRTCRoom.b, paramTRTCCloudListener));
    this.a.enterRoom(paramTRTCRoom.b.a(), paramTRTCRoom.b.d);
  }
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    this.d.a(paramTRTCCloudListener);
  }
  
  public void a(String paramString)
  {
    Printer.a("startPlayMusic", new Object[] { paramString });
    this.c.getAudioEffectManager().startPlayMusic(new TRTCInstance.2(this, 0, paramString));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Printer.a("muteRemoteAudio", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    this.c.muteRemoteAudio(paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    Printer.a("startLocalAudio", new Object[] { Boolean.valueOf(paramBoolean) });
    TRTCInstance.LocalAudioRunnable localLocalAudioRunnable = this.e;
    localLocalAudioRunnable.a = paramBoolean;
    this.b.removeCallbacks(localLocalAudioRunnable);
    this.b.postDelayed(this.e, 50L);
  }
  
  public void b()
  {
    Printer.a("exitSubCloud", new Object[0]);
    if (this.a != null)
    {
      this.a.exitRoom();
      return;
    }
    Printer.a("exitSubCloud call but not working", new Object[0]);
  }
  
  public void b(int paramInt)
  {
    Printer.a("setAudioCaptureVolume", new Object[] { Integer.valueOf(paramInt) });
    this.c.setAudioCaptureVolume(paramInt);
  }
  
  public void b(RoomParam paramRoomParam)
  {
    Printer.a("enterRoom", new Object[0]);
    this.c.setSystemVolumeType(1);
    this.c.setDefaultStreamRecvMode(true, true);
    this.c.enterRoom(paramRoomParam.a(), paramRoomParam.d);
  }
  
  public void b(TRTCCloudListener paramTRTCCloudListener)
  {
    this.d.b(paramTRTCCloudListener);
  }
  
  public void b(boolean paramBoolean)
  {
    Printer.a("muteLocalAudio", new Object[] { Boolean.valueOf(paramBoolean) });
    this.c.muteLocalAudio(paramBoolean);
  }
  
  public void c()
  {
    Printer.a("pausePlayMusic", new Object[0]);
    this.c.getAudioEffectManager().stopPlayMusic(0);
  }
  
  public void c(int paramInt)
  {
    Printer.a("setAudioPlayoutVolume", new Object[] { Integer.valueOf(paramInt) });
    this.c.setAudioPlayoutVolume(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    Printer.a("muteAllRemoteAudio", new Object[] { Boolean.valueOf(paramBoolean) });
    this.c.muteAllRemoteAudio(paramBoolean);
  }
  
  public void d()
  {
    Printer.a("destroy", new Object[0]);
    if (this.a != null) {
      try
      {
        if (this.a != null)
        {
          this.a.setListener(null);
          this.a = null;
        }
        Printer.a("destroy sub", new Object[0]);
      }
      finally {}
    }
    if (this.c != null) {
      try
      {
        if (this.c != null)
        {
          this.b.removeCallbacks(this.e);
          TRTCCloud.destroySharedInstance();
          this.c.setListener(null);
          this.c = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void d(int paramInt)
  {
    this.c.getAudioEffectManager().setMusicPublishVolume(0, paramInt);
    this.c.getAudioEffectManager().setMusicPlayoutVolume(0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCInstance
 * JD-Core Version:    0.7.0.1
 */