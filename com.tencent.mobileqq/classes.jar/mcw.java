import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class mcw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  mcw(mcv parammcv) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mcw
 * JD-Core Version:    0.7.0.1
 */