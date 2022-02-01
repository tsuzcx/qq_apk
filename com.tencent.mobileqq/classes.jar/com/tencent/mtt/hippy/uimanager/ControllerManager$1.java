package com.tencent.mtt.hippy.uimanager;

class ControllerManager$1
  implements Runnable
{
  ControllerManager$1(ControllerManager paramControllerManager) {}
  
  public void run()
  {
    int i = this.a.b.a();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        this.a.b(this.a.b.b(i));
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.ControllerManager.1
 * JD-Core Version:    0.7.0.1
 */