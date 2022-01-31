package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext$HandleVideo
  implements Runnable
{
  public PreviewContext$HandleVideo(PreviewContext paramPreviewContext) {}
  
  public void run()
  {
    if ((SVHwEncoder)this.a.mEncodeRef.get() != null) {
      if (PreviewContext.access$000(this.a))
      {
        this.a.mAVCodec.handleQQVideoFrameWithCallback();
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoFrameWithCallback");
        }
      }
    }
    for (;;)
    {
      this.a.mCamera.a.a(7, new Object[] { Integer.valueOf(0) });
      this.a.mVideoFrameProcess.incrementAndGet();
      return;
      this.a.mAVCodec.handleQQVideoOneFrame();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoOneFrame");
      }
      this.a.encodeOneFrameNotify();
      continue;
      this.a.mAVCodec.handleQQVideo();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: encode=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.HandleVideo
 * JD-Core Version:    0.7.0.1
 */