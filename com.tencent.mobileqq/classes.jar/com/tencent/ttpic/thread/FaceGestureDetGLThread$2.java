package com.tencent.ttpic.thread;

import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.concurrent.CountDownLatch;

class FaceGestureDetGLThread$2
  implements Runnable
{
  FaceGestureDetGLThread$2(FaceGestureDetGLThread paramFaceGestureDetGLThread, byte[] paramArrayOfByte, int paramInt1, int paramInt2, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    FaceGestureDetGLThread.access$402(this.this$0, AlgoUtils.calBrightnessAdjustment(this.val$data, this.val$faceDetWidth, this.val$faceDetHeight, FaceGestureDetGLThread.access$100(this.this$0).getAllFaces(), FaceGestureDetGLThread.access$300(this.this$0), FaceGestureDetGLThread.access$500(this.this$0)));
    this.val$brightnessCdl.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.2
 * JD-Core Version:    0.7.0.1
 */