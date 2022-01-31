import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.net.GdtHttp.Params;
import java.lang.ref.WeakReference;

public final class qla
  implements Runnable
{
  public qla(GdtHttp.Params paramParams, WeakReference paramWeakReference) {}
  
  public void run()
  {
    GdtHttp.a(this.jdField_a_of_type_ComTencentGdtadNetGdtHttp$Params);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new qlb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qla
 * JD-Core Version:    0.7.0.1
 */