import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class qqg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qqg(qqf paramqqf) {}
  
  public void onGlobalLayout()
  {
    this.a.a(-1);
    this.a.post(new qqh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqg
 * JD-Core Version:    0.7.0.1
 */