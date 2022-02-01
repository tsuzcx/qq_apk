package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

@ProxyService(proxy=MusicPlayerProxy.class)
public class MusicPlayerProxyImpl
  implements MusicPlayerProxy
{
  private static String b;
  private IQQPlayerService a;
  private MusicPlayerProxy.MusicPlayerListener c = null;
  private String d = null;
  private String e = null;
  private long f = -1L;
  private ServiceConnection g = new MusicPlayerProxyImpl.1(this);
  private IQQPlayerCallback.Stub h = new MusicPlayerProxyImpl.2(this);
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:a	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   6: ifnonnull +102 -> 108
    //   9: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   12: lstore_1
    //   13: aload_0
    //   14: getfield 39	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:f	J
    //   17: ldc2_w 36
    //   20: lcmp
    //   21: ifeq +30 -> 51
    //   24: lload_1
    //   25: aload_0
    //   26: getfield 39	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:f	J
    //   29: lsub
    //   30: ldc2_w 64
    //   33: lcmp
    //   34: ifle +6 -> 40
    //   37: goto +14 -> 51
    //   40: ldc 67
    //   42: iconst_1
    //   43: ldc 69
    //   45: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: goto +60 -> 108
    //   51: aload_0
    //   52: lload_1
    //   53: putfield 39	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:f	J
    //   56: new 76	android/content/Intent
    //   59: dup
    //   60: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: ldc 84
    //   65: invokespecial 87	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   68: astore_3
    //   69: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 46	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:g	Landroid/content/ServiceConnection;
    //   77: bipush 33
    //   79: invokevirtual 91	com/tencent/qphone/base/util/BaseApplication:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   82: pop
    //   83: ldc 67
    //   85: iconst_1
    //   86: ldc 93
    //   88: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto +17 -> 108
    //   94: astore_3
    //   95: goto +16 -> 111
    //   98: astore_3
    //   99: ldc 67
    //   101: iconst_1
    //   102: ldc 95
    //   104: aload_3
    //   105: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	MusicPlayerProxyImpl
    //   12	41	1	l	long
    //   68	5	3	localIntent	Intent
    //   94	1	3	localObject	Object
    //   98	16	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	37	94	finally
    //   40	48	94	finally
    //   51	91	94	finally
    //   99	108	94	finally
    //   2	37	98	java/lang/Throwable
    //   40	48	98	java/lang/Throwable
    //   51	91	98	java/lang/Throwable
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:a	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   6: ifnull +35 -> 41
    //   9: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: aload_0
    //   13: getfield 46	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:g	Landroid/content/ServiceConnection;
    //   16: invokevirtual 103	com/tencent/qphone/base/util/BaseApplication:unbindService	(Landroid/content/ServiceConnection;)V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 54	com/tencent/qqmini/proxyimpl/MusicPlayerProxyImpl:a	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   24: goto +17 -> 41
    //   27: astore_1
    //   28: goto +16 -> 44
    //   31: astore_1
    //   32: ldc 67
    //   34: iconst_1
    //   35: ldc 105
    //   37: aload_1
    //   38: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MusicPlayerProxyImpl
    //   27	1	1	localObject	Object
    //   31	16	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
    //   32	41	27	finally
    //   2	24	31	java/lang/Throwable
  }
  
  private String c()
  {
    if (b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MusicPlayerProxyImpl");
      localStringBuilder.append(this.d);
      b = QQPlayerService.a(8, localStringBuilder.toString());
    }
    return b;
  }
  
  public com.tencent.qqmini.sdk.launcher.core.model.SongInfo getCurrentSong()
  {
    try
    {
      if (this.a != null)
      {
        com.tencent.mobileqq.music.SongInfo localSongInfo = this.a.k();
        com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo1 = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
        localSongInfo1.id = localSongInfo.a;
        localSongInfo1.mid = localSongInfo.b;
        localSongInfo1.uin = localSongInfo.c;
        localSongInfo1.url = localSongInfo.d;
        localSongInfo1.title = localSongInfo.e;
        localSongInfo1.summary = localSongInfo.f;
        localSongInfo1.coverUrl = localSongInfo.g;
        localSongInfo1.detailUrl = localSongInfo.h;
        localSongInfo1.album = localSongInfo.i;
        localSongInfo1.singer = localSongInfo.j;
        localSongInfo1.singerId = localSongInfo.k;
        localSongInfo1.startTime = localSongInfo.l;
        localSongInfo1.type = localSongInfo.m;
        localSongInfo1.fromMini = localSongInfo.n;
        localSongInfo1.duration = localSongInfo.p;
        return localSongInfo1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSong exception ", localException);
    }
    return null;
  }
  
  public int getCurrentSongPosition()
  {
    IQQPlayerService localIQQPlayerService = this.a;
    if (localIQQPlayerService != null) {
      try
      {
        int i = localIQQPlayerService.j();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return 0;
  }
  
  public int getDuration()
  {
    IQQPlayerService localIQQPlayerService = this.a;
    if (localIQQPlayerService != null) {
      try
      {
        int i = localIQQPlayerService.i();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongDuration exception ", localException);
      }
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2)
  {
    this.c = paramMusicPlayerListener;
    this.d = paramString1;
    this.e = paramString2;
    a();
  }
  
  public boolean isInit()
  {
    return this.a != null;
  }
  
  public boolean isPlaying()
  {
    for (;;)
    {
      try
      {
        if (this.a != null) {
          if (this.a.a(c())) {
            break label83;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBackgroundAudioState: null ");
        if (this.a != null) {
          break label85;
        }
        bool = true;
        localStringBuilder.append(bool);
        Log.i("MusicPlayerProxyImpl", localStringBuilder.toString());
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "isPlaying exception ", localException);
        return false;
      }
      label83:
      return true;
      label85:
      boolean bool = false;
    }
  }
  
  public void pause()
  {
    try
    {
      if (this.a != null)
      {
        this.a.a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "pause exception ", localException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.a != null)
      {
        this.a.b();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "resume exception ", localException);
    }
  }
  
  public void seekTo(int paramInt)
  {
    try
    {
      if (this.a != null)
      {
        this.a.b(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "seekTo exception ", localException);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    try
    {
      if (this.a != null)
      {
        this.a.a(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "setPlayMode exception ", localException);
    }
  }
  
  public void startPlay(com.tencent.qqmini.sdk.launcher.core.model.SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (paramArrayOfSongInfo != null)
    {
      if (paramArrayOfSongInfo.length < 1) {
        return;
      }
      Object localObject = this.a;
      if (localObject != null) {
        try
        {
          ((IQQPlayerService)localObject).a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
          Bundle localBundle = this.a.q();
          localObject = localBundle;
          if (localBundle == null)
          {
            localObject = new Bundle();
            this.a.a((Bundle)localObject);
          }
          ((Bundle)localObject).putString("KEY_SOURCE_NAME", this.e);
          this.a.a((Bundle)localObject);
          localObject = new com.tencent.mobileqq.music.SongInfo[paramArrayOfSongInfo.length];
          int i = 0;
          while (i < paramArrayOfSongInfo.length)
          {
            localObject[i] = new com.tencent.mobileqq.music.SongInfo();
            localObject[i].i = paramArrayOfSongInfo[i].album;
            localObject[i].g = paramArrayOfSongInfo[i].coverUrl;
            localObject[i].h = paramArrayOfSongInfo[i].detailUrl;
            localObject[i].p = paramArrayOfSongInfo[i].duration;
            localObject[i].n = paramArrayOfSongInfo[i].fromMini;
            localObject[i].a = paramArrayOfSongInfo[i].id;
            localObject[i].b = paramArrayOfSongInfo[i].mid;
            localObject[i].j = paramArrayOfSongInfo[i].singer;
            localObject[i].k = paramArrayOfSongInfo[i].singerId;
            localObject[i].l = paramArrayOfSongInfo[i].startTime;
            localObject[i].f = paramArrayOfSongInfo[i].summary;
            localObject[i].e = paramArrayOfSongInfo[i].title;
            localObject[i].m = paramArrayOfSongInfo[i].type;
            localObject[i].c = paramArrayOfSongInfo[i].uin;
            localObject[i].d = paramArrayOfSongInfo[i].url;
            i += 1;
          }
          this.a.a(100);
          this.a.a(c(), (com.tencent.mobileqq.music.SongInfo[])localObject, paramInt);
          return;
        }
        catch (Exception paramArrayOfSongInfo)
        {
          QLog.e("MusicPlayerProxyImpl", 1, "startPlay exception ", paramArrayOfSongInfo);
        }
      }
    }
  }
  
  public void stop()
  {
    try
    {
      if (this.a != null)
      {
        this.a.c();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "stop exception ", localException);
    }
  }
  
  public void unInit()
  {
    b();
    this.c = null;
    this.d = null;
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl
 * JD-Core Version:    0.7.0.1
 */