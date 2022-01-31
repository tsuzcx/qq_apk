package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import ahtn;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;

@TargetApi(16)
public class HWVideoDecoder
{
  private ahtn jdField_a_of_type_Ahtn;
  private DecodeOutputSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeOutputSurface;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public static final float a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1.0F;
    case 1: 
      return 2.0F;
    case 2: 
      return 0.5F;
    case 3: 
      return 1.5F;
    case 4: 
      return 0.25F;
    }
    return -1.0F;
  }
  
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
      this.jdField_a_of_type_Ahtn = new ahtn(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.jdField_a_of_type_Ahtn.a(paramDecodeConfig);
      this.jdField_a_of_type_JavaLangThread = new Thread(this.jdField_a_of_type_Ahtn, "HWVideoDecoder-Thread");
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
    this.jdField_a_of_type_Ahtn = null;
  }
  
  public void a(int paramInt)
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      localahtn.a(paramInt);
      SdkContext.a().a().d("HWVideoDecoder", "setSpeedType" + paramInt);
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "setSpeedType " + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong)
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      localahtn.b(paramLong);
      SdkContext.a().a().d("HWVideoDecoder", "seekTo " + paramLong + " ms");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "seekTo " + paramLong + " ms failed, can not find DecodeRunnable");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      SdkContext.a().a().d("HWVideoDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localahtn.a(paramLong1, paramLong2);
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
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      ahtn.a(localahtn, true);
      SdkContext.a().a().d("HWVideoDecoder", "pauseDecode");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void b(int paramInt)
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      localahtn.a(paramInt);
      SdkContext.a().a().d("HWVideoDecoder", "seekTo " + paramInt + " ms");
      return;
    }
    SdkContext.a().a().b("HWVideoDecoder", "seekTo " + paramInt + " ms failed, can not find DecodeRunnable");
  }
  
  public void c()
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if (localahtn != null)
    {
      localahtn.a();
      ahtn.a(localahtn, false);
      synchronized (ahtn.a(localahtn))
      {
        ahtn.a(localahtn).notifyAll();
        SdkContext.a().a().d("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    SdkContext.a().a().b("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void d()
  {
    ahtn localahtn = this.jdField_a_of_type_Ahtn;
    if ((localahtn != null) && (ahtn.a(localahtn))) {
      synchronized (ahtn.a(localahtn))
      {
        ahtn.a(localahtn).notifyAll();
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