import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class squ
  implements OnCompositionLoadedListener
{
  squ(sqt paramsqt) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "onCompositionLoaded failed!");
      }
      return;
    }
    this.a.a.post(new sqv(this, paramLottieComposition));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     squ
 * JD-Core Version:    0.7.0.1
 */