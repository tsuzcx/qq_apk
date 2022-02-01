package com.tencent.mobileqq.shortvideo.dancemachine;

import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

class TrAsyncTextureLoad$1
  implements Runnable
{
  TrAsyncTextureLoad$1(TrAsyncTextureLoad paramTrAsyncTextureLoad) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture start loading");
    GLFrameImage.oncePreloadBoyFilterPrivateResource();
    long l2 = System.currentTimeMillis();
    DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture end loading timeCost=" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad.1
 * JD-Core Version:    0.7.0.1
 */