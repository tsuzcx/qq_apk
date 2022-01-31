import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ssb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ssb(srv paramsrv) {}
  
  public void onGlobalLayout()
  {
    int i = srv.a(this.a).getHeight();
    if (i != srv.b(this.a)) {
      srv.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssb
 * JD-Core Version:    0.7.0.1
 */