package com.tencent.qg.video;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.qg.sdk.video.IMediaPlayer;
import com.tencent.qg.sdk.video.VideoPlayer;
import com.tencent.qg.video.videodecoder.MediaDecoder;
import com.tencent.qg.video.videodecoder.MediaDecoder.DecodeListener;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class DefaultMediaPlayer
  implements IMediaPlayer
{
  private String a;
  private String b;
  private long c;
  private MediaDecoder d;
  private int e;
  private int f;
  private int g;
  private RenderBuffer h;
  private GPUOESBaseFilter i;
  private SurfaceTexture j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private int n = -1;
  private int o = -1;
  private volatile boolean p = false;
  private volatile int q = 0;
  private MediaDecoder.DecodeListener r = new DefaultMediaPlayer.1(this);
  
  private void c()
  {
    SLog.b("DefaultMediaPlayer", "onVideoPlayEnded");
    VideoPlayer.nativeEvent(this.c, "ended");
    this.p = true;
  }
  
  private void d()
  {
    SLog.b("DefaultMediaPlayer", "onVideoPlayRepeated");
    this.p = false;
  }
  
  public void a()
  {
    SLog.b("DefaultMediaPlayer", "onPause");
    MediaDecoder localMediaDecoder = this.d;
    if (localMediaDecoder != null) {
      localMediaDecoder.c();
    }
  }
  
  public void b()
  {
    SLog.b("DefaultMediaPlayer", "onStop");
    MediaDecoder localMediaDecoder = this.d;
    if (localMediaDecoder != null) {
      localMediaDecoder.b();
    }
  }
  
  public void create(long paramLong)
  {
    SLog.b("DefaultMediaPlayer", "qg -> create");
    this.c = paramLong;
  }
  
  public void destroy()
  {
    SLog.b("DefaultMediaPlayer", "qg -> destroy");
    b();
    Object localObject = this.h;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.i;
    if (localObject != null) {
      ((GPUOESBaseFilter)localObject).destroy();
    }
  }
  
  public int getCurrentPosition()
  {
    return (int)this.d.e();
  }
  
  public int getDuration()
  {
    return (int)VideoCompositeHelper.b(this.a);
  }
  
  public boolean isEnd()
  {
    return this.p;
  }
  
  public boolean isMuted()
  {
    MediaDecoder localMediaDecoder = this.d;
    if (localMediaDecoder != null) {
      return localMediaDecoder.f();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    MediaDecoder localMediaDecoder = this.d;
    if (localMediaDecoder != null) {
      return localMediaDecoder.a();
    }
    return false;
  }
  
  public void pause()
  {
    SLog.b("DefaultMediaPlayer", "qg -> pause");
    a();
  }
  
  public void play(int paramInt1, int paramInt2, int paramInt3)
  {
    SLog.a("DefaultMediaPlayer", "qg -> play , texture id = %d , width = %d , height = %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    VideoPerformanceMonitor.a(hashCode(), "[Player] receive play cmd from qg");
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    if ((!this.m) && (isPlaying())) {
      return;
    }
    if (!this.m)
    {
      MediaDecoder localMediaDecoder = this.d;
      if ((localMediaDecoder != null) && (localMediaDecoder.d()))
      {
        this.l = true;
        this.k = false;
        return;
      }
    }
    this.l = false;
    this.k = true;
  }
  
  public void seekTo(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setMuted(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setSrc(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(this.b))
    {
      localObject = paramString;
      if (!paramString.startsWith(this.b))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.m = (TextUtils.equals((CharSequence)localObject, this.a) ^ true);
    this.a = ((String)localObject);
    SLog.a("DefaultMediaPlayer", "qg -> set Src , src = %s , isSrcChanged :%s", localObject, Boolean.valueOf(this.m));
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    SLog.b("DefaultMediaPlayer", "qg -> setVolume , not support yet");
  }
  
  public void stop()
  {
    SLog.b("DefaultMediaPlayer", "qg -> stop");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.DefaultMediaPlayer
 * JD-Core Version:    0.7.0.1
 */