package com.tencent.qgplayer.rtmpsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qgplayer.rtmpsdk.a.g;
import com.tencent.qgplayer.rtmpsdk.b.a;
import com.tencent.qgplayer.rtmpsdk.c.d;
import com.tencent.qgplayer.rtmpsdk.c.e;
import java.util.List;

public class SimpleQGPlayer
  implements IQGPlayListener, QGPlayer
{
  public static final int CLARIFY_FHD = 5;
  public static final int CLARIFY_FLU = 1;
  public static final int CLARIFY_HD = 3;
  public static final int CLARIFY_SD = 2;
  public static final int CLARIFY_SHD = 4;
  public static final int CLARIFY_UNKNOWN = 0;
  public static final int MEDIA_TYPE_LIVE_FLV = 2;
  public static final int MEDIA_TYPE_LIVE_HLS = 3;
  public static final int MEDIA_TYPE_LIVE_MP4 = 4;
  public static final int MEDIA_TYPE_RTMP = 1;
  public static final int MEDIA_TYPE_UNKNOWN = 0;
  public static final int STREAM_TYPE_LIVE = 1;
  public static final int STREAM_TYPE_UNKNOWN = 0;
  public static final int STREAM_TYPE_VOD = 2;
  public static ILogListener logListener;
  private boolean a = true;
  private boolean b = false;
  private boolean c = true;
  private float d = 1.0F;
  private Context e;
  private QGPlayerView f;
  private boolean g = true;
  private QGMediaStream[] h = null;
  private int i = 0;
  private String j;
  private int k = 0;
  private int l = 2;
  private int m = 0;
  private g n;
  private a o;
  private int p;
  private IQGPlayListener q;
  private d r = new d();
  private Handler s = new Handler(Looper.getMainLooper());
  private boolean t = false;
  private int u = -1;
  
  public SimpleQGPlayer(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.o = new a();
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    byte[] arrayOfByte;
    StringBuilder localStringBuilder;
    int i4;
    int i1;
    int i2;
    try
    {
      if (paramString.contains("?")) {
        str = paramString;
      }
      for (paramString = paramString + "&txPlayerId=" + System.currentTimeMillis();; paramString = paramString + "?txPlayerId=" + System.currentTimeMillis())
      {
        str = paramString;
        arrayOfByte = paramString.getBytes("UTF-8");
        str = paramString;
        localStringBuilder = new StringBuilder(arrayOfByte.length);
        str = paramString;
        i4 = arrayOfByte.length;
        i1 = 0;
        break;
        str = paramString;
        localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i2) }));
        break label294;
        str = paramString;
      }
      label140:
      str = paramString;
      localStringBuilder.append((char)i2);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    label159:
    return str.trim();
    label294:
    label299:
    for (;;)
    {
      str = paramString;
      paramString = localStringBuilder.toString();
      str = paramString;
      break label159;
      for (;;)
      {
        if (i1 >= i4) {
          break label299;
        }
        int i3 = arrayOfByte[i1];
        i2 = i3;
        if (i3 < 0) {
          i2 = i3 + 256;
        }
        if ((i2 <= 32) || (i2 >= 127) || (i2 == 34) || (i2 == 37) || (i2 == 60) || (i2 == 62) || (i2 == 91) || (i2 == 125) || (i2 == 92) || (i2 == 93) || (i2 == 94) || (i2 == 96) || (i2 == 123)) {
          break;
        }
        if (i2 != 124) {
          break label140;
        }
        break;
        i1 += 1;
      }
    }
  }
  
  private void a(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Object localObject = paramString1;
    if (paramArrayOfQGMediaStream != null)
    {
      localObject = paramString1;
      if (paramArrayOfQGMediaStream.length > paramInt1)
      {
        localObject = paramString1;
        if (paramInt1 >= 0) {
          localObject = paramArrayOfQGMediaStream[paramInt1].url;
        }
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.o == null))
    {
      QGLog.e("QGPlayer.SimpleQGPlayer", "start fail, playUrl is null or mVideoRender released , playUrl : " + (String)localObject);
      return;
    }
    stop(this.g);
    if (paramArrayOfQGMediaStream == null) {
      this.h = null;
    }
    for (;;)
    {
      paramArrayOfQGMediaStream = (QGMediaStream[])localObject;
      if (TextUtils.equals(this.j, (CharSequence)localObject)) {
        break label258;
      }
      paramString1 = a((String)localObject);
      if (this.h != null)
      {
        paramArrayOfQGMediaStream = this.h;
        int i2 = paramArrayOfQGMediaStream.length;
        int i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            localObject = paramArrayOfQGMediaStream[i1];
            ((QGMediaStream)localObject).url = a(((QGMediaStream)localObject).url);
            i1 += 1;
            continue;
            this.h = new QGMediaStream[paramArrayOfQGMediaStream.length];
            i1 = 0;
            try
            {
              while (i1 < this.h.length)
              {
                this.h[i1] = ((QGMediaStream)paramArrayOfQGMediaStream[i1].clone());
                i1 += 1;
              }
            }
            catch (CloneNotSupportedException paramArrayOfQGMediaStream)
            {
              paramArrayOfQGMediaStream.printStackTrace();
            }
          }
        }
      }
    }
    paramArrayOfQGMediaStream = paramString1;
    if (this.h != null)
    {
      paramArrayOfQGMediaStream = paramString1;
      if (paramInt1 >= 0)
      {
        paramArrayOfQGMediaStream = paramString1;
        if (paramInt1 < this.h.length) {
          paramArrayOfQGMediaStream = this.h[paramInt1].url;
        }
      }
    }
    label258:
    this.i = paramInt1;
    this.j = paramArrayOfQGMediaStream;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    this.n = new g(this.e, this.o, this.a, this.b, this.c);
    this.n.a(this.d);
    if (this.q != null) {
      QGPlayerNativeManager.addPlayListener(this.j, this);
    }
    QGPlayerNativeManager.addMediaDataListener(paramArrayOfQGMediaStream, this.n);
    if (this.f != null)
    {
      this.n.a(this.f);
      this.f.setVisibility(0);
      setRenderMode(this.p);
    }
    this.n.a(this.h, paramInt1, paramArrayOfQGMediaStream, paramInt2, paramInt3, paramInt4, paramString2);
    this.n.a(this.t);
  }
  
  public static void init()
  {
    QGLog.i("QGPlayer.SimpleQGPlayer", "init QGPlayer");
    QGPlayerNativeManager.init();
  }
  
  public static void setLogListener(ILogListener paramILogListener)
  {
    logListener = paramILogListener;
  }
  
  public int getCurrentTime()
  {
    return QGPlayerNativeManager.nativeGetCurrentTime(this.j);
  }
  
  public float getDownloadAvgSpeed()
  {
    if (TextUtils.isEmpty(this.j))
    {
      QGLog.e("QGPlayer.SimpleQGPlayer", "Get download speed when player has no play url!");
      return 0.0F;
    }
    return QGPlayerNativeManager.nativeGetDownloadAvgSpeed(this.j);
  }
  
  @Nullable
  public QGAVDownloadProfile getDownloadProfile()
  {
    return QGPlayerNativeManager.nativeGetDownloadProfile(this.j);
  }
  
  public int getDuration()
  {
    return QGPlayerNativeManager.nativeGetDuration(this.j);
  }
  
  public List<QGMediaStream> getMediaStreams()
  {
    return QGPlayerNativeManager.nativeGetMediaStreams(this.j);
  }
  
  public boolean isPlaying()
  {
    if (this.o != null) {
      return this.o.b();
    }
    return false;
  }
  
  public boolean isStarted()
  {
    return (this.o != null) && (this.o.c());
  }
  
  public void onPlayEvent(final int paramInt, final Bundle paramBundle)
  {
    if (paramInt != 6003) {
      QGLog.i("QGPlayer.SimpleQGPlayer", "onPlayEvent event " + paramInt);
    }
    if (this.s == null) {}
    do
    {
      return;
      this.s.post(new Runnable()
      {
        public void run()
        {
          if (paramInt == 2301)
          {
            SimpleQGPlayer.this.setHWVideoDec(false);
            if (SimpleQGPlayer.b(SimpleQGPlayer.this) == 3) {
              SimpleQGPlayer.a(SimpleQGPlayer.this, SimpleQGPlayer.this.getCurrentTime());
            }
            SimpleQGPlayer.a(SimpleQGPlayer.this, SimpleQGPlayer.c(SimpleQGPlayer.this), SimpleQGPlayer.d(SimpleQGPlayer.this), SimpleQGPlayer.e(SimpleQGPlayer.this), SimpleQGPlayer.f(SimpleQGPlayer.this), SimpleQGPlayer.b(SimpleQGPlayer.this), SimpleQGPlayer.g(SimpleQGPlayer.this), "");
          }
          if (SimpleQGPlayer.a(SimpleQGPlayer.this) != null) {
            SimpleQGPlayer.a(SimpleQGPlayer.this).onPlayEvent(paramInt, paramBundle);
          }
        }
      });
      if (paramInt == 6001)
      {
        this.o.b(this.j);
        return;
      }
    } while (paramInt != 6003);
    this.s.post(new Runnable()
    {
      public void run()
      {
        if (SimpleQGPlayer.h(SimpleQGPlayer.this) != -1)
        {
          SimpleQGPlayer.this.seek(SimpleQGPlayer.h(SimpleQGPlayer.this));
          SimpleQGPlayer.a(SimpleQGPlayer.this, -1);
        }
      }
    });
  }
  
  public void onPlayerStatus(final int paramInt, final Bundle paramBundle)
  {
    QGLog.d("QGPlayer.SimpleQGPlayer", "onPlayerStatus status " + paramInt);
    if (this.s == null) {
      return;
    }
    this.s.post(new Runnable()
    {
      public void run()
      {
        if (SimpleQGPlayer.a(SimpleQGPlayer.this) != null) {
          SimpleQGPlayer.a(SimpleQGPlayer.this).onPlayerStatus(paramInt, paramBundle);
        }
      }
    });
  }
  
  public void onStatusChanged(final QGAVProfile paramQGAVProfile)
  {
    paramQGAVProfile.cpuUsage = this.r.a();
    if (this.s == null) {
      return;
    }
    this.s.post(new Runnable()
    {
      public void run()
      {
        if (SimpleQGPlayer.a(SimpleQGPlayer.this) != null) {
          SimpleQGPlayer.a(SimpleQGPlayer.this).onStatusChanged(paramQGAVProfile);
        }
      }
    });
  }
  
  public void pause()
  {
    QGLog.i("QGPlayer.SimpleQGPlayer", "pause");
    if (this.n != null) {
      this.n.a(this.j);
    }
  }
  
  public void release()
  {
    if (this.o != null)
    {
      this.o.a();
      this.o = null;
    }
  }
  
  public void resume()
  {
    QGLog.i("QGPlayer.SimpleQGPlayer", "resume");
    if (this.n != null) {
      this.n.b(this.j);
    }
  }
  
  public boolean seek(int paramInt)
  {
    if (this.n != null) {
      return this.n.b(this.j, paramInt);
    }
    return false;
  }
  
  public void setCookie(String paramString)
  {
    QGPlayerNativeManager.nativeSetCookie(this.j, paramString);
  }
  
  public void setDynamicBufferConfig(QGDynamicBufferConfig paramQGDynamicBufferConfig)
  {
    if (this.o != null) {
      this.o.a(paramQGDynamicBufferConfig);
    }
  }
  
  public void setDynamicBufferConfigRealTime(QGDynamicBufferConfig paramQGDynamicBufferConfig)
  {
    if (this.o != null) {
      this.o.b(paramQGDynamicBufferConfig);
    }
  }
  
  public void setEnableFetchVideoFrameExtraData(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (this.n != null) {
      this.n.a(paramBoolean);
    }
  }
  
  public void setEnableNativeAudioPlayer(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setHWVideoDec(boolean paramBoolean)
  {
    if ((e.a >= 16) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.a = paramBoolean;
      return;
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      setVolume(f1);
      return;
    }
  }
  
  public void setPlayListener(IQGPlayListener paramIQGPlayListener)
  {
    this.q = paramIQGPlayListener;
    if (!TextUtils.isEmpty(this.j))
    {
      if (paramIQGPlayListener != null) {
        QGPlayerNativeManager.addPlayListener(this.j, this);
      }
    }
    else {
      return;
    }
    QGPlayerNativeManager.removePlayListener(this.j);
  }
  
  public void setPlayerView(@NonNull QGPlayerView paramQGPlayerView)
  {
    this.f = paramQGPlayerView;
    if (this.o != null) {
      this.o.a(paramQGPlayerView);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.p = paramInt;
    if (this.o != null) {
      this.o.a(paramInt);
    }
  }
  
  public void setVolume(float paramFloat)
  {
    this.d = paramFloat;
    if (this.n != null) {
      this.n.a(paramFloat);
    }
  }
  
  public void start(String paramString, int paramInt1, int paramInt2)
  {
    a(null, 0, paramString, 0, paramInt1, paramInt2, "");
  }
  
  public void start(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(null, 0, paramString, paramInt1, paramInt2, paramInt3, "");
  }
  
  public void start(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    a(null, 0, paramString1, paramInt1, paramInt2, paramInt3, paramString2);
  }
  
  public void start(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramArrayOfQGMediaStream, paramInt1, null, 0, paramInt2, paramInt3, "");
  }
  
  public void stop(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.f != null)) {
      this.f.setVisibility(8);
    }
    this.g = paramBoolean;
    if (this.n != null)
    {
      QGPlayerNativeManager.removeMediaDataListener(this.j);
      this.n.c(this.j);
    }
    QGPlayerNativeManager.removePlayListener(this.j);
    this.n = null;
    this.r.b();
  }
  
  public boolean switchClarify(int paramInt, boolean paramBoolean)
  {
    if (this.h != null)
    {
      int i1 = 0;
      while (i1 < this.h.length)
      {
        if (this.h[i1].levelType == paramInt) {
          this.i = i1;
        }
        i1 += 1;
      }
    }
    return QGPlayerNativeManager.nativeSwitchToClarify(this.j, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.SimpleQGPlayer
 * JD-Core Version:    0.7.0.1
 */