package com.tencent.mobileqq.qqlive.trtc.video.videoprocess;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;

public class TRTCVideoPreProcessCtrl
  implements ITRTCVideoPreProcess
{
  private TRTCCloud a;
  private QQLiveAEFilterProcess b;
  private SensorManager c;
  private SensorEventListener d;
  
  public int a(QQLiveVideoBaseFrame paramQQLiveVideoBaseFrame1, QQLiveVideoBaseFrame paramQQLiveVideoBaseFrame2)
  {
    boolean bool = paramQQLiveVideoBaseFrame1 instanceof QQLiveVideoBaseFrame;
    TRTCCloudDef.TRTCVideoFrame localTRTCVideoFrame = null;
    if (bool) {
      paramQQLiveVideoBaseFrame1 = ((QQLiveProcessFrame)paramQQLiveVideoBaseFrame1).a();
    } else {
      paramQQLiveVideoBaseFrame1 = null;
    }
    if ((paramQQLiveVideoBaseFrame2 instanceof QQLiveVideoBaseFrame)) {
      localTRTCVideoFrame = ((QQLiveProcessFrame)paramQQLiveVideoBaseFrame2).a();
    }
    paramQQLiveVideoBaseFrame2 = this.b;
    if (paramQQLiveVideoBaseFrame2 != null) {
      if (paramQQLiveVideoBaseFrame2.c())
      {
        this.b.a(paramQQLiveVideoBaseFrame1.width, paramQQLiveVideoBaseFrame1.height);
        localTRTCVideoFrame.texture.textureId = this.b.a(paramQQLiveVideoBaseFrame1.texture.textureId);
      }
      else
      {
        localTRTCVideoFrame.texture.textureId = paramQQLiveVideoBaseFrame1.texture.textureId;
      }
    }
    return 0;
  }
  
  public void a()
  {
    this.a = null;
    SensorEventListener localSensorEventListener = this.d;
    if (localSensorEventListener != null) {
      this.c.unregisterListener(localSensorEventListener);
    }
  }
  
  public void b()
  {
    QQLiveAEFilterProcess localQQLiveAEFilterProcess = this.b;
    if (localQQLiveAEFilterProcess != null) {
      localQQLiveAEFilterProcess.a();
    }
  }
  
  public void c()
  {
    QQLiveAEFilterProcess localQQLiveAEFilterProcess = this.b;
    if (localQQLiveAEFilterProcess != null) {
      localQQLiveAEFilterProcess.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.videoprocess.TRTCVideoPreProcessCtrl
 * JD-Core Version:    0.7.0.1
 */