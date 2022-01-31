import android.animation.TypeEvaluator;

final class owt
  implements TypeEvaluator
{
  private ows a;
  
  public ows a(float paramFloat, ows paramows1, ows paramows2)
  {
    float f1 = paramows1.a + (paramows2.a - paramows1.a) * paramFloat;
    float f2 = paramows1.b + (paramows2.b - paramows1.b) * paramFloat;
    paramFloat = paramows1.c + (paramows2.c - paramows1.c) * paramFloat;
    if (this.a == null) {
      this.a = new ows(f1, f2, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a = f1;
      this.a.b = f2;
      this.a.c = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owt
 * JD-Core Version:    0.7.0.1
 */