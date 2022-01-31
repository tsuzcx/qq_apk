import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class sff
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  sff(sez paramsez) {}
  
  public void onGlobalLayout()
  {
    int i = sez.a(this.a).getHeight();
    if (i != sez.b(this.a)) {
      sez.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sff
 * JD-Core Version:    0.7.0.1
 */