package cooperation.qqreader.helper;

import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieResult;
import cooperation.qqreader.utils.Log;
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
      Log.c("LoadingAnimationManager", "onCompositionLoaded lottieComposition is null");
      LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, false);
      LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
    }
    do
    {
      return;
      LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).setComposition(localLottieComposition);
      LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).loop(true);
    } while ((LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0) == null) || (LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get() == null) || (((ImageView)LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).get()).getVisibility() != 0));
    LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0).run();
    LoadingAnimationManager.a(this.jdField_a_of_type_CooperationQqreaderHelperLoadingAnimationManager$2.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.LoadingAnimationManager.2.1
 * JD-Core Version:    0.7.0.1
 */