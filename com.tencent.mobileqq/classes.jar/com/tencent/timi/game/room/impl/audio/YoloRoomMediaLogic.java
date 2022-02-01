package com.tencent.timi.game.room.impl.audio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomEventListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCInterface;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoom;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import com.tencent.timi.game.utils.Logger;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;

public class YoloRoomMediaLogic
{
  static long b;
  boolean a = true;
  private int c;
  private long d;
  private String e;
  private String f;
  private TRTCInterface g;
  private LiveData<RoomState> h;
  private Observer<RoomState> i;
  private MutableLiveData<ConcurrentHashMap<String, Integer>> j;
  private Observer<ConcurrentHashMap<String, Integer>> k;
  private MutableLiveData<RoomState> l;
  private Observer<RoomState> m;
  private MutableLiveData<ConcurrentHashMap<String, Integer>> n;
  private Observer<ConcurrentHashMap<String, Integer>> o;
  private YoloRoomInterface.YoloRoomAudioListener p;
  private TRTCCloudListener q;
  private List<IRoomEventListener> r;
  
  public YoloRoomMediaLogic(int paramInt, long paramLong)
  {
    this.c = paramInt;
    this.d = paramLong;
    this.r = new ArrayList();
    this.f = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).b();
    this.e = a(paramLong);
    this.g = TRTCMultipeVoiceRoomManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("yoloRoomType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", yoloRoomId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", selfUid = ");
    localStringBuilder.append(LogUtil.getSafePrintUin(this.f));
    localStringBuilder.append(", audioRoomName = ");
    localStringBuilder.append(this.e);
    Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ServerEnv.c().toLowerCase());
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private static void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("room_mic_enable");
    localStringBuilder.append(paramInt);
    TGSharedPreferenceUtil.a(localStringBuilder.toString(), paramBoolean);
  }
  
  public static boolean c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("room_mic_enable");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return TGSharedPreferenceUtil.b((String)localObject, bool);
  }
  
  private void g()
  {
    Object localObject1 = this.g.a(this.e);
    if (localObject1 != null)
    {
      this.h = ((TRTCMultipeVoiceRoom)localObject1).d();
      this.j = ((TRTCMultipeVoiceRoom)localObject1).a();
    }
    localObject1 = this.h;
    if (localObject1 != null)
    {
      localObject2 = new YoloRoomMediaLogic.3(this);
      this.i = ((Observer)localObject2);
      ((LiveData)localObject1).observeForever((Observer)localObject2);
    }
    localObject1 = this.j;
    if (localObject1 == null)
    {
      Logger.c("YoloRoomAudioLogic", "registerLiveData but memberMicLevelLD is null!");
      return;
    }
    Object localObject2 = new YoloRoomMediaLogic.4(this);
    this.k = ((Observer)localObject2);
    ((MutableLiveData)localObject1).observeForever((Observer)localObject2);
  }
  
  private void h()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((LiveData)localObject).removeObserver(this.i);
    }
    localObject = this.j;
    if (localObject != null) {
      ((MutableLiveData)localObject).removeObserver(this.k);
    }
  }
  
  private void i()
  {
    MutableLiveData localMutableLiveData = this.l;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObserver(this.m);
    }
    localMutableLiveData = this.n;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObserver(this.o);
    }
  }
  
  private void j() {}
  
  public void a()
  {
    Logger.a("YoloRoomAudioLogic", "exitAudioRoom ");
    this.g.j(this.e);
    this.g.b(this.e, this.q);
    this.r.clear();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBgmPublishVolumn, publishVolumn = ");
    localStringBuilder.append(paramInt);
    Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
    this.g.b(paramInt);
  }
  
  public void a(IRoomEventListener paramIRoomEventListener)
  {
    if (!this.r.contains(paramIRoomEventListener)) {
      this.r.add(paramIRoomEventListener);
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBgmPath, path = ");
    localStringBuilder.append(paramString);
    Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
    this.g.i(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opSpeakingSeat, isOn = ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.g.b(this.e);
      return;
    }
    this.g.c(this.e);
  }
  
  public void a(boolean paramBoolean, YoloRoomInterface.YoloRoomAudioListener paramYoloRoomAudioListener)
  {
    Logger.a("YoloRoomAudioLogic", "enterAudioRoom");
    this.p = paramYoloRoomAudioListener;
    this.g.a(this.e, this.f, this.c, new YoloRoomMediaLogic.1(this));
    if ((paramBoolean) && (c(this.c))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    b(paramBoolean);
    c(true);
    this.g.a(100);
    b(100);
    g();
    this.g.b(this.e, this.q);
    paramYoloRoomAudioListener = this.g;
    String str = this.e;
    YoloRoomMediaLogic.2 local2 = new YoloRoomMediaLogic.2(this);
    this.q = local2;
    paramYoloRoomAudioListener.a(str, local2);
  }
  
  public void b()
  {
    Logger.a("YoloRoomAudioLogic", "destroy ");
    h();
    i();
  }
  
  public void b(int paramInt)
  {
    this.g.a(this.e, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g.d(this.e);
    } else {
      this.g.e(this.e);
    }
    if ((paramBoolean) && (!c())) {
      c(true);
    }
    a(paramBoolean, this.c);
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeakerEnable, ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomAudioLogic", localStringBuilder.toString());
    if (paramBoolean) {
      this.g.f(this.e);
    } else {
      this.g.g(this.e);
    }
    this.a = paramBoolean;
  }
  
  public boolean c()
  {
    TRTCMultipeVoiceRoom localTRTCMultipeVoiceRoom = this.g.a(this.e);
    if (localTRTCMultipeVoiceRoom != null) {
      return localTRTCMultipeVoiceRoom.g() ^ true;
    }
    return this.a;
  }
  
  public boolean d()
  {
    return this.g.h(this.e);
  }
  
  public LiveData<Boolean> e()
  {
    TRTCMultipeVoiceRoom localTRTCMultipeVoiceRoom = this.g.a(this.e);
    if (localTRTCMultipeVoiceRoom != null) {
      return localTRTCMultipeVoiceRoom.c();
    }
    return null;
  }
  
  public LiveData<Boolean> f()
  {
    TRTCMultipeVoiceRoom localTRTCMultipeVoiceRoom = this.g.a(this.e);
    if (localTRTCMultipeVoiceRoom != null) {
      return localTRTCMultipeVoiceRoom.b();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic
 * JD-Core Version:    0.7.0.1
 */