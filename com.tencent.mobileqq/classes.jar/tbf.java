public final class tbf
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1) + 1.0F) * paramFloat3 + paramFloat2;
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 /= paramFloat4 / 2.0F;
    if (paramFloat1 < 1.0F) {
      return paramFloat1 * (paramFloat3 / 2.0F * paramFloat1 * paramFloat1) + paramFloat2;
    }
    paramFloat3 /= 2.0F;
    paramFloat1 -= 2.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1) + 2.0F) * paramFloat3 + paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */