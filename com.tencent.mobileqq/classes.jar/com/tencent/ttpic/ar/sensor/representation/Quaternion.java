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
    float f4 = this.points[0];
    float f6 = this.points[1];
    float f7 = this.points[2];
    float f5 = this.points[3];
    MatrixF4x4 localMatrixF4x4 = this.matrix;
    float f1 = f6 * f6 * 2.0F;
    float f8 = f7 * f7 * 2.0F;
    localMatrixF4x4.setX0(1.0F - f1 - f8);
    localMatrixF4x4 = this.matrix;
    float f9 = f4 * f6 * 2.0F;
    float f10 = f5 * f7 * 2.0F;
    localMatrixF4x4.setX1(f9 + f10);
    localMatrixF4x4 = this.matrix;
    float f2 = f4 * f7 * 2.0F;
    float f3 = f5 * f6 * 2.0F;
    localMatrixF4x4.setX2(f2 - f3);
    this.matrix.setX3(0.0F);
    this.matrix.setY0(f9 - f10);
    localMatrixF4x4 = this.matrix;
    f9 = 1.0F - f4 * f4 * 2.0F;
    localMatrixF4x4.setY1(f9 - f8);
    localMatrixF4x4 = this.matrix;
    f6 = f6 * f7 * 2.0F;
    f4 = f5 * f4 * 2.0F;
    localMatrixF4x4.setY2(f6 + f4);
    this.matrix.setY3(0.0F);
    this.matrix.setZ0(f2 + f3);
    this.matrix.setZ1(f6 - f4);
    this.matrix.setZ2(f9 - f1);
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
    if (this.matrix.size() == 16)
    {
      if (this.matrix.isColumnMajor()) {
        arrayOfInt = MatrixF4x4.matIndCol16_3x3;
      } else {
        arrayOfInt = MatrixF4x4.matIndRow16_3x3;
      }
    }
    else if (this.matrix.isColumnMajor()) {
      arrayOfInt = MatrixF4x4.matIndCol9_3x3;
    } else {
      arrayOfInt = MatrixF4x4.matIndRow9_3x3;
    }
    int j = 0;
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    int n = arrayOfInt[2];
    int i1 = arrayOfInt[3];
    int i2 = arrayOfInt[4];
    int i3 = arrayOfInt[5];
    int i4 = arrayOfInt[6];
    int i5 = arrayOfInt[7];
    int i6 = arrayOfInt[8];
    float f1 = arrayOfFloat[k] + arrayOfFloat[i2] + arrayOfFloat[i6];
    double d1;
    float f3;
    float f2;
    float f4;
    if (f1 > 0.0F)
    {
      d1 = f1;
      Double.isNaN(d1);
      f3 = (float)Math.sqrt(d1 + 1.0D) * 2.0F;
      f2 = (arrayOfFloat[i5] - arrayOfFloat[i3]) / f3;
      f1 = (arrayOfFloat[n] - arrayOfFloat[i4]) / f3;
      f4 = (arrayOfFloat[i1] - arrayOfFloat[m]) / f3;
      f3 = 0.25F * f3;
    }
    else
    {
      int i;
      if (arrayOfFloat[k] > arrayOfFloat[i2]) {
        i = 1;
      } else {
        i = 0;
      }
      if (arrayOfFloat[k] > arrayOfFloat[i6]) {
        j = 1;
      }
      float f5;
      float f6;
      if ((j & i) != 0)
      {
        d1 = arrayOfFloat[k];
        Double.isNaN(d1);
        d2 = arrayOfFloat[i2];
        Double.isNaN(d2);
        d3 = arrayOfFloat[i6];
        Double.isNaN(d3);
        f5 = (float)Math.sqrt(d1 + 1.0D - d2 - d3) * 2.0F;
        f3 = (arrayOfFloat[i5] - arrayOfFloat[i3]) / f5;
        f2 = f5 * 0.25F;
        f1 = (arrayOfFloat[m] + arrayOfFloat[i1]) / f5;
        f6 = arrayOfFloat[n];
      }
      for (f4 = arrayOfFloat[i4];; f4 = arrayOfFloat[i5])
      {
        f4 = (f6 + f4) / f5;
        break label635;
        if (arrayOfFloat[i2] <= arrayOfFloat[i6]) {
          break;
        }
        d1 = arrayOfFloat[i2];
        Double.isNaN(d1);
        d2 = arrayOfFloat[k];
        Double.isNaN(d2);
        d3 = arrayOfFloat[i6];
        Double.isNaN(d3);
        f5 = (float)Math.sqrt(d1 + 1.0D - d2 - d3) * 2.0F;
        f3 = (arrayOfFloat[n] - arrayOfFloat[i4]) / f5;
        f2 = (arrayOfFloat[m] + arrayOfFloat[i1]) / f5;
        f1 = f5 * 0.25F;
        f6 = arrayOfFloat[i3];
      }
      d1 = arrayOfFloat[i6];
      Double.isNaN(d1);
      double d2 = arrayOfFloat[k];
      Double.isNaN(d2);
      double d3 = arrayOfFloat[i2];
      Double.isNaN(d3);
      f4 = (float)Math.sqrt(d1 + 1.0D - d2 - d3) * 2.0F;
      f3 = (arrayOfFloat[i1] - arrayOfFloat[m]) / f4;
      f2 = (arrayOfFloat[n] + arrayOfFloat[i4]) / f4;
      f1 = (arrayOfFloat[i3] + arrayOfFloat[i5]) / f4;
      f4 *= 0.25F;
    }
    label635:
    setX(f2);
    setY(f1);
    setZ(f4);
    setW(f3);
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
    double d1 = paramFloat / 2.0F;
    double d2 = Math.sin(Math.toRadians(d1));
    paramFloat = paramVector3f.getX();
    float f = (float)d2;
    setX(paramFloat * f);
    setY(paramVector3f.getY() * f);
    setZ(paramVector3f.getZ() * f);
    setW((float)Math.cos(Math.toRadians(d1)));
    this.dirty = true;
  }
  
  public void setAxisAngleRad(Vector3f paramVector3f, double paramDouble)
  {
    double d = paramDouble / 2.0D;
    float f1 = paramVector3f.getX();
    float f2 = (float)d;
    setX(f1 * f2);
    setY(paramVector3f.getY() * f2);
    setZ(paramVector3f.getZ() * f2);
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
    double d1 = Math.toRadians(paramFloat3);
    double d3 = Math.toRadians(paramFloat2);
    double d5 = Math.toRadians(paramFloat1);
    double d2 = d1 / 2.0D;
    d1 = Math.cos(d2);
    d2 = Math.sin(d2);
    double d4 = d3 / 2.0D;
    d3 = Math.cos(d4);
    d4 = Math.sin(d4);
    double d6 = d5 / 2.0D;
    d5 = Math.cos(d6);
    d6 = Math.sin(d6);
    double d7 = d1 * d3;
    double d8 = d2 * d4;
    setW((float)(d7 * d5 - d8 * d6));
    setX((float)(d7 * d6 + d8 * d5));
    d2 *= d3;
    d1 *= d4;
    setY((float)(d2 * d5 + d1 * d6));
    setZ((float)(d1 * d5 - d2 * d6));
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
    Object localObject = paramQuaternion1;
    float f2 = dotProduct(paramQuaternion1);
    paramQuaternion1 = (Quaternion)localObject;
    float f1 = f2;
    if (f2 < 0.0F)
    {
      if (this.tmpQuaternion == null) {
        this.tmpQuaternion = new Quaternion();
      }
      paramQuaternion1 = this.tmpQuaternion;
      f1 = -f2;
      paramQuaternion1.points[0] = (-localObject.points[0]);
      paramQuaternion1.points[1] = (-localObject.points[1]);
      paramQuaternion1.points[2] = (-localObject.points[2]);
      paramQuaternion1.points[3] = (-localObject.points[3]);
    }
    if (Math.abs(f1) >= 1.0D)
    {
      paramQuaternion2.points[0] = this.points[0];
      paramQuaternion2.points[1] = this.points[1];
      paramQuaternion2.points[2] = this.points[2];
      paramQuaternion2.points[3] = this.points[3];
      return;
    }
    double d1 = f1 * f1;
    Double.isNaN(d1);
    double d2 = Math.sqrt(1.0D - d1);
    double d3 = Math.acos(f1);
    d1 = 1.0F - paramFloat;
    Double.isNaN(d1);
    d1 = Math.sin(d1 * d3) / d2;
    double d4 = paramFloat;
    Double.isNaN(d4);
    d2 = Math.sin(d4 * d3) / d2;
    localObject = paramQuaternion2.points;
    d3 = this.points[3];
    Double.isNaN(d3);
    d4 = paramQuaternion1.points[3];
    Double.isNaN(d4);
    localObject[3] = ((float)(d3 * d1 + d4 * d2));
    localObject = paramQuaternion2.points;
    d3 = this.points[0];
    Double.isNaN(d3);
    d4 = paramQuaternion1.points[0];
    Double.isNaN(d4);
    localObject[0] = ((float)(d3 * d1 + d4 * d2));
    localObject = paramQuaternion2.points;
    d3 = this.points[1];
    Double.isNaN(d3);
    d4 = paramQuaternion1.points[1];
    Double.isNaN(d4);
    localObject[1] = ((float)(d3 * d1 + d4 * d2));
    paramQuaternion2 = paramQuaternion2.points;
    d3 = this.points[2];
    Double.isNaN(d3);
    d4 = paramQuaternion1.points[2];
    Double.isNaN(d4);
    paramQuaternion2[2] = ((float)(d3 * d1 + d4 * d2));
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
    float f3 = (float)Math.sqrt(1.0F - getW() * getW());
    float f1;
    float f2;
    if (f3 < 0.001D)
    {
      f1 = this.points[0];
      f2 = this.points[1];
      f3 = this.points[2];
    }
    else
    {
      f1 = this.points[0] / f3;
      f2 = this.points[1] / f3;
      f3 = this.points[2] / f3;
    }
    paramVector4f.points[0] = f1;
    paramVector4f.points[1] = f2;
    paramVector4f.points[2] = f3;
    paramVector4f.points[3] = (f4 * 2.0F);
  }
  
  public double[] toEulerAngles()
  {
    return new double[] { Math.atan2(this.points[1] * 2.0F * getW() - this.points[0] * 2.0F * this.points[2], 1.0F - this.points[1] * this.points[1] * 2.0F - this.points[2] * this.points[2] * 2.0F), Math.asin(this.points[0] * 2.0F * this.points[1] + this.points[2] * 2.0F * getW()), Math.atan2(this.points[0] * 2.0F * getW() - this.points[1] * 2.0F * this.points[2], 1.0F - this.points[0] * this.points[0] * 2.0F - this.points[2] * this.points[2] * 2.0F) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{X: ");
    localStringBuilder.append(getX());
    localStringBuilder.append(", Y:");
    localStringBuilder.append(getY());
    localStringBuilder.append(", Z:");
    localStringBuilder.append(getZ());
    localStringBuilder.append(", W:");
    localStringBuilder.append(getW());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.Quaternion
 * JD-Core Version:    0.7.0.1
 */