import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class mly
  implements lsi
{
  private WeakReference<mlx> a;
  
  public mly(mlx parammlx)
  {
    this.a = new WeakReference(parammlx);
  }
  
  public boolean a(lsh paramlsh, MotionEvent paramMotionEvent)
  {
    mlx localmlx = (mlx)this.a.get();
    if (localmlx != null) {
      return localmlx.a(paramlsh, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */