package org.jbox2d.pooling.normal;

import org.jbox2d.common.Vec3;

class DefaultWorldPool$9
  extends OrderedStack<Vec3>
{
  DefaultWorldPool$9(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected Vec3 newInstance()
  {
    return new Vec3();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.9
 * JD-Core Version:    0.7.0.1
 */