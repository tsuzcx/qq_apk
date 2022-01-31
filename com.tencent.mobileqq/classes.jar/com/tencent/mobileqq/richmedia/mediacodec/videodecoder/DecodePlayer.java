package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class DecodePlayer
  implements HWDecodeListener
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private final DecodePlayer.AudioDecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig = new DecodePlayer.AudioDecodeConfig();
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = null;
  private SimpleAudioPlayer jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private long b = -1L;
  
  public DecodePlayer()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(paramInt);
  }
  
  public void a(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, paramInt, paramOnFrameAvailableListener, this);
    if ((FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer != null) && (!VideoPrefsUtil.getMaterialMute()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Int = 0;
    this.b = System.nanoTime();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    SdkContext.a().a().a("DecodePlayer", "onDecodeError errorCode = " + paramInt, paramThrowable);
    b();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Int = ((int)paramLong);
    this.b = System.nanoTime();
    if ((FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer != null) && (!VideoPrefsUtil.getMaterialMute()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString, (int)paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(paramLong1, paramLong2);
    }
  }
  
  public void a(HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = paramHWDecodeListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString = paramString1;
    if ((FileUtil.b(paramString2)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer == null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer = new SimpleAudioPlayer();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString = paramString2;
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d("DecodePlayer", "setFilePath: videoFilePath = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString + " ; audioFilePath = " + paramString2);
    }
    this.jdField_a_of_type_Long = VideoUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.c = this.jdField_a_of_type_Long;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) && (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(3);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSimpleAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodePlayer$AudioDecodeConfig.jdField_a_of_type_JavaLangString, (int)((System.nanoTime() - this.b) / 1000000L) + this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    SdkContext.a().a().d("DecodePlayer", "onDecodeStart");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    SdkContext.a().a().d("DecodePlayer", "onDecodeFinish");
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.e();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    SdkContext.a().a().d("DecodePlayer", "onDecodeCancel");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.f();
    }
  }
  
  public void g()
  {
    SdkContext.a().a().d("DecodePlayer", "onDecodeRepeat");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer
 * JD-Core Version:    0.7.0.1
 */