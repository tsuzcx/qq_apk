import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class lzy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  lzy(lzx paramlzx) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzy
 * JD-Core Version:    0.7.0.1
 */