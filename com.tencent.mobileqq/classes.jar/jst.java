import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class jst
  implements URLDrawable.URLDrawableListener
{
  public jst(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
      DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jst
 * JD-Core Version:    0.7.0.1
 */