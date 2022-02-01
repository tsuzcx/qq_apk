package org.jbox2d.pooling.normal;

import org.jbox2d.common.Vec2;

class DefaultWorldPool$8
  extends OrderedStack<Vec2>
{
  DefaultWorldPool$8(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected Vec2 newInstance()
  {
    return new Vec2();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.8
 * JD-Core Version:    0.7.0.1
 */