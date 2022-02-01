package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

public class CropHomeing
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public CropHomeing(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    return Float.compare(paramCropHomeing1.d, paramCropHomeing2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(CropHomeing paramCropHomeing)
  {
    this.c *= paramCropHomeing.c;
    this.a -= paramCropHomeing.a;
    this.b -= paramCropHomeing.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.CropHomeing
 * JD-Core Version:    0.7.0.1
 */