package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.util.EnumSet;

public class a
{
  private static String a = "MediaPlayerWrapper";
  private MediaPlayer b = new MediaPlayer();
  private a.a c = a.a.a;
  private a d = this;
  private MediaPlayer.OnPreparedListener e = new a.1(this);
  private MediaPlayer.OnCompletionListener f = new a.2(this);
  private MediaPlayer.OnBufferingUpdateListener g = new a.3(this);
  private MediaPlayer.OnErrorListener h = new a.4(this);
  
  a()
  {
    this.b.setOnPreparedListener(this.e);
    this.b.setOnCompletionListener(this.f);
    this.b.setOnBufferingUpdateListener(this.g);
    this.b.setOnErrorListener(this.h);
  }
  
  public void a()
  {
    Log.d(a, "prepareAsync()");
    if (EnumSet.of(a.a.c, a.a.g).contains(this.c))
    {
      this.b.prepareAsync();
      this.c = a.a.d;
      return;
    }
    throw new RuntimeException();
  }
  
  public void a(int paramInt)
  {
    Log.d(a, "seekTo()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.h).contains(this.c))
    {
      this.b.seekTo(paramInt);
      return;
    }
    throw new RuntimeException();
  }
  
  public void a(Context paramContext, Uri paramUri)
  {
    if (this.c == a.a.a) {}
    try
    {
      this.b.setDataSource(paramContext, paramUri);
      this.c = a.a.c;
      return;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext.printStackTrace();
      return;
      throw new RuntimeException();
    }
    catch (IOException paramContext)
    {
      break label28;
    }
    catch (IllegalArgumentException paramContext)
    {
      label28:
      break label28;
    }
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.b.setOnCompletionListener(new a.6(this, paramOnCompletionListener));
  }
  
  public void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.b.setOnPreparedListener(new a.5(this, paramOnPreparedListener));
  }
  
  public void a(MediaPlayer paramMediaPlayer) {}
  
  public void a(MediaPlayer paramMediaPlayer, int paramInt) {}
  
  boolean a(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    this.b.setAudioStreamType(paramInt);
  }
  
  public void b(MediaPlayer paramMediaPlayer) {}
  
  public boolean b()
  {
    Log.d(a, "isPlaying()");
    if (this.c != a.a.b) {
      return this.b.isPlaying();
    }
    throw new RuntimeException();
  }
  
  public void c()
  {
    Log.d(a, "pause()");
    if (EnumSet.of(a.a.f, a.a.i).contains(this.c))
    {
      this.b.pause();
      this.c = a.a.i;
      return;
    }
    throw new RuntimeException();
  }
  
  public void d()
  {
    Log.d(a, "start()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.h).contains(this.c))
    {
      this.b.start();
      this.c = a.a.f;
      return;
    }
    throw new RuntimeException();
  }
  
  public void e()
  {
    Log.d(a, "stop()");
    if (EnumSet.of(a.a.e, a.a.f, a.a.g, a.a.i, a.a.h).contains(this.c))
    {
      this.b.stop();
      this.c = a.a.g;
      return;
    }
    throw new RuntimeException();
  }
  
  public void f()
  {
    Log.d(a, "release()");
    this.b.release();
  }
  
  public int g()
  {
    if (this.c != a.a.b) {
      return this.b.getCurrentPosition();
    }
    return 0;
  }
  
  public int h()
  {
    if (EnumSet.of(a.a.e, a.a.f, a.a.i, a.a.g, a.a.h).contains(this.c)) {
      return this.b.getDuration();
    }
    return 100;
  }
  
  public void i()
  {
    this.b.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a
 * JD-Core Version:    0.7.0.1
 */