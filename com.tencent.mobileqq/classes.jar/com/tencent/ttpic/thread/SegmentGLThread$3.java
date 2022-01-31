package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.openapi.filter.ExpFilter;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import java.util.concurrent.CountDownLatch;

class SegmentGLThread$3
  implements Runnable
{
  SegmentGLThread$3(SegmentGLThread paramSegmentGLThread, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    if (BitmapUtils.isLegal(SegmentGLThread.access$1400(this.this$0)))
    {
      SegmentGLThread.access$1400(this.this$0).recycle();
      SegmentGLThread.access$1402(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$1500(this.this$0)))
    {
      SegmentGLThread.access$1500(this.this$0).recycle();
      SegmentGLThread.access$1502(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$1600(this.this$0)))
    {
      SegmentGLThread.access$1600(this.this$0).recycle();
      SegmentGLThread.access$1602(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$1700(this.this$0)))
    {
      SegmentGLThread.access$1700(this.this$0).recycle();
      SegmentGLThread.access$1702(this.this$0, null);
    }
    SegmentGLThread.access$500(this.this$0).clear();
    SegmentGLThread.access$900(this.this$0)[0].clear();
    SegmentGLThread.access$900(this.this$0)[1].clear();
    SegmentGLThread.access$600(this.this$0).clear();
    SegmentGLThread.access$700(this.this$0).clear();
    SegmentGLThread.access$800(this.this$0).clear();
    SegmentGLThread.access$400(this.this$0).ClearGLSL();
    SegmentGLThread.access$200(this.this$0).ClearGLSL();
    SegmentGLThread.access$300(this.this$0).clearGLSLSelf();
    GLES20.glDeleteTextures(SegmentGLThread.access$1000(this.this$0).length, SegmentGLThread.access$1000(this.this$0), 0);
    SegmentGLThread.access$100(this.this$0).release();
    SegmentGLThread.access$000(this.this$0).release();
    HandlerThreadManager.getInstance().destroyHandlerThread(SegmentGLThread.access$1800(this.this$0));
    SegmentGLThread.access$1202(this.this$0, false);
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.3
 * JD-Core Version:    0.7.0.1
 */