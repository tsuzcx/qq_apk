import android.view.animation.Interpolator;

class qzk
  implements Interpolator
{
  qzk(qzi paramqzi) {}
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat + 0.12F) * 6.283185307179586D / -0.1800000071525574D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzk
 * JD-Core Version:    0.7.0.1
 */