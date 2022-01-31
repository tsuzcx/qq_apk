import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class snv
  implements OnCompositionLoadedListener
{
  snv(snu paramsnu) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "onCompositionLoaded failed!");
      }
      return;
    }
    this.a.a.post(new snw(this, paramLottieComposition));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snv
 * JD-Core Version:    0.7.0.1
 */