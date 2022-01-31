import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.dinifly.LottieDrawable;

public class mot
{
  public View a;
  public ViewStub a;
  public LottieDrawable a;
  public View b = null;
  
  public mot()
  {
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        if (!paramBoolean) {
          break label76;
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(i);
      }
      if (this.b != null) {
        this.b.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(i);
      }
      return;
      i = 8;
      break;
      label76:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */