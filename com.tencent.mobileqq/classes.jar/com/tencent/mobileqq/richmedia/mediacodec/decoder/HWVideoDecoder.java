package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import avxk;
import avxl;
import avxn;
import avxo;
import com.tencent.mobileqq.app.ThreadManager;
import veg;

@TargetApi(16)
public class HWVideoDecoder
  implements avxo
{
  private avxl jdField_a_of_type_Avxl;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(avxk paramavxk, Surface paramSurface, avxn paramavxn)
  {
    if ((paramavxk == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    veg.b("HWVideoDecoder", "startDecode config = %s", paramavxk);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramavxk.a, paramSurface, paramavxn);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramavxk);
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
      veg.a("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    veg.d("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      veg.a("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.a(paramLong1, paramLong2);
      return;
    }
    veg.d("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(avxk paramavxk, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, avxn paramavxn)
  {
    this.jdField_a_of_type_Avxl = new avxl(paramInt, paramOnFrameAvailableListener);
    a(paramavxk, this.jdField_a_of_type_Avxl.a, paramavxn);
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
      veg.b("HWVideoDecoder", "pauseDecode");
      return;
    }
    veg.d("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
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
        veg.b("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    veg.d("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */