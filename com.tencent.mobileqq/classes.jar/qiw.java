import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.aditem.GdtHttpPost;
import com.tencent.gdtad.aditem.GdtHttpPost.Params;
import java.lang.ref.WeakReference;

public final class qiw
  implements Runnable
{
  public qiw(GdtHttpPost.Params paramParams, WeakReference paramWeakReference) {}
  
  public void run()
  {
    GdtHttpPost.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtHttpPost$Params);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new qix(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qiw
 * JD-Core Version:    0.7.0.1
 */