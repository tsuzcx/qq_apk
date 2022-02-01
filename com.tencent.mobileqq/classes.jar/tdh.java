import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.util.Set;

class tdh
  implements URLDrawable.URLDrawableListener
{
  private ImageAction jdField_a_of_type_ComTencentViolaUiComponentImageImageAction;
  private boolean jdField_a_of_type_Boolean;
  
  public tdh(tdf paramtdf, boolean paramBoolean, ImageAction paramImageAction)
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
    tdf.a(this.jdField_a_of_type_Tdf).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tdf.a(this.jdField_a_of_type_Tdf, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    tdf.a(this.jdField_a_of_type_Tdf, this.jdField_a_of_type_ComTencentViolaUiComponentImageImageAction, paramURLDrawable, this.jdField_a_of_type_Boolean);
    tdf.a(this.jdField_a_of_type_Tdf).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdh
 * JD-Core Version:    0.7.0.1
 */