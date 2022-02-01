import android.view.animation.Interpolator;

public class sal
  implements Interpolator
{
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return -paramFloat3 * (float)Math.cos(paramFloat1 / paramFloat4 * 1.570796326794897D) + paramFloat3 + paramFloat2;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(paramFloat, 0.0F, 1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sal
 * JD-Core Version:    0.7.0.1
 */