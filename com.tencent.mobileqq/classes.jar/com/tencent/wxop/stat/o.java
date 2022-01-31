package com.tencent.wxop.stat;

import android.content.Context;

final class o
  implements Runnable
{
  o(Context paramContext) {}
  
  public final void run()
  {
    StatServiceImpl.flushDataToDB(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.o
 * JD-Core Version:    0.7.0.1
 */