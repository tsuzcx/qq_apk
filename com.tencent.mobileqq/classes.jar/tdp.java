import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class tdp
  implements OnCompositionLoadedListener
{
  tdp(tdo paramtdo) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.setImageAssetsFolder(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.setComposition(paramLottieComposition);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdp
 * JD-Core Version:    0.7.0.1
 */