import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class rxp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public rxp(SlideActiveAnimController paramSlideActiveAnimController, Runnable paramRunnable) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rxp
 * JD-Core Version:    0.7.0.1
 */