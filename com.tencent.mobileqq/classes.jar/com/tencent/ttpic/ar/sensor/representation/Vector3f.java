package com.tencent.ttpic.ar.sensor.representation;

public class Vector3f
{
  protected float[] points = new float[3];
  
  public Vector3f() {}
  
  public Vector3f(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = paramFloat;
  }
  
  public Vector3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
  }
  
  public Vector3f(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    paramVector3f = paramVector3f.points;
    arrayOfFloat[0] = paramVector3f[0];
    arrayOfFloat[1] = paramVector3f[1];
    arrayOfFloat[2] = paramVector3f[2];
  }
  
  public Vector3f(Vector4f paramVector4f)
  {
    if (paramVector4f.w() != 0.0F)
    {
      this.points[0] = (paramVector4f.x() / paramVector4f.w());
      this.points[1] = (paramVector4f.y() / paramVector4f.w());
      this.points[2] = (paramVector4f.z() / paramVector4f.w());
      return;
    }
    this.points[0] = paramVector4f.x();
    this.points[1] = paramVector4f.y();
    this.points[2] = paramVector4f.z();
  }
  
  public void add(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] += paramFloat;
    arrayOfFloat[1] += paramFloat;
    arrayOfFloat[2] += paramFloat;
  }
  
  public void add(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector3f = paramVector3f.points;
    arrayOfFloat[0] = (f + paramVector3f[0]);
    arrayOfFloat[1] += paramVector3f[1];
    arrayOfFloat[2] += paramVector3f[2];
  }
  
  public void crossProduct(Vector3f paramVector3f1, Vector3f paramVector3f2)
  {
    float[] arrayOfFloat1 = this.points;
    float f = arrayOfFloat1[1];
    float[] arrayOfFloat2 = paramVector3f1.points;
    paramVector3f2.setX(f * arrayOfFloat2[2] - arrayOfFloat1[2] * arrayOfFloat2[1]);
    arrayOfFloat1 = this.points;
    f = arrayOfFloat1[2];
    arrayOfFloat2 = paramVector3f1.points;
    paramVector3f2.setY(f * arrayOfFloat2[0] - arrayOfFloat1[0] * arrayOfFloat2[2]);
    arrayOfFloat1 = this.points;
    f = arrayOfFloat1[0];
    paramVector3f1 = paramVector3f1.points;
    paramVector3f2.setZ(f * paramVector3f1[1] - arrayOfFloat1[1] * paramVector3f1[0]);
  }
  
  public float dotProduct(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector3f = paramVector3f.points;
    return f * paramVector3f[0] + arrayOfFloat[1] * paramVector3f[1] + arrayOfFloat[2] * paramVector3f[2];
  }
  
  public float getLength()
  {
    float[] arrayOfFloat = this.points;
    return (float)Math.sqrt(arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[2] * arrayOfFloat[2]);
  }
  
  public float getX()
  {
    return this.points[0];
  }
  
  public float getY()
  {
    return this.points[1];
  }
  
  public float getZ()
  {
    return this.points[2];
  }
  
  public void multiplyByScalar(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] *= paramFloat;
    arrayOfFloat[1] *= paramFloat;
    arrayOfFloat[2] *= paramFloat;
  }
  
  public void normalize()
  {
    float[] arrayOfFloat = this.points;
    double d1 = Math.sqrt(arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[2] * arrayOfFloat[2]);
    arrayOfFloat = this.points;
    double d2 = arrayOfFloat[0];
    Double.isNaN(d2);
    arrayOfFloat[0] = ((float)(d2 / d1));
    d2 = arrayOfFloat[1];
    Double.isNaN(d2);
    arrayOfFloat[1] = ((float)(d2 / d1));
    d2 = arrayOfFloat[2];
    Double.isNaN(d2);
    arrayOfFloat[2] = ((float)(d2 / d1));
  }
  
  public void set(Vector3f paramVector3f)
  {
    set(paramVector3f.points);
  }
  
  public void set(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.points, 0, 3);
  }
  
  public void setX(float paramFloat)
  {
    this.points[0] = paramFloat;
  }
  
  public void setXYZ(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
  }
  
  public void setY(float paramFloat)
  {
    this.points[1] = paramFloat;
  }
  
  public void setZ(float paramFloat)
  {
    this.points[2] = paramFloat;
  }
  
  public void subtract(Vector3f paramVector3f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector3f = paramVector3f.points;
    arrayOfFloat[0] = (f - paramVector3f[0]);
    arrayOfFloat[1] -= paramVector3f[1];
    arrayOfFloat[2] -= paramVector3f[2];
  }
  
  public float[] toArray()
  {
    return this.points;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("X:");
    localStringBuilder.append(this.points[0]);
    localStringBuilder.append(" Y:");
    localStringBuilder.append(this.points[1]);
    localStringBuilder.append(" Z:");
    localStringBuilder.append(this.points[2]);
    return localStringBuilder.toString();
  }
  
  public float x()
  {
    return this.points[0];
  }
  
  public void x(float paramFloat)
  {
    this.points[0] = paramFloat;
  }
  
  public float y()
  {
    return this.points[1];
  }
  
  public void y(float paramFloat)
  {
    this.points[1] = paramFloat;
  }
  
  public float z()
  {
    return this.points[2];
  }
  
  public void z(float paramFloat)
  {
    this.points[2] = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.Vector3f
 * JD-Core Version:    0.7.0.1
 */