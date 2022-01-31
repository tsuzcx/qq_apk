public class ogq
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public ogq(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public ogq(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public ogq(ogq paramogq)
  {
    this.a = paramogq.a;
    this.b = paramogq.b;
  }
  
  public void a(ogq paramogq)
  {
    float f = this.a;
    this.a = paramogq.a;
    paramogq.a = f;
    f = this.b;
    this.b = paramogq.b;
    paramogq.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogq
 * JD-Core Version:    0.7.0.1
 */