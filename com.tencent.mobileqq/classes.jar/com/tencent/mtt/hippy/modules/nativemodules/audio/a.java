package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.IOException;
import java.util.EnumSet;

public class a
{
  private final MediaPlayer a = new MediaPlayer();
  private a.a b = a.a.a;
  private final a c = this;
  private final MediaPlayer.OnPreparedListener d = new a.1(this);
  private final MediaPlayer.OnCompletionListener e = new a.2(this);
  private final MediaPlayer.OnBufferingUpdateListener f = new a.3(this);
  private final MediaPlayer.OnErrorListener g = new a.4(this);
  
  a()
  {
    this.a.setOnPreparedListener(this.d);
    this.a.setOnCompletionListener(this.e);
    this.a.setOnBufferingUpdateListener(this.f);
    this.a.setOnErrorListener(this.g);
  }
  
  public void a()
  {
    Log.d("MediaPlayerWrapper", "prepareAsync()");
    if (EnumSet.of(a.a.c, a.a.g).contains(this.b))
    {
      this.a.prepareAsync();
      this.b = a.a.d;
      return;
    }
    throw new RuntimeException();
  }
  
  public void a(int paramInt)
  {
    Log.d("MediaPlayerWrapper", "seekTo()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.h).contains(this.b))
    {
      this.a.seekTo(paramInt);
      return;
    }
    throw new RuntimeException();
  }
  
  public void a(Context paramContext, Uri paramUri)
  {
    if (this.b == a.a.a)
    {
      try
      {
        this.a.setDataSource(paramContext, paramUri);
        this.b = a.a.c;
        return;
      }
      catch (IOException paramContext) {}catch (IllegalStateException paramContext) {}catch (IllegalArgumentException paramContext) {}
      paramContext.printStackTrace();
      return;
    }
    throw new RuntimeException();
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.a.setOnCompletionListener(new a.6(this, paramOnCompletionListener));
  }
  
  public void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.a.setOnPreparedListener(new a.5(this, paramOnPreparedListener));
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    LogUtils.d("MediaPlayerStateWrapper", "onPrepared");
  }
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt)
  {
    LogUtils.d("MediaPlayerStateWrapper", "onBufferingUpdate");
  }
  
  boolean a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    this.a.setAudioStreamType(paramInt);
  }
  
  public void b(MediaPlayer paramMediaPlayer)
  {
    LogUtils.d("MediaPlayerStateWrapper", "onCompletion");
  }
  
  public boolean b()
  {
    Log.d("MediaPlayerWrapper", "isPlaying()");
    if (this.b != a.a.b) {
      return this.a.isPlaying();
    }
    throw new RuntimeException();
  }
  
  public void c()
  {
    Log.d("MediaPlayerWrapper", "pause()");
    if (EnumSet.of(a.a.f, a.a.i).contains(this.b))
    {
      this.a.pause();
      this.b = a.a.i;
      return;
    }
    throw new RuntimeException();
  }
  
  public void d()
  {
    Log.d("MediaPlayerWrapper", "start()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.h).contains(this.b))
    {
      this.a.start();
      this.b = a.a.f;
      return;
    }
    throw new RuntimeException();
  }
  
  public void e()
  {
    Log.d("MediaPlayerWrapper", "stop()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.g, a.a.i, a.a.h).contains(this.b))
    {
      this.a.stop();
      this.b = a.a.g;
      return;
    }
    throw new RuntimeException();
  }
  
  public void f()
  {
    Log.d("MediaPlayerWrapper", "release()");
    this.a.release();
  }
  
  public int g()
  {
    if (this.b != a.a.b) {
      return this.a.getCurrentPosition();
    }
    return 0;
  }
  
  public int h()
  {
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.g, a.a.h).contains(this.b)) {
      return this.a.getDuration();
    }
    return 100;
  }
  
  public void i()
  {
    this.a.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a
 * JD-Core Version:    0.7.0.1
 */