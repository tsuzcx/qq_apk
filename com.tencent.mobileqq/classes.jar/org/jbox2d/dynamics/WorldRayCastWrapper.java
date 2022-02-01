package org.jbox2d.dynamics;

import org.jbox2d.callbacks.RayCastCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.common.Vec2;

class WorldRayCastWrapper
  implements TreeRayCastCallback
{
  BroadPhase broadPhase;
  RayCastCallback callback;
  private final RayCastOutput output = new RayCastOutput();
  private final Vec2 point = new Vec2();
  private final Vec2 temp = new Vec2();
  
  public float raycastCallback(RayCastInput paramRayCastInput, int paramInt)
  {
    FixtureProxy localFixtureProxy = (FixtureProxy)this.broadPhase.getUserData(paramInt);
    Fixture localFixture = localFixtureProxy.fixture;
    paramInt = localFixtureProxy.childIndex;
    if (localFixture.raycast(this.output, paramRayCastInput, paramInt))
    {
      float f = this.output.fraction;
      this.temp.set(paramRayCastInput.p2).mulLocal(f);
      this.point.set(paramRayCastInput.p1).mulLocal(1.0F - f).addLocal(this.temp);
      return this.callback.reportFixture(localFixture, this.point, this.output.normal, f);
    }
    return paramRayCastInput.maxFraction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.WorldRayCastWrapper
 * JD-Core Version:    0.7.0.1
 */