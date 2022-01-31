import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class sns
  implements OnCompositionLoadedListener
{
  sns(snr paramsnr) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.a.a.setComposition(paramLottieComposition);
      this.a.a.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sns
 * JD-Core Version:    0.7.0.1
 */