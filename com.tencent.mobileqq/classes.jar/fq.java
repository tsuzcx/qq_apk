import android.graphics.Bitmap;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fq
{
  public int a;
  public long a;
  public Bitmap a;
  public fh a;
  public WeakReference<ETTextView> a;
  public long b;
  
  public fq()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static fq a(ETTextView paramETTextView)
  {
    if (ETTextView.a(paramETTextView) == null) {
      return null;
    }
    fq localfq = new fq();
    localfq.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localfq.jdField_a_of_type_Long = paramETTextView.jdField_a_of_type_Long;
    localfq.jdField_a_of_type_Fh = paramETTextView.jdField_a_of_type_Fh;
    localfq.jdField_a_of_type_Int = ETTextView.a(paramETTextView).currentFrameIndex();
    localfq.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.a(paramETTextView).a();
    localfq.b = System.currentTimeMillis();
    return localfq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     fq
 * JD-Core Version:    0.7.0.1
 */