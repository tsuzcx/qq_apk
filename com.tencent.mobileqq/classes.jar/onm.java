import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

public class onm
  implements TouchWebView.OnScrollChangedListener
{
  public onm(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt1 = paramInt2 - paramInt4;
    if (paramInt1 > 0)
    {
      if (this.a.jdField_b_of_type_Int < 0) {
        this.a.jdField_b_of_type_Int = 0;
      }
      paramView = this.a;
      paramView.jdField_b_of_type_Int = (paramInt1 + paramView.jdField_b_of_type_Int);
      if ((this.a.jdField_b_of_type_Int > this.a.jdField_c_of_type_Int) && (this.a.jdField_c_of_type_Boolean))
      {
        this.a.jdField_c_of_type_Boolean = false;
        if (this.a.jdField_a_of_type_AndroidViewView != null)
        {
          this.a.a(this.a.jdField_b_of_type_AndroidViewView, 0);
          this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
          this.a.jdField_a_of_type_AndroidViewView.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
      }
    }
    do
    {
      do
      {
        return;
        if (this.a.jdField_b_of_type_Int > 0) {
          this.a.jdField_b_of_type_Int = 0;
        }
        paramView = this.a;
        paramView.jdField_b_of_type_Int = (paramInt1 + paramView.jdField_b_of_type_Int);
      } while ((-this.a.jdField_b_of_type_Int <= this.a.jdField_c_of_type_Int) || (this.a.jdField_c_of_type_Boolean));
      this.a.jdField_c_of_type_Boolean = true;
    } while (this.a.jdField_a_of_type_AndroidViewView == null);
    this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.a.jdField_a_of_type_AndroidViewView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onm
 * JD-Core Version:    0.7.0.1
 */