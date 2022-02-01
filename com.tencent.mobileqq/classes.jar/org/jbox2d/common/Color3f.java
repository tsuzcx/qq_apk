package org.jbox2d.common;

public class Color3f
{
  public static final Color3f BLACK = new Color3f(0.0F, 0.0F, 0.0F);
  public static final Color3f BLUE = new Color3f(0.0F, 0.0F, 1.0F);
  public static final Color3f GREEN = new Color3f(0.0F, 1.0F, 0.0F);
  public static final Color3f RED = new Color3f(1.0F, 0.0F, 0.0F);
  public static final Color3f WHITE = new Color3f(1.0F, 1.0F, 1.0F);
  public float x;
  public float y;
  public float z;
  
  public Color3f()
  {
    this.z = 0.0F;
    this.y = 0.0F;
    this.x = 0.0F;
  }
  
  public Color3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void set(Color3f paramColor3f)
  {
    this.x = paramColor3f.x;
    this.y = paramColor3f.y;
    this.z = paramColor3f.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Color3f
 * JD-Core Version:    0.7.0.1
 */