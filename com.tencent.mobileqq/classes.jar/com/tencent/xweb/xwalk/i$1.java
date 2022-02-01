package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkV8;

class i$1
  implements Runnable
{
  i$1(i parami, int paramInt) {}
  
  public void run()
  {
    if (this.b.a != null) {
      return;
    }
    this.b.a = new XWalkV8();
    this.b.a.init(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i.1
 * JD-Core Version:    0.7.0.1
 */