import android.animation.TypeEvaluator;

final class oqk
  implements TypeEvaluator
{
  private oqj a;
  
  public oqj a(float paramFloat, oqj paramoqj1, oqj paramoqj2)
  {
    float f1 = paramoqj1.a + (paramoqj2.a - paramoqj1.a) * paramFloat;
    float f2 = paramoqj1.b + (paramoqj2.b - paramoqj1.b) * paramFloat;
    paramFloat = paramoqj1.c + (paramoqj2.c - paramoqj1.c) * paramFloat;
    if (this.a == null) {
      this.a = new oqj(f1, f2, paramFloat);
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
 * Qualified Name:     oqk
 * JD-Core Version:    0.7.0.1
 */