import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class mlh
  implements lrq
{
  private WeakReference<mlg> a;
  
  public mlh(mlg parammlg)
  {
    this.a = new WeakReference(parammlg);
  }
  
  public boolean a(lrp paramlrp, MotionEvent paramMotionEvent)
  {
    mlg localmlg = (mlg)this.a.get();
    if (localmlg != null) {
      return localmlg.a(paramlrp, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlh
 * JD-Core Version:    0.7.0.1
 */