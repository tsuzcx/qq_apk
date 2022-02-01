package com.tencent.ttpic.openapi;

import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnFaceDetListener;

class PTFaceDetector$1
  implements FaceGestureDetGLThread.OnFaceDetListener
{
  PTFaceDetector$1(PTFaceDetector paramPTFaceDetector) {}
  
  public void onDataReady(SegmentDataPipe paramSegmentDataPipe)
  {
    PTFaceDetector.access$000(this.this$0, paramSegmentDataPipe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceDetector.1
 * JD-Core Version:    0.7.0.1
 */