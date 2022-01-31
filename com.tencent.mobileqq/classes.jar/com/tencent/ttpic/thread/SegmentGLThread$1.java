package com.tencent.ttpic.thread;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.ExpFilter;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.youtu.android.segmenter.SegmenterLib;

class SegmentGLThread$1
  implements Runnable
{
  SegmentGLThread$1(SegmentGLThread paramSegmentGLThread, EGLContext paramEGLContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    SegmentGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
    SegmentGLThread.access$102(this.this$0, new OffscreenSurface(SegmentGLThread.access$000(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    SegmentGLThread.access$100(this.this$0).makeCurrent();
    SegmentGLThread.access$200(this.this$0).apply();
    SegmentGLThread.access$300(this.this$0).apply();
    SegmentGLThread.access$400(this.this$0).apply();
    SegmentGLThread.access$502(this.this$0, new GLSegSharedData());
    SegmentGLThread.access$602(this.this$0, new Frame());
    SegmentGLThread.access$702(this.this$0, new Frame());
    SegmentGLThread.access$802(this.this$0, new Frame());
    SegmentGLThread.access$900(this.this$0)[0] = new Frame();
    SegmentGLThread.access$900(this.this$0)[1] = new Frame();
    GLES20.glGenTextures(SegmentGLThread.access$1000(this.this$0).length, SegmentGLThread.access$1000(this.this$0), 0);
    SegmentGLThread.access$1102(this.this$0, new SegmenterLib(this.val$protoFilePath, this.val$modeFilePath));
    SegmentGLThread.access$1202(this.this$0, SegmentGLThread.access$1100(this.this$0).init());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.1
 * JD-Core Version:    0.7.0.1
 */