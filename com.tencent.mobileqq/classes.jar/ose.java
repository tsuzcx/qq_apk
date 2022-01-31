import android.animation.TypeEvaluator;

final class ose
  implements TypeEvaluator
{
  private osd a;
  
  public osd a(float paramFloat, osd paramosd1, osd paramosd2)
  {
    float f1 = paramosd1.a + (paramosd2.a - paramosd1.a) * paramFloat;
    float f2 = paramosd1.b + (paramosd2.b - paramosd1.b) * paramFloat;
    paramFloat = paramosd1.c + (paramosd2.c - paramosd1.c) * paramFloat;
    if (this.a == null) {
      this.a = new osd(f1, f2, paramFloat);
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
 * Qualified Name:     ose
 * JD-Core Version:    0.7.0.1
 */