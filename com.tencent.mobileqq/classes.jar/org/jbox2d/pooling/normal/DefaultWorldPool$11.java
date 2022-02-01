package org.jbox2d.pooling.normal;

import org.jbox2d.collision.AABB;

class DefaultWorldPool$11
  extends OrderedStack<AABB>
{
  DefaultWorldPool$11(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected AABB newInstance()
  {
    return new AABB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.11
 * JD-Core Version:    0.7.0.1
 */