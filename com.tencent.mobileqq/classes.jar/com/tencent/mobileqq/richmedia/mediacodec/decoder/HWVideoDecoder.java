package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import axpl;
import axpm;
import axpo;
import axpp;
import com.tencent.mobileqq.app.ThreadManager;
import wsv;

@TargetApi(16)
public class HWVideoDecoder
  implements axpp
{
  private axpm jdField_a_of_type_Axpm;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(axpl paramaxpl, Surface paramSurface, axpo paramaxpo)
  {
    if ((paramaxpl == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    wsv.b("HWVideoDecoder", "startDecode config = %s", paramaxpl);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramaxpl.a, paramSurface, paramaxpo);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramaxpl);
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
      wsv.a("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    wsv.d("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      wsv.a("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.a(paramLong1, paramLong2);
      return;
    }
    wsv.d("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(axpl paramaxpl, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, axpo paramaxpo)
  {
    this.jdField_a_of_type_Axpm = new axpm(paramInt, paramOnFrameAvailableListener);
    a(paramaxpl, this.jdField_a_of_type_Axpm.a, paramaxpo);
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
      wsv.b("HWVideoDecoder", "pauseDecode");
      return;
    }
    wsv.d("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
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
        wsv.b("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    wsv.d("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */