public class otm
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public otm(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public otm(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public otm(otm paramotm)
  {
    this.a = paramotm.a;
    this.b = paramotm.b;
  }
  
  public void a(otm paramotm)
  {
    float f = this.a;
    this.a = paramotm.a;
    paramotm.a = f;
    f = this.b;
    this.b = paramotm.b;
    paramotm.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otm
 * JD-Core Version:    0.7.0.1
 */