import android.graphics.Bitmap;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fw
{
  public int a;
  public long a;
  public Bitmap a;
  public fn a;
  public WeakReference<ETTextView> a;
  public long b;
  
  public fw()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static fw a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    fw localfw = new fw();
    localfw.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localfw.jdField_a_of_type_Long = paramETTextView.mMsgId;
    localfw.jdField_a_of_type_Fn = paramETTextView.mLayout;
    localfw.jdField_a_of_type_Int = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localfw.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.access$400(paramETTextView).a();
    localfw.b = System.currentTimeMillis();
    return localfw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fw
 * JD-Core Version:    0.7.0.1
 */