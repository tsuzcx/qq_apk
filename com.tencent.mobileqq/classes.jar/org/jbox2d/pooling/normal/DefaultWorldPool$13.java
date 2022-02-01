package org.jbox2d.pooling.normal;

import org.jbox2d.common.Mat33;

class DefaultWorldPool$13
  extends OrderedStack<Mat33>
{
  DefaultWorldPool$13(DefaultWorldPool paramDefaultWorldPool, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected Mat33 newInstance()
  {
    return new Mat33();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.13
 * JD-Core Version:    0.7.0.1
 */