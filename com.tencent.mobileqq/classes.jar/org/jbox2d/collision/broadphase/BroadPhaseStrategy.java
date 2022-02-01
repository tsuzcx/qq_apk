package org.jbox2d.collision.broadphase;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Vec2;

public abstract interface BroadPhaseStrategy
{
  public abstract int computeHeight();
  
  public abstract int createProxy(AABB paramAABB, Object paramObject);
  
  public abstract void destroyProxy(int paramInt);
  
  public abstract void drawTree(DebugDraw paramDebugDraw);
  
  public abstract float getAreaRatio();
  
  public abstract AABB getFatAABB(int paramInt);
  
  public abstract int getHeight();
  
  public abstract int getInsertionCount();
  
  public abstract int getMaxBalance();
  
  public abstract Object getUserData(int paramInt);
  
  public abstract boolean moveProxy(int paramInt, AABB paramAABB, Vec2 paramVec2);
  
  public abstract void query(TreeCallback paramTreeCallback, AABB paramAABB);
  
  public abstract void raycast(TreeRayCastCallback paramTreeRayCastCallback, RayCastInput paramRayCastInput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.BroadPhaseStrategy
 * JD-Core Version:    0.7.0.1
 */