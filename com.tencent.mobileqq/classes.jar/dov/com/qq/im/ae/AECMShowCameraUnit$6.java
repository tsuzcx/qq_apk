package dov.com.qq.im.ae;

import android.animation.ValueAnimator;
import bmvk;
import bmvn;
import bmvo;

public class AECMShowCameraUnit$6
  implements Runnable
{
  public AECMShowCameraUnit$6(bmvk parambmvk) {}
  
  public void run()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addListener(new bmvn(this));
    localValueAnimator.addUpdateListener(new bmvo(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.6
 * JD-Core Version:    0.7.0.1
 */