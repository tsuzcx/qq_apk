package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.tencent.tkd.topicsdk.framework.TLog;

@TargetApi(16)
public class HWVideoDecoder
  implements IVideoDecoder
{
  private HWVideoDecoder.DecodeRunnable jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder$DecodeRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private void a(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    TLog.a("HWVideoDecoder", "startDecode config = " + paramDecodeConfig);
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder$DecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.a, paramSurface, paramHWDecodeListener);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder$DecodeRunnable.a(paramDecodeConfig);
      this.jdField_a_of_type_JavaLangThread = new Thread(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder$DecodeRunnable, "HWVideoDecoder-Thread");
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
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWVideoDecoder$DecodeRunnable = null;
  }
  
  public void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    a(paramDecodeConfig, new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener).a, paramHWDecodeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */