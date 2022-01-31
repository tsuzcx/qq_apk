package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.view.Surface;
import aons;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

@TargetApi(16)
public class SimpleVideoDecoder
{
  private aons jdField_a_of_type_Aons;
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
    this.jdField_a_of_type_Aons = null;
  }
  
  public void a(int paramInt)
  {
    aons localaons = this.jdField_a_of_type_Aons;
    if (localaons != null)
    {
      localaons.a(paramInt);
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
      this.jdField_a_of_type_Aons = new aons(paramDecodeConfig.a, paramSurface, paramTrackingDecoderListener);
      this.jdField_a_of_type_Aons.a(paramDecodeConfig);
      this.jdField_a_of_type_Aons.a(paramBoolean);
      this.jdField_a_of_type_JavaLangThread = new Thread(this.jdField_a_of_type_Aons, "SimpleVideoDecoder-Thread");
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