package com.tencent.ttpic.thread;

import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.concurrent.CountDownLatch;

class FaceGestureDetGLThread$1
  implements Runnable
{
  FaceGestureDetGLThread$1(FaceGestureDetGLThread paramFaceGestureDetGLThread, byte[] paramArrayOfByte, int paramInt1, int paramInt2, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    FaceGestureDetGLThread.access$002(this.this$0, AlgoUtils.getHistogram(this.val$data, this.val$faceDetWidth, this.val$faceDetHeight, FaceGestureDetGLThread.access$100(this.this$0).getAllFaces(), FaceGestureDetGLThread.access$200(this.this$0), FaceGestureDetGLThread.access$300(this.this$0)));
    this.val$hisCdl.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.1
 * JD-Core Version:    0.7.0.1
 */