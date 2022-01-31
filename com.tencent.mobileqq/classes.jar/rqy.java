import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class rqy
  implements OnCompositionLoadedListener
{
  rqy(rqx paramrqx, Runnable paramRunnable) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    RefreshAnimView.a(this.jdField_a_of_type_Rqx.a, paramLottieComposition);
    if (paramLottieComposition != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqy
 * JD-Core Version:    0.7.0.1
 */