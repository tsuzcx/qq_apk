package com.tencent.mobileqq.shortvideo.mediadevice;

import azdf;
import azdl;
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
    if ((SVHwEncoder)this.this$0.mEncodeRef.get() != null) {
      if (PreviewContext.access$000(this.this$0))
      {
        this.this$0.mAVCodec.handleQQVideoFrameWithCallback();
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoFrameWithCallback");
        }
      }
    }
    for (;;)
    {
      this.this$0.mCamera.a.a(7, new Object[] { Integer.valueOf(0) });
      this.this$0.mVideoFrameProcess.incrementAndGet();
      return;
      this.this$0.mAVCodec.handleQQVideoOneFrame();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoOneFrame");
      }
      this.this$0.encodeOneFrameNotify();
      continue;
      this.this$0.mAVCodec.handleQQVideo();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: encode=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.HandleVideo
 * JD-Core Version:    0.7.0.1
 */