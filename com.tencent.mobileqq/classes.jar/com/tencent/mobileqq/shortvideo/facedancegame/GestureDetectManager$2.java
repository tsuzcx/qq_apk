package com.tencent.mobileqq.shortvideo.facedancegame;

import android.os.SystemClock;
import com.tencent.av.avgesture.AVGestureWrapper;

class GestureDetectManager$2
  implements Runnable
{
  GestureDetectManager$2(GestureDetectManager paramGestureDetectManager, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IGestureDetectCallBack paramIGestureDetectCallBack) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtimeNanos();
    AVGestureWrapper localAVGestureWrapper = new AVGestureWrapper();
    boolean bool = localAVGestureWrapper.doCalc(this.val$finalInput, this.val$gestureDataWidth, this.val$gestureDataHeight, 0, 0, true);
    FaceDanceDetectTask.logTimeInfo("AVGestureWrapper.doCalc", l, SystemClock.elapsedRealtimeNanos());
    if (this.val$callBack != null)
    {
      FaceDanceDetectTask.GestureDetectTaskResult localGestureDetectTaskResult = new FaceDanceDetectTask.GestureDetectTaskResult();
      localGestureDetectTaskResult.vaild = bool;
      if (bool) {
        localGestureDetectTaskResult.type = localAVGestureWrapper.getGestureType();
      }
      this.val$callBack.gestureDetectEnd(localGestureDetectTaskResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager.2
 * JD-Core Version:    0.7.0.1
 */