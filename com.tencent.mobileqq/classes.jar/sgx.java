import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class sgx
  implements OnCompositionLoadedListener
{
  sgx(sgw paramsgw, Runnable paramRunnable) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    RefreshAnimView.a(this.jdField_a_of_type_Sgw.a, paramLottieComposition);
    if (paramLottieComposition != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgx
 * JD-Core Version:    0.7.0.1
 */