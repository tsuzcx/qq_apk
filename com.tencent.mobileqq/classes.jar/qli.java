import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import java.lang.ref.WeakReference;

final class qli
  implements Runnable
{
  qli(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData, WeakReference paramWeakReference) {}
  
  public void run()
  {
    GdtCanvasFormError localGdtCanvasFormError = qlh.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new qlj(this, localGdtCanvasFormError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qli
 * JD-Core Version:    0.7.0.1
 */