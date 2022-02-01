package com.tencent.ttpic.ar.sensor.representation;

public class Quaternion
  extends Vector4f
{
  private boolean dirty = false;
  private MatrixF4x4 matrix = new MatrixF4x4();
  private Quaternion tmpQuaternion;
  private Vector4f tmpVector = new Vector4f();
  
  public Quaternion()
  {
    loadIdentityQuat();
  }
  
  private void convertQuatToMatrix()
  {
    float f1 = this.points[0];
    float f2 = this.points[1];
    float f3 = this.points[2];
    float f4 = this.points[3];
    this.matrix.setX0(1.0F - f2 * f2 * 2.0F - f3 * f3 * 2.0F);
    this.matrix.setX1(f1 * f2 * 2.0F + f4 * f3 * 2.0F);
    this.matrix.setX2(f1 * f3 * 2.0F - f4 * f2 * 2.0F);
    this.matrix.setX3(0.0F);
    this.matrix.setY0(f1 * f2 * 2.0F - f4 * f3 * 2.0F);
    this.matrix.setY1(1.0F - f1 * f1 * 2.0F - f3 * f3 * 2.0F);
    this.matrix.setY2(f2 * f3 * 2.0F + f4 * f1 * 2.0F);
    this.matrix.setY3(0.0F);
    this.matrix.setZ0(f1 * f3 * 2.0F + f4 * f2 * 2.0F);
    this.matrix.setZ1(f3 * f2 * 2.0F - f4 * f1 * 2.0F);
    this.matrix.setZ2(1.0F - f1 * f1 * 2.0F - f2 * f2 * 2.0F);
    this.matrix.setZ3(0.0F);
    this.matrix.setW0(0.0F);
    this.matrix.setW1(0.0F);
    this.matrix.setW2(0.0F);
    this.matrix.setW3(1.0F);
  }
  
  private void generateQuaternionFromMatrix()
  {
    float[] arrayOfFloat = this.matrix.getMatrix();
    int[] arrayOfInt;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    float f1;
    float f2;
    float f4;
    float f3;
    if (this.matrix.size() == 16) {
      if (this.matrix.isColumnMajor())
      {
        arrayOfInt = MatrixF4x4.matIndCol16_3x3;
        k = arrayOfInt[0];
        m = arrayOfInt[1];
        n = arrayOfInt[2];
        i1 = arrayOfInt[3];
        i2 = arrayOfInt[4];
        i3 = arrayOfInt[5];
        i4 = arrayOfInt[6];
        i5 = arrayOfInt[7];
        i6 = arrayOfInt[8];
        f1 = arrayOfFloat[k] + arrayOfFloat[i2] + arrayOfFloat[i6];
        if (f1 <= 0.0F) {
          break label232;
        }
        f2 = 2.0F * (float)Math.sqrt(f1 + 1.0D);
        f1 = 0.25F * f2;
        f4 = (arrayOfFloat[i5] - arrayOfFloat[i3]) / f2;
        f3 = (arrayOfFloat[n] - arrayOfFloat[i4]) / f2;
        f2 = (arrayOfFloat[i1] - arrayOfFloat[m]) / f2;
      }
    }
    for (;;)
    {
      setX(f4);
      setY(f3);
      setZ(f2);
      setW(f1);
      return;
      arrayOfInt = MatrixF4x4.matIndRow16_3x3;
      break;
      if (this.matrix.isColumnMajor())
      {
        arrayOfInt = MatrixF4x4.matIndCol9_3x3;
        break;
      }
      arrayOfInt = MatrixF4x4.matIndRow9_3x3;
      break;
      label232:
      int i;
      if (arrayOfFloat[k] > arrayOfFloat[i2])
      {
        i = 1;
        label249:
        if (arrayOfFloat[k] <= arrayOfFloat[i6]) {
          break label364;
        }
      }
      float f5;
      label364:
      for (int j = 1;; j = 0)
      {
        if ((i & j) == 0) {
          break label370;
        }
        f2 = 2.0F * (float)Math.sqrt(1.0D + arrayOfFloat[k] - arrayOfFloat[i2] - arrayOfFloat[i6]);
        f1 = (arrayOfFloat[i5] - arrayOfFloat[i3]) / f2;
        f4 = 0.25F * f2;
        f3 = (arrayOfFloat[m] + arrayOfFloat[i1]) / f2;
        f5 = arrayOfFloat[n];
        f2 = (arrayOfFloat[i4] + f5) / f2;
        break;
        i = 0;
        break label249;
      }
      label370:
      if (arrayOfFloat[i2] > arrayOfFloat[i6])
      {
        f2 = 2.0F * (float)Math.sqrt(1.0D + arrayOfFloat[i2] - arrayOfFloat[k] - arrayOfFloat[i6]);
        f1 = (arrayOfFloat[n] - arrayOfFloat[i4]) / f2;
        f4 = (arrayOfFloat[m] + arrayOfFloat[i1]) / f2;
        f3 = 0.25F * f2;
        f5 = arrayOfFloat[i3];
        f2 = (arrayOfFloat[i5] + f5) / f2;
      }
      else
      {
        f2 = 2.0F * (float)Math.sqrt(1.0D + arrayOfFloat[i6] - arrayOfFloat[k] - arrayOfFloat[i2]);
        f1 = (arrayOfFloat[i1] - arrayOfFloat[m]) / f2;
        f4 = (arrayOfFloat[n] + arrayOfFloat[i4]) / f2;
        f3 = (arrayOfFloat[i3] + arrayOfFloat[i5]) / f2;
        f2 *= 0.25F;
      }
    }
  }
  
  public void addQuat(Quaternion paramQuaternion)
  {
    this.dirty = true;
    addQuat(paramQuaternion, this);
  }
  
  public void addQuat(Quaternion paramQuaternion1, Quaternion paramQuaternion2)
  {
    paramQuaternion2.setX(getX() + paramQuaternion1.getX());
    paramQuaternion2.setY(getY() + paramQuaternion1.getY());
    paramQuaternion2.setZ(getZ() + paramQuaternion1.getZ());
    paramQuaternion2.setW(getW() + paramQuaternion1.getW());
  }
  
  public void copyFromVec3(Vector3f paramVector3f, float paramFloat)
  {
    copyFromV3f(paramVector3f, paramFloat);
  }
  
  public MatrixF4x4 getMatrix4x4()
  {
    if (this.dirty)
    {
      convertQuatToMatrix();
      this.dirty = false;
    }
    return this.matrix;
  }
  
  public void loadIdentityQuat()
  {
    this.dirty = true;
    setX(0.0F);
    setY(0.0F);
    setZ(0.0F);
    setW(1.0F);
  }
  
  public void multiplyByQuat(Quaternion paramQuaternion)
  {
    this.dirty = true;
    if (this.tmpQuaternion == null) {
      this.tmpQuaternion = new Quaternion();
    }
    this.tmpQuaternion.copyVec4(this);
    multiplyByQuat(paramQuaternion, this.tmpQuaternion);
    copyVec4(this.tmpQuaternion);
  }
  
  public void multiplyByQuat(Quaternion paramQuaternion1, Quaternion paramQuaternion2)
  {
    if (paramQuaternion1 != paramQuaternion2)
    {
      paramQuaternion2.points[3] = (this.points[3] * paramQuaternion1.points[3] - this.points[0] * paramQuaternion1.points[0] - this.points[1] * paramQuaternion1.points[1] - this.points[2] * paramQuaternion1.points[2]);
      paramQuaternion2.points[0] = (this.points[3] * paramQuaternion1.points[0] + this.points[0] * paramQuaternion1.points[3] + this.points[1] * paramQuaternion1.points[2] - this.points[2] * paramQuaternion1.points[1]);
      paramQuaternion2.points[1] = (this.points[3] * paramQuaternion1.points[1] + this.points[1] * paramQuaternion1.points[3] + this.points[2] * paramQuaternion1.points[0] - this.points[0] * paramQuaternion1.points[2]);
      paramQuaternion2.points[2] = (this.points[3] * paramQuaternion1.points[2] + this.points[2] * paramQuaternion1.points[3] + this.points[0] * paramQuaternion1.points[1] - this.points[1] * paramQuaternion1.points[0]);
      return;
    }
    this.tmpVector.points[0] = paramQuaternion1.points[0];
    this.tmpVector.points[1] = paramQuaternion1.points[1];
    this.tmpVector.points[2] = paramQuaternion1.points[2];
    this.tmpVector.points[3] = paramQuaternion1.points[3];
    paramQuaternion2.points[3] = (this.points[3] * this.tmpVector.points[3] - this.points[0] * this.tmpVector.points[0] - this.points[1] * this.tmpVector.points[1] - this.points[2] * this.tmpVector.points[2]);
    paramQuaternion2.points[0] = (this.points[3] * this.tmpVector.points[0] + this.points[0] * this.tmpVector.points[3] + this.points[1] * this.tmpVector.points[2] - this.points[2] * this.tmpVector.points[1]);
    paramQuaternion2.points[1] = (this.points[3] * this.tmpVector.points[1] + this.points[1] * this.tmpVector.points[3] + this.points[2] * this.tmpVector.points[0] - this.points[0] * this.tmpVector.points[2]);
    paramQuaternion2.points[2] = (this.points[3] * this.tmpVector.points[2] + this.points[2] * this.tmpVector.points[3] + this.points[0] * this.tmpVector.points[1] - this.points[1] * this.tmpVector.points[0]);
  }
  
  public void multiplyByScalar(float paramFloat)
  {
    this.dirty = true;
    multiplyByScalar(paramFloat);
  }
  
  public void normalise()
  {
    this.dirty = true;
    float f = (float)Math.sqrt(this.points[3] * this.points[3] + this.points[0] * this.points[0] + this.points[1] * this.points[1] + this.points[2] * this.points[2]);
    this.points[3] /= f;
    this.points[0] /= f;
    this.points[1] /= f;
    this.points[2] /= f;
  }
  
  public void normalize()
  {
    normalise();
  }
  
  public void set(Quaternion paramQuaternion)
  {
    this.dirty = true;
    copyVec4(paramQuaternion);
  }
  
  public void setAxisAngle(Vector3f paramVector3f, float paramFloat)
  {
    double d = Math.sin(Math.toRadians(paramFloat / 2.0F));
    setX(paramVector3f.getX() * (float)d);
    setY(paramVector3f.getY() * (float)d);
    float f = paramVector3f.getZ();
    setZ((float)d * f);
    setW((float)Math.cos(Math.toRadians(paramFloat / 2.0F)));
    this.dirty = true;
  }
  
  public void setAxisAngleRad(Vector3f paramVector3f, double paramDouble)
  {
    double d = paramDouble / 2.0D;
    setX(paramVector3f.getX() * (float)d);
    setY(paramVector3f.getY() * (float)d);
    float f = paramVector3f.getZ();
    setZ((float)d * f);
    setW((float)paramDouble / 2.0F);
    this.dirty = true;
  }
  
  public void setColumnMajor(float[] paramArrayOfFloat)
  {
    this.matrix.setMatrix(paramArrayOfFloat);
    this.matrix.setColumnMajor(true);
    generateQuaternionFromMatrix();
  }
  
  public void setEulerAngle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d2 = Math.toRadians(paramFloat3);
    double d4 = Math.toRadians(paramFloat2);
    double d6 = Math.toRadians(paramFloat1);
    double d1 = Math.cos(d2 / 2.0D);
    d2 = Math.sin(d2 / 2.0D);
    double d3 = Math.cos(d4 / 2.0D);
    d4 = Math.sin(d4 / 2.0D);
    double d5 = Math.cos(d6 / 2.0D);
    d6 = Math.sin(d6 / 2.0D);
    double d7 = d1 * d3;
    double d8 = d2 * d4;
    setW((float)(d7 * d5 - d8 * d6));
    setX((float)(d7 * d6 + d8 * d5));
    setY((float)(d2 * d3 * d5 + d1 * d4 * d6));
    setZ((float)(d4 * d1 * d5 - d2 * d3 * d6));
    this.dirty = true;
  }
  
  public void setRowMajor(float[] paramArrayOfFloat)
  {
    this.matrix.setMatrix(paramArrayOfFloat);
    this.matrix.setColumnMajor(false);
    generateQuaternionFromMatrix();
  }
  
  public void slerp(Quaternion paramQuaternion1, Quaternion paramQuaternion2, float paramFloat)
  {
    float f2 = dotProduct(paramQuaternion1);
    float f1 = f2;
    Quaternion localQuaternion = paramQuaternion1;
    if (f2 < 0.0F)
    {
      if (this.tmpQuaternion == null) {
        this.tmpQuaternion = new Quaternion();
      }
      localQuaternion = this.tmpQuaternion;
      f1 = -f2;
      localQuaternion.points[0] = (-paramQuaternion1.points[0]);
      localQuaternion.points[1] = (-paramQuaternion1.points[1]);
      localQuaternion.points[2] = (-paramQuaternion1.points[2]);
      localQuaternion.points[3] = (-paramQuaternion1.points[3]);
    }
    if (Math.abs(f1) >= 1.0D)
    {
      paramQuaternion2.points[0] = this.points[0];
      paramQuaternion2.points[1] = this.points[1];
      paramQuaternion2.points[2] = this.points[2];
      paramQuaternion2.points[3] = this.points[3];
      return;
    }
    double d2 = Math.sqrt(1.0D - f1 * f1);
    double d3 = Math.acos(f1);
    double d1 = Math.sin((1.0F - paramFloat) * d3) / d2;
    d2 = Math.sin(d3 * paramFloat) / d2;
    paramQuaternion2.points[3] = ((float)(this.points[3] * d1 + localQuaternion.points[3] * d2));
    paramQuaternion2.points[0] = ((float)(this.points[0] * d1 + localQuaternion.points[0] * d2));
    paramQuaternion2.points[1] = ((float)(this.points[1] * d1 + localQuaternion.points[1] * d2));
    paramQuaternion1 = paramQuaternion2.points;
    d3 = this.points[2];
    paramQuaternion1[2] = ((float)(d2 * localQuaternion.points[2] + d1 * d3));
  }
  
  public void subQuat(Quaternion paramQuaternion)
  {
    this.dirty = true;
    subQuat(paramQuaternion, this);
  }
  
  public void subQuat(Quaternion paramQuaternion1, Quaternion paramQuaternion2)
  {
    paramQuaternion2.setX(getX() - paramQuaternion1.getX());
    paramQuaternion2.setY(getY() - paramQuaternion1.getY());
    paramQuaternion2.setZ(getZ() - paramQuaternion1.getZ());
    paramQuaternion2.setW(getW() - paramQuaternion1.getW());
  }
  
  public void toAxisAngle(Vector4f paramVector4f)
  {
    if (getW() > 1.0F) {
      normalise();
    }
    float f4 = (float)Math.toDegrees(Math.acos(getW()));
    float f1 = (float)Math.sqrt(1.0F - getW() * getW());
    float f3;
    float f2;
    if (f1 < 0.001D)
    {
      f3 = this.points[0];
      f2 = this.points[1];
    }
    for (f1 = this.points[2];; f1 = this.points[2] / f1)
    {
      paramVector4f.points[0] = f3;
      paramVector4f.points[1] = f2;
      paramVector4f.points[2] = f1;
      paramVector4f.points[3] = (2.0F * f4);
      return;
      f3 = this.points[0] / f1;
      f2 = this.points[1] / f1;
    }
  }
  
  public double[] toEulerAngles()
  {
    return new double[] { Math.atan2(this.points[1] * 2.0F * getW() - this.points[0] * 2.0F * this.points[2], 1.0F - this.points[1] * this.points[1] * 2.0F - this.points[2] * this.points[2] * 2.0F), Math.asin(this.points[0] * 2.0F * this.points[1] + this.points[2] * 2.0F * getW()), Math.atan2(this.points[0] * 2.0F * getW() - this.points[1] * 2.0F * this.points[2], 1.0F - this.points[0] * this.points[0] * 2.0F - this.points[2] * this.points[2] * 2.0F) };
  }
  
  public String toString()
  {
    return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.Quaternion
 * JD-Core Version:    0.7.0.1
 */