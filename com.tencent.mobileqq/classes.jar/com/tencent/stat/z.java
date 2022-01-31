package com.tencent.stat;

import android.content.Context;

final class z
  implements Runnable
{
  z(Context paramContext) {}
  
  public void run()
  {
    StatServiceImpl.flushDataToDB(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.z
 * JD-Core Version:    0.7.0.1
 */