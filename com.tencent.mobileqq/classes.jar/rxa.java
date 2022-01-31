import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.util.Set;

class rxa
  implements URLDrawable.URLDrawableListener
{
  private ImageAction jdField_a_of_type_ComTencentViolaUiComponentImageImageAction;
  private boolean jdField_a_of_type_Boolean;
  
  public rxa(rwy paramrwy, boolean paramBoolean, ImageAction paramImageAction)
  {
    this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction = paramImageAction;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction.onCancel();
    rwy.a(this.jdField_a_of_type_Rwy).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    rwy.a(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    rwy.a(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, this.jdField_a_of_type_Boolean);
    rwy.a(this.jdField_a_of_type_Rwy).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxa
 * JD-Core Version:    0.7.0.1
 */