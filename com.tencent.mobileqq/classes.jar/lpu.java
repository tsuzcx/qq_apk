import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class lpu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  lpu(lpt paramlpt) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */