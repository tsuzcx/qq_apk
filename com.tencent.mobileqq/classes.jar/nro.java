public class nro
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public nro(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public nro(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public nro(nro paramnro)
  {
    this.a = paramnro.a;
    this.b = paramnro.b;
  }
  
  public void a(nro paramnro)
  {
    float f = this.a;
    this.a = paramnro.a;
    paramnro.a = f;
    f = this.b;
    this.b = paramnro.b;
    paramnro.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nro
 * JD-Core Version:    0.7.0.1
 */