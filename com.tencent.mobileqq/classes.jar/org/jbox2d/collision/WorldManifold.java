package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public class WorldManifold
{
  public final Vec2 normal = new Vec2();
  public final Vec2[] points = new Vec2[2];
  private final Vec2 pool3 = new Vec2();
  private final Vec2 pool4 = new Vec2();
  
  public WorldManifold()
  {
    int i = 0;
    while (i < 2)
    {
      this.points[i] = new Vec2();
      i += 1;
    }
  }
  
  public final void initialize(Manifold paramManifold, Transform paramTransform1, float paramFloat1, Transform paramTransform2, float paramFloat2)
  {
    if (paramManifold.pointCount == 0) {
      return;
    }
    int k = WorldManifold.1.$SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[paramManifold.type.ordinal()];
    int j = 0;
    int i = 0;
    if (k != 1)
    {
      float f9;
      if (k != 2)
      {
        if (k != 3) {
          return;
        }
        localVec21 = this.pool3;
        Rot.mulToOutUnsafe(paramTransform2.q, paramManifold.localNormal, this.normal);
        Transform.mulToOut(paramTransform2, paramManifold.localPoint, localVec21);
        paramTransform2 = this.pool4;
        while (i < paramManifold.pointCount)
        {
          Transform.mulToOut(paramTransform1, paramManifold.points[i].localPoint, paramTransform2);
          f1 = paramFloat2 - ((paramTransform2.x - localVec21.x) * this.normal.x + (paramTransform2.y - localVec21.y) * this.normal.y);
          f2 = this.normal.x;
          f3 = paramTransform2.x;
          f4 = this.normal.y;
          f5 = paramTransform2.y;
          f6 = -this.normal.x;
          f7 = paramTransform2.x;
          f8 = -this.normal.y;
          f9 = paramTransform2.y;
          localObject = this.points;
          localObject[i].x = ((f6 * paramFloat1 + f7 + (f2 * f1 + f3)) * 0.5F);
          localObject[i].y = ((f8 * paramFloat1 + f9 + (f4 * f1 + f5)) * 0.5F);
          i += 1;
        }
        paramManifold = this.normal;
        paramManifold.x = (-paramManifold.x);
        paramManifold = this.normal;
        paramManifold.y = (-paramManifold.y);
        return;
      }
      localVec21 = this.pool3;
      Rot.mulToOutUnsafe(paramTransform1.q, paramManifold.localNormal, this.normal);
      Transform.mulToOut(paramTransform1, paramManifold.localPoint, localVec21);
      paramTransform1 = this.pool4;
      i = j;
      while (i < paramManifold.pointCount)
      {
        Transform.mulToOut(paramTransform2, paramManifold.points[i].localPoint, paramTransform1);
        f1 = paramFloat1 - ((paramTransform1.x - localVec21.x) * this.normal.x + (paramTransform1.y - localVec21.y) * this.normal.y);
        f2 = this.normal.x;
        f3 = paramTransform1.x;
        f4 = this.normal.y;
        f5 = paramTransform1.y;
        f6 = -this.normal.x;
        f7 = paramTransform1.x;
        f8 = -this.normal.y;
        f9 = paramTransform1.y;
        localObject = this.points;
        localObject[i].x = ((f2 * f1 + f3 + (f6 * paramFloat2 + f7)) * 0.5F);
        localObject[i].y = ((f4 * f1 + f5 + (f8 * paramFloat2 + f9)) * 0.5F);
        i += 1;
      }
    }
    Vec2 localVec21 = this.pool3;
    Object localObject = this.pool4;
    Vec2 localVec22 = this.normal;
    localVec22.x = 1.0F;
    localVec22.y = 0.0F;
    Transform.mulToOut(paramTransform1, paramManifold.localPoint, localVec21);
    Transform.mulToOut(paramTransform2, paramManifold.points[0].localPoint, (Vec2)localObject);
    if (MathUtils.distanceSquared(localVec21, (Vec2)localObject) > 1.421086E-014F)
    {
      this.normal.x = (((Vec2)localObject).x - localVec21.x);
      this.normal.y = (((Vec2)localObject).y - localVec21.y);
      this.normal.normalize();
    }
    float f1 = this.normal.x;
    float f2 = localVec21.x;
    float f3 = this.normal.y;
    float f4 = localVec21.y;
    float f5 = -this.normal.x;
    float f6 = ((Vec2)localObject).x;
    float f7 = -this.normal.y;
    float f8 = ((Vec2)localObject).y;
    paramManifold = this.points;
    paramManifold[0].x = ((f1 * paramFloat1 + f2 + (f5 * paramFloat2 + f6)) * 0.5F);
    paramManifold[0].y = ((f3 * paramFloat1 + f4 + (f7 * paramFloat2 + f8)) * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.WorldManifold
 * JD-Core Version:    0.7.0.1
 */