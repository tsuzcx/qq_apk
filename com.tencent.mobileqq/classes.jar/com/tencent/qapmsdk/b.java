package com.tencent.qapmsdk;

import com.tencent.qapmsdk.qapmmanager.QAPMLauncher;

public class b
  implements Runnable
{
  private int a = 0;
  
  b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    QAPMLauncher.INSTANCE.launch(this.a);
    QAPMLauncher.INSTANCE.afterLaunch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.b
 * JD-Core Version:    0.7.0.1
 */