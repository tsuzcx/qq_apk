import android.graphics.Bitmap;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETTextView;
import java.lang.ref.WeakReference;

public class fs
{
  public int a;
  public long a;
  public Bitmap a;
  public fj a;
  public WeakReference<ETTextView> a;
  public long b;
  
  public fs()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static fs a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    fs localfs = new fs();
    localfs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localfs.jdField_a_of_type_Long = paramETTextView.mMsgId;
    localfs.jdField_a_of_type_Fj = paramETTextView.mLayout;
    localfs.jdField_a_of_type_Int = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localfs.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.access$400(paramETTextView).a();
    localfs.b = System.currentTimeMillis();
    return localfs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fs
 * JD-Core Version:    0.7.0.1
 */