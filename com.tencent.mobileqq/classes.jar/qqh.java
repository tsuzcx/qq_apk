import android.view.ViewTreeObserver;

class qqh
  implements Runnable
{
  qqh(qqg paramqqg) {}
  
  public void run()
  {
    if ((qqf.a(this.a.a) != null) && (this.a.a.getViewTreeObserver() != null))
    {
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(qqf.a(this.a.a));
      qqf.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqh
 * JD-Core Version:    0.7.0.1
 */