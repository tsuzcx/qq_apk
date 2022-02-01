package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.graphics.SurfaceTexture;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWAudioRecoder;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder;

public class Mp4ReEncoderWithAudio
  extends Mp4ReEncoder
{
  private HWAudioRecoder b;
  
  public void b()
  {
    super.b();
    try
    {
      if (this.b != null)
      {
        this.b.c();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean g()
  {
    boolean bool4 = this.a.b();
    Object localObject = this.b;
    boolean bool3 = false;
    boolean bool1;
    if ((localObject != null) && (!((HWAudioRecoder)localObject).a())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startEncode,");
    ((StringBuilder)localObject).append(bool4);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(bool1);
    TLog.b("Mp4ReEncoderWithAudio", ((StringBuilder)localObject).toString());
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
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    super.onFrameAvailable(paramSurfaceTexture);
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.Mp4ReEncoderWithAudio
 * JD-Core Version:    0.7.0.1
 */