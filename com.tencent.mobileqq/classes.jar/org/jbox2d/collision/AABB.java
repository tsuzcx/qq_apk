package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.IWorldPool;
import org.jbox2d.pooling.normal.DefaultWorldPool;

public class AABB
{
  public final Vec2 lowerBound;
  public final Vec2 upperBound;
  
  public AABB()
  {
    this.lowerBound = new Vec2();
    this.upperBound = new Vec2();
  }
  
  public AABB(AABB paramAABB)
  {
    this(paramAABB.lowerBound, paramAABB.upperBound);
  }
  
  public AABB(Vec2 paramVec21, Vec2 paramVec22)
  {
    this.lowerBound = paramVec21.clone();
    this.upperBound = paramVec22.clone();
  }
  
  public static final boolean testOverlap(AABB paramAABB1, AABB paramAABB2)
  {
    if (paramAABB2.lowerBound.x - paramAABB1.upperBound.x <= 0.0F)
    {
      if (paramAABB2.lowerBound.y - paramAABB1.upperBound.y > 0.0F) {
        return false;
      }
      if (paramAABB1.lowerBound.x - paramAABB2.upperBound.x <= 0.0F) {
        return paramAABB1.lowerBound.y - paramAABB2.upperBound.y <= 0.0F;
      }
    }
    return false;
  }
  
  public final void combine(AABB paramAABB)
  {
    Vec2 localVec22 = this.lowerBound;
    if (localVec22.x < paramAABB.lowerBound.x) {
      localVec21 = this.lowerBound;
    } else {
      localVec21 = paramAABB.lowerBound;
    }
    localVec22.x = localVec21.x;
    localVec22 = this.lowerBound;
    if (localVec22.y < paramAABB.lowerBound.y) {
      localVec21 = this.lowerBound;
    } else {
      localVec21 = paramAABB.lowerBound;
    }
    localVec22.y = localVec21.y;
    localVec22 = this.upperBound;
    if (localVec22.x > paramAABB.upperBound.x) {
      localVec21 = this.upperBound;
    } else {
      localVec21 = paramAABB.upperBound;
    }
    localVec22.x = localVec21.x;
    Vec2 localVec21 = this.upperBound;
    if (localVec21.y > paramAABB.upperBound.y) {
      paramAABB = this.upperBound;
    } else {
      paramAABB = paramAABB.upperBound;
    }
    localVec21.y = paramAABB.y;
  }
  
  public final void combine(AABB paramAABB1, AABB paramAABB2)
  {
    Vec2 localVec22 = this.lowerBound;
    if (paramAABB1.lowerBound.x < paramAABB2.lowerBound.x) {
      localVec21 = paramAABB1.lowerBound;
    } else {
      localVec21 = paramAABB2.lowerBound;
    }
    localVec22.x = localVec21.x;
    localVec22 = this.lowerBound;
    if (paramAABB1.lowerBound.y < paramAABB2.lowerBound.y) {
      localVec21 = paramAABB1.lowerBound;
    } else {
      localVec21 = paramAABB2.lowerBound;
    }
    localVec22.y = localVec21.y;
    localVec22 = this.upperBound;
    if (paramAABB1.upperBound.x > paramAABB2.upperBound.x) {
      localVec21 = paramAABB1.upperBound;
    } else {
      localVec21 = paramAABB2.upperBound;
    }
    localVec22.x = localVec21.x;
    Vec2 localVec21 = this.upperBound;
    if (paramAABB1.upperBound.y > paramAABB2.upperBound.y) {
      paramAABB1 = paramAABB1.upperBound;
    } else {
      paramAABB1 = paramAABB2.upperBound;
    }
    localVec21.y = paramAABB1.y;
  }
  
  public final boolean contains(AABB paramAABB)
  {
    return (this.lowerBound.x > paramAABB.lowerBound.x) && (this.lowerBound.y > paramAABB.lowerBound.y) && (paramAABB.upperBound.x > this.upperBound.x) && (paramAABB.upperBound.y > this.upperBound.y);
  }
  
  public final Vec2 getCenter()
  {
    Vec2 localVec2 = new Vec2(this.lowerBound);
    localVec2.addLocal(this.upperBound);
    localVec2.mulLocal(0.5F);
    return localVec2;
  }
  
  public final void getCenterToOut(Vec2 paramVec2)
  {
    paramVec2.x = ((this.lowerBound.x + this.upperBound.x) * 0.5F);
    paramVec2.y = ((this.lowerBound.y + this.upperBound.y) * 0.5F);
  }
  
  public final Vec2 getExtents()
  {
    Vec2 localVec2 = new Vec2(this.upperBound);
    localVec2.subLocal(this.lowerBound);
    localVec2.mulLocal(0.5F);
    return localVec2;
  }
  
  public final void getExtentsToOut(Vec2 paramVec2)
  {
    paramVec2.x = ((this.upperBound.x - this.lowerBound.x) * 0.5F);
    paramVec2.y = ((this.upperBound.y - this.lowerBound.y) * 0.5F);
  }
  
