package dov.com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWAudioRecoder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.MediaMuxerWrapper;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class Mp4ReEncoderWithAudio
  extends Mp4ReEncoder
{
  private HWAudioRecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder;
  private MediaMuxerWrapper jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper;
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper = new MediaMuxerWrapper(this, paramEncodeConfig.jdField_a_of_type_JavaLangString, paramHWEncodeListener);
      paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder = new HWAudioRecoder(paramDecodeConfig, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper);
      super.a(paramDecodeConfig, paramEncodeConfig, paramHWEncodeListener, paramEncodeFilterRender);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", localException);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder.a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoderWithAudio", 2, new Object[] { "startEncode,", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool1) });
      }
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void onDecodeFinish()
  {
    super.onDecodeFinish();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioRecoder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoderWithAudio
 * JD-Core Version:    0.7.0.1
 */