package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.view.Surface;
import aowi;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

@TargetApi(16)
public class SimpleVideoDecoder
{
  private aowi jdField_a_of_type_Aowi;
  private Thread jdField_a_of_type_JavaLangThread;
  
  private static boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    int i = 0;
    while (i < localCodecCapabilities.colorFormats.length)
    {
      if (localCodecCapabilities.colorFormats[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    QLog.e("SimpleVideoDecoder", 2, "couldn't find a good color format for " + paramMediaCodecInfo.getName() + " / " + paramString);
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = null;
    this.jdField_a_of_type_Aowi = null;
  }
  
  public void a(int paramInt)
  {
    aowi localaowi = this.jdField_a_of_type_Aowi;
    if (localaowi != null)
    {
      localaowi.a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("SimpleVideoDecoder", 2, "setSpeedType" + paramInt);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("SimpleVideoDecoder", 2, "setSpeedType " + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void a(DecodeConfig paramDecodeConfig, Surface paramSurface, TrackingDecoderListener paramTrackingDecoderListener, boolean paramBoolean)
  {
    if (paramDecodeConfig == null) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    if (QLog.isColorLevel()) {
      QLog.i("SimpleVideoDecoder", 2, "startDecode config = " + paramDecodeConfig);
    }
    Thread localThread;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      localThread = this.jdField_a_of_type_JavaLangThread;
      a();
    }
    try
    {
      localThread.join();
      this.jdField_a_of_type_Aowi = new aowi(paramDecodeConfig.a, paramSurface, paramTrackingDecoderListener);
      this.jdField_a_of_type_Aowi.a(paramDecodeConfig);
      this.jdField_a_of_type_Aowi.a(paramBoolean);
      this.jdField_a_of_type_JavaLangThread = new Thread(this.jdField_a_of_type_Aowi, "SimpleVideoDecoder-Thread");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleVideoDecoder
 * JD-Core Version:    0.7.0.1
 */