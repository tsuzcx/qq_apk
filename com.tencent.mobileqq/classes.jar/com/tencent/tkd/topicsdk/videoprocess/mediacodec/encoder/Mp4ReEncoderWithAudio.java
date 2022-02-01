package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.graphics.SurfaceTexture;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWAudioRecoder;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder;

public class Mp4ReEncoderWithAudio
  extends Mp4ReEncoder
{
  private HWAudioRecoder a;
  
  public boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder.a();
    if ((this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder == null) || (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder.a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      TLog.b("Mp4ReEncoderWithAudio", "startEncode," + bool2 + " " + bool1);
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    try
    {
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder.a();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    super.onFrameAvailable(paramSurfaceTexture);
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWAudioRecoder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoderWithAudio
 * JD-Core Version:    0.7.0.1
 */