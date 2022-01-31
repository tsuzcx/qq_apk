import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class sry
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  sry(srs paramsrs) {}
  
  public void onGlobalLayout()
  {
    int i = srs.a(this.a).getHeight();
    if (i != srs.b(this.a)) {
      srs.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sry
 * JD-Core Version:    0.7.0.1
 */