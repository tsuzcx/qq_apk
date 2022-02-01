package com.tencent.mobileqq.guild.audio;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCFocusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

public class TRTCAudioRoomLocal
  extends TRTCCloudListener
  implements IGuildTRTCFocusApi.TRTCFocusListener, ITRTCAudioRoom
{
  public static int a = 1400509444;
  public static int b = 300;
  private static TRTCAudioRoomLocal c;
  private int d;
  private String e;
  private String f;
  private TRTCCloud g;
  private TXBeautyManager h;
  private boolean i;
  private ITRTCAudioRoom.ITRTCAudioRoomListener j;
  private TRTCCloudDef.TRTCParams k;
  private Handler l;
  private ITRTCAudioRoom.ITRTCAudioRoomCallback m;
  private ITRTCAudioRoom.ITRTCAudioRoomCallback n;
  
  public static TRTCAudioRoomLocal f()
  {
    try
    {
      if (c == null) {
        c = new TRTCAudioRoomLocal();
      }
      TRTCAudioRoomLocal localTRTCAudioRoomLocal = c;
      return localTRTCAudioRoomLocal;
    }
    finally {}
  }
  
  private void i()
  {
    if (this.k == null) {
      return;
    }
    ((IGuildTRTCFocusApi)QRoute.api(IGuildTRTCFocusApi.class)).requestTRTCFocus(this, new TRTCAudioRoomLocal.2(this), null);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    if ((paramInt2 != 0) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      this.d = paramInt1;
      this.f = paramString3;
      this.e = paramString2;
      this.m = paramITRTCAudioRoomCallback;
      paramITRTCAudioRoomCallback = new StringBuilder();
      paramITRTCAudioRoomCallback.append("enter room, app id:");
      paramITRTCAudioRoomCallback.append(paramInt2);
      paramITRTCAudioRoomCallback.append(" room id:");
      paramITRTCAudioRoomCallback.append(paramString2);
      paramITRTCAudioRoomCallback.append(" user id:");
      paramITRTCAudioRoomCallback.append(paramString3);
      paramITRTCAudioRoomCallback.append(" sign:");
      paramITRTCAudioRoomCallback.append(paramString4);
      QLog.i("TRTCAudioRoomLocal", 1, paramITRTCAudioRoomCallback.toString());
      this.k = new TRTCCloudDef.TRTCParams();
      paramITRTCAudioRoomCallback = this.k;
      paramITRTCAudioRoomCallback.sdkAppId = paramInt2;
      paramITRTCAudioRoomCallback.privateMapKey = paramString1;
      paramITRTCAudioRoomCallback.userId = paramString3;
      paramITRTCAudioRoomCallback.userSig = paramString4;
      paramITRTCAudioRoomCallback.role = paramInt3;
      paramITRTCAudioRoomCallback.roomId = Integer.valueOf(paramString2).intValue();
      i();
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("enter trtc room fail. params invalid. room id:");
    paramString1.append(paramString2);
    paramString1.append(" user id:");
    paramString1.append(paramString3);
    paramString1.append(" sign is empty:");
    paramString1.append(TextUtils.isEmpty(paramString4));
    QLog.e("TRTCAudioRoomLocal", 1, paramString1.toString());
    if (paramITRTCAudioRoomCallback != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("enter trtc room fail. params invalid. room id:");
      paramString1.append(paramString2);
      paramString1.append(" user id:");
      paramString1.append(paramString3);
      paramString1.append(" sign is empty:");
      paramString1.append(TextUtils.isEmpty(paramString4));
      paramITRTCAudioRoomCallback.a(-1, paramString1.toString());
    }
  }
  
  public void a(Context paramContext, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init context:");
    localStringBuilder.append(paramContext);
    QLog.i("TRTCAudioRoomLocal", 1, localStringBuilder.toString());
    SoLoadManager.getInstance().load("trtc_entry", new TRTCAudioRoomLocal.1(this, paramContext, paramITRTCAudioRoomCallback));
  }
  
  public void a(Context paramContext, String paramString)
  {
    TXLiveBase.setLibraryPath(paramString);
    this.g = TRTCCloud.sharedInstance(paramContext);
    this.h = this.g.getBeautyManager();
    this.l = new Handler(Looper.getMainLooper());
  }
  
  public void a(ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback)
  {
    QLog.i("TRTCAudioRoomLocal", 1, "exit room.");
    this.f = null;
    this.k = null;
    this.m = null;
    this.n = paramITRTCAudioRoomCallback;
    this.l.removeCallbacksAndMessages(null);
    this.g.exitRoom();
  }
  
  public void a(ITRTCAudioRoom.ITRTCAudioRoomListener paramITRTCAudioRoomListener)
  {
    this.j = paramITRTCAudioRoomListener;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mute remote audio, user id:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" mute:");
    localStringBuilder.append(paramBoolean);
    QLog.i("TRTCAudioRoomLocal", 1, localStringBuilder.toString());
    this.g.muteRemoteAudio(paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    TRTCCloud localTRTCCloud = this.g;
    int i1;
    if (paramBoolean) {
      i1 = b;
    } else {
      i1 = 0;
    }
    localTRTCCloud.enableAudioVolumeEvaluation(i1);
  }
  
  public void b()
  {
    this.g.muteLocalAudio(false);
    onUserAudioAvailable(this.f, true);
  }
  
  public void c()
  {
    this.g.muteLocalAudio(true);
    onUserAudioAvailable(this.f, false);
  }
  
  public void d()
  {
    this.g.setAudioRoute(0);
  }
  
  public void e()
  {
    this.g.setAudioRoute(1);
  }
  
  public void g()
  {
    this.g.switchRole(20);
    this.g.startLocalAudio();
  }
  
  public void h()
  {
    this.g.stopLocalAudio();
    this.g.switchRole(21);
  }
  
  public void onAudioRouteChanged(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioRouteChanged new:");
    localStringBuilder.append(paramInt1);
    QLog.i("TRTCAudioRoomLocal", 1, localStringBuilder.toString());
  }
  
  public void onEnterRoom(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on enter room, tid:");
    localStringBuilder.append(Thread.currentThread().getId());
    QLog.i("TRTCAudioRoomLocal", 1, localStringBuilder.toString());
    if (this.m != null)
    {
      if (paramLong > 0L)
      {
        QLog.i("TRTCAudioRoomLocal", 1, "on enter room success");
        this.i = true;
        this.m.a(0, "enter room success.");
        a(true);
        this.g.startLocalAudio();
        return;
      }
      QLog.e("TRTCAudioRoomLocal", 1, "on enter room fail");
      this.i = false;
      this.m.a((int)paramLong, "enter room fail");
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onError: ");
    paramBundle.append(paramInt);
    QLog.i("TRTCAudioRoomLocal", 1, paramBundle.toString());
    paramBundle = this.j;
    if (paramBundle != null) {
      paramBundle.b(paramInt, paramString);
    }
  }
  
  public void onExitRoom(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on exit room.tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.i("TRTCAudioRoomLocal", 1, ((StringBuilder)localObject).toString());
    localObject = this.n;
    if (localObject != null)
    {
      this.i = false;
      ((ITRTCAudioRoom.ITRTCAudioRoomCallback)localObject).a(0, "exit room success.");
      this.n = null;
    }
    if (this.j != null)
    {
      if (paramInt == 0) {
        localObject = "主动调用 exitRoom 退房";
      } else if (paramInt == 1) {
        localObject = "被服务器踢出当前房间";
      } else if (paramInt == 2) {
        localObject = "当前房间整个被解散";
      } else {
        localObject = "";
      }
      this.j.a(paramInt, (String)localObject);
    }
    ((IGuildTRTCFocusApi)QRoute.api(IGuildTRTCFocusApi.class)).onReleaseTRTCFocus(this);
  }
  
  public void onMicDidReady()
  {
    QLog.i("TRTCAudioRoomLocal", 1, "onMicDidReady");
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on user enter, user id:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.i("TRTCAudioRoomLocal", 1, ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      ((ITRTCAudioRoom.ITRTCAudioRoomListener)localObject).b(paramString);
    }
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on user exit, user id:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.i("TRTCAudioRoomLocal", 1, ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      ((ITRTCAudioRoom.ITRTCAudioRoomListener)localObject).c(paramString);
    }
  }
  
  public void onSetMixTranscodingConfig(int paramInt, String paramString)
  {
    super.onSetMixTranscodingConfig(paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on set mix transcoding, code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.i("TRTCAudioRoomLocal", 1, localStringBuilder.toString());
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on user audio available, user id:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" available:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.i("TRTCAudioRoomLocal", 1, ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      ((ITRTCAudioRoom.ITRTCAudioRoomListener)localObject).a(paramString, paramBoolean);
    }
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    this.j.a(ITRTCAudioRoom.TRTCVolumeInfo.a(paramArrayList), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomLocal
 * JD-Core Version:    0.7.0.1
 */