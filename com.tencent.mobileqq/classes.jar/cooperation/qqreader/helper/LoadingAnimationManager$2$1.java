package cooperation.qqreader.helper;

import android.widget.ImageView;
import bguq;
import bgwf;
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
      bgwf.c("LoadingAnimationManager", "onCompositionLoaded lottieComposition is null");
      bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, false);
      bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
    }
    do
    {
      return;
      bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).setComposition(localLottieComposition);
      bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).loop(true);
    } while ((bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0) == null) || (bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get() == null) || (((ImageView)bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get()).getVisibility() != 0));
    bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).run();
    bguq.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.helper.LoadingAnimationManager.2.1
 * JD-Core Version:    0.7.0.1
 */