package org.jbox2d.pooling.normal;

import java.util.HashMap;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Distance;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.pooling.IDynamicStack;
import org.jbox2d.pooling.IWorldPool;

public class DefaultWorldPool
  implements IWorldPool
{
  private final OrderedStack<AABB> aabbs;
  private final HashMap<Integer, float[]> afloats = new HashMap();
  private final HashMap<Integer, int[]> aints = new HashMap();
  private final HashMap<Integer, Vec2[]> avecs = new HashMap();
  private final MutableStack<Contact> ccstack = new DefaultWorldPool.2(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final MutableStack<Contact> chcstack = new DefaultWorldPool.6(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final MutableStack<Contact> chpstack = new DefaultWorldPool.7(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final Collision collision;
  private final MutableStack<Contact> cpstack = new DefaultWorldPool.3(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final Distance dist;
  private final MutableStack<Contact> ecstack = new DefaultWorldPool.4(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final MutableStack<Contact> epstack = new DefaultWorldPool.5(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final OrderedStack<Mat33> mat33s;
  private final OrderedStack<Mat22> mats;
  private final MutableStack<Contact> pcstack = new DefaultWorldPool.1(this, Settings.CONTACT_STACK_INIT_SIZE);
  private final OrderedStack<Rot> rots;
  private final TimeOfImpact toi;
  private final OrderedStack<Vec3> vec3s;
  private final OrderedStack<Vec2> vecs;
  private final IWorldPool world = this;
  
  public DefaultWorldPool(int paramInt1, int paramInt2)
  {
    this.vecs = new DefaultWorldPool.8(this, paramInt1, paramInt2);
    this.vec3s = new DefaultWorldPool.9(this, paramInt1, paramInt2);
    this.mats = new DefaultWorldPool.10(this, paramInt1, paramInt2);
    this.aabbs = new DefaultWorldPool.11(this, paramInt1, paramInt2);
    this.rots = new DefaultWorldPool.12(this, paramInt1, paramInt2);
    this.mat33s = new DefaultWorldPool.13(this, paramInt1, paramInt2);
    this.dist = new Distance();
    this.collision = new Collision(this);
    this.toi = new TimeOfImpact(this);
  }
  
  public IDynamicStack<Contact> getChainCircleContactStack()
  {
    return this.chcstack;
  }
  
  public IDynamicStack<Contact> getChainPolyContactStack()
  {
    return this.chpstack;
  }
  
  public final IDynamicStack<Contact> getCircleContactStack()
  {
    return this.ccstack;
  }
  
  public final Collision getCollision()
  {
    return this.collision;
  }
  
  public final Distance getDistance()
  {
    return this.dist;
  }
  
  public IDynamicStack<Contact> getEdgeCircleContactStack()
  {
    return this.ecstack;
  }
  
  public IDynamicStack<Contact> getEdgePolyContactStack()
  {
    return this.epstack;
  }
  
  public final float[] getFloatArray(int paramInt)
  {
    if (!this.afloats.containsKey(Integer.valueOf(paramInt))) {
      this.afloats.put(Integer.valueOf(paramInt), new float[paramInt]);
    }
    return (float[])this.afloats.get(Integer.valueOf(paramInt));
  }
  
  public final int[] getIntArray(int paramInt)
  {
    if (!this.aints.containsKey(Integer.valueOf(paramInt))) {
      this.aints.put(Integer.valueOf(paramInt), new int[paramInt]);
    }
    return (int[])this.aints.get(Integer.valueOf(paramInt));
  }
  
  public final IDynamicStack<Contact> getPolyCircleContactStack()
  {
    return this.cpstack;
  }
  
  public final IDynamicStack<Contact> getPolyContactStack()
  {
    return this.pcstack;
  }
  
  public final TimeOfImpact getTimeOfImpact()
  {
    return this.toi;
  }
  
  public final Vec2[] getVec2Array(int paramInt)
  {
    if (!this.avecs.containsKey(Integer.valueOf(paramInt)))
    {
      Vec2[] arrayOfVec2 = new Vec2[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfVec2[i] = new Vec2();
        i += 1;
      }
      this.avecs.put(Integer.valueOf(paramInt), arrayOfVec2);
    }
    return (Vec2[])this.avecs.get(Integer.valueOf(paramInt));
  }
  
  public final AABB popAABB()
  {
    return (AABB)this.aabbs.pop();
  }
  
  public final AABB[] popAABB(int paramInt)
  {
    return (AABB[])this.aabbs.pop(paramInt);
  }
  
  public final Mat22 popMat22()
  {
    return (Mat22)this.mats.pop();
  }
  
  public final Mat22[] popMat22(int paramInt)
  {
    return (Mat22[])this.mats.pop(paramInt);
  }
  
  public final Mat33 popMat33()
  {
    return (Mat33)this.mat33s.pop();
  }
  
  public final Rot popRot()
  {
    return (Rot)this.rots.pop();
  }
  
  public final Vec2 popVec2()
  {
    return (Vec2)this.vecs.pop();
  }
  
  public final Vec2[] popVec2(int paramInt)
  {
    return (Vec2[])this.vecs.pop(paramInt);
  }
  
  public final Vec3 popVec3()
  {
    return (Vec3)this.vec3s.pop();
  }
  
  public final Vec3[] popVec3(int paramInt)
  {
    return (Vec3[])this.vec3s.pop(paramInt);
  }
  
  public final void pushAABB(int paramInt)
  {
    this.aabbs.push(paramInt);
  }
  
  public final void pushMat22(int paramInt)
  {
    this.mats.push(paramInt);
  }
  
  public final void pushMat33(int paramInt)
  {
    this.mat33s.push(paramInt);
  }
  
  public final void pushRot(int paramInt)
  {
    this.rots.push(paramInt);
  }
  
  public final void pushVec2(int paramInt)
  {
    this.vecs.push(paramInt);
  }
  
  public final void pushVec3(int paramInt)
  {
    this.vec3s.push(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool
 * JD-Core Version:    0.7.0.1
 */