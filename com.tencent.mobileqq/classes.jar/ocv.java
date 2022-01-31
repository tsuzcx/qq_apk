public class ocv
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public ocv(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public ocv(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public ocv(ocv paramocv)
  {
    this.a = paramocv.a;
    this.b = paramocv.b;
  }
  
  public void a(ocv paramocv)
  {
    float f = this.a;
    this.a = paramocv.a;
    paramocv.a = f;
    f = this.b;
    this.b = paramocv.b;
    paramocv.b = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocv
 * JD-Core Version:    0.7.0.1
 */