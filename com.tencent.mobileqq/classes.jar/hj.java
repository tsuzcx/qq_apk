import android.graphics.Bitmap;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class hj
{
  public int a;
  public long a;
  public Bitmap a;
  public ha a;
  public WeakReference<ETTextView> a;
  public long b;
  
  public hj()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static hj a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    hj localhj = new hj();
    localhj.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localhj.jdField_a_of_type_Long = paramETTextView.mMsgId;
    localhj.jdField_a_of_type_Ha = paramETTextView.mLayout;
    localhj.jdField_a_of_type_Int = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localhj.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.access$400(paramETTextView).a();
    localhj.b = System.currentTimeMillis();
    return localhj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hj
 * JD-Core Version:    0.7.0.1
 */