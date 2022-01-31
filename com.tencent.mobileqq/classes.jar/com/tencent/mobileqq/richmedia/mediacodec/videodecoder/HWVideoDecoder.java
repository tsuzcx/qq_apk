package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import ahov;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;

@TargetApi(16)
public class HWVideoDecoder
{
  private ahov jdField_a_of_type_Ahov;
  private DecodeOutputSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeOutputSurface;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    SdkContext.a().a().c("HWVideoDecoder", "startDecode config = " + paramDecodeConfig);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_Ahov = new ahov(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.jdField_a_of_type_Ahov.a(paramDecodeConfig);
      this.jdField_a_of_type_JavaLangThread = new Thread(this.jdField_a_of_type_Ahov, "HWVideoDecoder-Thread");
      this.jdField_a_of_type_JavaLangThread.start();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_Ahov = null;
  }
  
  public void a(int paramInt)
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      localahov.a(paramInt);
      SdkContext.a().a().d("HWVideoDecoder", "setSpeedType" + paramInt);
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "setSpeedType " + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong)
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      localahov.b(paramLong);
      SdkContext.a().a().d("HWVideoDecoder", "seekTo " + paramLong + " ms");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "seekTo " + paramLong + " ms failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      SdkContext.a().a().d("HWVideoDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localahov.a(paramLong1, paramLong2);
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeOutputSurface = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    a(paramDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeOutputSurface.a, paramHWDecodeListener);
  }
  
  public void b()
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      ahov.a(localahov, true);
      SdkContext.a().a().d("HWVideoDecoder", "pauseDecode");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void b(int paramInt)
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      localahov.a(paramInt);
      SdkContext.a().a().d("HWVideoDecoder", "seekTo " + paramInt + " ms");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "seekTo " + paramInt + " ms failed, can not find DecodeRunnable");
  }
  
  public void c()
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if (localahov != null)
    {
      localahov.a();
      ahov.a(localahov, false);
      synchronized (ahov.a(localahov))
      {
        ahov.a(localahov).notifyAll();
        SdkContext.a().a().d("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    SdkContext.a().a().b("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void d()
  {
    ahov localahov = this.jdField_a_of_type_Ahov;
    if ((localahov != null) && (ahov.a(localahov))) {
      synchronized (ahov.a(localahov))
      {
        ahov.a(localahov).notifyAll();
        SdkContext.a().a().d("HWVideoDecoder", "decodeFrame");
        return;
      }
    }
    SdkContext.a().a().b("HWVideoDecoder", "decodeFrame failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */