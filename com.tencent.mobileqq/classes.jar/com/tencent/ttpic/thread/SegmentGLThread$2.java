package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.filter.ExpFilter;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.SegmentUtil;
import com.tencent.view.RendererUtils;
import com.tencent.youtu.android.segmenter.SegmenterLib;
import java.util.HashMap;
import java.util.Map;

class SegmentGLThread$2
  implements Runnable
{
  SegmentGLThread$2(SegmentGLThread paramSegmentGLThread, Frame paramFrame, int paramInt) {}
  
  public void run()
  {
    if ((!this.this$0.isInitReady()) || (SegmentGLThread.access$1300(this.this$0) == null)) {}
    SegmentDataPipe localSegmentDataPipe;
    Frame localFrame;
    boolean bool;
    int i;
    label117:
    int j;
    label124:
    long l1;
    do
    {
      do
      {
        return;
        localSegmentDataPipe = SegmentGLThread.access$500(this.this$0).getFreeTexturePileMakeBusy();
      } while (localSegmentDataPipe == null);
      localFrame = FrameBufferCache.getInstance().get(this.val$inputFrame.width, this.val$inputFrame.height);
      if (this.val$rotation == 0) {
        break;
      }
      FrameUtil.rotateCorrect(this.val$inputFrame, this.val$inputFrame.width, this.val$inputFrame.height, this.val$rotation, SegmentGLThread.access$400(this.this$0), localFrame);
      bool = SegmentUtil.isHorizon(this.val$rotation);
      if (!bool) {
        break label773;
      }
      i = 32;
      if (!bool) {
        break label779;
      }
      j = 16;
      localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
      BenchUtil.benchStart("[showPreview][FABBY] segment");
      l1 = System.currentTimeMillis();
      SegmentGLThread.access$200(this.this$0).RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, localSegmentDataPipe.mTexFrame);
      localFrame.unlock();
      SegmentGLThread.access$802(this.this$0, localSegmentDataPipe.mTexFrame);
      GLES20.glFinish();
    } while (localSegmentDataPipe.mMaskFrame == null);
    localSegmentDataPipe.mMaskFrame.bindFrame(-1, SegmentGLThread.access$800(this.this$0).width, SegmentGLThread.access$800(this.this$0).height, 0.0D);
    SegmentGLThread.access$200(this.this$0).RenderProcess(SegmentGLThread.access$800(this.this$0).getTextureId(), i * 16, j * 16, -1, 0.0D, SegmentGLThread.access$700(this.this$0));
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1400(this.this$0))) {
      SegmentGLThread.access$1402(this.this$0, Bitmap.createBitmap(256, 512, Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1500(this.this$0))) {
      SegmentGLThread.access$1502(this.this$0, Bitmap.createBitmap(512, 256, Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1600(this.this$0))) {
      SegmentGLThread.access$1602(this.this$0, Bitmap.createBitmap(16, 32, Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1700(this.this$0))) {
      SegmentGLThread.access$1702(this.this$0, Bitmap.createBitmap(32, 16, Bitmap.Config.ARGB_8888));
    }
    Bitmap localBitmap1;
    if (bool)
    {
      localBitmap1 = SegmentGLThread.access$1500(this.this$0);
      label412:
      if (!bool) {
        break label797;
      }
    }
    label773:
    label779:
    label797:
    for (Bitmap localBitmap2 = SegmentGLThread.access$1700(this.this$0);; localBitmap2 = SegmentGLThread.access$1600(this.this$0))
    {
      RendererUtils.saveTextureToBitmap(SegmentGLThread.access$700(this.this$0).getTextureId(), i * 16, j * 16, localBitmap1);
      BenchUtil.benchStart("segmentDetect");
      SegmentGLThread.access$1100(this.this$0).segmentOnBit(localBitmap1, localBitmap2, i * 16, j * 16, i, j);
      BenchUtil.benchEnd("segmentDetect");
      GlUtil.loadTexture(SegmentGLThread.access$1000(this.this$0)[0], localBitmap2);
      SegmentGLThread.access$300(this.this$0).updateParam(SegmentGLThread.access$800(this.this$0).width, SegmentGLThread.access$800(this.this$0).height, i, j);
      SegmentGLThread.access$300(this.this$0).RenderProcess(SegmentGLThread.access$1000(this.this$0)[0], SegmentGLThread.access$800(this.this$0).width, SegmentGLThread.access$800(this.this$0).height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
      if (this.val$rotation != 0)
      {
        FrameUtil.rotateCorrect(localSegmentDataPipe.mMaskFrame, localSegmentDataPipe.mMaskFrame.width, localSegmentDataPipe.mMaskFrame.height, -this.val$rotation, SegmentGLThread.access$400(this.this$0), localFrame);
        SegmentGLThread.access$200(this.this$0).RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
        localFrame.unlock();
      }
      localSegmentDataPipe.makeDataReady();
      SegmentGLThread.access$500(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
      SegmentGLThread.access$1300(this.this$0).onDataReady(localSegmentDataPipe);
      long l2 = System.currentTimeMillis();
      BenchUtil.benchEnd("[showPreview][FABBY] segment");
      localSegmentDataPipe.detectTimes = new HashMap();
      localSegmentDataPipe.detectTimes.put("sdk_background_detect_time", Long.valueOf(l2 - l1));
      return;
      SegmentGLThread.access$200(this.this$0).RenderProcess(this.val$inputFrame.getTextureId(), this.val$inputFrame.width, this.val$inputFrame.height, -1, 0.0D, localFrame);
      break;
      i = 16;
      break label117;
      j = 32;
      break label124;
      localBitmap1 = SegmentGLThread.access$1400(this.this$0);
      break label412;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.2
 * JD-Core Version:    0.7.0.1
 */