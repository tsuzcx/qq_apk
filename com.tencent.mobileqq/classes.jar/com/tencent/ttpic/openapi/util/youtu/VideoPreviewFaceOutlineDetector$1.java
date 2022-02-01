package com.tencent.ttpic.openapi.util.youtu;

import com.tencent.ttpic.baseutils.fps.BenchUtil;

class VideoPreviewFaceOutlineDetector$1
  implements Runnable
{
  VideoPreviewFaceOutlineDetector$1(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    BenchUtil.benchStart("only faceDetect");
    this.this$0.doFaceDetect(this.val$data, this.val$w, this.val$h);
    BenchUtil.benchEnd("only faceDetect");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector.1
 * JD-Core Version:    0.7.0.1
 */