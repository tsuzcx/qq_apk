package org.jbox2d.dynamics;

import org.jbox2d.callbacks.QueryCallback;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.collision.broadphase.BroadPhase;

class WorldQueryWrapper
  implements TreeCallback
{
  BroadPhase broadPhase;
  QueryCallback callback;
  
  public boolean treeCallback(int paramInt)
  {
    FixtureProxy localFixtureProxy = (FixtureProxy)this.broadPhase.getUserData(paramInt);
    return this.callback.reportFixture(localFixtureProxy.fixture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.WorldQueryWrapper
 * JD-Core Version:    0.7.0.1
 */