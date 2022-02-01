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
  private MediaMuxerWrapper g;
  private HWAudioRecoder h;
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    try
    {
      this.g = new MediaMuxerWrapper(this, paramEncodeConfig.b, paramHWEncodeListener);
      paramEncodeConfig.s = this.g;
      this.h = new HWAudioRecoder(paramDecodeConfig, this.g);
    }
    catch (Exception localException)
    {
      QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", localException);
    }
    super.a(paramDecodeConfig, paramEncodeConfig, paramHWEncodeListener, paramEncodeFilterRender);
  }
  
  public boolean b()
  {
    boolean bool4 = this.a.c();
    HWAudioRecoder localHWAudioRecoder = this.h;
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
      if (this.h != null)
      {
        this.h.c();
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
    paramSurfaceTexture = this.h;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoderWithAudio
 * JD-Core Version:    0.7.0.1
 */