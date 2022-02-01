package com.tencent.ttpic.openapi.recorder;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.WindowSurface;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.recorder.MyRecorder;

class RenderSrfTex$3
  implements Runnable
{
  RenderSrfTex$3(RenderSrfTex paramRenderSrfTex, VideoRecorderListener paramVideoRecorderListener) {}
  
  public void run()
  {
    if (RenderSrfTex.access$900(this.this$0) != null) {
      RenderSrfTex.access$900(this.this$0).stop();
    }
    if (RenderSrfTex.access$800(this.this$0) != null) {
      RenderSrfTex.access$800(this.this$0).release();
    }
    if (RenderSrfTex.access$1100(this.this$0) != null) {
      RenderSrfTex.access$1100(this.this$0).release();
    }
    RenderSrfTex.access$700(this.this$0).clearGLSLSelf();
    RenderSrfTex.access$600(this.this$0).clear();
    if ((this.val$listener != null) && (RenderSrfTex.access$900(this.this$0) != null)) {
      this.val$listener.onVideoRecordFinish(RenderSrfTex.access$900(this.this$0).getOutputPath());
    }
    if (RenderSrfTex.access$1300(this.this$0) != null)
    {
      HandlerThreadManager.getInstance().destroyHandlerThread(HandlerThreadTag.CAMERA_VIDEO_SAVE);
      RenderSrfTex.access$1302(this.this$0, null);
    }
    if (RenderSrfTex.access$1400(this.this$0) != null) {
      RenderSrfTex.access$1402(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.RenderSrfTex.3
 * JD-Core Version:    0.7.0.1
 */