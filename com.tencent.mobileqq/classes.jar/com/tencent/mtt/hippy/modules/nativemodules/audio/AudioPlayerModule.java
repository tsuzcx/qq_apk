package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.content.Context;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="AudioPlayerModule")
public class AudioPlayerModule
  extends HippyNativeModuleBase
{
  private HippyEngineContext a;
  private a b;
  private int c = 0;
  private int d = 0;
  private String e = "STOPPED";
  
  public AudioPlayerModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.a = paramHippyEngineContext;
    this.b = new a();
  }
  
  private a a(Context paramContext, Uri paramUri, MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.e = "BUFFERING";
    try
    {
      a locala = new a();
      locala.a(paramContext, paramUri);
      locala.b(3);
      if (paramOnPreparedListener != null)
      {
        locala.a(paramOnPreparedListener);
        locala.a();
        return locala;
      }
      locala.i();
      return locala;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private String a()
  {
    if (this.b.b()) {
      return "PLAYING";
    }
    return this.e;
  }
  
  @HippyMethod(name="destroyNotification")
  public void destroyNotification() {}
  
  @HippyMethod(name="getStatus")
  public void getStatus(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("status", a());
    localHippyMap.pushInt("duration", this.b.h() / 1000);
    localHippyMap.pushInt("progress", this.b.g() / 1000);
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="goBack")
  public void goBack(Float paramFloat)
  {
    try
    {
      int i = Math.round(paramFloat.floatValue());
      int j = this.b.g() - i * 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      seekTo(i);
      return;
    }
    catch (Exception paramFloat)
    {
      paramFloat.printStackTrace();
    }
  }
  
  @HippyMethod(name="goForward")
  public void goForward(Float paramFloat)
  {
    try
    {
      int j = Math.round(paramFloat.floatValue()) * 1000 + this.b.g();
      int i = j;
      if (j > this.c) {
        i = this.c;
      }
      seekTo(i);
      return;
    }
    catch (Exception paramFloat)
    {
      paramFloat.printStackTrace();
    }
  }
  
  @HippyMethod(name="pause")
  public void pause()
  {
    try
    {
      if (this.b != null) {
        this.b.c();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.e = "PAUSED";
    }
  }
  
  @HippyMethod(name="play")
  public void play(String paramString, Promise paramPromise)
  {
    try
    {
      paramString = Uri.parse(paramString);
      stop();
      this.b = a(this.a.getGlobalConfigs().getContext(), paramString, new AudioPlayerModule.1(this));
      this.b.a(new AudioPlayerModule.2(this));
      paramPromise.resolve("OK");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramPromise.resolve("ERROR");
    }
  }
  
  @HippyMethod(name="resume")
  public void resume()
  {
    try
    {
      if (this.b != null) {
        this.b.d();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.e = "BUFFERING";
    }
  }
  
  @HippyMethod(name="seekTo")
  public void seekTo(int paramInt)
  {
    try
    {
      if (this.b != null) {
        this.b.a(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.e = "BUFFERING";
    }
  }
  
  @HippyMethod(name="stop")
  public void stop()
  {
    try
    {
      if (this.b != null)
      {
        this.b.e();
        this.b.f();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.e = "STOPPED";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule
 * JD-Core Version:    0.7.0.1
 */