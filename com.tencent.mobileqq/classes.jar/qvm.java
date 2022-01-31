import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;

public class qvm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public qvm(SlideActiveAnimController paramSlideActiveAnimController, Runnable paramRunnable) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.a();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvm
 * JD-Core Version:    0.7.0.1
 */