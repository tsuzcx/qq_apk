package com.tencent.qg.video;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
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
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b();
    }
  }
  
  public void b()
  {
    SLog.b("DefaultMediaPlayer", "onStop");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
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
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
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
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.c();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
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
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      return;
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
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.e = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a(paramBoolean);
      }
      return;
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b(paramBoolean);
      }
      return;
    }
  }
  
  public void setSrc(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      str = paramString;
      if (!paramString.startsWith(this.jdField_b_of_type_JavaLangString)) {
        str = this.jdField_b_of_type_JavaLangString + paramString;
      }
    }
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = str;
      SLog.a("DefaultMediaPlayer", "qg -> set Src , src = %s , isSrcChanged :%s", str, Boolean.valueOf(this.jdField_c_of_type_Boolean));
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.video.DefaultMediaPlayer
 * JD-Core Version:    0.7.0.1
 */