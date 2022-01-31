package com.tencent.mobileqq.vas;

class VasQuickUpdateEngine$1
  implements Runnable
{
  VasQuickUpdateEngine$1(VasQuickUpdateEngine paramVasQuickUpdateEngine) {}
  
  public void run()
  {
    synchronized (VasQuickUpdateEngine.hasSoLoaded)
    {
      this.this$0.doLoad();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.1
 * JD-Core Version:    0.7.0.1
 */