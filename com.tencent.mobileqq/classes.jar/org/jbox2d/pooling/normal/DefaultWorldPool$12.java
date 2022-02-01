package org.jbox2d.pooling.normal;

import org.jbox2d.common.Rot;

class DefaultWorldPool$12
  extends OrderedStack<Rot>
{
  DefaultWorldPool$12(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected Rot newInstance()
  {
    return new Rot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.12
 * JD-Core Version:    0.7.0.1
 */