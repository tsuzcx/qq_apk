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
import com.tencent.mtt.hippy.utils.LogUtils;

@HippyNativeModule(name="AudioPlayerModule")
public class AudioPlayerModule
  extends HippyNativeModuleBase
{
  private final HippyEngineContext b;
  private a c;
  private String d = "STOPPED";
  
  public AudioPlayerModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.b = paramHippyEngineContext;
    this.c = new a();
  }
  
  private a a(Context paramContext, Uri paramUri, MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.d = "BUFFERING";
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
    if (this.c.b()) {
      return "PLAYING";
    }
    return this.d;
  }
  
  @HippyMethod(name="destroyNotification")
  public void destroyNotification()
  {
    LogUtils.d("AudioPlayerModule", "destroyNotification");
  }
  
  @HippyMethod(name="getStatus")
  public void getStatus(Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("status", a());
    localHippyMap.pushInt("duration", this.c.h() / 1000);
    localHippyMap.pushInt("progress", this.c.g() / 1000);
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="goBack")
  public void goBack(Float paramFloat)
  {
    try
    {
      int i = Math.round(paramFloat.floatValue());
      int j = this.c.g() - i * 1000;
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
    for (;;)
    {
      try
      {
        int i = Math.round(paramFloat.floatValue());
        i = this.c.g() + i * 1000;
        int j = 0;
        if (i > 0)
        {
          i = j;
          seekTo(i);
          return;
        }
      }
      catch (Exception paramFloat)
      {
        paramFloat.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  @HippyMethod(name="pause")
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   11: invokevirtual 134	com/tencent/mtt/hippy/modules/nativemodules/audio/a:c	()V
    //   14: aload_0
    //   15: ldc 136
    //   17: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   20: return
    //   21: astore_1
    //   22: goto +11 -> 33
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   30: goto -16 -> 14
    //   33: aload_0
    //   34: ldc 136
    //   36: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   39: goto +5 -> 44
    //   42: aload_1
    //   43: athrow
    //   44: goto -2 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	AudioPlayerModule
    //   21	1	1	localObject	java.lang.Object
    //   25	18	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	21	finally
    //   26	30	21	finally
    //   0	14	25	java/lang/Exception
  }
  
  @HippyMethod(name="play")
  public void play(String paramString, Promise paramPromise)
  {
    try
    {
      paramString = Uri.parse(paramString);
      stop();
      this.c = a(this.b.getGlobalConfigs().getContext(), paramString, new AudioPlayerModule.1(this));
      if ((!a) && (this.c == null)) {
        throw new AssertionError();
      }
      this.c.a(new AudioPlayerModule.2(this));
      paramPromise.resolve("OK");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramPromise.resolve("ERROR");
    }
  }
  
  /* Error */
  @HippyMethod(name="resume")
  public void resume()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   11: invokevirtual 182	com/tencent/mtt/hippy/modules/nativemodules/audio/a:d	()V
    //   14: aload_0
    //   15: ldc 47
    //   17: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   20: return
    //   21: astore_1
    //   22: goto +11 -> 33
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   30: goto -16 -> 14
    //   33: aload_0
    //   34: ldc 47
    //   36: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   39: goto +5 -> 44
    //   42: aload_1
    //   43: athrow
    //   44: goto -2 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	AudioPlayerModule
    //   21	1	1	localObject	java.lang.Object
    //   25	18	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	21	finally
    //   26	30	21	finally
    //   0	14	25	java/lang/Exception
  }
  
  /* Error */
  @HippyMethod(name="seekTo")
  public void seekTo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   11: iload_1
    //   12: invokevirtual 184	com/tencent/mtt/hippy/modules/nativemodules/audio/a:a	(I)V
    //   15: aload_0
    //   16: ldc 47
    //   18: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   21: return
    //   22: astore_2
    //   23: goto +11 -> 34
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   31: goto -16 -> 15
    //   34: aload_0
    //   35: ldc 47
    //   37: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   40: goto +5 -> 45
    //   43: aload_2
    //   44: athrow
    //   45: goto -2 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	AudioPlayerModule
    //   0	48	1	paramInt	int
    //   22	1	2	localObject	java.lang.Object
    //   26	18	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	22	finally
    //   27	31	22	finally
    //   0	15	26	java/lang/Exception
  }
  
  /* Error */
  @HippyMethod(name="stop")
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   4: ifnull +17 -> 21
    //   7: aload_0
    //   8: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   11: invokevirtual 187	com/tencent/mtt/hippy/modules/nativemodules/audio/a:e	()V
    //   14: aload_0
    //   15: getfield 42	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:c	Lcom/tencent/mtt/hippy/modules/nativemodules/audio/a;
    //   18: invokevirtual 190	com/tencent/mtt/hippy/modules/nativemodules/audio/a:f	()V
    //   21: aload_0
    //   22: ldc 32
    //   24: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   27: return
    //   28: astore_1
    //   29: goto +11 -> 40
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   37: goto -16 -> 21
    //   40: aload_0
    //   41: ldc 32
    //   43: putfield 34	com/tencent/mtt/hippy/modules/nativemodules/audio/AudioPlayerModule:d	Ljava/lang/String;
    //   46: goto +5 -> 51
    //   49: aload_1
    //   50: athrow
    //   51: goto -2 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	AudioPlayerModule
    //   28	1	1	localObject	java.lang.Object
    //   32	18	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	28	finally
    //   33	37	28	finally
    //   0	21	32	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.AudioPlayerModule
 * JD-Core Version:    0.7.0.1
 */