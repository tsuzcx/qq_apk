package com.tencent.ttpic.ar.sensor.representation;

public class Vector4f
{
  protected float[] points = { 0.0F, 0.0F, 0.0F, 0.0F };
  
  public Vector4f()
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
  }
  
  public Vector4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = paramFloat4;
  }
  
  public Vector4f(Vector3f paramVector3f, float paramFloat)
  {
    this.points[0] = paramVector3f.x();
    this.points[1] = paramVector3f.y();
    this.points[2] = paramVector3f.z();
    this.points[3] = paramFloat;
  }
  
  public void add(Vector3f paramVector3f, float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] += paramVector3f.x();
    arrayOfFloat = this.points;
    arrayOfFloat[1] += paramVector3f.y();
    arrayOfFloat = this.points;
    arrayOfFloat[2] += paramVector3f.z();
    paramVector3f = this.points;
    paramVector3f[3] += paramFloat;
  }
  
  public void add(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector4f = paramVector4f.points;
    arrayOfFloat[0] = (f + paramVector4f[0]);
    arrayOfFloat[1] += paramVector4f[1];
    arrayOfFloat[2] += paramVector4f[2];
    arrayOfFloat[3] += paramVector4f[3];
  }
  
  public float[] array()
  {
    return this.points;
  }
  
  public boolean compareTo(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    boolean bool2 = false;
    float f = arrayOfFloat[0];
    paramVector4f = paramVector4f.points;
    boolean bool1 = bool2;
    if (f == paramVector4f[0])
    {
      bool1 = bool2;
      if (arrayOfFloat[1] == paramVector4f[1])
      {
        bool1 = bool2;
        if (arrayOfFloat[2] == paramVector4f[2])
        {
          bool1 = bool2;
          if (arrayOfFloat[3] == paramVector4f[3]) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Vector4f copy()
  {
    Vector4f localVector4f = new Vector4f();
    localVector4f.setXYZW(x(), y(), z(), w());
    return localVector4f;
  }
  
  public void copyFromV3f(Vector3f paramVector3f, float paramFloat)
  {
    this.points[0] = paramVector3f.x();
    this.points[1] = paramVector3f.y();
    this.points[2] = paramVector3f.z();
    this.points[3] = paramFloat;
  }
  
  public void copyVec4(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    paramVector4f = paramVector4f.points;
    arrayOfFloat[0] = paramVector4f[0];
    arrayOfFloat[1] = paramVector4f[1];
    arrayOfFloat[2] = paramVector4f[2];
    arrayOfFloat[3] = paramVector4f[3];
  }
  
  public float dotProduct(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector4f = paramVector4f.points;
    return f * paramVector4f[0] + arrayOfFloat[1] * paramVector4f[1] + arrayOfFloat[2] * paramVector4f[2] + arrayOfFloat[3] * paramVector4f[3];
  }
  
  public float getW()
  {
    return this.points[3];
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
  
  public void lerp(Vector4f paramVector4f1, Vector4f paramVector4f2, float paramFloat)
  {
    paramVector4f2 = paramVector4f2.points;
    float[] arrayOfFloat = this.points;
    float f1 = arrayOfFloat[0];
    float f2 = 1.0F * paramFloat;
    paramVector4f1 = paramVector4f1.points;
    paramVector4f2[0] = (f1 * f2 + paramVector4f1[0] * paramFloat);
    paramVector4f2[1] = (arrayOfFloat[1] * f2 + paramVector4f1[1] * paramFloat);
    paramVector4f2[2] = (arrayOfFloat[2] * f2 + paramVector4f1[2] * paramFloat);
    paramVector4f2[3] = (arrayOfFloat[3] * f2 + paramVector4f1[3] * paramFloat);
  }
  
  public void multiplyByScalar(float paramFloat)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] *= paramFloat;
    arrayOfFloat[1] *= paramFloat;
    arrayOfFloat[2] *= paramFloat;
    arrayOfFloat[3] *= paramFloat;
  }
  
  public void normalize()
  {
    float[] arrayOfFloat = this.points;
    if (arrayOfFloat[3] == 0.0F) {
      return;
    }
    arrayOfFloat[0] /= arrayOfFloat[3];
    arrayOfFloat[1] /= arrayOfFloat[3];
    arrayOfFloat[2] /= arrayOfFloat[3];
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
  
  public void setW(float paramFloat)
  {
    this.points[3] = paramFloat;
  }
  
  public void setX(float paramFloat)
  {
    this.points[0] = paramFloat;
  }
  
  public void setXYZW(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.points;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = paramFloat4;
  }
  
  public void setY(float paramFloat)
  {
    this.points[1] = paramFloat;
  }
  
  public void setZ(float paramFloat)
  {
    this.points[2] = paramFloat;
  }
  
  public void subdivide(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector4f = paramVector4f.points;
    arrayOfFloat[0] = (f / paramVector4f[0]);
    arrayOfFloat[1] /= paramVector4f[1];
    arrayOfFloat[2] /= paramVector4f[2];
    arrayOfFloat[3] /= paramVector4f[3];
  }
  
  public Vector4f subtract(Vector4f paramVector4f)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector4f = paramVector4f.points;
    arrayOfFloat[0] = (f - paramVector4f[0]);
    arrayOfFloat[1] -= paramVector4f[1];
    arrayOfFloat[2] -= paramVector4f[2];
    arrayOfFloat[3] -= paramVector4f[3];
    return this;
  }
  
  public void subtract(Vector4f paramVector4f1, Vector4f paramVector4f2)
  {
    float[] arrayOfFloat = this.points;
    float f = arrayOfFloat[0];
    paramVector4f1 = paramVector4f1.points;
    paramVector4f2.setXYZW(f - paramVector4f1[0], arrayOfFloat[1] - paramVector4f1[1], arrayOfFloat[2] - paramVector4f1[2], arrayOfFloat[3] - paramVector4f1[3]);
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
    localStringBuilder.append(" W:");
    localStringBuilder.append(this.points[3]);
    return localStringBuilder.toString();
  }
  
  public float w()
  {
    return this.points[3];
  }
  
  public void w(float paramFloat)
  {
    this.points[3] = paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.Vector4f
 * JD-Core Version:    0.7.0.1
 */