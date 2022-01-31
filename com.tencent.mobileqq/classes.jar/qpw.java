import android.view.View;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.GdtViewStatus;
import java.lang.ref.WeakReference;

public class qpw
  implements Runnable
{
  public qpw(GdtViewStatus paramGdtViewStatus) {}
  
  public void run()
  {
    if (GdtUIUtils.a((View)GdtViewStatus.a(this.a).get()) > GdtViewStatus.a(this.a)) {
      GdtViewStatus.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qpw
 * JD-Core Version:    0.7.0.1
 */