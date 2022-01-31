import android.view.animation.Interpolator;

public class lwf
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return 12.9184F * paramFloat * paramFloat * paramFloat - 22.5776F * paramFloat * paramFloat + 9.65921F * paramFloat + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwf
 * JD-Core Version:    0.7.0.1
 */