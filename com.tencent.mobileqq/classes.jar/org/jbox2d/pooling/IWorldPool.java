package org.jbox2d.pooling;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Distance;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.contacts.Contact;

public abstract interface IWorldPool
{
  public abstract IDynamicStack<Contact> getChainCircleContactStack();
  
  public abstract IDynamicStack<Contact> getChainPolyContactStack();
  
  public abstract IDynamicStack<Contact> getCircleContactStack();
  
  public abstract Collision getCollision();
  
  public abstract Distance getDistance();
  
  public abstract IDynamicStack<Contact> getEdgeCircleContactStack();
  
  public abstract IDynamicStack<Contact> getEdgePolyContactStack();
  
  public abstract float[] getFloatArray(int paramInt);
  
  public abstract int[] getIntArray(int paramInt);
  
  public abstract IDynamicStack<Contact> getPolyCircleContactStack();
  
  public abstract IDynamicStack<Contact> getPolyContactStack();
  
  public abstract TimeOfImpact getTimeOfImpact();
  
  public abstract Vec2[] getVec2Array(int paramInt);
  
  public abstract AABB popAABB();
  
  public abstract AABB[] popAABB(int paramInt);
  
  public abstract Mat22 popMat22();
  
  public abstract Mat22[] popMat22(int paramInt);
  
  public abstract Mat33 popMat33();
  
  public abstract Rot popRot();
  
  public abstract Vec2 popVec2();
  
  public abstract Vec2[] popVec2(int paramInt);
  
  public abstract Vec3 popVec3();
  
  public abstract Vec3[] popVec3(int paramInt);
  
  public abstract void pushAABB(int paramInt);
  
  public abstract void pushMat22(int paramInt);
  
  public abstract void pushMat33(int paramInt);
  
  public abstract void pushRot(int paramInt);
  
  public abstract void pushVec2(int paramInt);
  
  public abstract void pushVec3(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.IWorldPool
 * JD-Core Version:    0.7.0.1
 */