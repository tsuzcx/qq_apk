package cooperation.qqreader.helper;

import android.widget.ImageView;
import bmpj;
import bmqw;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieResult;
import java.lang.ref.WeakReference;

class LoadingAnimationManager$2$1
  implements Runnable
{
  LoadingAnimationManager$2$1(LoadingAnimationManager.2 param2, LottieResult paramLottieResult) {}
  
  public void run()
  {
    LottieComposition localLottieComposition = (LottieComposition)this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieResult.getValue();
    if (localLottieComposition == null)
    {
      bmqw.c("LoadingAnimationManager", "onCompositionLoaded lottieComposition is null");
      bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, false);
      bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
    }
    do
    {
      return;
      bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).setComposition(localLottieComposition);
      bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).loop(true);
    } while ((bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0) == null) || (bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get() == null) || (((ImageView)bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get()).getVisibility() != 0));
    bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).run();
    bmpj.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.helper.LoadingAnimationManager.2.1
 * JD-Core Version:    0.7.0.1
 */