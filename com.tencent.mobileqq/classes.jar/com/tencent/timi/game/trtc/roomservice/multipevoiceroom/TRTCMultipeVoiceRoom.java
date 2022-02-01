package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import com.tencent.timi.game.trtc.tools.CloudListenerInformer;
import com.tencent.timi.game.utils.Logger;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class TRTCMultipeVoiceRoom
{
  final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> a = new MutableLiveData();
  private TRTCCloud b;
  private final String c;
  private final String d;
  private int e = 21;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private int i = 100;
  private RoomState j = new RoomState();
  private final ConcurrentHashMap<String, Integer> k = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> l = new ConcurrentHashMap();
  private CloudListenerInformer m = new CloudListenerInformer();
  private TRTCCloudListener n;
  private final MutableLiveData<ConcurrentHashMap<String, Integer>> o = new MutableLiveData();
  private final MutableLiveData<Boolean> p = new MutableLiveData();
  private final MutableLiveData<Boolean> q = new MutableLiveData();
  private final MutableLiveData<Boolean> r = new MutableLiveData();
  private final MutableLiveData<Integer> s = new MutableLiveData();
  private final MutableLiveData<RoomState> t = new TRTCMultipeVoiceRoom.1(this);
  
  public TRTCMultipeVoiceRoom(TRTCCloud paramTRTCCloud, String paramString1, String paramString2)
  {
    this.b = paramTRTCCloud;
    this.c = paramString1;
    this.d = paramString2;
    paramTRTCCloud.enableAudioVolumeEvaluation(300);
    paramTRTCCloud.setListener(new TRTCMultipeVoiceRoom.2(this, this.m));
    paramString2 = this.m;
    paramTRTCCloud = new TRTCMultipeVoiceRoom.3(this, paramTRTCCloud, paramString1);
    this.n = paramTRTCCloud;
    paramString2.a(paramTRTCCloud);
  }
  
  private void b(int paramInt)
  {
    this.j.a = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRoomState:");
    localStringBuilder.append(this.j.a());
    localStringBuilder.append(" roomID");
    localStringBuilder.append(this.c);
    Logger.a("TRTCMultipeVoiceRoom", localStringBuilder.toString());
    this.t.setValue(this.j);
    TRTCMultipeVoiceRoomManager.a().b();
  }
  
  public MutableLiveData<ConcurrentHashMap<String, Integer>> a()
  {
    return this.o;
  }
  
  void a(int paramInt)
  {
    this.i = paramInt;
    this.s.setValue(Integer.valueOf(paramInt));
  }
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    this.m.a(paramTRTCCloudListener);
  }
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.q.setValue(Boolean.valueOf(this.g));
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.q;
  }
  
  public void b(TRTCCloudListener paramTRTCCloudListener)
  {
    this.m.b(paramTRTCCloudListener);
  }
  
  void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.r.setValue(Boolean.valueOf(this.h));
  }
  
  public MutableLiveData<Boolean> c()
  {
    return this.r;
  }
  
  void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.p.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public MutableLiveData<RoomState> d()
  {
    return this.t;
  }
  
  public TRTCCloud e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRTCMultipeVoiceRoom{roomID='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userID='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", role=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isOnMicPosition=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isSpeakerMute=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isMicMute=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", volume=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", roomState=");
    localStringBuilder.append(this.j.a());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoom
 * JD-Core Version:    0.7.0.1
 */