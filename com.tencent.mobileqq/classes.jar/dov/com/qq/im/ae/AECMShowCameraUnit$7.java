package dov.com.qq.im.ae;

import android.animation.ValueAnimator;
import bmvk;
import bmvp;
import bmvq;

public class AECMShowCameraUnit$7
  implements Runnable
{
  public AECMShowCameraUnit$7(bmvk parambmvk, int paramInt) {}
  
  public void run()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addListener(new bmvp(this));
    localValueAnimator.addUpdateListener(new bmvq(this));
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.7
 * JD-Core Version:    0.7.0.1
 */