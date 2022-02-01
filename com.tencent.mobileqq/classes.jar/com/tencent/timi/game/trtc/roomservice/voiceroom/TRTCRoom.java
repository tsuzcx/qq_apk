package com.tencent.timi.game.trtc.roomservice.voiceroom;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.tproom_impl.TPRoom;
import com.tencent.timi.game.trtc.TRTCInstance;
import com.tencent.timi.game.trtc.roomservice.BgmParam;
import com.tencent.timi.game.trtc.roomservice.RoomHandle;
import com.tencent.timi.game.trtc.roomservice.RoomParam;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashMapLiveData;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashSetLiveData;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.SubRoomState;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.SubRoomWrapper;
import com.tencent.timi.game.trtc.tools.Printer;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TRTCRoom
  extends TPRoom
{
  public final RoomParam b;
  SubRoomWrapper c;
  protected MutableLiveData<RoomState> d = new TRTCRoom.1(this);
  protected HashSetLiveData<HashSet<String>> e = new HashSetLiveData();
  protected HashMapLiveData<HashMap<String, Boolean>> f = new HashMapLiveData();
  protected HashMapLiveData<HashMap<String, Integer>> g = new HashMapLiveData();
  boolean h = false;
  private TRTCInstance i;
  private final RoomHandle j;
  private Observer<Boolean> k;
  private Observer<Boolean> l;
  private Observer<Integer> m;
  private Observer<Integer> n;
  private Observer<Integer> o;
  private Observer<RoomState> p;
  private Observer<BgmParam> q;
  private TRTCCloudListener r;
  
  public TRTCRoom(Lifecycle paramLifecycle, RoomParam paramRoomParam, RoomHandle paramRoomHandle)
  {
    super(paramLifecycle, paramRoomParam);
    this.b = paramRoomParam;
    this.j = paramRoomHandle;
  }
  
  private void b()
  {
    this.i.a(((Boolean)this.j.a.getValue()).booleanValue());
    boolean bool1 = ((SubRoomState)this.j.g.getValue()).b;
    int i1 = 20;
    boolean bool2 = false;
    Object localObject;
    if (!bool1)
    {
      localObject = this.i;
      if (!((Boolean)this.j.a.getValue()).booleanValue()) {
        i1 = 21;
      }
      ((TRTCInstance)localObject).a(i1);
      this.i.b(((Boolean)this.j.b.getValue()).booleanValue() ^ true);
      localObject = this.f;
      String str = this.b.a;
      bool1 = bool2;
      if (((Boolean)this.j.a.getValue()).booleanValue())
      {
        bool1 = bool2;
        if (((Boolean)this.j.b.getValue()).booleanValue()) {
          bool1 = true;
        }
      }
      ((HashMapLiveData)localObject).a(str, Boolean.valueOf(bool1));
      return;
    }
    this.i.a(21);
    this.i.b(true);
    if (this.i.a != null)
    {
      localObject = this.i.a;
      if (!((Boolean)this.j.a.getValue()).booleanValue()) {
        i1 = 21;
      }
      ((TRTCCloud)localObject).switchRole(i1);
      this.i.a.muteLocalAudio(((Boolean)this.j.b.getValue()).booleanValue() ^ true);
      return;
    }
    Printer.a("refreshSeatAndMic", new Object[] { "error subcloud is null" });
  }
  
  private void c()
  {
    this.i.b(((Integer)this.j.c.getValue()).intValue());
    this.i.c(((Integer)this.j.d.getValue()).intValue());
    if (((Integer)this.j.c.getValue()).intValue() == 0) {
      this.g.a(this.b.a, Integer.valueOf(0));
    }
  }
  
  private void d()
  {
    int i1;
    if (!((SubRoomState)this.j.g.getValue()).b)
    {
      i1 = ((Integer)this.j.e.getValue()).intValue();
      if (i1 != 0)
      {
        if ((i1 != 1) && (i1 != 3)) {
          return;
        }
        this.i.c(true);
        if (this.i.a != null) {
          this.i.a.muteAllRemoteAudio(true);
        }
      }
      else
      {
        this.i.c(false);
        if (this.i.a != null) {
          this.i.a.muteAllRemoteAudio(false);
        }
      }
    }
    else
    {
      i1 = ((Integer)this.j.e.getValue()).intValue();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 3) {
            return;
          }
          this.i.c(true);
          if (this.i.a != null) {
            this.i.a.muteAllRemoteAudio(true);
          }
        }
        else
        {
          Object localObject = (HashSet)this.e.getValue();
          HashSet localHashSet = (HashSet)this.c.a.a().getValue();
          this.i.c(false);
          if (localHashSet != null)
          {
            localObject = ((HashSet)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              if (!localHashSet.contains(str)) {
                this.i.a(str, true);
              }
            }
          }
        }
      }
      else
      {
        this.i.c(false);
        if (this.i.a != null) {
          this.i.a.muteAllRemoteAudio(false);
        }
      }
    }
  }
  
  private void e()
  {
    BgmParam localBgmParam = (BgmParam)this.j.f.getValue();
    if (localBgmParam.c) {
      if (!TextUtils.isEmpty(localBgmParam.a)) {
        this.i.a(localBgmParam.a);
      } else {
        this.i.c();
      }
    }
    this.i.d(localBgmParam.b);
  }
  
  private void f()
  {
    if (((SubRoomState)this.j.g.getValue()).b)
    {
      if (this.h)
      {
        this.i.b();
        Printer.a("refreshSubRoomState", new Object[] { "Warning:进入子房间重复调用" });
      }
      this.i.a(this.c.a, new TRTCRoom.2(this));
      this.h = true;
      return;
    }
    if (this.h) {
      this.i.b();
    } else {
      Printer.a("refreshSubRoomState", new Object[] { "Warning:退出子房间重复调用" });
    }
    this.h = false;
  }
  
  private void g()
  {
    this.c = new SubRoomWrapper((SubRoomState)this.j.g.getValue(), this.j);
    ((SubRoomState)this.j.g.getValue()).e = this.c.a;
  }
  
  private void h()
  {
    Object localObject1 = this.j.a;
    Object localObject2 = new TRTCRoom.3(this);
    this.k = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.b;
    localObject2 = new TRTCRoom.4(this);
    this.l = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.c;
    localObject2 = new TRTCRoom.5(this);
    this.m = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.d;
    localObject2 = new TRTCRoom.6(this);
    this.n = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.e;
    localObject2 = new TRTCRoom.7(this);
    this.o = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.g;
    localObject2 = new TRTCRoom.8(this);
    this.p = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.j.f;
    localObject2 = new TRTCRoom.9(this);
    this.q = ((Observer)localObject2);
    ((LiveData)localObject1).observeForever((Observer)localObject2);
    localObject1 = this.i;
    localObject2 = new TRTCRoom.10(this, this, this.b);
    this.r = ((TRTCCloudListener)localObject2);
    ((TRTCInstance)localObject1).a((TRTCCloudListener)localObject2);
  }
  
  private void i()
  {
    this.j.a.removeObserver(this.k);
    this.j.b.removeObserver(this.l);
    this.j.c.removeObserver(this.m);
    this.j.d.removeObserver(this.n);
    this.j.e.removeObserver(this.o);
    this.j.g.removeObserver(this.p);
    this.j.f.removeObserver(this.q);
    this.i.b(this.r);
  }
  
  public LiveData<HashSet<String>> a()
  {
    return this.e;
  }
  
  public void onCreate()
  {
    Printer.a("onCreate", new Object[0]);
    this.i = new TRTCInstance();
    this.i.a(this.b);
    h();
    g();
    b();
  }
  
  public void onDestroy()
  {
    Printer.a("onDestroy", new Object[0]);
    this.i.d();
    i();
  }
  
  public void onPause()
  {
    Printer.a("onPause", new Object[0]);
  }
  
  public void onResume()
  {
    Printer.a("onResume", new Object[0]);
  }
  
  public void onStart()
  {
    Printer.a("onStart", new Object[0]);
    this.i.b(this.b);
  }
  
  public void onStop()
  {
    Printer.a("onStop", new Object[0]);
    this.i.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom
 * JD-Core Version:    0.7.0.1
 */