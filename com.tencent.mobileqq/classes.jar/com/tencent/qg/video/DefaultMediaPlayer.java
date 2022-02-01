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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaDecoder.DecodeListener jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeListener = new DefaultMediaPlayer.1(this);
  private MediaDecoder jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int e = -1;
  private volatile int f = 0;
  
  private void c()
  {
    SLog.b("DefaultMediaPlayer", "onVideoPlayEnded");
    VideoPlayer.nativeEvent(this.jdField_a_of_type_Long, "ended");
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void d()
  {
    SLog.b("DefaultMediaPlayer", "onVideoPlayRepeated");
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a()
  {
    SLog.b("DefaultMediaPlayer", "onPause");
    MediaDecoder localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
    if (localMediaDecoder != null) {
      localMediaDecoder.b();
    }
  }
  
  public void b()
  {
    SLog.b("DefaultMediaPlayer", "onStop");
    MediaDecoder localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
    if (localMediaDecoder != null) {
      localMediaDecoder.a();
    }
  }
  
  public void create(long paramLong)
  {
    SLog.b("DefaultMediaPlayer", "qg -> create");
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void destroy()
  {
    SLog.b("DefaultMediaPlayer", "qg -> destroy");
    b();
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
    if (localObject != null) {
      ((GPUOESBaseFilter)localObject).destroy();
    }
  }
  
  public int getCurrentPosition()
  {
    return (int)this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
  }
  
  public int getDuration()
  {
    return (int)VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean isEnd()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean isMuted()
  {
    MediaDecoder localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
    if (localMediaDecoder != null) {
      return localMediaDecoder.c();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    MediaDecoder localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
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
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    if ((!this.jdField_c_of_type_Boolean) && (isPlaying())) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      MediaDecoder localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
      if ((localMediaDecoder != null) && (localMediaDecoder.b()))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void seekTo(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a(paramInt);
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
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = paramString;
      if (!paramString.startsWith(this.jdField_b_of_type_JavaLangString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.jdField_c_of_type_Boolean = (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString) ^ true);
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    SLog.a("DefaultMediaPlayer", "qg -> set Src , src = %s , isSrcChanged :%s", localObject, Boolean.valueOf(this.jdField_c_of_type_Boolean));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.DefaultMediaPlayer
 * JD-Core Version:    0.7.0.1
 */