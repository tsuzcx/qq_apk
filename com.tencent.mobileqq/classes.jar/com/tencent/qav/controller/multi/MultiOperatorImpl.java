package com.tencent.qav.controller.multi;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qav.monitor.CallingStateMonitor.CallingStateListener;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.avcore.jni.data.AVUserInfo;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultiOperatorImpl
  extends MultiOperatorBase
  implements IMultiOperator, CallingStateMonitor.CallingStateListener
{
  protected QavDef.MultiParams f;
  protected Map<Long, QavDef.MultiUserInfo> g;
  protected boolean h;
  protected boolean i = false;
  private AudioManager j;
  private boolean k;
  private boolean l;
  private int m;
  private boolean n;
  private Runnable o;
  
  public MultiOperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    this(paramContext, paramLong, paramVideoChannelInterface, true);
  }
  
  public MultiOperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface, boolean paramBoolean)
  {
    super(paramContext, paramLong, paramVideoChannelInterface, paramBoolean);
    AVLog.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramVideoChannelInterface }));
    this.j = ((AudioManager)this.a.getSystemService("audio"));
    this.g = new HashMap();
    CallingStateMonitor.a().a(this);
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.requestMemPosInfoList();
    }
  }
  
  private void e(boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.c != null)
    {
      if (paramBoolean)
      {
        this.c.startAudioSend(true);
        return;
      }
      this.c.stopAudioSend(true);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.c != null)
    {
      if (paramBoolean)
      {
        this.c.startAudioRecv();
        return;
      }
      this.c.stopAudioRecv();
    }
  }
  
  public int a(QavDef.MultiParams paramMultiParams)
  {
    for (;;)
    {
      try
      {
        AVLog.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { paramMultiParams }));
        boolean bool1 = CallingStateMonitor.a().c();
        boolean bool2 = CallingStateMonitor.a().d();
        AVLog.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        if ((!bool1) && (!bool2))
        {
          if (this.h)
          {
            AVLog.a("MultiOperatorImpl", "enterRoom duplicate call.");
            return -3;
          }
          QavCtrl.a(this.d);
          QavCtrl.a(this.d, this.a, this.b);
          QQGAudioCtrl localQQGAudioCtrl = this.c;
          int i2 = -1;
          if (localQQGAudioCtrl != null)
          {
            this.f = paramMultiParams;
            if (paramMultiParams.g == 1)
            {
              i1 = this.c.startCommonGAudio(paramMultiParams.a, paramMultiParams.b, paramMultiParams.c, paramMultiParams.d, this.b, paramMultiParams.f, paramMultiParams.g, paramMultiParams.h, 0);
            }
            else
            {
              if (paramMultiParams.g != 2) {
                if (paramMultiParams.g != 4) {
                  break label327;
                }
              }
              i1 = this.c.commonRequest(paramMultiParams.a, paramMultiParams.d, paramMultiParams.b, paramMultiParams.c, paramMultiParams.g, 0, 8, "", paramMultiParams.g, paramMultiParams.h, paramMultiParams.i);
            }
            AVLog.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i1) }));
            if (i1 == 0) {
              n();
            }
            this.h = true;
            this.i = false;
          }
          else
          {
            i1 = -1;
          }
          if (i1 == 0) {
            i2 = 0;
          }
          return i2;
        }
        else
        {
          AVLog.a("MultiOperatorImpl", "enterRoom device take up.");
          return -2;
        }
      }
      finally {}
      label327:
      int i1 = -1;
    }
  }
  
  protected QavDef.MultiUserInfo a(long paramLong)
  {
    Map localMap = this.g;
    if (localMap != null) {
      return (QavDef.MultiUserInfo)localMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AVLog.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.h) }));
      if (this.h)
      {
        g();
        c(4);
      }
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    Map localMap = this.g;
    if (localMap != null) {
      localMap.put(Long.valueOf(paramMultiUserInfo.mUin), paramMultiUserInfo);
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    ObserverDispatcher.b().a(QavMultiObserver.class, 5, new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) });
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
    this.k = paramBoolean;
  }
  
  protected QavDef.MultiUserInfo b(long paramLong)
  {
    Map localMap = this.g;
    if (localMap != null) {
      return (QavDef.MultiUserInfo)localMap.remove(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      this.j.stopBluetoothSco();
      this.j.setBluetoothScoOn(false);
      this.j.setSpeakerphoneOn(false);
      if (Build.VERSION.SDK_INT >= 21) {
        this.j.setMode(3);
      } else {
        this.j.setMode(2);
      }
      this.m = paramInt;
      return;
    }
    catch (Exception localException)
    {
      Throwable localThrowable;
      break label144;
    }
    if (paramInt == 1)
    {
      this.j.stopBluetoothSco();
      this.j.setBluetoothScoOn(false);
      this.j.setSpeakerphoneOn(true);
      this.j.setMode(3);
      this.m = paramInt;
      return;
    }
    if (paramInt == 2)
    {
      this.j.startBluetoothSco();
      this.j.setBluetoothScoOn(true);
      this.j.setSpeakerphoneOn(false);
      this.j.setMode(3);
      this.m = paramInt;
      return;
      label144:
      AVLog.a("MultiOperatorImpl", "setAudioRoute fail.", localThrowable);
    }
  }
  
  protected void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.b().a(QavMultiObserver.class, 3, new Object[] { paramMultiUserInfo });
  }
  
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    this.l = paramBoolean;
  }
  
  protected void c(int paramInt)
  {
    AVLog.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    ObserverDispatcher.b().a(QavMultiObserver.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void c(long paramLong, ArrayList<AVUserInfo> paramArrayList)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    if (((QavDef.MultiParams)localObject).a == 11)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        AVUserInfo localAVUserInfo = (AVUserInfo)localIterator.next();
        localObject = a(localAVUserInfo.account);
        paramArrayList = (ArrayList<AVUserInfo>)localObject;
        if (localObject == null)
        {
          paramArrayList = new QavDef.MultiUserInfo();
          paramArrayList.mUin = localAVUserInfo.account;
          paramArrayList.mMicOn = true;
          a(paramArrayList);
        }
        int i1;
        if (TextUtils.isEmpty(paramArrayList.mOpenId))
        {
          paramArrayList.mOpenId = localAVUserInfo.openId;
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (i1 != 0)
        {
          b(paramArrayList);
          if (!paramArrayList.mMicOn) {
            a(paramArrayList, false);
          }
        }
      }
    }
    if (this.n)
    {
      paramArrayList = m();
      AVLog.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
      ObserverDispatcher.b().a(QavMultiObserver.class, 7, new Object[] { paramArrayList });
      this.n = false;
    }
  }
  
  protected void c(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.b().a(QavMultiObserver.class, 4, new Object[] { paramMultiUserInfo });
  }
  
  public void c(boolean paramBoolean)
  {
    a(1, paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    a(2, paramBoolean);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    try
    {
      AVLog.c("MultiOperatorImpl", "exitRoom");
      this.f = null;
      if (this.g != null) {
        this.g.clear();
      }
      if (this.c != null)
      {
        this.c.quitRoom(0);
        o();
        this.h = false;
      }
      return;
    }
    finally {}
  }
  
  public void h()
  {
    try
    {
      AVLog.c("MultiOperatorImpl", "updateRoomInfo");
      a();
      this.n = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int i()
  {
    return this.m;
  }
  
  public void j()
  {
    try
    {
      CallingStateMonitor.a().a(null);
      if (this.g != null)
      {
        this.g.clear();
        this.g = null;
      }
      super.j();
      return;
    }
    finally {}
  }
  
  public String l()
  {
    if (this.c != null) {
      try
      {
        String str = this.c.getNetWorkQualityRTT();
        return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  protected List<QavDef.MultiUserInfo> m()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values();
      if (!((Collection)localObject).isEmpty()) {
        return new ArrayList((Collection)localObject);
      }
    }
    return null;
  }
  
  protected void n()
  {
    if (this.o == null)
    {
      this.o = new MultiOperatorImpl.1(this);
      ThreadManager.a(this.o, 30000L);
    }
  }
  
  protected void o()
  {
    Runnable localRunnable = this.o;
    if (localRunnable != null)
    {
      ThreadManager.b(localRunnable);
      this.o = null;
    }
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    AVLog.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    AVLog.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
    QavDef.MultiUserInfo localMultiUserInfo = a(paramLong);
    if (localMultiUserInfo != null)
    {
      localMultiUserInfo.mMicOn = (paramBoolean ^ true);
      if ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.f.a != 11)) {
        a(localMultiUserInfo, bool);
      }
    }
  }
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    g();
    o();
    if (paramInt2 == 15)
    {
      c(3);
      return;
    }
    c(2);
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    g();
    o();
    c(2);
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.f == null) {
      return;
    }
    if (paramInt1 == 70)
    {
      AVLog.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      if (paramAVUserInfo.account == this.b) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        o();
        ObserverDispatcher.b().a(QavMultiObserver.class, 1, new Object[0]);
      }
      paramVarArgs = a(paramAVUserInfo.account);
      if ((paramVarArgs == null) && (paramInt1 == 0))
      {
        paramVarArgs = new QavDef.MultiUserInfo();
        paramVarArgs.mUin = paramAVUserInfo.account;
        paramVarArgs.mMicOn = true;
        a(paramVarArgs);
        if (this.f.a == 11)
        {
          a();
          return;
        }
        b(paramVarArgs);
        return;
      }
      paramAVUserInfo = paramVarArgs;
      if (paramInt1 != 0)
      {
        paramAVUserInfo = new QavDef.MultiUserInfo();
        paramAVUserInfo.mUin = this.f.e;
        paramAVUserInfo.mOpenId = this.f.f;
        paramAVUserInfo.mMicOn = true;
        a(paramAVUserInfo);
      }
      b(paramAVUserInfo);
      return;
    }
    if (paramInt1 == 71)
    {
      AVLog.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = b(paramAVUserInfo.account);
      if (paramAVUserInfo != null) {
        c(paramAVUserInfo);
      }
    }
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 42) || (paramInt1 == 43))
    {
      boolean bool;
      if (paramInt1 == 42) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt2 = paramArrayOfLong.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        QavDef.MultiUserInfo localMultiUserInfo = a(paramArrayOfLong[paramInt1]);
        if ((localMultiUserInfo != null) && ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.f.a != 11))) {
          ObserverDispatcher.b().a(QavMultiObserver.class, 6, new Object[] { localMultiUserInfo, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onSelfAudioVolumeChange(long paramLong)
  {
    QavDef.MultiUserInfo localMultiUserInfo = a(this.b);
    if ((localMultiUserInfo != null) && ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.f.a != 11)))
    {
      int i1 = (int)paramLong;
      ObserverDispatcher.b().a(QavMultiObserver.class, 6, new Object[] { localMultiUserInfo, Boolean.valueOf(true), Integer.valueOf(i1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.controller.multi.MultiOperatorImpl
 * JD-Core Version:    0.7.0.1
 */