  public final float getPerimeter()
  {
    return (this.upperBound.x - this.lowerBound.x + this.upperBound.y - this.lowerBound.y) * 2.0F;
  }
  
  public final void getVertices(Vec2[] paramArrayOfVec2)
  {
    paramArrayOfVec2[0].set(this.lowerBound);
    paramArrayOfVec2[1].set(this.lowerBound);
    Vec2 localVec2 = paramArrayOfVec2[1];
    localVec2.x += this.upperBound.x - this.lowerBound.x;
    paramArrayOfVec2[2].set(this.upperBound);
    paramArrayOfVec2[3].set(this.upperBound);
    paramArrayOfVec2 = paramArrayOfVec2[3];
    paramArrayOfVec2.x -= this.upperBound.x - this.lowerBound.x;
  }
  
  public final boolean isValid()
  {
    float f1 = this.upperBound.x;
    float f2 = this.lowerBound.x;
    boolean bool2 = false;
    if (f1 - f2 < 0.0F) {
      return false;
    }
    if (this.upperBound.y - this.lowerBound.y < 0.0F) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.lowerBound.isValid())
    {
      bool1 = bool2;
      if (this.upperBound.isValid()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput)
  {
    return raycast(paramRayCastOutput, paramRayCastInput, new DefaultWorldPool(4, 4));
  }
  
  public final boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, IWorldPool paramIWorldPool)
  {
    Vec2 localVec21 = paramIWorldPool.popVec2();
    Vec2 localVec22 = paramIWorldPool.popVec2();
    Vec2 localVec23 = paramIWorldPool.popVec2();
    Vec2 localVec24 = paramIWorldPool.popVec2();
    localVec21.set(paramRayCastInput.p1);
    localVec22.set(paramRayCastInput.p2).subLocal(paramRayCastInput.p1);
    Vec2.absToOut(localVec22, localVec23);
    float f1 = localVec23.x;
    float f2 = -3.402824E+038F;
    float f4 = 3.4028235E+38F;
    float f3;
    float f5;
    if (f1 < 1.192093E-007F)
    {
      if (localVec21.x >= this.lowerBound.x)
      {
        f1 = f2;
        if (this.upperBound.x >= localVec21.x) {}
      }
      else
      {
        paramIWorldPool.pushVec2(4);
        return false;
      }
    }
    else
    {
      f3 = 1.0F / localVec22.x;
      f1 = (this.lowerBound.x - localVec21.x) * f3;
      f4 = f3 * (this.upperBound.x - localVec21.x);
      if (f1 > f4)
      {
        f3 = f1;
        f5 = 1.0F;
        f1 = f4;
        f4 = f5;
      }
      else
      {
        f3 = f4;
        f4 = -1.0F;
      }
      if (f1 > -3.402824E+038F)
      {
        localVec24.setZero();
        localVec24.x = f4;
        f2 = f1;
      }
      f3 = MathUtils.min(3.4028235E+38F, f3);
      f1 = f2;
      f4 = f3;
      if (f2 > f3)
      {
        paramIWorldPool.pushVec2(4);
        return false;
      }
    }
    if (localVec23.y < 1.192093E-007F)
    {
      if ((localVec21.y < this.lowerBound.y) || (this.upperBound.y < localVec21.y))
      {
        paramIWorldPool.pushVec2(4);
        return false;
      }
    }
    else
    {
      f2 = localVec22.y;
      float f6 = 1.0F;
      f2 = 1.0F / f2;
      f5 = (this.lowerBound.y - localVec21.y) * f2;
      f2 = (this.upperBound.y - localVec21.y) * f2;
      if (f5 <= f2)
      {
        f6 = -1.0F;
        f3 = f5;
        f5 = f2;
        f2 = f3;
      }
      f3 = f1;
      if (f2 > f1)
      {
        localVec24.setZero();
        localVec24.y = f6;
        f3 = f2;
      }
      f1 = f3;
      if (f3 > MathUtils.min(f4, f5))
      {
        paramIWorldPool.pushVec2(4);
        return false;
      }
    }
    if ((f1 >= 0.0F) && (paramRayCastInput.maxFraction >= f1))
    {
      paramRayCastOutput.fraction = f1;
      paramRayCastOutput.normal.x = localVec24.x;
      paramRayCastOutput.normal.y = localVec24.y;
      paramIWorldPool.pushVec2(4);
      return true;
    }
    paramIWorldPool.pushVec2(4);
    return false;
  }
  
  public final void set(AABB paramAABB)
  {
    Vec2 localVec2 = paramAABB.lowerBound;
    this.lowerBound.x = localVec2.x;
    this.lowerBound.y = localVec2.y;
    paramAABB = paramAABB.upperBound;
    this.upperBound.x = paramAABB.x;
    this.upperBound.y = paramAABB.y;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AABB[");
    localStringBuilder.append(this.lowerBound);
    localStringBuilder.append(" . ");
    localStringBuilder.append(this.upperBound);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.AABB
 * JD-Core Version:    0.7.0.1
 */