package com.tencent.turingfd.sdk.xq;

public class return
  extends Thread
{
  public return(switch paramswitch) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      label6:
      switch localswitch = this.this$0;
      switch.a(localswitch, switch.a(localswitch).getContext());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.return
 * JD-Core Version:    0.7.0.1
 */