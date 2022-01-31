import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class rrb
  implements OnCompositionLoadedListener
{
  rrb(rra paramrra, Runnable paramRunnable) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    RefreshAnimView.a(this.jdField_a_of_type_Rra.a, paramLottieComposition);
    if (paramLottieComposition != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrb
 * JD-Core Version:    0.7.0.1
 */