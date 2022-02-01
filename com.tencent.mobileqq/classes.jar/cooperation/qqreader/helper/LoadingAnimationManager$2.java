package cooperation.qqreader.helper;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieResult;
import mqq.os.MqqHandler;

class LoadingAnimationManager$2
  implements Runnable
{
  LoadingAnimationManager$2(LoadingAnimationManager paramLoadingAnimationManager, Context paramContext) {}
  
  public void run()
  {
    LottieResult localLottieResult = LottieCompositionFactory.fromUrlSync(this.a, "https://qqread-book-1251316161.file.myqcloud.com/audio/qr_browser_loading.json");
    ThreadManager.getUIHandler().post(new LoadingAnimationManager.2.1(this, localLottieResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.helper.LoadingAnimationManager.2
 * JD-Core Version:    0.7.0.1
 */