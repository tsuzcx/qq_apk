import android.graphics.Bitmap;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fx
{
  public int a;
  public long a;
  public Bitmap a;
  public fo a;
  public WeakReference<ETTextView> a;
  public long b;
  
  public fx()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static fx a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    fx localfx = new fx();
    localfx.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localfx.jdField_a_of_type_Long = paramETTextView.mMsgId;
    localfx.jdField_a_of_type_Fo = paramETTextView.mLayout;
    localfx.jdField_a_of_type_Int = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localfx.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.access$400(paramETTextView).a();
    localfx.b = System.currentTimeMillis();
    return localfx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fx
 * JD-Core Version:    0.7.0.1
 */