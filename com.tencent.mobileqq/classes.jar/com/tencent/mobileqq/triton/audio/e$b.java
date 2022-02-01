package com.tencent.mobileqq.triton.audio;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.io.File;
import java.lang.ref.WeakReference;

public class e$b
  implements IAudioStateChangeListener
{
  int a;
  IAudioStateChangeListener b;
  String c;
  volatile String d;
  volatile boolean e;
  volatile int f;
  WeakReference<e> g;
  
  public e$b(e parame1, e parame2, int paramInt, IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.g = new WeakReference(parame2);
    this.a = paramInt;
    this.b = paramIAudioStateChangeListener;
    this.f = 0;
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists());
  }
  
  private void b()
  {
    e.c(this.h).l().download(this.c, new e.b.a(this));
    TTLog.c("[audio] TTAudioPlayerManager", "downloadAndPlayAudio rawPath:" + this.c);
  }
  
  private void b(boolean paramBoolean)
  {
    if (a(e.c(this.h).l().getResPath(this.d, null, null)))
    {
      Object localObject = this.g;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (e)this.g.get();
        TTLog.c("[audio] TTAudioPlayerManager", "audioId:" + this.a + ", playLocalAudio localPath:" + this.d);
        ((e)localObject).a(null, this.a, this.d);
        if (paramBoolean) {
          ((e)localObject).j(this.a);
        }
      }
      return;
    }
    TTLog.b("[audio] TTAudioPlayerManager", "playLocalAudio localPath:" + this.d + " not exists");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void onCanPlay()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onCanPlay();
    }
  }
  
  public void onEnded()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onEnded();
    }
  }
  
  public void onError(int paramInt)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (e)this.g.get();
      if (localObject == null) {
        break label193;
      }
    }
    label193:
    for (int i = ((e)this.g.get()).o;; i = 10)
    {
      TTLog.b("[audio] TTAudioPlayerManager", this + " onError retryCount:" + this.f + ", audioId:" + this.a + " totalErrorCount:" + i);
      if ((URLUtil.isNetworkUrl(this.c)) && (this.f < 1) && (i < 10))
      {
        this.f += 1;
        if (localObject != null) {
          ((e)localObject).o += 1;
        }
        if (a(this.d)) {
          b(a());
        }
      }
      do
      {
        return;
        localObject = null;
        break;
        b();
        return;
        localObject = this.b;
      } while (localObject == null);
      ((IAudioStateChangeListener)localObject).onError(paramInt);
      return;
    }
  }
  
  public void onPause()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPause();
    }
  }
  
  public void onPlay()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPlay();
    }
  }
  
  public void onSeeked()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onSeeked();
    }
  }
  
  public void onSeeking()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onSeeking();
    }
  }
  
  public void onStop()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onStop();
    }
  }
  
  public void onTimeUpdate()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onTimeUpdate();
    }
  }
  
  public void onWaiting()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.b;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onWaiting();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.e.b
 * JD-Core Version:    0.7.0.1
 */