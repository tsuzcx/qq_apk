package org.jbox2d.pooling.normal;

import org.jbox2d.common.Mat22;

class DefaultWorldPool$10
  extends OrderedStack<Mat22>
{
  DefaultWorldPool$10(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected Mat22 newInstance()
  {
    return new Mat22();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.10
 * JD-Core Version:    0.7.0.1
 */