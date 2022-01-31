import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.util.Set;

class rwx
  implements URLDrawable.URLDrawableListener
{
  private ImageAction jdField_a_of_type_ComTencentViolaUiComponentImageImageAction;
  private boolean jdField_a_of_type_Boolean;
  
  public rwx(rwv paramrwv, boolean paramBoolean, ImageAction paramImageAction)
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
    rwv.a(this.jdField_a_of_type_Rwv).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    rwv.a(this.jdField_a_of_type_Rwv, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    rwv.a(this.jdField_a_of_type_Rwv, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, this.jdField_a_of_type_Boolean);
    rwv.a(this.jdField_a_of_type_Rwv).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwx
 * JD-Core Version:    0.7.0.1
 */