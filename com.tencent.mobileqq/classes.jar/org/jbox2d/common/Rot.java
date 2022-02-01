package org.jbox2d.common;

import java.io.Serializable;

public class Rot
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public float c;
  public float s;
  
  public Rot()
  {
    setIdentity();
  }
  
  public Rot(float paramFloat)
  {
    set(paramFloat);
  }
  
  public static final void mul(Rot paramRot1, Rot paramRot2, Rot paramRot3)
  {
    float f1 = paramRot1.c;
    float f2 = paramRot2.c;
    float f3 = paramRot1.s;
    float f4 = paramRot2.s;
    paramRot3.s = (f3 * f2 + f1 * f4);
    paramRot3.c = (f1 * f2 - f3 * f4);
  }
  
  public static final void mulToOut(Rot paramRot, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramRot.s;
    float f2 = paramVec21.x;
    float f3 = paramRot.c;
    float f4 = paramVec21.y;
    paramVec22.x = (paramRot.c * paramVec21.x - paramRot.s * paramVec21.y);
    paramVec22.y = (f1 * f2 + f3 * f4);
  }
  
  public static final void mulToOutUnsafe(Rot paramRot, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (paramRot.c * paramVec21.x - paramRot.s * paramVec21.y);
    paramVec22.y = (paramRot.s * paramVec21.x + paramRot.c * paramVec21.y);
  }
  
  public static final void mulTrans(Rot paramRot1, Rot paramRot2, Rot paramRot3)
  {
    float f1 = paramRot1.c;
    float f2 = paramRot2.c;
    float f3 = paramRot1.s;
    float f4 = paramRot2.s;
    paramRot3.s = (f1 * f4 - f3 * f2);
    paramRot3.c = (f1 * f2 + f3 * f4);
  }
  
  public static final void mulTrans(Rot paramRot, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = -paramRot.s;
    float f2 = paramVec21.x;
    float f3 = paramRot.c;
    float f4 = paramVec21.y;
    paramVec22.x = (paramRot.c * paramVec21.x + paramRot.s * paramVec21.y);
    paramVec22.y = (f1 * f2 + f3 * f4);
  }
  
  public static final void mulTransUnsafe(Rot paramRot1, Rot paramRot2, Rot paramRot3)
  {
    float f1 = paramRot1.c;
    float f2 = paramRot2.s;
    float f3 = paramRot1.s;
    float f4 = paramRot2.c;
    paramRot3.s = (f2 * f1 - f3 * f4);
    paramRot3.c = (f1 * f4 + paramRot1.s * paramRot2.s);
  }
  
  public static final void mulTransUnsafe(Rot paramRot, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (paramRot.c * paramVec21.x + paramRot.s * paramVec21.y);
    paramVec22.y = (-paramRot.s * paramVec21.x + paramRot.c * paramVec21.y);
  }
  
  public static final void mulUnsafe(Rot paramRot1, Rot paramRot2, Rot paramRot3)
  {
    float f1 = paramRot1.s;
    float f2 = paramRot2.c;
    float f3 = paramRot1.c;
    paramRot3.s = (f1 * f2 + paramRot2.s * f3);
    paramRot3.c = (f3 * f2 - paramRot1.s * paramRot2.s);
  }
  
  public Rot clone()
  {
    Rot localRot = new Rot();
    localRot.s = this.s;
    localRot.c = this.c;
    return localRot;
  }
  
  public float getAngle()
  {
    return MathUtils.atan2(this.s, this.c);
  }
  
  public float getCos()
  {
    return this.c;
  }
  
  public float getSin()
  {
    return this.s;
  }
  
  public void getXAxis(Vec2 paramVec2)
  {
    paramVec2.set(this.c, this.s);
  }
  
  public void getYAxis(Vec2 paramVec2)
  {
    paramVec2.set(-this.s, this.c);
  }
  
  public Rot set(float paramFloat)
  {
    this.s = MathUtils.sin(paramFloat);
    this.c = MathUtils.cos(paramFloat);
    return this;
  }
  
  public Rot set(Rot paramRot)
  {
    this.s = paramRot.s;
    this.c = paramRot.c;
    return this;
  }
  
  public Rot setIdentity()
  {
    this.s = 0.0F;
    this.c = 1.0F;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Rot(s:");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", c:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Rot
 * JD-Core Version:    0.7.0.1
 */