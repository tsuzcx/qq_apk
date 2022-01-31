import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class qlp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qlp(qlo paramqlo) {}
  
  public void onGlobalLayout()
  {
    this.a.a(-1);
    this.a.post(new qlq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qlp
 * JD-Core Version:    0.7.0.1
 */