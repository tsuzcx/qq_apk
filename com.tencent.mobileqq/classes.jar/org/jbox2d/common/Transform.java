package org.jbox2d.common;

import java.io.Serializable;

public class Transform
  implements Serializable
{
  private static Vec2 pool = new Vec2();
  private static final long serialVersionUID = 1L;
  public final Vec2 p;
  public final Rot q;
  
  public Transform()
  {
    this.p = new Vec2();
    this.q = new Rot();
  }
  
  public Transform(Transform paramTransform)
  {
    this.p = paramTransform.p.clone();
    this.q = paramTransform.q.clone();
  }
  
  public Transform(Vec2 paramVec2, Rot paramRot)
  {
    this.p = paramVec2.clone();
    this.q = paramRot.clone();
  }
  
  public static final Transform mul(Transform paramTransform1, Transform paramTransform2)
  {
    Transform localTransform = new Transform();
    Rot.mulUnsafe(paramTransform1.q, paramTransform2.q, localTransform.q);
    Rot.mulToOutUnsafe(paramTransform1.q, paramTransform2.p, localTransform.p);
    localTransform.p.addLocal(paramTransform1.p);
    return localTransform;
  }
  
  public static final Vec2 mul(Transform paramTransform, Vec2 paramVec2)
  {
    return new Vec2(paramTransform.q.c * paramVec2.x - paramTransform.q.s * paramVec2.y + paramTransform.p.x, paramTransform.q.s * paramVec2.x + paramTransform.q.c * paramVec2.y + paramTransform.p.y);
  }
  
  public static final void mulToOut(Transform paramTransform1, Transform paramTransform2, Transform paramTransform3)
  {
    Rot.mul(paramTransform1.q, paramTransform2.q, paramTransform3.q);
    Rot.mulToOut(paramTransform1.q, paramTransform2.p, paramTransform3.p);
    paramTransform3.p.addLocal(paramTransform1.p);
  }
  
  public static final void mulToOut(Transform paramTransform, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramTransform.q.s;
    float f2 = paramVec21.x;
    float f3 = paramTransform.q.c;
    float f4 = paramVec21.y;
    float f5 = paramTransform.p.y;
    paramVec22.x = (paramTransform.q.c * paramVec21.x - paramTransform.q.s * paramVec21.y + paramTransform.p.x);
    paramVec22.y = (f1 * f2 + f3 * f4 + f5);
  }
  
  public static final void mulToOutUnsafe(Transform paramTransform1, Transform paramTransform2, Transform paramTransform3)
  {
    Rot.mulUnsafe(paramTransform1.q, paramTransform2.q, paramTransform3.q);
    Rot.mulToOutUnsafe(paramTransform1.q, paramTransform2.p, paramTransform3.p);
    paramTransform3.p.addLocal(paramTransform1.p);
  }
  
  public static final void mulToOutUnsafe(Transform paramTransform, Vec2 paramVec21, Vec2 paramVec22)
  {
    paramVec22.x = (paramTransform.q.c * paramVec21.x - paramTransform.q.s * paramVec21.y + paramTransform.p.x);
    paramVec22.y = (paramTransform.q.s * paramVec21.x + paramTransform.q.c * paramVec21.y + paramTransform.p.y);
  }
  
  public static final Transform mulTrans(Transform paramTransform1, Transform paramTransform2)
  {
    Transform localTransform = new Transform();
    Rot.mulTransUnsafe(paramTransform1.q, paramTransform2.q, localTransform.q);
    pool.set(paramTransform2.p).subLocal(paramTransform1.p);
    Rot.mulTransUnsafe(paramTransform1.q, pool, localTransform.p);
    return localTransform;
  }
  
  public static final Vec2 mulTrans(Transform paramTransform, Vec2 paramVec2)
  {
    float f1 = paramVec2.x - paramTransform.p.x;
    float f2 = paramVec2.y - paramTransform.p.y;
    return new Vec2(paramTransform.q.c * f1 + paramTransform.q.s * f2, -paramTransform.q.s * f1 + paramTransform.q.c * f2);
  }
  
  public static final void mulTransToOut(Transform paramTransform1, Transform paramTransform2, Transform paramTransform3)
  {
    Rot.mulTrans(paramTransform1.q, paramTransform2.q, paramTransform3.q);
    pool.set(paramTransform2.p).subLocal(paramTransform1.p);
    Rot.mulTrans(paramTransform1.q, pool, paramTransform3.p);
  }
  
  public static final void mulTransToOut(Transform paramTransform, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x - paramTransform.p.x;
    float f2 = paramVec21.y - paramTransform.p.y;
    float f3 = -paramTransform.q.s;
    float f4 = paramTransform.q.c;
    paramVec22.x = (paramTransform.q.c * f1 + paramTransform.q.s * f2);
    paramVec22.y = (f3 * f1 + f4 * f2);
  }
  
  public static final void mulTransToOutUnsafe(Transform paramTransform1, Transform paramTransform2, Transform paramTransform3)
  {
    Rot.mulTransUnsafe(paramTransform1.q, paramTransform2.q, paramTransform3.q);
    pool.set(paramTransform2.p).subLocal(paramTransform1.p);
    Rot.mulTransUnsafe(paramTransform1.q, pool, paramTransform3.p);
  }
  
  public static final void mulTransToOutUnsafe(Transform paramTransform, Vec2 paramVec21, Vec2 paramVec22)
  {
    float f1 = paramVec21.x - paramTransform.p.x;
    float f2 = paramVec21.y - paramTransform.p.y;
    paramVec22.x = (paramTransform.q.c * f1 + paramTransform.q.s * f2);
    paramVec22.y = (-paramTransform.q.s * f1 + paramTransform.q.c * f2);
  }
  
  public final Transform set(Transform paramTransform)
  {
    this.p.set(paramTransform.p);
    this.q.set(paramTransform.q);
    return this;
  }
  
  public final void set(Vec2 paramVec2, float paramFloat)
  {
    this.p.set(paramVec2);
    this.q.set(paramFloat);
  }
  
  public final void setIdentity()
  {
    this.p.setZero();
    this.q.setIdentity();
  }
  
  public final String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("XForm:\n");
    ((StringBuilder)localObject).append("Position: ");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("R: \n");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Transform
 * JD-Core Version:    0.7.0.1
 */