package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;

@TargetApi(16)
public class HWVideoDecoder
  implements IVideoDecoder
{
  private DecodeOutputSurface jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeOutputSurface;
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig != null) && (paramSurface != null))
    {
      SLog.b("HWVideoDecoder", "startDecode config = %s", paramDecodeConfig);
      Thread localThread = this.jdField_a_of_type_JavaLangThread;
      if (localThread != null)
      {
        a();
        try
        {
          localThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramDecodeConfig);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable, "HWVideoDecoder-Thread", 8);
      this.jdField_a_of_type_JavaLangThread.start();
      return;
    }
    throw new IllegalArgumentException("both decodeConfig and surface should not be null");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable.a();
  }
  
  public void a()
  {
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    if (localThread != null) {
      localThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable = null;
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeOutputSurface = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    a(paramDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeOutputSurface.a, paramHWDecodeListener);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWVideoDecoder$DecodeRunnable.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */