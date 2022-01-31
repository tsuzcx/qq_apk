package com.tencent.trackrecordlib.core;

import com.tencent.trackrecordlib.c.b;

class c$8
  implements Runnable
{
  c$8(c paramc, b paramb) {}
  
  public void run()
  {
    RecordManager.getInstance().recordEvent(this.a);
    c.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.8
 * JD-Core Version:    0.7.0.1
 */