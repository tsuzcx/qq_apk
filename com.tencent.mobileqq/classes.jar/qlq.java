import android.view.ViewTreeObserver;

class qlq
  implements Runnable
{
  qlq(qlp paramqlp) {}
  
  public void run()
  {
    if ((qlo.a(this.a.a) != null) && (this.a.a.getViewTreeObserver() != null))
    {
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(qlo.a(this.a.a));
      qlo.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qlq
 * JD-Core Version:    0.7.0.1
 */