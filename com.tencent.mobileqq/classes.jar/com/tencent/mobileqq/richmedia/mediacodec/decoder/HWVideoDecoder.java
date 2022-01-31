package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import auxr;
import auxs;
import auxu;
import auxv;
import com.tencent.mobileqq.app.ThreadManager;
import urk;

@TargetApi(16)
public class HWVideoDecoder
  implements auxv
{
  private auxs jdField_a_of_type_Auxs;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(auxr paramauxr, Surface paramSurface, auxu paramauxu)
  {
    if ((paramauxr == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    urk.b("HWVideoDecoder", "startDecode config = %s", paramauxr);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramauxr.a, paramSurface, paramauxu);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramauxr);
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
      urk.a("HWVideoDecoder", "setSpeedType %d", Integer.valueOf(paramInt));
      return;
    }
    urk.d("HWVideoDecoder", "setSpeedType %d failed, can not find DecodeRunnable", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      urk.a("HWVideoDecoder", "setPlayRange [%d ms, %d ms]", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      localDecodeRunnable.a(paramLong1, paramLong2);
      return;
    }
    urk.d("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void a(auxr paramauxr, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, auxu paramauxu)
  {
    this.jdField_a_of_type_Auxs = new auxs(paramInt, paramOnFrameAvailableListener);
    a(paramauxr, this.jdField_a_of_type_Auxs.a, paramauxu);
  }
  
  public void b()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      HWVideoDecoder.DecodeRunnable.a(localDecodeRunnable, true);
      urk.b("HWVideoDecoder", "pauseDecode");
      return;
    }
    urk.d("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
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
        urk.b("HWVideoDecoder", "resumeDecode");
        return;
      }
    }
    urk.d("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */