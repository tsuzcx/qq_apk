package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import bbko;
import bbkp;
import bbkr;
import bbks;
import com.tencent.mobileqq.app.ThreadManager;
import yuk;

@TargetApi(16)
public class HWVideoDecoder
  implements bbks
{
  private bbkp jdField_a_of_type_Bbkp;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(bbko parambbko, Surface paramSurface, bbkr parambbkr)
  {
    if ((parambbko == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    yuk.b("HWVideoDecoder", "startDecode config = %s", parambbko);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(parambbko.a, paramSurface, parambbkr);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(parambbko);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable, "HWVideoDecoder-Thread", 8);
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
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = null;
  }
  
  public void a(int paramInt)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.a(paramInt);
      yuk.a("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    yuk.d("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      yuk.a("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.a(paramLong1, paramLong2);
      return;
    }
    yuk.d("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(bbko parambbko, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, bbkr parambbkr)
  {
    this.jdField_a_of_type_Bbkp = new bbkp(paramInt, paramOnFrameAvailableListener);
    a(parambbko, this.jdField_a_of_type_Bbkp.a, parambbkr);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.b();
  }
  
  public void b()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      HWVideoDecoder.DecodeRunnable.a(localDecodeRunnable, true);
      yuk.b("HWVideoDecoder", "pauseDecode");
      return;
    }
    yuk.d("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void c()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      HWVideoDecoder.DecodeRunnable.a(localDecodeRunnable, false);
      synchronized (HWVideoDecoder.DecodeRunnable.a(localDecodeRunnable))
      {
        HWVideoDecoder.DecodeRunnable.a(localDecodeRunnable).notifyAll();
        yuk.b("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    yuk.d("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */