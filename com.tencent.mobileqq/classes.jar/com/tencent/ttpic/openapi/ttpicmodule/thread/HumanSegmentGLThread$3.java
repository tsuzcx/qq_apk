package com.tencent.ttpic.openapi.ttpicmodule.thread;

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

class HumanSegmentGLThread$3
  implements Runnable
{
  HumanSegmentGLThread$3(HumanSegmentGLThread paramHumanSegmentGLThread, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    if (BitmapUtils.isLegal(HumanSegmentGLThread.access$1200(this.this$0)))
    {
      HumanSegmentGLThread.access$1200(this.this$0).recycle();
      HumanSegmentGLThread.access$1202(this.this$0, null);
    }
    if (BitmapUtils.isLegal(HumanSegmentGLThread.access$1300(this.this$0)))
    {
      HumanSegmentGLThread.access$1300(this.this$0).recycle();
      HumanSegmentGLThread.access$1302(this.this$0, null);
    }
    if (BitmapUtils.isLegal(HumanSegmentGLThread.access$1400(this.this$0)))
    {
      HumanSegmentGLThread.access$1400(this.this$0).recycle();
      HumanSegmentGLThread.access$1402(this.this$0, null);
    }
    if (BitmapUtils.isLegal(HumanSegmentGLThread.access$1500(this.this$0)))
    {
      HumanSegmentGLThread.access$1500(this.this$0).recycle();
      HumanSegmentGLThread.access$1502(this.this$0, null);
    }
    HumanSegmentGLThread.access$500(this.this$0).clear();
    HumanSegmentGLThread.access$900(this.this$0)[0].clear();
    HumanSegmentGLThread.access$900(this.this$0)[1].clear();
    HumanSegmentGLThread.access$600(this.this$0).clear();
    HumanSegmentGLThread.access$700(this.this$0).clear();
    HumanSegmentGLThread.access$800(this.this$0).clear();
    HumanSegmentGLThread.access$400(this.this$0).clearGLSL();
    HumanSegmentGLThread.access$200(this.this$0).clearGLSL();
    HumanSegmentGLThread.access$300(this.this$0).clearGLSLSelf();
    GLES20.glDeleteTextures(HumanSegmentGLThread.access$1000(this.this$0).length, HumanSegmentGLThread.access$1000(this.this$0), 0);
    HumanSegmentGLThread.access$100(this.this$0).release();
    HumanSegmentGLThread.access$000(this.this$0).release();
    HandlerThreadManager.getInstance().destroyHandlerThread(HumanSegmentGLThread.access$1600(this.this$0));
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.thread.HumanSegmentGLThread.3
 * JD-Core Version:    0.7.0.1
 */