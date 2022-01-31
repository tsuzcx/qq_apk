import android.content.res.Resources;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.lang.ref.WeakReference;

public class sxk
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public sxk(int paramInt, WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFormSimpleItem != null) {
        localFormSimpleItem.setRightText(localFormSimpleItem.getResources().getString(this.jdField_a_of_type_Int));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxk
 * JD-Core Version:    0.7.0.1
 */