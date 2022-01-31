public class ocy
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public ocy(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public ocy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public ocy(ocy paramocy)
  {
    this.a = paramocy.a;
    this.b = paramocy.b;
  }
  
  public void a(ocy paramocy)
  {
    float f = this.a;
    this.a = paramocy.a;
    paramocy.a = f;
    f = this.b;
    this.b = paramocy.b;
    paramocy.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocy
 * JD-Core Version:    0.7.0.1
 */