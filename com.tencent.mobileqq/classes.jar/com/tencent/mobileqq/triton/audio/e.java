package com.tencent.mobileqq.triton.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayer;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerFactory;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  private final Object a = new Object();
  private TTEngine b;
  private IAudioPlayerFactory c;
  private IAudioPlayerFactory d;
  private AudioManager e;
  private AudioManager.OnAudioFocusChangeListener f;
  private AtomicBoolean g = new AtomicBoolean(false);
  private ConcurrentHashMap<Integer, IAudioPlayer> h = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, e.b> i = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<IAudioPlayer> j = new ConcurrentLinkedQueue();
  private volatile boolean k = true;
  private volatile int l = 1;
  private volatile int m = 1;
  private volatile boolean n;
  public volatile int o = 0;
  
  public e(TTEngine paramTTEngine)
  {
    this.b = paramTTEngine;
  }
  
  private int c(boolean paramBoolean)
  {
    TTLog.c("[audio] TTAudioPlayerManager", "execAudioFocus focus=" + paramBoolean);
    AudioManager localAudioManager = this.e;
    int i1;
    if (localAudioManager == null) {
      i1 = -1;
    }
    int i2;
    do
    {
      do
      {
        do
        {
          return i1;
          if (!paramBoolean) {
            break;
          }
          i2 = localAudioManager.requestAudioFocus(this.f, 3, 1);
          i1 = i2;
        } while (i2 != 1);
        i1 = i2;
      } while (!this.n);
      this.n = false;
      j();
      i1 = i2;
    } while (this.b.getJsRuntime(1) == null);
    this.b.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionEnd", null);
    return i2;
    return localAudioManager.abandonAudioFocus(this.f);
  }
  
  private IAudioPlayer f()
  {
    if (h() != null) {
      return h().create();
    }
    if (g() != null) {
      return g().create();
    }
    return null;
  }
  
  private IAudioPlayerFactory g()
  {
    if (this.d == null) {
      this.d = new c();
    }
    return this.d;
  }
  
  private IAudioPlayerFactory h()
  {
    return this.c;
  }
  
  private void i()
  {
    try
    {
      TTLog.c("[audio] TTAudioPlayerManager", "muteAll");
      Iterator localIterator = this.h.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          localIAudioPlayer.setVolume(0.0F);
        }
      }
      return;
    }
    finally
    {
      TTLog.b("[audio] TTAudioPlayerManager", "catching exception :muteAll error:", localThrowable);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/mobileqq/triton/audio/e:m	I
    //   4: ifle +121 -> 125
    //   7: aload_0
    //   8: getfield 62	com/tencent/mobileqq/triton/audio/e:l	I
    //   11: i2f
    //   12: fstore_1
    //   13: aload_0
    //   14: getfield 64	com/tencent/mobileqq/triton/audio/e:m	I
    //   17: istore_2
    //   18: fconst_1
    //   19: fload_1
    //   20: fmul
    //   21: iload_2
    //   22: i2f
    //   23: fdiv
    //   24: fstore_1
    //   25: ldc 78
    //   27: new 80	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   34: ldc 181
    //   36: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: fload_1
    //   40: invokevirtual 184	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   43: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 99	com/tencent/mobileqq/triton/engine/TTLog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aload_0
    //   51: getfield 51	com/tencent/mobileqq/triton/audio/e:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   54: invokevirtual 152	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   57: invokeinterface 158 1 0
    //   62: astore_3
    //   63: aload_3
    //   64: invokeinterface 164 1 0
    //   69: ifeq +55 -> 124
    //   72: aload_3
    //   73: invokeinterface 168 1 0
    //   78: checkcast 170	com/tencent/mobileqq/triton/sdk/audio/IAudioPlayer
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull -22 -> 63
    //   88: aload 4
    //   90: fload_1
    //   91: invokeinterface 174 2 0
    //   96: goto -33 -> 63
    //   99: astore 4
    //   101: ldc 78
    //   103: ldc 186
    //   105: aload 4
    //   107: invokestatic 179	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: pop
    //   111: goto -48 -> 63
    //   114: astore_3
    //   115: ldc 78
    //   117: ldc 188
    //   119: aload_3
    //   120: invokestatic 179	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: pop
    //   124: return
    //   125: fconst_1
    //   126: fstore_1
    //   127: goto -102 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	e
    //   12	115	1	f1	float
    //   17	5	2	i1	int
    //   62	11	3	localIterator	Iterator
    //   114	6	3	localThrowable1	Throwable
    //   81	8	4	localIAudioPlayer	IAudioPlayer
    //   99	7	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   88	96	99	finally
    //   0	18	114	finally
    //   25	63	114	finally
    //   63	83	114	finally
    //   101	111	114	finally
  }
  
  private IAudioPlayer l(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.h;
    if (localConcurrentHashMap != null) {
      return (IAudioPlayer)localConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public int a(MiniGameInfo paramMiniGameInfo, int paramInt, String paramString)
  {
    try
    {
      boolean bool = URLUtil.isNetworkUrl(paramString);
      if (bool) {}
      Object localObject;
      for (paramMiniGameInfo = paramString;; paramMiniGameInfo = ((File)localObject).getPath())
      {
        localObject = (e.b)this.i.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          ((e.b)localObject).a(paramString, paramMiniGameInfo);
        }
        paramString = (IAudioPlayer)this.h.get(Integer.valueOf(paramInt));
        if (paramString != null) {
          paramString.setAudioPath(paramMiniGameInfo);
        }
        return 0;
        paramMiniGameInfo = this.b.l().getResPath(paramString, "", paramMiniGameInfo);
        if (TextUtils.isEmpty(paramMiniGameInfo)) {
          break label166;
        }
        localObject = new File(paramMiniGameInfo);
        if (!((File)localObject).exists()) {
          break;
        }
      }
      label166:
      for (paramMiniGameInfo = "setMusicPath musicPath:" + paramString + ", localPath:" + paramMiniGameInfo + ", file not found";; paramMiniGameInfo = "setMusicPath musicPath:" + paramString + ", localPath:" + paramMiniGameInfo + " file path empty error")
      {
        TTLog.b("[audio] TTAudioPlayerManager", paramMiniGameInfo);
        paramMiniGameInfo = null;
        break;
      }
      return -1;
    }
    finally
    {
      TTLog.b("[audio] TTAudioPlayerManager", "setMusicPath " + paramString + " error ", paramMiniGameInfo);
    }
  }
  
  public void a()
  {
    if (this.n)
    {
      j();
      this.n = false;
    }
    if (this.b.getJsRuntime(1) != null) {
      this.b.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionEnd", null);
    }
  }
  
  public void a(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.h.remove(Integer.valueOf(paramInt));
    if (localIAudioPlayer != null)
    {
      localIAudioPlayer.release();
      this.j.add(localIAudioPlayer);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.seekTo(paramFloat);
    }
  }
  
  public void a(int paramInt, IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.j.poll();
    paramIAudioStateChangeListener = new e.b(this, this, paramInt, paramIAudioStateChangeListener);
    this.i.put(Integer.valueOf(paramInt), paramIAudioStateChangeListener);
    if (localIAudioPlayer == null)
    {
      localIAudioPlayer = f();
      if (localIAudioPlayer != null)
      {
        localIAudioPlayer.setAudioId(paramInt);
        localIAudioPlayer.setStateChangeListener(paramIAudioStateChangeListener);
        this.h.put(Integer.valueOf(paramInt), localIAudioPlayer);
        TTLog.c("[audio] TTAudioPlayerManager", String.format("createAudioContext. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.h.size()) }));
        return;
      }
      TTLog.b("[audio] TTAudioPlayerManager", String.format("createAudioContext error. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.h.size()) }));
      return;
    }
    localIAudioPlayer.release();
    localIAudioPlayer.setAudioId(paramInt);
    localIAudioPlayer.setStateChangeListener(paramIAudioStateChangeListener);
    this.h.put(Integer.valueOf(paramInt), localIAudioPlayer);
    TTLog.c("[audio] TTAudioPlayerManager", String.format("createAudioContext reuse. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.h.size()) }));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setAutoPlay(paramBoolean);
    }
  }
  
  public void a(Context paramContext)
  {
    this.e = ((AudioManager)paramContext.getSystemService("audio"));
    this.f = new e.a(this);
  }
  
  public void a(IAudioPlayerFactory paramIAudioPlayerFactory)
  {
    this.c = paramIAudioPlayerFactory;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    c(paramBoolean ^ true);
  }
  
  public void b()
  {
    AudioManager localAudioManager = this.e;
    if (localAudioManager != null)
    {
      this.l = localAudioManager.getStreamVolume(3);
      this.m = this.e.getStreamMaxVolume(3);
    }
    this.n = true;
    i();
    if (this.b.getJsRuntime(1) != null) {
      this.b.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionBegin", null);
    }
  }
  
  public void b(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setStartTime(paramFloat);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setLoop(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getAutoPlay();
    }
    return false;
  }
  
  public double c(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getBufferedTime();
    }
    return 0.0D;
  }
  
  public void c()
  {
    c(false);
    if (!this.g.get()) {
      this.g.set(false);
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.h.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          localIAudioPlayer.release();
        }
      }
    }
    this.h.clear();
    this.j.clear();
    TTLog.c("[audio] TTAudioPlayerManager", "onDestroy");
  }
  
  public void c(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null)
    {
      if (this.n) {
        paramFloat = 0.0F;
      }
      localIAudioPlayer.setVolume(paramFloat);
    }
  }
  
  public double d(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getCurrentPosition();
    }
    return 0.0D;
  }
  
  public void d()
  {
    try
    {
      TTLog.c("[audio] TTAudioPlayerManager", "pauseMusic all");
      this.g.set(true);
      c(false);
      Iterator localIterator = this.h.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          try
          {
            if (localIAudioPlayer.isPlaying()) {
              localIAudioPlayer.setNeedResume(true);
            }
            localIAudioPlayer.pause();
          }
          finally {}
        }
      }
      return;
    }
    finally
    {
      TTLog.b("[audio] TTAudioPlayerManager", "catching exception :pauseMusic error:", localThrowable1);
    }
  }
  
  public double e(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getDuration();
    }
    return 0.0D;
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: ldc 78
    //   2: ldc_w 387
    //   5: invokestatic 99	com/tencent/mobileqq/triton/engine/TTLog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: aload_0
    //   10: getfield 46	com/tencent/mobileqq/triton/audio/e:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   13: iconst_0
    //   14: invokevirtual 360	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   17: aload_0
    //   18: getfield 60	com/tencent/mobileqq/triton/audio/e:k	Z
    //   21: ifne +9 -> 30
    //   24: aload_0
    //   25: iconst_1
    //   26: invokespecial 329	com/tencent/mobileqq/triton/audio/e:c	(Z)I
    //   29: pop
    //   30: aload_0
    //   31: getfield 51	com/tencent/mobileqq/triton/audio/e:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: invokevirtual 152	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   37: invokeinterface 158 1 0
    //   42: astore_1
    //   43: aload_1
    //   44: invokeinterface 164 1 0
    //   49: ifeq +49 -> 98
    //   52: aload_1
    //   53: invokeinterface 168 1 0
    //   58: checkcast 170	com/tencent/mobileqq/triton/sdk/audio/IAudioPlayer
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull -20 -> 43
    //   66: aload_2
    //   67: invokeinterface 390 1 0
    //   72: ifeq -29 -> 43
    //   75: aload_2
    //   76: invokeinterface 393 1 0
    //   81: goto -38 -> 43
    //   84: astore_2
    //   85: ldc 78
    //   87: ldc_w 395
    //   90: aload_2
    //   91: invokestatic 179	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   94: pop
    //   95: goto -52 -> 43
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 66	com/tencent/mobileqq/triton/audio/e:o	I
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	e
    //   42	11	1	localIterator	Iterator
    //   61	15	2	localIAudioPlayer	IAudioPlayer
    //   84	7	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   66	81	84	finally
  }
  
  public boolean f(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getLoop();
    }
    return false;
  }
  
  public boolean g(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.isPaused();
    }
    return false;
  }
  
  public float h(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getStartTime();
    }
    return 0.0F;
  }
  
  public void i(int paramInt)
  {
    try
    {
      IAudioPlayer localIAudioPlayer = l(paramInt);
      if (localIAudioPlayer != null)
      {
        localIAudioPlayer.setNeedResume(false);
        localIAudioPlayer.pause();
      }
      return;
    }
    finally
    {
      TTLog.b("[audio] TTAudioPlayerManager", "pauseMusic fail!", localThrowable);
    }
  }
  
  public void j(int paramInt)
  {
    Object localObject = (e.b)this.i.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((e.b)localObject).a(true);
    }
    localObject = (IAudioPlayer)this.h.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      ((IAudioPlayer)localObject).play();
      if (!this.k) {
        c(true);
      }
    }
  }
  
  public void k(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = l(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.e
 * JD-Core Version:    0.7.0.1
 */