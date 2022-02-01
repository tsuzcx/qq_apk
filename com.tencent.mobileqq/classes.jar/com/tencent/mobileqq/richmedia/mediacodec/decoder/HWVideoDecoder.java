package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import bbky;
import bbkz;
import bblb;
import bblc;
import com.tencent.mobileqq.app.ThreadManager;
import ykq;

@TargetApi(16)
public class HWVideoDecoder
  implements bblc
{
  private bbkz jdField_a_of_type_Bbkz;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(bbky parambbky, Surface paramSurface, bblb parambblb)
  {
    if ((parambbky == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    ykq.b("HWVideoDecoder", "startDecode config = %s", parambbky);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(parambbky.a, paramSurface, parambblb);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(parambbky);
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
      ykq.a("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    ykq.d("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      ykq.a("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.a(paramLong1, paramLong2);
      return;
    }
    ykq.d("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(bbky parambbky, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, bblb parambblb)
  {
    this.jdField_a_of_type_Bbkz = new bbkz(paramInt, paramOnFrameAvailableListener);
    a(parambbky, this.jdField_a_of_type_Bbkz.a, parambblb);
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
      ykq.b("HWVideoDecoder", "pauseDecode");
      return;
    }
    ykq.d("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
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
        ykq.b("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    ykq.d("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */