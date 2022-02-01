package cooperation.qqfav.util;

import java.lang.ref.WeakReference;

class HandlerPlus$TimerRunnable
  implements Runnable
{
  int a;
  long b;
  private WeakReference<Runnable> c;
  
  private HandlerPlus$TimerRunnable(HandlerPlus paramHandlerPlus, Runnable paramRunnable)
  {
    this.c = new WeakReference(paramRunnable);
  }
  
  public void run()
  {
    Runnable localRunnable = (Runnable)this.c.get();
    if (localRunnable != null)
    {
      int i = this.a;
      if (i > 0)
      {
        this.a = (i - 1);
        localRunnable.run();
        i = this.a;
        if (i > 0) {
          this.this$0.a(localRunnable, i, this.b, 0L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus.TimerRunnable
 * JD-Core Version:    0.7.0.1
 */