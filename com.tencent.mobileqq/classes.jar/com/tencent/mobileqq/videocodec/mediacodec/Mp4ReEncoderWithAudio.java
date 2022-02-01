package com.tencent.mobileqq.videocodec.mediacodec;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioRecoder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.MediaMuxerWrapper;
import com.tencent.qphone.base.util.QLog;

public class Mp4ReEncoderWithAudio
  extends Mp4ReEncoder
{
  private HWAudioRecoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder;
  private MediaMuxerWrapper jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper = new MediaMuxerWrapper(this, paramEncodeConfig.jdField_a_of_type_JavaLangString, paramHWEncodeListener);
      paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder = new HWAudioRecoder(paramDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper);
    }
    catch (Exception localException)
    {
      QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", localException);
    }
    super.a(paramDecodeConfig, paramEncodeConfig, paramHWEncodeListener, paramEncodeFilterRender);
  }
  
  public boolean a()
  {
    boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a();
    HWAudioRecoder localHWAudioRecoder = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder;
    boolean bool3 = false;
    boolean bool1;
    if ((localHWAudioRecoder != null) && (!localHWAudioRecoder.a())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoderWithAudio", 2, new Object[] { "startEncode,", Boolean.valueOf(bool4), " ", Boolean.valueOf(bool1) });
    }
    boolean bool2 = bool3;
    if (bool4)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void onDecodeFinish()
  {
    super.onDecodeFinish();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder.a();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    super.onFrameAvailable(paramSurfaceTexture);
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioRecoder;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoderWithAudio
 * JD-Core Version:    0.7.0.1
 */